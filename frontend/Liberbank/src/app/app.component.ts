import { Component, OnInit } from '@angular/core';
import { UserRegistre, Address } from './model/userRegistre';
import { UserRegistreService } from './service/userRegister.service';
import { Router, ActivatedRoute, Params } from '@angular/router';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [UserRegistreService]
})
export class AppComponent implements OnInit{
  title = 'Liberbank';
  public user: UserRegistre;
  public status: string;
  public showForm: boolean;

  constructor(
    private _userRegisterService: UserRegistreService,
    private _route: ActivatedRoute,
    private _router: Router
  ) {
    this.user = new UserRegistre("","","","",new Address("","","","","") ,"")
    this.showForm = true;
  }

  ngOnInit() {
  }

  resgistrar(form) {
    console.log(this.user)
    this._userRegisterService.registrado(this.user).subscribe(
      response => {
        if(response) {
          console.log("Registro completado")
          this.status = 'success'
          this.showForm = false;
          this._router.navigate(['/interface'])

        } else {
          this.status = 'error'
        }
      },
      error => {
        console.error(error)
      }
    );
  }
 
}
 






