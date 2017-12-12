import {Component, OnInit} from '@angular/core';
import {OktaService} from './shared/okta/okta.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'My Tournaments';
  user;

  constructor(public oktaService: OktaService) {
  }

  ngOnInit() {
    if (this.oktaService.isAuthenticated()) {
      this.user = this.oktaService.idTokenAsUser;
    }

    this.oktaService.user$.subscribe(user => {
      console.log(user);
      this.user = user;
    });
  }

}
