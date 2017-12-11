import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class TournamentService {

  public API = 'http://localhost:8081';
  // public TOURNAMENT_API = this.API + '/tour';
  public TOURNAMENT_API = this.API + '/pokta/tournaments';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get(this.TOURNAMENT_API);
  }

  get(id: string) {
    return this.http.get(this.TOURNAMENT_API + '/' + id);
  }

  save(tournament: any): Observable<any> {
    let result: Observable<Object>;
    if (tournament['href']) {
      result = this.http.put(tournament.href, tournament);
    } else {
      result = this.http.post(this.TOURNAMENT_API, tournament);
    }
    return result; // .catch(error => Observable.throw(error));
  }

  remove(href: string) {
    return this.http.delete(href);
  }

}
