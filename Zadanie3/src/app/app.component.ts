import { Component, Input } from '@angular/core';
//import { Person } from './person';
//import { PersonService } from './person.service';
//import { PERSONS } from './mock-persons';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  styles: [`
  .selected {
    background-color: #CFD8DC !important;
    color: white;
  }

  .button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    text-align: center;
    text-decoration: none;
    font-size: 16px;
    float:right;
    cursor: pointer;
    border-radius: 5px;
}
.like {
    float: right;
    left: 60px;
    position: relative;
}
  .persons {
    margin: 0 0 2em 0;
    list-style-type: none;
    padding: 0;
    width: 15em;
  }
  .persons li {
    cursor: pointer;
    position: relative;
    left: 0;
    background-color: #EEE;
    margin: .5em;
    padding: .3em 0;
    height: 1.6em;
    border-radius: 4px;
  }
  .persons li.selected:hover {
    background-color: #BBD8DC !important;
    color: white;
  }
  .persons li:hover {
    color: #607D8B;
    background-color: #DDD;
    left: .1em;
  }
  .persons .text {
    position: relative;
    top: -3px;
  }
  .persons .badge {
    display: inline-block;
    font-size: small;
    color: white;
    padding: 0.8em 0.7em 0 0.7em;
    background-color: #607D8B;
    line-height: 1em;
    position: relative;
    left: -1px;
    top: -4px;
    height: 1.8em;
    margin-right: .8em;
    border-radius: 4px 0 0 4px;
  }
`],
  //providers: [PersonService]

})
export class AppComponent {

    title = 'List of people';
    persons:Person[] =  [
  { id: 1, name: 'Misiałkeł', surname: 'hodor', like:0 },
  { id: 2, name: 'Emlkeł',surname: 'koks', like:0 },
  { id: 3, name: 'Faciolubski',surname: 'gok', like:0 },
  { id: 4, name: 'Cyrano',surname: 'koka', like:0 },
  { id: 5, name: 'Patryś',surname: 'foka', like:0 },
  { id: 6, name: 'Wojti',surname: 'smok', like:0 },
  { id: 7, name: 'Steve',surname: 'rok', like:0 },
  { id: 8, name: 'Axel',surname: 'tłok', like:0 },
  { id: 9, name: 'Guseppe',surname: 'lok', like:0 },
  { id: 10, name: 'Maciuś',surname: 'zbok', like:0 }
];
    isForm: number = 1;
    person: Person = {id: 1,name: '',surname: '', like:0};
    selectedPerson: Person= this.person;

  licznik(person:Person): void{
      if(person.like==0)
      {
        person.like++;
      }
     }

  onSelect(person: Person): void {
       this.selectedPerson = person;
  }
  showForm(): void{
    this.isForm*=-1;
  }

  onSort():void{
    function compare(a,b) {
      if (a.like < b.like)
        return 1;
      if (a.like > b.like)
        return -1;
      return 0;
    }

    this.persons.sort(compare);
  }
    addPerson(event):void{
		this.persons.push(new Person(this.persons.length+1,event.osoba.name, event.osoba.surname));
			console.log(event);
		//	this.clearData();
	}
}

export class Person {
  id: number;
  name: string; 
  surname: string; 
  like: number;

  constructor (id, name, surname){
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.like = 0;
  }
}







