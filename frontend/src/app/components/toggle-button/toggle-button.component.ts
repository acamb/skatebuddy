import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-toggle-button',
  templateUrl: './toggle-button.component.html',
  styleUrls: ['./toggle-button.component.css']
})
export class ToggleButtonComponent implements OnInit {

  @Input()
  value: boolean;
  @Output()
  valueChange= new EventEmitter<boolean>();

  constructor() { }

  ngOnInit() {
  }

  toggle(){
    //this.value = !this.value;
    this.valueChange.emit(!this.value);
  }
}
