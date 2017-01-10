import { Component } from '@angular/core';

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
`]


})
export class AppComponent {

    title = 'List of people';
    persons = PERSONS;
    person: Person = {id: 1,name: 'Windstorm', like:0};
    selectedPerson: Person=this.person;

    licznik(person:Person): void{
      if(person.like==0)
      {
        person.like++;
      }
     }

    onSelect(person: Person): void {
       this.selectedPerson = person;
  }

      onSort():void{
    function compare(a,b) {
      if (a.like < b.like)
        return 1;
      if (a.like > b.like)
        return -1;
      return 0;
    }

    PERSONS.sort(compare);
  }
  
}
export class Person {
  id: number;
  name: string;  
  like: number;
}
const PERSONS: Person[] = [
  { id: 1, name: 'Misiałkeł', like:0 },
  { id: 2, name: 'Emlkeł', like:0 },
  { id: 3, name: 'Faciolubski', like:0 },
  { id: 4, name: 'Cyrano', like:0 },
  { id: 5, name: 'Patryś', like:0 },
  { id: 6, name: 'Wojti', like:0 },
  { id: 7, name: 'Steve', like:0 },
  { id: 8, name: 'Axel', like:0 },
  { id: 9, name: 'Guseppe', like:0 },
  { id: 10, name: 'Maciuś', like:0 }
];




