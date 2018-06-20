import { Component, OnInit, Input } from '@angular/core';
import { Accomodation } from '../model/accomodation';
import { FilterService } from './filter.service';
import { QueryShareService } from '../services/queryshare.service';

@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent implements OnInit {

  @Input() accomodations: Accomodation[]
  query: {
    address: string,
    city: string,
    country: string,
    persons: number,
    dateOfArrival: any,
    dateOfReturn: any,
    accomodationTypes: number[],
    accomodationCategories: number[],
    accomodationServices: number[]
  };

  @Input() filters: {
    name: string,
    type: number
  }[];

  categoriesOpen: boolean;
  typesOpen: boolean;
  servicesOpen: boolean;

  allCategories: {
    categoryID: number,
    categoryName: string,
    checked: boolean,
    idd: string
  }[];

  allTypes: {
    typeID: number,
    typeName: string,
    checked: boolean,
    idd: string
  }[];

  allServices: {
    serviceID: number,
    serviceName: string,
    checked: boolean,
    idd: string
  }[];

  fullQuery: string;

  locations: {
    address: string,
    city: string,
    country: string
  }[];

  constructor(
    private filterService: FilterService,
	private queryShareService :QueryShareService
  ) { }

  ngOnInit() {
	  
	  
    this.allCategories = [];
    this.allServices = [];
    this.allTypes = [];
    this.locations = [];
    this.fullQuery = '';
    const date = new Date();
    let tomm = new Date();
    tomm.setTime(date.getTime()+1000*60*60*24);

    this.query = {
      address: '',
      city: '',
      country: '',
      persons: 1,
      dateOfArrival: this.parseDate(date),
      dateOfReturn: this.parseDate(tomm),
      accomodationTypes: [],
      accomodationCategories: [],
      accomodationServices: []
    };

    this.typesOpen = false;
    this.servicesOpen = false;
    this.categoriesOpen = false;

    this.filterService.getTypes().subscribe(
      (data) => {
        this.allTypes = data;
        for(let i=0; i<this.allTypes.length; i++){
          this.allTypes[i].checked = false;
          this.allTypes[i].idd = this.allTypes[i].typeID+"_"+this.allTypes[i].typeName;
        }
      }
    );

    this.filterService.getServices().subscribe(
      (data) => {
        this.allServices = data;
        for(let i=0; i<this.allServices.length; i++){
          this.allServices[i].checked = false;
          this.allServices[i].idd = this.allServices[i].serviceID+"_"+this.allServices[i].serviceName;
        }
      }
    );

    /*this.filterService.getCategories().subscribe(
      (data) => {
        this.allCategories = data;
        for(let i=0; i<this.allCategories.length; i++){
          this.allCategories[i].checked = false;
          this.allCategories[i].idd = this.allCategories[i].categoryID+"_"+this.allCategories[i].categoryName;
        }
      }
    );*/
  }

  public parseDate(date: Date): string{
    let humDate = date.getFullYear()+'-';
    if(date.getMonth()+1 < 10){
      humDate += '0';
    }
      
    humDate += (date.getMonth()+1)+'-';

    if(date.getDate() < 10){
      humDate += '0';
    }

    humDate += date.getDate();
    return humDate;
  }

  public doSearchh() {
	  
	  this.queryShareService.setQuery(this.query);
    this.accomodations.splice(0, this.accomodations.length);

    if(this.categoriesOpen == false && this.typesOpen == false && this.servicesOpen == false){
      this.filterService.doSearch(this.query).subscribe(
        (data) => {
          for(let i=0; i<data.length; i++){
            this.accomodations.push(data[i]);
          }
        }
      );
    }else{
      let categories = [];
      for(let i=0; i<this.allCategories.length; i++){
        if(this.allCategories[i].checked){
          categories.push(this.allCategories[i].categoryID);
        }
      }
      this.query.accomodationCategories = categories;
      
      let types = [];
      for(let i=0; i<this.allTypes.length; i++){
        types.push(this.allTypes[i].typeID);
      }
      this.query.accomodationTypes = types;
  
      let services = [];
      for(let i=0; i<this.allServices.length; i++){
        services.push(this.allServices[i].serviceID);
      }
      this.query.accomodationServices = services;

      this.filterService.doAdvancedSearch(this.query).subscribe(
        (data) => {
          for(let i=0; i<data.length; i++){
            this.accomodations.push(data[i]);
          }
        }
      );
    }
  }

  public searchForLocations(){
    this.locations = [];
    this.query.address = '';
    this.query.city = '';
    this.query.country = '';

    if(this.fullQuery.length > 1){
      this.filterService.getLocations(this.fullQuery).subscribe(
        (data) => {
          this.locations = data;
        }
      );
    }
  }

  public chooseLocation(location: any){
    this.query.address = '';
    this.query.city = '';
    this.query.country = '';
    this.fullQuery = '';

    this.query.address = location.address;
    this.query.city = location.city;
    this.query.country = location.country;
  
    this.locations = [];
    this.locations.push({
      address: this.query.address,
      city: this.query.city,
      country: this.query.country
    })
  }
  
  public openCategories(){
    this.categoriesOpen = !this.categoriesOpen;
  }

  public openServices(){
    this.servicesOpen = !this.servicesOpen;
  }

  public openTypes(){
    this.typesOpen = !this.typesOpen;
  }

  public checkFilter(name: string, type: number){
    for(let filter of this.filters){
      if(filter.name === name && filter.type === type){
        this.filters.splice(this.filters.indexOf(filter), 1);
        return;
      }
    }

    this.filters.push({
      name: name,
      type: type
    });
  }

}
