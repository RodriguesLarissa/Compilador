import { FilesBarComponent } from './../components/files-bar/files-bar.component';
import { EditorComponent } from './../components/editor/editor.component';
import { ToolsBarComponent } from '../components/tools-bar/tools-bar.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { MainPageComponent } from '../main-page/main-page.component';
import { HttpClientModule } from '@angular/common/http';
import { MonacoEditorModule } from 'ngx-monaco-editor';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    MainPageComponent,
    ToolsBarComponent,
    EditorComponent,
    FilesBarComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    MonacoEditorModule.forRoot()
  ],
  providers: [],
  bootstrap: [MainPageComponent]
})
export class MainPageModule { }
