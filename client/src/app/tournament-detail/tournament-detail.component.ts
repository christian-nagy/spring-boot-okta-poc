import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatInput} from '@angular/material';
import {ActivatedRoute, Router} from '@angular/router';
import {TournamentService} from '../shared/tournament/tournament.service';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-tournament-detail',
  templateUrl: './tournament-detail.component.html',
  styleUrls: ['./tournament-detail.component.css']
})
export class TournamentDetailComponent implements OnInit, AfterViewInit {
  tournament: any = {name: ''};
  @ViewChild(MatInput) name: MatInput;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private tournamentService: TournamentService) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      if (params.id !== 'add') {
        this.tournamentService.get(params.id).subscribe((t: any) => {
          this.tournament = t;
          // this.tournament.href = t._links.self.href;
        }, error => console.error(error));
      }
    });
  }

  ngAfterViewInit() {
    setTimeout(() => {
      this.name.focus();
    }, 150);
  }

  onSubmit(form: NgForm) {
    this.tournamentService.save(form).subscribe(() => {
      this.router.navigate(['/tournaments']);
    });
  }

  remove(href) {
    this.tournamentService.remove(href).subscribe(() => {
      this.router.navigate(['/tournaments']);
    });
  }

}
