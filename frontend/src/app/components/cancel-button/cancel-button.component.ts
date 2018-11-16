import {Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';

@Component({
  selector: 'app-cancel-button',
  templateUrl: './cancel-button.component.html',
  styleUrls: ['./cancel-button.component.css']
})
export class CancelButtonComponent implements OnInit {

  @Input()
  payload: any;

  @Input()
  deleteKey = "cancel"

  @Output()
  onCancel = new EventEmitter();

  @ViewChild('confirmModal') modal;

  constructor() { }

  ngOnInit() {
  }

  openConfirmDialog(){
    this.modal.open();
  }

  closeModal(){
    this.modal.close();
  }

  cancel(){
    this.onCancel.emit(this.payload);
  }

}
