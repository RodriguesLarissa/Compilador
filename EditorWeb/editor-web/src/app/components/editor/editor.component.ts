import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'editor',
  templateUrl: './editor.component.html',
  styleUrls: ['./editor.component.scss']
})
export class EditorComponent implements OnInit {

  editorOptions = {theme: 'vs-dark', language: 'javascript', minimap: { enabled: false }};
  code: string= '//Digite seu codigo aqui ou abra um arquivo';

  constructor() { }

  ngOnInit(): void {
  }

}
