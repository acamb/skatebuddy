import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';

@Component({
  selector: 'app-overlay',
  templateUrl: './overlay.component.html',
  styleUrls: ['./overlay.component.css']
})
export class OverlayComponent implements OnInit,OnChanges {

  @Input()
  show: boolean;

  filteredShow: boolean;

  @Input()
  text: string;

  constructor() { }

  ngOnInit() {
  }


  ngOnChanges(changes: SimpleChanges): void {
    if (this.show){
      setTimeout(() => this.filteredShow=this.show,300);
    }
    else{
      this.filteredShow = this.show;
    }
  }
}
