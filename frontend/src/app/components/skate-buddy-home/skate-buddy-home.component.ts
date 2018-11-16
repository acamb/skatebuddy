import { Component, OnInit } from '@angular/core';
import {SkateBuddyService} from "../../skate-buddy.service";
import {User} from "../../model/User";
import {Observable} from "rxjs/index";
import {AppStateService} from "../../app-state.service";
import {animations} from "../../animations";

@Component({
  selector: 'app-skate-buddy-home',
  templateUrl: './skate-buddy-home.component.html',
  styleUrls: ['./skate-buddy-home.component.css'],
  animations: [ animations ]
})
export class SkateBuddyHomeComponent implements OnInit {

  appState: AppStateService;

  constructor(private service: SkateBuddyService,
              appState: AppStateService) {
    this.appState=appState;
    this.init();
  }

  async init() {


    this.appState.user = await this.service.getUser().toPromise();
    this.appState.wheels = await this.service.getWheels().toPromise();

    if (!this.appState.initialized) {
    //autoimport enabled only if a set of wheel is defined as 'current'
    if (this.appState.user.accessToken != undefined &&
      this.appState.user.stats.autoimport &&
      this.appState.user.stats.currentWheel != undefined) {
      this.appState.activies = await this.service.importNewActivities().toPromise();
    }
    this.appState.initialized=true;
  }
  }

  ngOnInit() {

  }



}
