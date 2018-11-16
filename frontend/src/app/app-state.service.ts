import { Injectable } from '@angular/core';
import {User} from "./model/User";
import {Activity} from "./model/Activity";
import {Wheel} from "./model/Wheel";

@Injectable({
  providedIn: 'root'
})
export class AppStateService {

  private _user: User;
  private _activities: Array<Activity>;
  private _wheels: Array<Wheel>;
  private _error: string;
  private _overlay = false;
  private _initialized=false;


  get initialized(): boolean {
    return this._initialized;
  }

  set initialized(value: boolean) {
    this._initialized = value;
  }

  get overlay(): boolean {
    return this._overlay;
  }

  set overlay(value: boolean) {
    this._overlay = value;
  }

  get error(): string {
    return this._error;
  }

  set error(value: string) {
    this._error = value;
  }

  get user(){
    return this._user;
  }

  set user(user: User){
    this._user = user;
  }

  get activies(){
    return this._activities;
  }

  set activies(activities: Array<Activity>){
    this._activities = activities;
  }

  get wheels(){
    return this._wheels;
  }

  set wheels(wheels: Array<Wheel>){
    this._wheels = wheels;
  }

  constructor() { }
}
