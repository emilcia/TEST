package com.example.vaadindemo;

import com.example.vaadindemo.domain.Person;
import com.example.vaadindemo.service.PersonManager;
import com.google.gwt.thirdparty.guava.common.base.CaseFormat;
import com.google.gwt.user.client.ui.Grid;
import com.vaadin.annotations.Title;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.DefaultErrorHandler;
import com.vaadin.server.UserError;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.TreeTable;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@Title("Vaadin Demo App")
public class VaadinApp extends UI {

	private static final long serialVersionUID = 1L;
	private PersonManager personManager = new PersonManager();

	private Person person = new Person("Martyna", 1990, "Martynowska", "mm@wp.pl", 698123456, "",1,"ala", "kot");
	private BeanItem<Person> personItem = new BeanItem<Person>(person);

	private BeanItemContainer<Person> persons = new BeanItemContainer<Person>(
			Person.class);

	enum Action {
		EDIT, ADD, LOGIN;
	}

	private class MyFormWindow extends Window {
		private static final long serialVersionUID = 1L;

		private Action action;
		
		public MyFormWindow(Action act) {
			this.action = act;

			setModal(true);
			center();
			
			switch (action) {
			case ADD:
				setCaption("Dodaj nową osobę");
				break;
			case EDIT:
				setCaption("Edytuj osobę");
				break;
			case LOGIN:
				setCaption("Zaloguj się");
				break;
			default:
				break;
			}
			

			final FormLayout form = new FormLayout();
			TextField log = new TextField("Login");
			PasswordField pas = new PasswordField("Hasło");

			final FieldGroup binder = new FieldGroup(personItem);
			 Button saveBtn = new Button();

			final Button cancelBtn = new Button(" Anuluj ");
			if(action == Action.ADD || action == Action.EDIT)
			{
				ListSelect month = new ListSelect("miesiac");
				month.addItems("Styczeń", "Luty", "Marzec", "Kwiecień", "Maj", "Czerwiec", "Lipiec", "Sierpień", "Wrzesień", "Październik", "Listopad", "Grudzień");
				month.setRows(1);
				ListSelect day = new ListSelect("dzien");
				day.addItems(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31);
				day.setRows(1);
			form.addComponent(binder.buildAndBind("Nazwisko", "lastName"));
			form.addComponent(binder.buildAndBind("Rok urodzenia", "yob"));
			form.addComponent(month);
			binder.bind(month, "month");
			binder.bind(day, "day");
			form.addComponent(day);
			
			form.addComponent(binder.buildAndBind("Imię", "firstName"));
			form.addComponent(binder.buildAndBind("E-mail", "address"));
			form.addComponent(binder.buildAndBind("Telefon", "phoneNumber"));
			form.addComponent(binder.buildAndBind("Login", "login"));
			form.addComponent(binder.buildAndBind("Haslo", "password"));
			
			OptionGroup single = new OptionGroup("Pleć");
			single.addItems("Kobieta", "Mężczyzna");
			form.addComponent(single);
			
			if (action == Action.ADD){
				saveBtn = new Button(" Dodaj osobę ");
			}
			else
			{
				saveBtn = new Button(" Zapisz zmiany ");
			}

			binder.setBuffered(true);

			binder.getField("lastName").setRequired(true);
			binder.getField("firstName").setRequired(true);
			}
			else
			{
				form.addComponent(log);
				form.addComponent(pas);
				saveBtn = new Button(" Zaloguj ");

			}

			VerticalLayout fvl = new VerticalLayout();
			fvl.setMargin(true);
			fvl.addComponent(form);

			HorizontalLayout hl = new HorizontalLayout();
			hl.addComponent(saveBtn);
			hl.addComponent(cancelBtn);
			fvl.addComponent(hl);
								
			setContent(fvl);

			saveBtn.addClickListener(new ClickListener() {

				private static final long serialVersionUID = 1L;

				@Override
				public void buttonClick(ClickEvent event) {
					try {
						
						binder.commit();
						
						
						if (action == Action.ADD || action == Action.EDIT) {
							if(person.validEmail())
							{
								if(person.validPhone())
								{
									 if (action == Action.EDIT) {
										personManager.updatePerson(person);
									}
									 else
									personManager.addPerson(person);
								}
								else 
								{
									Notification.show("Nieprawidłowy numer telefonu");
									addWindow(new MyFormWindow(Action.ADD));

								}
							}else {
								Notification.show("Nieprawidłowy adres email");
								addWindow(new MyFormWindow(Action.ADD));
							
								}
				
						} 
						else if (action == Action.LOGIN) {
								if(personManager.findPerson(log.getValue())!=null)
								{
									if(personManager.findPerson(log.getValue()).getPassword().equals(pas.getValue()))
									{
									drawTable();
									}
									else
									{
										Notification.show("Nie udało sie zalogować.");
										addWindow(new MyFormWindow(Action.LOGIN));
									}

								}
									else
								{
										Notification.show("Nie ma takiego uzytkownika");
										addWindow(new MyFormWindow(Action.LOGIN));
								}
						}

						persons.removeAllItems();
						persons.addAll(personManager.findAll());
						close();
					} catch (CommitException e) {
						e.printStackTrace();
					}
				}
			});

			cancelBtn.addClickListener(new ClickListener() {

				private static final long serialVersionUID = 1L;

				@Override
				public void buttonClick(ClickEvent event) {
					binder.discard();
					close();
				}
			});
		}
	}

