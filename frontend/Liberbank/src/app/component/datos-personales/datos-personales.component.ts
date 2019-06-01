import { Component, OnInit } from '@angular/core';
import { User } from '../../model/user';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-datos-personales',
  templateUrl: './datos-personales.component.html',
  styleUrls: ['./datos-personales.component.css']
})
export class DatosPersonalesComponent implements OnInit {
  public datosUsuario;

  constructor() { 
    this.datosUsuario = JSON.parse(localStorage.getItem('userLogin'))
  }

  ngOnInit() {

    console.log(this.datosUsuario)
  
  }

}
