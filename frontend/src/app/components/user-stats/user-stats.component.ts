import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {User} from "../../model/User";
import {SkateBuddyService} from "../../skate-buddy.service";
import {AppStateService} from "../../app-state.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-user-stats',
  templateUrl: './user-stats.component.html',
  styleUrls: ['./user-stats.component.css']
})
export class UserStatsComponent implements OnInit {

  @ViewChild("addWheelModal") modal;
  @Input()
  user: User;

  constructor(private service: SkateBuddyService,
              private appState: AppStateService,
              private router: Router) { }

  ngOnInit() {
  }

  importNewActivities(){
    if((this.appState.activies == undefined || this.appState.activies.length == 0) && (this.appState.wheels == undefined || this.appState.wheels.length == 0)){
      this.openModal();
    }
    else{
      this.refresh();
    }
  }

  openModal(){
    this.modal.open();
  }

  closeModal(){
    this.refresh();
    this.modal.close();
  }

  addWheel(){
    this.router.navigateByUrl("/wheels");
  }

  async refresh(){
    this.appState.activies = await this.service.importNewActivities().toPromise();
    this.appState.user = await this.service.getUser().toPromise();
  }

}
