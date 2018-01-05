import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule} from "@angular/router";
import { NgbModule} from "@ng-bootstrap/ng-bootstrap";

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ProgramComponent } from './program/program.component';
import { StartingStrongComponent } from './program/starting-strong/starting-strong.component';
import { Phase1Component } from './program/starting-strong/phase1/phase1.component';
import { Phase2Component } from './program/starting-strong/phase2/phase2.component';
import { Phase3Component } from './program/starting-strong/phase3/phase3.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FormComponent } from './program/starting-strong/phase1/form/form.component';
import { ListComponent } from './program/starting-strong/phase1/list/list.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ProgramComponent,
    StartingStrongComponent,
    Phase1Component,
    Phase2Component,
    Phase3Component,
    NavbarComponent,
    FormComponent,
    ListComponent
  ],
  imports: [
    BrowserModule,
    NgbModule.forRoot(),
    RouterModule.forRoot([
      { path: '', component: HomeComponent },
      { path: 'programs', component: ProgramComponent },
      { path: 'programs/starting-strength', component: StartingStrongComponent },
      { path: 'programs/starting-strength/phase1', component: Phase1Component },
      { path: 'programs/starting-strength/phase2', component: Phase2Component },
      { path: 'programs/starting-strength/phase3', component: Phase3Component },
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
