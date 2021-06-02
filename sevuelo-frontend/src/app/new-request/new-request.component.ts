import { Component, OnInit } from '@angular/core';
import { RequestService } from '../request.service';
import { Request } from '../request.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-request',
  templateUrl: './new-request.component.html',
  styleUrls: ['./new-request.component.scss']
})
export class NewRequestComponent implements OnInit {

  request: Request;

  constructor(
    private requestService: RequestService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.request = new Request();
  }

  previousState(): void {
    window.history.back();
  }


  save(): void {

    this.requestService.addRequest(this.request)
      .subscribe((newRequest) => {
        this.request = newRequest;
        this.router.navigate(['/requests']);
      }
    );

  }

}
