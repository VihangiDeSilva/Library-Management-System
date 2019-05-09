import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-delete-item',
  template: `
 
  <hr>
  
  <div class="con"> 
    <div class="column c1">
    <h3>Please Enter ISBN Of Book Here:</h3>

    <form [formGroup]="deleteForm" (ngSubmit)="deleteData()">

    <label>*ISBN </label>
      
      <input type="text" name="isbn" required formControlName = "isbn">
     
   
   <button type="submit" >Delete</button>
   
  
 </form>
 </div>


 </div>

 

  `,
  styles: [
    '.c1{width:50%; height:500px;float:left;} .c2{width:50%; height:500px;float:right;}'
  ]
})
export class DeleteItemComponent implements OnInit {

  deleteForm:FormGroup;
  constructor(private http: HttpClient) { 
    this.deleteForm = new FormGroup({
      'isbn': new FormControl(null)

    });
  }

  ngOnInit() {
  }

  deleteData() {
    const formData = JSON.stringify(this.deleteForm.value);
    this.http.post('http://localhost:9000/api/delete', formData)
      .subscribe((response) => alert(response));
  }
}
