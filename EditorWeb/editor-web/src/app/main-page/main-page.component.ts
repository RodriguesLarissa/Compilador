import { Component } from '@angular/core';

@Component({
  selector: 'main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.scss']
})
export class MainPageComponent {
  title = 'editor-web';

  code: string = '//Digite seu codigo aqui ou abra um arquivo';
}