	@Override
	protected void init(VaadinRequest request) {
		
		Button loginPersonFormBtn = new Button("Login");
		Button addPersonFormBtn = new Button("Dodaj");
		
		VerticalLayout vl = new VerticalLayout();
		setContent(vl);
		
		addPersonFormBtn.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				addWindow(new MyFormWindow(Action.ADD));

			}
		});
		loginPersonFormBtn.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				addWindow(new MyFormWindow(Action.LOGIN));
			}
		});
		HorizontalLayout hl = new HorizontalLayout();
		hl.addComponent(addPersonFormBtn);
		hl.addComponent(loginPersonFormBtn);
		
		vl.addComponent(hl);
		

	}

	public void drawTable(){
		
		Button logoutPersonFormBtn = new Button("Logout");
		Button editPersonFormBtn = new Button("Edit");

		VerticalLayout vl = new VerticalLayout();
		setContent(vl);


		editPersonFormBtn.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				addWindow(new MyFormWindow(Action.EDIT));
			}
		});

		logoutPersonFormBtn.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				
					
					Button loginPersonFormBtn = new Button("Login");
					Button addPersonFormBtn = new Button("Dodaj");
					
					VerticalLayout vl = new VerticalLayout();
					setContent(vl);
					
					addPersonFormBtn.addClickListener(new ClickListener() {

						private static final long serialVersionUID = 1L;

						@Override
						public void buttonClick(ClickEvent event) {
							addWindow(new MyFormWindow(Action.ADD));

						}
					});
					loginPersonFormBtn.addClickListener(new ClickListener() {

						private static final long serialVersionUID = 1L;

						@Override
						public void buttonClick(ClickEvent event) {
							addWindow(new MyFormWindow(Action.LOGIN));
						}
					});
					HorizontalLayout hl = new HorizontalLayout();
					hl.addComponent(addPersonFormBtn);
					hl.addComponent(loginPersonFormBtn);
					
					vl.addComponent(hl);
			}
		});

		HorizontalLayout hl = new HorizontalLayout();
		hl.addComponent(editPersonFormBtn);
		hl.addComponent(logoutPersonFormBtn);
		
		final Table personsTable = new Table("Persons", persons);
		personsTable.sort();
		personsTable.setColumnHeader("firstName", "Imię");
		personsTable.setColumnHeader("lastName", "Nazwisko");
		personsTable.setColumnHeader("yob", "Rok urodzenia");
		personsTable.setColumnHeader("phoneNumber", "Numer telefonu");
		personsTable.setColumnHeader("month", "Miesiąc");
		personsTable.setSelectable(true);
		personsTable.setImmediate(true);

		personsTable.addValueChangeListener(new Property.ValueChangeListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {

				Person selectedPerson = (Person) personsTable.getValue();
				if (selectedPerson == null) {
					person.setFirstName("");
					person.setLastName("");
					person.setYob(0);
					person.setId(null);
					person.setPhoneNumber(0);
					person.setMonth("");
					person.setDay(0);

				} else {
					person.setFirstName(selectedPerson.getFirstName());
					person.setLastName(selectedPerson.getLastName());
					person.setYob(selectedPerson.getYob());
					person.setId(selectedPerson.getId());
					person.setPhoneNumber(selectedPerson.getPhoneNumber());
					person.setMonth(selectedPerson.getMonth());
					person.setDay(selectedPerson.getDay());

				}
			}
		});

		vl.addComponent(hl);
		vl.addComponent(personsTable);
		
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		Label label = new Label();
		horizontalLayout.addComponent(label);
		label.setValue(UI.getCurrent().toString());
		
		vl.addComponent(horizontalLayout);
		
	}
}