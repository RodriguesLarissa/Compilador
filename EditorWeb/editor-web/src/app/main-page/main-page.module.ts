import { ToolsBarComponent } from '../components/barra-ferramentas/tools-bar/tools-bar.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { MainPageComponent } from '../main-page/main-page.component';

@NgModule({
  declarations: [
    MainPageComponent,
    ToolsBarComponent
  ],
  imports: [
    BrowserModule,
  ],
  providers: [],
  bootstrap: [MainPageComponent]
})
export class MainPageModule { }
