import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Request } from '../request.model';
import { RequestService } from '../request.service';

@Component({
  selector: 'app-request-detail',
  templateUrl: './request-detail.component.html',
  styleUrls: ['./request-detail.component.scss']
})
export class RequestDetailComponent implements OnInit {

  @Input() request: Request = new Request();

  valueButton = '';

  constructor(
    private requestService: RequestService,
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.getRequest();
  }

  previousState(): void {
    window.history.back();
  }

  getRequest(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.requestService.getRequest(Number.parseInt(id))
      .subscribe(request => this.request = request);
  }

  reserve(): void {
    this.requestService.reserveRequest(this.request)
      .subscribe((newRequest) => {
        this.request = newRequest;
        this.previousState();
      }
    );
  }

  onChangeStatus(): void {
    this.requestService.changeStatus(this.request)
      .subscribe((newRequest) => {
          this.request = newRequest;
          this.previousState();
        }
      );
  }

  getValueButton(): string {
    if (this.request['status'] === 'NEW'){
      this.valueButton = 'Reserve';
    } else if (this.request['status'] === 'RESERVE') {
      this.valueButton = 'Reverse';
    }
    return this.valueButton;
  }

}
