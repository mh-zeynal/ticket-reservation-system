import {AfterViewInit, Component, ElementRef, Input, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {ControlValueAccessor, FormControl, NG_VALUE_ACCESSOR, Validators} from "@angular/forms";
import {City} from "../../../../interfaces/city";
import {ConnectionPositionPair} from "@angular/cdk/overlay";
import {MatSelect} from "@angular/material/select";
import {ReplaySubject, Subject} from "rxjs";
import {take, takeUntil} from "rxjs/operators";

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
export class CustomSearchBoxInputComponent implements OnInit, AfterViewInit, OnDestroy, ControlValueAccessor {

  @Input() type !: string;

  cities!: City[];

  cityCtrl = new FormControl(null, Validators.required);

  cityFilterCtrl = new FormControl('');

  filteredCities: ReplaySubject<City[]> = new ReplaySubject<City[]>(1);

  @ViewChild('singleSelect', { static: true }) singleSelect!: MatSelect;

  _onDestroy = new Subject<void>();

  constructor() { }

  ngOnInit() {
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
    this.filteredCities.next(this.cities.slice());
    this.cityFilterCtrl.valueChanges
      .pipe(takeUntil(this._onDestroy))
      .subscribe(() => {
        this.filterBanks();
      });
    this.cityCtrl.valueChanges.subscribe(value => {
      this.onChange(value);
    })
  }

  ngAfterViewInit() {
    this.setInitialValue();
  }

  ngOnDestroy() {
    this._onDestroy.next();
    this._onDestroy.complete();
  }

  setInitialValue() {
    this.filteredCities
      .pipe(take(1), takeUntil(this._onDestroy))
      .subscribe(() => {
        this.singleSelect.compareWith = (a: City, b: City) => a && b && a.name === b.name;
      });
  }

  filterBanks() {
    if (!this.cities) {
      return;
    }
    let search = this.cityFilterCtrl.value;
    if (!search) {
      this.filteredCities.next(this.cities.slice());
      return;
    } else {
      search = search.toLowerCase();
    }
    this.filteredCities.next(
      this.cities.filter(city => city.name.toLowerCase().indexOf(search) > -1)
    );
  }
  // selectCity(val: any, event: MouseEvent){
  //   debugger
  //   this.hideList();
  //   (this.input.nativeElement as HTMLInputElement).value = val;
  //   (this.box.nativeElement as HTMLInputElement).value = '';
  //   this.onChange(val);
  //   event.stopPropagation();
  // }

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
