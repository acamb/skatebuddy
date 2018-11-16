import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Observable} from "rxjs/index";
import {Wheel} from "../../model/Wheel";
import {SkateBuddyService} from "../../skate-buddy.service";
import {AppStateService} from "../../app-state.service";
import {animations} from "../../animations";

@Component({
  selector: 'app-manage-wheels',
  templateUrl: './manage-wheels.component.html',
  styleUrls: ['./manage-wheels.component.css'],
  animations: [ animations ]
})
export class ManageWheelsComponent implements OnInit {

  appState: AppStateService;
  @Output()
  wheelsChange = new EventEmitter<Wheel>();

  constructor(private service: SkateBuddyService,
              appState: AppStateService) {
    this.appState=appState;
    this.loadWheels();
  }

  async loadWheels(){
    let wheels = await this.service.getWheels().toPromise();
    this.appState.wheels=wheels;
  }

  ngOnInit() {
  }

  async setCurrentWheel(wheel: Wheel){
    this.appState.wheels= await this.service.setCurrentWheel(wheel).toPromise();
    this.appState.user = await this.service.getUser().toPromise();
    //this.wheelsChange.emit(wheel);
  }

  async deleteWheel(wheel: Wheel){
    this.appState.wheels= await this.service.deleteWheel(wheel).toPromise();
    this.wheelsChange.emit(wheel);
  }

}
