import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { TranslateLoader, TranslateModule, TranslateService } from '@ngx-translate/core';
import {TranslateHttpLoader} from "@ngx-translate/http-loader";
import { AppComponent } from './app.component';
import {HTTP_INTERCEPTORS, HttpClient, HttpClientModule, HttpHandler} from "@angular/common/http";
import {routing} from "./app.routing";
import {SkateBuddyHomeComponent} from "./components/skate-buddy-home/skate-buddy-home.component";
import { ConnectWithStravaComponent } from './components/connect-with-strava/connect-with-strava.component';
import { UserStatsComponent } from './components/user-stats/user-stats.component';
import { ManageWheelsComponent } from './components/manage-wheels/manage-wheels.component';
import { AddWheelComponent } from './components/add-wheel/add-wheel.component';
import { CurrentWheelComponent } from './components/current-wheel/current-wheel.component';
import {environment} from "../environments/environment";
import {FormsModule} from "@angular/forms";
import { ManageActivitiesComponent } from './components/manage-activities/manage-activities.component';
import { ErrorComponent } from './components/error/error.component';
import {HttpErrorInterceptor} from "./HttpErrorInterceptor";
import {LoggedInGuard} from "./guards/LoggedInGuard";
import {ErrorGuard} from "./guards/ErrorGuard";
import {LocalizedDatePipe} from "./pipes/LocalizedDatePipe";
import localeIt from '@angular/common/locales/it';
import {registerLocaleData} from "@angular/common";
import { CancelButtonComponent } from './components/cancel-button/cancel-button.component';
import { ModalComponent } from './components/modal/modal.component';
import { SettingsComponent } from './components/settings/settings.component';
import { ToggleButtonComponent } from './components/toggle-button/toggle-button.component';
import { OverlayComponent } from './components/overlay/overlay.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { DataTableTemplateComponent } from './components/data-table-template/data-table-template.component';
import {PaginationModule} from "ngx-bootstrap";
import { SecondsToDurationPipe} from "./pipes/SecondsToDurationPipe";
registerLocaleData(localeIt);

// AoT requires an exported function for factories
export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http,environment.context + "/assets/i18n/",".json");
}

@NgModule({
  declarations: [
    AppComponent,
    SkateBuddyHomeComponent,
    ConnectWithStravaComponent,
    UserStatsComponent,
    LocalizedDatePipe,
    SecondsToDurationPipe,
    ManageWheelsComponent,
    AddWheelComponent,
    CurrentWheelComponent,
    ManageActivitiesComponent,
    ErrorComponent,
    CancelButtonComponent,
    ModalComponent,
    SettingsComponent,
    ToggleButtonComponent,
    OverlayComponent,
    DataTableTemplateComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    PaginationModule.forRoot(),
    routing,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient]
      }
    })
  ],
  providers: [HttpClient,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpErrorInterceptor,
      multi: true,
    },LoggedInGuard,ErrorGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
