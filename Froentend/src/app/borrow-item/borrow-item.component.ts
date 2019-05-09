import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-borrow-item',
  template: `
  
  <hr>
  
  <div class="con"> 
    <div class="column c1">
      <h3>Please Enter  Information Here:</h3>

    <form [formGroup]="form3" (ngSubmit)="borrowedItem()">

      <label>*ISBN </label>
      <input type="text" name="isbn" required formControlName = "_isbn">
      
      <label>*Reader ID</label>
      <input type="text" name="readerId" required formControlName = "reader_id">
      
      <label>*Borrowed Date  </label>
      <input type="text" name="borrowedDate" required formControlName = "b_date">
    
    <label>*Borrowed Month </label>
    <input type="text" name="borrowedMonth" required formControlName = "b_month">
  
    <label>*Borrowed Year </label>
     <input type="text" name="borrowedYear" required formControlName = "b_year">

     <label>*Borrowed Hours </label>
     <input type="text" name="borrowedHours" required formControlName = "b_hours">

     <label>*Borrowed Min</label>
     <input type="text" name="borrowedMin" required formControlName = "b_mins">
   
   
   <button type="submit" >Submit</button>
   
  </form >
 </div>


  `,
  
})
export class BorrowItemComponent implements OnInit {
  form3: FormGroup;
  constructor(private http: HttpClient) { 
    this.form3 = new FormGroup({
      '_isbn': new FormControl(null),
      'reader_id': new FormControl(null),
      'b_date': new FormControl(null),
      'b_month': new FormControl(null),
      'b_year': new FormControl(null),
      'b_hours': new FormControl(null),
      'b_mins': new FormControl(null)

      
    });

  }
  

  ngOnInit() {
  }

  borrowedItem() {
    const formData = JSON.stringify(this.form3.value);
    this.http.post('http://localhost:9000/api/borrowItem', formData)
    .subscribe((res) => alert(res));
  }
}
