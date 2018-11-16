import {Component, OnInit} from '@angular/core';
import {TranslateService} from '@ngx-translate/core';
import {AppStateService} from "./app-state.service";
import {RouterOutlet} from "@angular/router";
import {animations} from "./animations";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  animations: [ animations ]
})
export class AppComponent implements OnInit{

  appState: AppStateService;


  constructor(translate: TranslateService,private _appState: AppStateService){
    translate.addLangs(["en", "it"]);
    translate.setDefaultLang('en');
    let browserLang = translate.getBrowserLang();
    translate.use(browserLang.match(/en|it/) ? browserLang : 'en');
    this.appState=_appState;
  }


  ngOnInit(): void {
    $(".navbar-nav li a").click(function (event) {
      // check if window is small enough so dropdown is created
      var toggle = $(".navbar-toggle").is(":visible");
      if (toggle) {
        //IMPORTANT: the cast is necessary to avoid "Property 'collapse' does not exist on type 'JQuery<HTMLElement>'."
        (<any>$(".navbar-collapse")).collapse('hide');
      }
    });
  }

  prepareRoute(outlet: RouterOutlet) {
    return outlet && outlet.activatedRouteData;
  }
}


