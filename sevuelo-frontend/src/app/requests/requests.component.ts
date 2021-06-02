import { Component, OnInit } from '@angular/core';
import { Request } from '../request.model';
import { RequestService } from '../request.service';

@Component({
  selector: 'app-requests',
  templateUrl: './requests.component.html',
  styleUrls: ['./requests.component.scss']
})
export class RequestsComponent implements OnInit {

  requests: Request[] = [];
  selectedRequest: Request;
  messageEmpty: string;

  constructor(private requestService: RequestService) { }

  ngOnInit(): void {
    this.messageEmpty = 'No found information.!';
    this.getRequests();
  }

  getRequests(): void {
    this.requestService.getRequests()
      .subscribe(requests => this.requests = requests);
  }

  onClickDelete(request: Request): void {
    this.requestService.deleteRequest(request).subscribe( resp => {
      if (resp) {
        this.getRequests();
        /*this.requests.forEach( (item, idx) => {
          if (item.id === request.id) {
            this.requests.slice(idx, 1);
          }
        });*/
      }
    } );
  }

}
