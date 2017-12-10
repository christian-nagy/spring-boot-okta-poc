import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {TournamentListComponent} from './tournament-list/tournament-list.component';
import {TournamentDetailComponent} from './tournament-detail/tournament-detail.component';
import {LoginComponent} from './login/login.component';
import {TournamentService} from './shared/tournament/tournament.service';
import {RouterModule, Routes} from '@angular/router';
import {OktaAuthGuard} from './shared/okta/okta.guard';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {OktaService} from './shared/okta/okta.service';
import {OktaAuthInterceptor} from './shared/okta/okta.interceptor';
import {
  MatButtonModule,
  MatCardModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatToolbarModule
} from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule} from '@angular/forms';


const appRoutes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'tournaments', component: TournamentListComponent, canActivate: [OktaAuthGuard]},
  {path: 'tournaments/:id', component: TournamentDetailComponent, canActivate: [OktaAuthGuard]},
  {path: '', redirectTo: '/tournaments', pathMatch: 'full'}
];


@NgModule({
  declarations: [
    AppComponent,
    TournamentListComponent,
    TournamentDetailComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    BrowserAnimationsModule,
    MatToolbarModule,
    MatListModule,
    MatCardModule,
    MatButtonModule,
    MatIconModule,
    MatInputModule,
    FormsModule
  ],
  providers: [TournamentService, OktaService, OktaAuthGuard, {
    provide: HTTP_INTERCEPTORS,
    useClass: OktaAuthInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule {
}

