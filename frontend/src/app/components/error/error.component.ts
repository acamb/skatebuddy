import { Component, OnInit } from '@angular/core';
import {AppStateService} from "../../app-state.service";

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  styleUrls: ['./error.component.css']
})
export class ErrorComponent implements OnInit {

  appState: AppStateService;

  constructor(appState: AppStateService) {
    this.appState=appState;
  }

  ngOnInit() {
  }

}
