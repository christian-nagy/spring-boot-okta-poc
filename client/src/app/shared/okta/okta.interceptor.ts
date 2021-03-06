import {Injectable} from '@angular/core';
import {
  HttpErrorResponse,
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
  HttpResponse
} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {OktaService} from './okta.service';
import 'rxjs/add/operator/do';

@Injectable()
export class OktaAuthInterceptor implements HttpInterceptor {

  constructor(private oktaService: OktaService) {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    if (this.oktaService.isAuthenticated()) {
      const accessToken = this.oktaService.signIn.tokenManager.get('accessToken');
      request = request.clone({
        setHeaders: {
          Authorization: `${accessToken.tokenType} ${accessToken.accessToken}`
        }
      });
    }

    return next.handle(request).do((event: HttpEvent<any>) => {
      if (event instanceof HttpResponse) {
        return event;
      } else if (event instanceof HttpErrorResponse) {
        if (event.status === 401) {
          this.oktaService.login();
        }
      }
    });
  }
}
