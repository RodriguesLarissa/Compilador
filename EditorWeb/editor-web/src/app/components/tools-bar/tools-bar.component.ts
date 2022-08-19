import { Component, OnInit } from '@angular/core';
import { FileUploadService } from './../../services/file-upload.service';

@Component({
  selector: 'tools-bar',
  templateUrl: './tools-bar.component.html',
  styleUrls: ['./tools-bar.component.scss']
})
export class ToolsBarComponent implements OnInit {

  file: File;

  constructor(private fileUploadService: FileUploadService) { }

  ngOnInit(): void {
  }

  onChange(file: any) {
    let fileReader = new FileReader();

    this.file = file.target.files[0];
    this.fileUploadService.upload(this.file).subscribe(
      (_) => {
        fileReader.onload = (_) => {
          console.log(fileReader.result);
        }
        fileReader.readAsText(this.file);
      }
    );
  }

}
