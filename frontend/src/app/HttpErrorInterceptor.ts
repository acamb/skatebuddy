import {HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {catchError, finalize, tap} from "rxjs/internal/operators";
import {Observable, of, throwError} from "rxjs/index";
import {Router} from "@angular/router";
import {Injectable} from "@angular/core";
import {AppStateService} from "./app-state.service";
@Injectable()
export class HttpErrorInterceptor implements HttpInterceptor {

  constructor(private router: Router,
              private appState: AppStateService){

  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>>{
    return next.handle(request)
      .pipe(
        finalize(()=> {this.appState.overlay=false;}),
        catchError(  (error: HttpErrorResponse) => {
          let errMsg = '';
          // Client Side Error
          if (error.error instanceof ErrorEvent) {
            errMsg = `Error calling ${request.url}: ${error.error.message}`;
          }
          else {  // Server Side Error
            errMsg = `Error calling ${request.url}: ${error.status} - ${error.message}`;
          }
          this.appState.error = errMsg;
          this.router.navigateByUrl("/error");
          //return of({});
          return throwError(errMsg);
        })
      )
  }
}
