import {Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {Wheel} from "../../model/Wheel";
import {SkateBuddyService} from "../../skate-buddy.service";
import {AppStateService} from "../../app-state.service";

@Component({
  selector: 'app-current-wheel',
  templateUrl: './current-wheel.component.html',
  styleUrls: ['./current-wheel.component.css']
})
export class CurrentWheelComponent implements OnInit {

  @ViewChild("rotateModal") rotateModal;
  @Input()
  wheel: Wheel;
  @Output()
  wheelChange= new EventEmitter<Wheel>();

  rotateImgSrc: string;

  appState: AppStateService;

  constructor(private service: SkateBuddyService,
              private _appState: AppStateService) {
    this.appState = _appState;
    this.rotateImgSrc = "assets/img/" + ( this.appState.user.stats.currentWheel.rotationCounter % 2 == 0 ? "giro0.svg" : "giro1.svg");
  }

  get hideRotateWarning(){
    if(this.wheel.currentKM == undefined || this.appState.user.stats.rotationKM == undefined){
      return true;
    }
    if(this.wheel.currentKM < this.appState.user.stats.rotationKM){
      return true;
    }
    return false;
  }

  ngOnInit() {
  }

  async doRotate(){
    let wheelChanged = await this.service.rotateWheel(this.appState.user.stats.currentWheel).toPromise();
    this.wheelChange.emit(wheelChanged);
    this.rotateImgSrc = "assets/img/" + ( this.appState.user.stats.currentWheel.rotationCounter % 2 == 0 ? "giro0.svg" : "giro1.svg");
    this.rotateModal.close();
  }

  rotate(){
    this.rotateModal.open();
  }

  closeModal(){
    this.rotateModal.close();
  }

}
