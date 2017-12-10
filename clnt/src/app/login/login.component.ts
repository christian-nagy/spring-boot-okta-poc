import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {OktaService} from '../shared/okta/okta.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private oktaService: OktaService,
              private router: Router) {
  }

  ngOnInit() {
    if (this.oktaService.isAuthenticated()) {
      this.router.navigate(['/']);
    } else {
      this.oktaService.showLogin();
    }

    // user authentication listener
    this.oktaService.user$.subscribe(user => {
      this.router.navigate(['/']);
    });
  }
}
