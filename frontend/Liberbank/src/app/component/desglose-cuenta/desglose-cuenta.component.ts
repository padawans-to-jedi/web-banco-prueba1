import { Component, OnInit } from '@angular/core';
import { Cuenta, BreakdownAccounts } from '../../model/cuenta';
import { Router, ActivatedRoute, Params } from '@angular/router';


@Component({
  selector: 'app-desglose-cuenta',
  templateUrl: './desglose-cuenta.component.html',
  styleUrls: ['./desglose-cuenta.component.css']
})
export class DesgloseCuentaComponent implements OnInit {

  public cuentas: Cuenta;
  public desglosesCuenta: BreakdownAccounts;

  constructor(
    private _route: ActivatedRoute,
    private _router: Router
  ) {
    this.cuentas = new Cuenta ([])
    this.desglosesCuenta = new BreakdownAccounts ([])

  }

  ngOnInit() {
  }

  volver() {
    this._router.navigate(['/cuenta']);
    console.log("quiero volver")
  }


}
