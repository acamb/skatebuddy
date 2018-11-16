import { Component, OnInit } from '@angular/core';
import {AppStateService} from "../../app-state.service";
import {SkateBuddyService} from "../../skate-buddy.service";
import {animations} from "../../animations";

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.css'],
  animations: [ animations ]
})
export class SettingsComponent implements OnInit {

  appState: AppStateService;
  saved=false;

  constructor(private _appStateService: AppStateService,private service: SkateBuddyService) {
    this.appState=_appStateService;
  }

  ngOnInit() {
  }

  async save(){
    this.appState.user.stats = await this.service.updateStats(this.appState.user.stats).toPromise();
    this.saved = true;
  }

}
