import { Component, OnInit } from '@angular/core';
import { Cuenta } from '../../model/cuenta';

@Component({
  selector: 'app-cuenta',
  templateUrl: './cuenta.component.html',
  styleUrls: ['./cuenta.component.css']
})
export class CuentaComponent implements OnInit {

  public cuentas: Cuenta;

  constructor() {

    this.cuentas = new Cuenta ([])

  }

  ngOnInit() {
  }

}
