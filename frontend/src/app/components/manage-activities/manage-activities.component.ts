import {Component, OnInit, ViewChild} from '@angular/core';
import {animations} from "../../animations";
import {AppStateService} from "../../app-state.service";
import {SkateBuddyService} from "../../skate-buddy.service";
import {Activity} from "../../model/Activity";
import {Wheel} from "../../model/Wheel";

@Component({
  selector: 'app-manage-activities',
  templateUrl: './manage-activities.component.html',
  styleUrls: ['./manage-activities.component.css'],
  animations: [ animations ]
})
export class ManageActivitiesComponent implements OnInit {

  @ViewChild("detailModal") detailModal;
  selected = new Activity();
  appState: AppStateService;

  constructor(private _appState: AppStateService,private service: SkateBuddyService) {
    this.appState=_appState;
    this.init();
  }

  async init(){
    this.appState.activies = await this.service.getUserActivities().toPromise();
  }

  get activities(){
    return this.appState.activies;
  }

  ngOnInit() {
  }

  async cancel(activity: Activity){
    await this.service.deleteActivity(activity).toPromise();
    this.appState.activies = await this.service.getUserActivities().toPromise();
  }

  goToDetail(activity: Activity){
    this.selected=activity;
    this.detailModal.open();
  }

  async updateWheel(activity: Activity){
    await this.service.changeWheel(activity).toPromise();
    this.appState.wheels = await this.service.getWheels().toPromise();
    this.appState.user = await this.service.getUser().toPromise();
  }

  compareWheel = (a: Wheel,b: Wheel) => {
    if(a == undefined || b == undefined) return false;
    return a.id == b.id;
  }

}
