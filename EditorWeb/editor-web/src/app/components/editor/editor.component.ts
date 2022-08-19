import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'editor',
  templateUrl: './editor.component.html',
  styleUrls: ['./editor.component.scss']
})
export class EditorComponent implements OnInit {

  editorOptions = {theme: 'vs-dark', language: 'javascript', minimap: { enabled: false }};

  @Input() code: string;

  constructor() { }

  ngOnInit(): void {
  }

}
