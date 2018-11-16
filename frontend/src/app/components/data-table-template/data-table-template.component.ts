import {Component, Input, OnInit, TemplateRef} from '@angular/core';

@Component({
  selector: 'app-data-table-template',
  templateUrl: './data-table-template.component.html',
  styleUrls: ['./data-table-template.component.css']
})
export class DataTableTemplateComponent<T> implements OnInit {

  @Input()
  data: T[];
  @Input()
  itemsPerPage: number = 10;
  @Input()
  currentPage = 1;
  @Input()
  paginated:boolean = false;
  @Input()
  headerTemplate: TemplateRef<any>;
  @Input()
  itemTemplate: TemplateRef<any>;
  constructor() { }

  ngOnInit() {
  }

  pageChange(event) {
    this.currentPage = event.page;
  }

  get pagedData(){
    if(this.data == undefined){
      return undefined;
    }
    if (!this.paginated) {
      return this.data;
    }
    const first = (this.currentPage - 1) * this.itemsPerPage;
    return this.data.slice( first, first + this.itemsPerPage );
  }

}
