import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-return-item',
  template: `
  <hr>
  
  <div class="con"> 
    <div class="column c1">
      <h3>Please Enter  Information Here:</h3>

    <form [formGroup]="form4" (ngSubmit)="returnedItem()">

      <label>*ISBN </label>
      <input type="text" name="risbn" required formControlName = "r_isbn">
      
      <label>*Reader ID</label>
      <input type="text" name="readerId" required formControlName = "reader_id">
      
      <label>*Returned Date  </label>
      <input type="text" name="returnedDate" required formControlName = "r_date">
    
    <label>*Returned Month </label>
    <input type="text" name="returnedMonth" required formControlName = "r_month">
  
    <label>*Returned Year </label>
     <input type="text" name="returnedYear" required formControlName = "r_year">

     <label>*Returned Hours </label>
     <input type="text" name="returnedHours" required formControlName = "r_hours">

     <label>*Returned Min</label>
     <input type="text" name="returnedMin" required formControlName = "r_mins">
   
   
   <button type="submit" >Submit</button>
   
  </form >
 </div>
  `,
  styles: []
})
export class ReturnItemComponent implements OnInit {
  form4: FormGroup;
  constructor(private http: HttpClient) { 
    this.form4 = new FormGroup({
      'r_isbn': new FormControl(null),
      'reader_id': new FormControl(null),
      'r_date': new FormControl(null),
      'r_month': new FormControl(null),
      'r_year': new FormControl(null),
      'r_hours': new FormControl(null),
      'r_mins': new FormControl(null)

    });

  }

  ngOnInit() {
  }

    returnedItem() {
      const formData = JSON.stringify(this.form4.value);
      this.http.post('http://localhost:9000/api/returnItem', formData)
      .subscribe((res) => alert(res));
    }
  }


