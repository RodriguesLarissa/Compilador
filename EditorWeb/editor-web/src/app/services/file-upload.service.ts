import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FileUploadService {

  // API url
  apiUrl = "https://file.io"

  constructor(private http: HttpClient) { }

  upload(file: any): Observable<any> {
      const formData = new FormData();
      formData.append("file", file, file.name);
      return this.http.post(this.apiUrl, formData);
  }
}
