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

  constructor(
    private _userRegisterService: UserRegistreService,
    private _route: ActivatedRoute,
    private _router: Router
  ) {
    this.idTransaccion = new Hash("")
  }

  ngOnInit() {
  }

  consultarHash() {
    console.log(this.idTransaccion)

    this._userRegisterService.consultHash(this.idTransaccion).subscribe(
      response => {
        console.log(response)
        this.transactionResponse = response;
        console.log(this.transactionResponse)
        console.log(this.transactionResponse.debitor)
        console.log(this.transactionResponse.creditor)
        console.log(this.transactionResponse.ammount)
        this._router.navigate(['/login']);

      }, error => {
        console.error(error)
      }
    )
  }



}
