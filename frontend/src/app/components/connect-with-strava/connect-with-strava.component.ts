import { Component, OnInit } from '@angular/core';
import {SkateBuddyService} from "../../skate-buddy.service";
import {environment} from "../../../environments/environment";
import {animations} from "../../animations";

@Component({
  selector: 'app-connect-with-strava',
  templateUrl: './connect-with-strava.component.html',
  styleUrls: ['./connect-with-strava.component.css'],
  animations: [ animations ]
})
export class ConnectWithStravaComponent implements OnInit {

  authorizeUrl : string;

  constructor(private service: SkateBuddyService) {
    this.authorizeUrl = service.getServer() + environment.authorizeUrl;
  }

  ngOnInit() {
  }

}
