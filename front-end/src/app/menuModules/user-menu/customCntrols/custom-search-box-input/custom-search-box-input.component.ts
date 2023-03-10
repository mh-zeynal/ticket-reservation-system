import {Component, ElementRef, Input, OnInit, ViewChild} from '@angular/core';
import {ControlValueAccessor, NG_VALUE_ACCESSOR} from "@angular/forms";
import {City} from "../../../../interfaces/city";

@Component({
  selector: 'app-custom-search-box-input',
  templateUrl: './custom-search-box-input.component.html',
  styleUrls: ['./custom-search-box-input.component.scss'],
  providers: [{
    provide: NG_VALUE_ACCESSOR,
    useExisting: CustomSearchBoxInputComponent,
    multi: true
  }]
})
export class CustomSearchBoxInputComponent implements OnInit, ControlValueAccessor {

  public cities !: City[];

  public results !: City[];

  @ViewChild("option_container") container!: ElementRef;

  @ViewChild('search_box') box!: ElementRef;

  @ViewChild('result_input') input !: ElementRef;

  @Input() dialogue !: string;

  constructor() { }

  ngOnInit(): void {
    this.cities = [
      {
        name: 'tehran'
      },
      {
        name: 'isfahan'
      },
      {
        name: 'shiraz'
      },
      {
        name: 'mashhad'
      },
      {
        name: 'newYork'
      },
      {
        name: 'istanbul'
      },
      {
        name: 'dubai'
      },
      {
        name: 'yazd'
      },
      {
        name: 'semnan'
      },
      {
        name: 'tabriz'
      },
      {
        name: 'rasht'
      },
      {
        name: 'beijing'
      },
      {
        name: 'london'
      },
      {
        name: 'wales'
      },
      {
        name: 'manhattan'
      },
      {
        name: 'detroit'
      },
      {
        name: 'Chicago'
      },
      {
        name: 'los angeles'
      },
      {
        name: 'columbia'
      },
      {
        name: 'california'
      },
      {
        name: 'saw paulo'
      },
      {
        name: 'athens'
      },
      {
        name: 'liverpool'
      },
      {
        name: 'manchester'
      },
      {
        name: 'boston'
      },
      {
        name: 'glasgow'
      },
      {
        name: 'birmingham'
      }
    ]
  }

  showList(event: MouseEvent){
    this.results = this.cities;
    if(!!this.container)
      (this.container.nativeElement as HTMLDivElement).style.display = 'flex';
    event.stopPropagation();
  }

  hideList(){
    if(!!this.container)
      (this.container.nativeElement as HTMLDivElement).style.display = 'none';
  }

  selectCity(val: any, event: MouseEvent){
    this.hideList();
    (this.input.nativeElement as HTMLInputElement).value = val;
    (this.box.nativeElement as HTMLInputElement).value = '';
    this.onChange(val);
    event.stopPropagation();
  }

  searchCity(){
    let val = (this.box.nativeElement as HTMLInputElement).value;
    if (val == '') {
      this.results = this.cities;
      return;
    }
    this.results = this.cities.filter(city => city.name.includes(val));
  }

  onChange = (change:any) => {}

  onTouched = (onTouched:any) => {}

  registerOnChange(fn: any) {
    this.onChange = fn;
  }

  registerOnTouched(fn: any) {
    this.onTouched = fn;
  }

  writeValue(obj: string) {
    this.onChange(obj);
  }

}
