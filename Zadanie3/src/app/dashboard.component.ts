import { Component, Output, EventEmitter, Inject } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Person } from './app.component';



@Component({
  selector: 'my-dashboard',
  templateUrl: './dashboard.component.html'
})

export class DashboardComponent { 
 
  @Output() 
  addToList = new EventEmitter();

  form: FormGroup;

  constructor(@Inject(FormBuilder) fb: FormBuilder) {
    this.form = fb.group({
      name:["", [Validators.minLength(4), Validators.maxLength(10)]],
      surname:["", Validators.required]
    });
  }

  addPerson():void{
      //console.log("emituje");
      if(this.form.dirty && this.form.valid)
      {
      this.addToList.emit({osoba:this.form.value});  
      }
   }
}

    
