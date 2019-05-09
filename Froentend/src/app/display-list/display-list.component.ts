import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs';
//import { Books } from '../Books';

@Component({
  selector: 'app-display-list',
  template: `
  <hr>
  <h2 >Books</h2>
    <table>
    <tr>
    <td>ISBN</td>
    <td>Name</td>
    <td>Author Name</td>
    <td>Availability</td>
    </tr>

    <tr *ngFor="let books of bookArray">
    <div *ngIf="books.currentReader==null;then greenBlock;else redBlock"></div>

    <ng-template #greenBlock>
    <th>{{books.isbn}}</th>
    <th>{{books.itemName}}</th>
    <th>{{books.authorName}}</th>
    <th style="background-color:darkseagreen;color: aliceblue">Available </th>
    </ng-template>
    
    <ng-template #redBlock>
    <th>{{books.isbn}}</th>
    <th>{{books.itemName}}</th>
    <th>{{books.authorName}}</th>
    <th style="background-color:red;color: aliceblue">Not Available </th>
    </ng-template>
    </tr>
    
    </table>
    <h2>DVDs</h2>
    <table>
    <tr>
    <td>ISBN</td>
    <td>Name</td>
    <td>Producer</td>
    <td>Availability</td>

    </tr>

    <tr *ngFor="let dvds of dvdArray">
    <div *ngIf="dvds.currentReader==null;then greenBlock;else redBlock"></div>

    <ng-template #greenBlock>
    <th>{{dvds.isbn}}</th>
    <th>{{dvds.itemName}}</th>
    <th>{{dvds.nameOfTheProducer}} </th>
    <th style="background-color:darkseagreen;color: aliceblue">Available </th>
    </ng-template>

    <ng-template #redBlock>
    <th>{{dvds.isbn}}</th>
    <th>{{dvds.itemName}}</th>
    <th>{{dvds.nameOfTheProducer}} </th>
    <th style="background-color:red;color: aliceblue">Not Available </th>
    </ng-template>

    </tr>

    </table>
  
   
  `,
  styles: [`table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
  }
  th, td {
    padding: 15px;`]
})
export class DisplayListComponent implements OnInit{
  person;

  constructor(private http: HttpClient){

  }


  public bookArray=[];
  public dvdArray=[];

  ngOnInit() {
    const obs =  this.http.get('/api/displayBooks ');
    obs.subscribe((response) => console.log(response));
    this.getBooks().subscribe(data => this.bookArray = data);

    const obss =  this.http.get('/api/displayDVD ');
    obss.subscribe((response) => console.log(response));
    this.getDVDs().subscribe(data => this.dvdArray = data);


  }
  getBooks(): Observable<Books[]> {
    return this.http.get<Books[]>('/api/displayBooks ');
}

getDVDs(): Observable<DVDs[]> {
  return this.http.get<DVDs[]>('/api/displayDVD ');
}



}
export interface Books{
  ISBN:number;
  bookName:string ;      // declare variables
  authorName: string ;
  publisher:string ;
  numberOfPages:number;
}

export interface DVDs{
 DISBN:number;
 nameOfTheFilm:String;     // declare variables
 languages:String;
 subtitles:String;
 nameOfTheProducer:String;
 actors:String;
}
