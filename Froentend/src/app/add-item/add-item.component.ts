import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-add-item',
  template: `
  
  <hr>
  
  <div class="con"> 
    <div class="column c1">
      <h3>Please Enter Book Information Here:</h3>

    <form [formGroup]="form1" (ngSubmit)="sendBookData()">

      <label>*ISBN </label>
      
      <input type="text" name="isbn" required formControlName = "isbn">
      <label>*Book Name</label>
      
      <input type="text" name="nameOfBook" required formControlName = "bname">
      <label>*Author Name </label>
    
    <input type="text" name="authorName" required formControlName = "author">
    <label>*Publisher </label>
    
    <input type="text" name="publisher" required formControlName = "publisher">
  <label>*Number Of Pages </label>
     
     <input type="text" name="numberOfPages" required formControlName = "pages">
   
   
   <button type="submit" >Add Book</button>
   
  </form >
 </div>

 <div class="column c2">
 <h3>Please Enter DVD Information Here:</h3>

  
  <form [formGroup]="form2" (ngSubmit)="sendDVDData()">
 
  
       <label>*ISBN </label>
       <input type="text" name="d_isbn" formControlName = "d_isbn" required>
       <label>*DVD Name</label> 
       <input type="text" name="dvdName" formControlName = "dvdName" required>
    
       <label>*languages</label>
       <input type="text" name="languages" formControlName = "languages" required>
   
		<label>*Subtitles;</label> 
        <input type="text" name="subtitles" formControlName = "subtitles" required>
    
       <label>*Name Of The Producer; </label>
       <input type="text" name="nameOfTheProducer" formControlName = "nameOfTheProducer" required>
       <label>*Actors </label>
       <input type="text" name="actors" formControlName = "actors" required>
    
    
    <button type="submit">Add DVD</button>
   
    
  </form>
  
  </div>
  
 </div>
 

  `,
  styles: [
    '.c1{width:40%; height:400px;float:left;} .c2{width:40%; height:400px;float:right;}'
  ]
})
export class AddItemComponent implements OnInit {

  form1: FormGroup;
  form2: FormGroup;
  constructor(private http: HttpClient) { 
    this.form1 = new FormGroup({
      'isbn': new FormControl(null),
      'bname': new FormControl(null),
      'author': new FormControl(null),
      'publisher': new FormControl(null),
      'pages': new FormControl(null)
      
    });

    this.form2 = new FormGroup({
      'd_isbn': new FormControl(null),
      'dvdName': new FormControl(null),
      'languages': new FormControl(null),
      'subtitles': new FormControl(null),
      'nameOfTheProducer': new FormControl(null),
      'actors': new FormControl(null)
      
    });
  }

  ngOnInit() {
  }

  sendBookData(){
    const formData = JSON.stringify(this.form1.value);
    this.http.post('http://localhost:9000/api/addBooks', formData)
   .subscribe((res) => alert(res));

  }

  sendDVDData(){
    const formData = JSON.stringify(this.form2.value);
    this.http.post('http://localhost:9000/api/addDVD', formData)
   .subscribe((res) => alert(res));

  }

}
