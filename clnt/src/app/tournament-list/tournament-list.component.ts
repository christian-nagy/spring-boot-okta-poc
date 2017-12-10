import {Component, OnInit} from '@angular/core';
import {TournamentService} from "../shared/tournament/tournament.service";

@Component({
  selector: 'app-tournament-list',
  templateUrl: './tournament-list.component.html',
  styleUrls: ['./tournament-list.component.css']
})
export class TournamentListComponent implements OnInit {

  tournaments: Array<any>;

  constructor(private ts: TournamentService) {
  }

  ngOnInit() {
    this.ts.getAll().subscribe(data => {
      this.tournaments = data;
    }, error => console.error(error));
  }

}
