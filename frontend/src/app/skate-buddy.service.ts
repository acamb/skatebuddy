import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "./model/User";
import {Observable, of} from "rxjs/index";
import {environment} from "../environments/environment";
import {Activity} from "./model/Activity";
import {Wheel} from "./model/Wheel";
import {catchError, map} from "rxjs/internal/operators";
import {Router} from "@angular/router";
import {RestResponse} from "./model/RestResponse";
import {Stats} from "./model/Stats";
import {AppStateService} from "./app-state.service";

@Injectable({
  providedIn: 'root'
})
export class SkateBuddyService {

  getServer(): string{
    let getUrl = window.location;
    let baseUrl = getUrl .protocol + "//" + getUrl.host + environment.context
    return baseUrl;
  }

  constructor(private http :HttpClient,private router: Router,private appState: AppStateService ) {

  }

  getUser(): Observable<User> {
    //this.appState.overlay=true;
    return this.http.get<User>(this.getServer()+ "/api/user/get");
  }

  authorize() {
    this.appState.overlay=true;
    this.http.get(this.getServer() + "/api/user/authorize").toPromise();
  }

  getUserActivities(): Observable<Array<Activity>>{
    this.appState.overlay=true;
    return this.http.get<Array<Activity>>(this.getServer()+"/api/activities/get");
  }

  getWheels(): Observable<Array<Wheel>>{
    this.appState.overlay=true;
    return this.http.get<Array<Wheel>>(this.getServer()+"/api/wheels/get");
  }

  addWheel(wheel: Wheel): Observable<Array<Wheel>>{
    this.appState.overlay=true;
    return this.http.post<Array<Wheel>>(this.getServer()+"/api/wheels/add",wheel);
  }

  setCurrentWheel(wheel: Wheel): Observable<Array<Wheel>>{
    this.appState.overlay=true;
    return this.http.post<Array<Wheel>>(this.getServer()+"/api/wheels/current",wheel);
  }

  importNewActivities(): Observable<Array<Activity>>{
    this.appState.overlay=true;
    return this.http.get<RestResponse<Array<Activity>>>(this.getServer()+"/api/activities/import").pipe(
      map( resp => resp.payload)
    );
  }

  rotateWheel(wheel: Wheel): Observable<Wheel> {
    this.appState.overlay=true;
    return this.http.put<Wheel>(this.getServer()+"/api/wheels/rotate",wheel);
  }

  deleteWheel(wheel: Wheel):Observable<Array<Wheel>>{
    this.appState.overlay=true;
    return this.http.delete<Array<Wheel>>(this.getServer()+"/api/wheels/delete?id="+wheel.id);
  }

  private handleError<T>(result?: T){
    return (error: any): Observable<T> => {
      console.error(error);
      this.router.navigateByUrl("/error");
      return of(result as T);
    };
  }

  updateStats(stats: Stats): Observable<Stats> {
    this.appState.overlay=true;
    return this.http.put<Stats>(this.getServer()+"/api/user/stats/update",stats);
  }

  deleteActivity(activity: Activity) {
    this.appState.overlay=true;
    return this.http.delete(this.getServer()+ "/api/activities/delete?id=" + activity.id)
  }

  changeWheel(activity: Activity){
    this.appState.overlay=true;
    return this.http.put(this.getServer() + "/api/activities/change",activity);
  }
}
