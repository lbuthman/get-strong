import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ProgramComponent } from './program/program.component';
import { StartingStrongComponent } from './program/starting-strong/starting-strong.component';
import { Phase1Component } from './program/starting-strong/phase1/phase1.component';
import { Phase2Component } from './program/starting-strong/phase2/phase2.component';
import { Phase3Component } from './program/starting-strong/phase3/phase3.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ProgramComponent,
    StartingStrongComponent,
    Phase1Component,
    Phase2Component,
    Phase3Component
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
