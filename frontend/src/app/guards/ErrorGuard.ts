import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {Injectable} from "@angular/core";
import {AppStateService} from "../app-state.service";
import {Observable} from "rxjs/index";
@Injectable()
export class ErrorGuard implements CanActivate{

  constructor(private appState: AppStateService,private router: Router){

  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if(this.appState.error != undefined){
      return true;
    }
    else{
      this.router.navigateByUrl("/skateBuddy");
      return false;
    }
  }
}
