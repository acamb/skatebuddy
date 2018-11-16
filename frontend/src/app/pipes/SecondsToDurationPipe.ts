
import {Pipe, PipeTransform} from "@angular/core";

@Pipe({
  name: 'secondsToDuration'
})
export class SecondsToDurationPipe implements PipeTransform {


  transform(seconds){
    return new Date(seconds * 1000).toISOString().substr(11, 8);
  }
}
