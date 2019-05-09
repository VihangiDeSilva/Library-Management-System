import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-generate-report',
  template: `
  <hr>
  <div class="main-content">
  <div class="container-fluid">
      <div class="row">
          <div class="col-lg-3 col-md-6 col-sm-6">
              <div class="card card-stats">
                  <div class="card-header card-header-warning card-header-icon">
                      <div class="card-icon">
                          <i class="material-icons">content_copy</i>
                      </div>
                      <p class="card-category">Book Used</p>
                      <h3 class="card-title">49/100
                          <small>Pcs</small>
                      </h3>
                  </div>
                  <div class="card-footer">
                      <div class="stats">
                            <i class="material-icons">date_range</i>&nbsp;
                          
                      </div>
                  </div>
              </div>
          </div>
          <div class="col-lg-3 col-md-6 col-sm-6">
              <div class="card card-stats">
                  <div class="card-header card-header-success card-header-icon">
                      <div class="card-icon">
                          <i class="material-icons">store</i>
                      </div>
                      <p class="card-category">DVD Used</p>
                      <h3 class="card-title">20/50</h3>
                  </div>
                  <div class="card-footer">
                      <div class="stats">
                          <i class="material-icons">date_range</i>&nbsp;
                      </div>
                  </div>
              </div>
          </div>
          <div class="col-lg-3 col-md-6 col-sm-6">
              <div class="card card-stats">
                  <div class="card-header card-header-danger card-header-icon">
                      <div class="card-icon">
                          <i class="material-icons">info_outline</i>
                      </div>
                      <p class="card-category">Total Readers</p>
                      <h3 class="card-title">75</h3>
                  </div>
                  <div class="card-footer">
                      <div class="stats">
                          <i class="material-icons">local_offer</i>
                      </div>
                  </div>
              </div>
          </div>
          <div class="col-lg-3 col-md-6 col-sm-6">
              <div class="card card-stats">
                  <div class="card-header card-header-info card-header-icon">
                      <div class="card-icon">
                          <i class="fa fa-book"></i>
                      </div>
                      <p class="card-category">Total Borrowed</p>
                      <h3 class="card-title">30</h3>
                  </div>
                  <div class="card-footer">
                      <div class="stats">
                          <i class="material-icons">&nbsp;</i>
                      </div>
                  </div>
              </div>
          </div>
      </div>


  </div>
</div>



  `,
  styles: []
})
export class GenerateReportComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
