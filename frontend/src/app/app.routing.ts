
import { ModuleWithProviders } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SkateBuddyHomeComponent} from "./components/skate-buddy-home/skate-buddy-home.component";
import {ManageWheelsComponent} from "./components/manage-wheels/manage-wheels.component";
import {AddWheelComponent} from "./components/add-wheel/add-wheel.component";
import {ManageActivitiesComponent} from "./components/manage-activities/manage-activities.component";
import {ErrorComponent} from "./components/error/error.component";
import {LoggedInGuard} from "./guards/LoggedInGuard";
import {ErrorGuard} from "./guards/ErrorGuard";
import {SettingsComponent} from "./components/settings/settings.component";


const menuRoutes: Routes = [


  {
    path: 'skateBuddy',
    component: SkateBuddyHomeComponent,
  },
  {
    path: 'wheels',
    component: ManageWheelsComponent,
    canActivate: [LoggedInGuard]
  },
  {
    path: 'activities',
    component: ManageActivitiesComponent,
    canActivate: [LoggedInGuard]
  },
  {
    path: 'addWheel',
    component: AddWheelComponent,
    canActivate: [LoggedInGuard]
  },{
    path: 'settings',
    component: SettingsComponent,
    canActivate: [LoggedInGuard]
  },
  {
    path: 'error',
    component: ErrorComponent,
    canActivate: [ErrorGuard]
  },
  {
    path: '',
    redirectTo: 'skateBuddy',
    pathMatch: 'full'
  }

];

const appRoutes: Routes = [
	...menuRoutes
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes, { useHash: true });
