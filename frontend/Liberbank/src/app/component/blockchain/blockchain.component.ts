import { Component, OnInit } from '@angular/core';
import { Hash, Transactions } from '../../model/hash';
import { UserRegistreService } from '../../service/userRegister.service';
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-blockchain',
  templateUrl: './blockchain.component.html',
  styleUrls: ['./blockchain.component.css'],
  providers: [UserRegistreService]
})
export class BlockchainComponent implements OnInit {

  public idTransaccion: Hash;
  public transactionResponse: Transactions;
  public status: string;
  public showData: boolean;

  constructor(
    private _userRegisterService: UserRegistreService,
    private _route: ActivatedRoute,
    private _router: Router
  ) {
    this.idTransaccion = new Hash("")
    this.showData = true;
  }

  ngOnInit() {
  }

  consultarHash() {
    console.log(this.idTransaccion)

    this._userRegisterService.consultHash(this.idTransaccion).subscribe(
      response => {
        this.transactionResponse = response;
        console.log(this.transactionResponse)

        if(this.transactionResponse) {
          console.log("Tengo los datos de la transacción")
          this.showData = false;
        } else {
          this.showData = true;
        }

        // this._router.navigate(['/login']);

      }, error => {
        console.error(error)
      }
    )
  }



}
