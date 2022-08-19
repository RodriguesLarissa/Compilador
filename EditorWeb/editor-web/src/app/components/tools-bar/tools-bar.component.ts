import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FileUploadService } from './../../services/file-upload.service';

@Component({
  selector: 'tools-bar',
  templateUrl: './tools-bar.component.html',
  styleUrls: ['./tools-bar.component.scss']
})
export class ToolsBarComponent implements OnInit {

  file: File;

  @Output() code = new EventEmitter<any>();

  constructor(private fileUploadService: FileUploadService) { }

  ngOnInit(): void {
  }

  onChange(file: any) {
    let fileReader = new FileReader();

    this.file = file.target.files[0];
    this.fileUploadService.upload(this.file).subscribe(
      (_) => {
        fileReader.onload = (_) => {
          this.code.emit(fileReader.result);
        }
        fileReader.readAsText(this.file);
      }
    );
  }

}
