import {Pipe, PipeTransform} from "@angular/core";
import {TranslateService} from "@ngx-translate/core";
import {DatePipe} from "@angular/common";

@Pipe({
  name: 'date'
})
export class LocalizedDatePipe implements PipeTransform {

  constructor(private translateService: TranslateService) {

  }

  public transform(value: any, pattern: string = 'mediumDate'): any {
    let ngPipe = new DatePipe(this.translateService.currentLang);
    return ngPipe.transform(value, pattern);
  }

}
