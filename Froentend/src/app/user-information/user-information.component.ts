import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-user-information',
  template: `
  
  <hr>
  
  <div class="con"> 
    <div class="column c1">
      <h3>Please Enter User Information Here:</h3>

    <form [formGroup]="form4" (ngSubmit)="addReaders()">

      <label>*Reader ID </label>
      <input type="text" name="readid" required formControlName = "readerId">
      
      <label>*Mobile Number</label>
      <input type="text" name="mobileNumber" required formControlName = "readerMobileNo">
      
      <label>*Name </label>
      <input type="text" name="readerName" required formControlName = "readerName">
    
    <label>*Email </label>
    <input type="email" name="readerEmail" required formControlName = "readerEmail">
  
   
   
   
   <button type="submit" >Submit</button>
   
  </form >
 </div>



  `,
  styles: []
})
export class UserInformationComponent implements OnInit {
  form4: FormGroup;
  constructor(private http: HttpClient) { 
    this.form4 = new FormGroup({
      'readerId': new FormControl(null),
      'readerMobileNo': new FormControl(null),
      'readerName': new FormControl(null),
      'readerEmail': new FormControl(null),
    });
    }

  ngOnInit() {
    
  }
  addReaders() {
    const formData = JSON.stringify(this.form4.value);
    this.http.post('http://localhost:9000/api/addReaders', formData)
    .subscribe((res) => alert(res));
  }
}
