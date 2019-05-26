import { Component, OnInit } from '@angular/core';
import { UserRegistre, Address } from './model/userRegistre';
import { registerModuleFactory } from '@angular/core/src/linker/ng_module_factory_loader';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'Liberbank';
  public user: UserRegistre;


  constructor() {
    this.user = new UserRegistre("","","","",new Address("","","","","") ,"")
  }

  ngOnInit() {
   console.log(this.user)
   this.resgistrar()
  
  }

  resgistrar() {
    console.log("Estoy haciendo click")
    console.log(this.user)
  }
 
}
 






