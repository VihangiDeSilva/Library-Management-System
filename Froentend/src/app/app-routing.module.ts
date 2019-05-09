import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserInformationComponent } from './user-information/user-information.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AddItemComponent } from './add-item/add-item.component';
import { DeleteItemComponent } from './delete-item/delete-item.component';
import { DisplayListComponent } from './display-list/display-list.component';
import { BorrowItemComponent } from './borrow-item/borrow-item.component';
import { ReturnItemComponent } from './return-item/return-item.component';
import { GenerateReportComponent } from './generate-report/generate-report.component';



const routes: Routes = [
  { path: '', redirectTo: '/departments', pathMatch: 'full' },
  
  { path: 'userinformation',   component: UserInformationComponent },
  { path: 'additem',   component: AddItemComponent },
  { path: 'deleteitem',   component: DeleteItemComponent },
  { path: 'displaylist',   component: DisplayListComponent },
  { path: 'borrowitem',   component: BorrowItemComponent },
  { path: 'returnitem',   component: ReturnItemComponent },
  { path: 'generatereport',   component: GenerateReportComponent },
  { path: '**',   component: PageNotFoundComponent }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [UserInformationComponent,
                                  AddItemComponent,
                                  DeleteItemComponent,
                                  DisplayListComponent,
                                  BorrowItemComponent,
                                  ReturnItemComponent,
                                  GenerateReportComponent,
                                  PageNotFoundComponent,
                                  ]