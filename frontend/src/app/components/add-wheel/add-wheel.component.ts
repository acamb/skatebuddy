import { Component, OnInit } from '@angular/core';
import {SkateBuddyService} from "../../skate-buddy.service";
import {Wheel} from "../../model/Wheel";
import {Router} from "@angular/router";
import {Location} from "@angular/common";
import {AppStateService} from "../../app-state.service";
import {animations} from "../../animations";
@Component({
  selector: 'app-add-wheel',
  templateUrl: './add-wheel.component.html',
  styleUrls: ['./add-wheel.component.css'],
  animations: [ animations ]
})
export class AddWheelComponent implements OnInit {


  wheel = new Wheel();


  constructor(private service: SkateBuddyService,
              private router : Router,
              private appState: AppStateService,
              private location: Location) { }

  ngOnInit() {
  }

  async addWheel(){
    this.appState.wheels = await this.service.addWheel(this.wheel).toPromise();
    this.appState.user = await this.service.getUser().toPromise();
  }

  reset(){
    this.wheel = new Wheel();
  }

  back(){
    this.location.back();
  }

}
