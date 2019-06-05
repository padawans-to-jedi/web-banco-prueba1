import { Component, OnInit } from '@angular/core';
import { UserRegistreService } from '../../service/userRegister.service';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Login } from '../../model/login';
import { User, Address } from '../../model/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [UserRegistreService]
})
export class LoginComponent implements OnInit {
  public user: Login;
  public apiUser: User;
  public status: string;
  public identity;
  public guardarDatos;

  constructor(
    private _userRegisterService: UserRegistreService,
    private _route: ActivatedRoute,
    private _router: Router
  ) {
    this.user = new Login ("","");
    this.apiUser = new User("","","","","", new Address("","","","",""), "");
  }

  ngOnInit() {
    this.identity = this._userRegisterService.getUserLogin();
  }

  acceder(form) {
    console.log(this.user)
    this._userRegisterService.acceder(this.user).subscribe(
      response => {
       this.apiUser = response;
       console.log(this.apiUser)

      /* GUARDAMOS LOS DATOS DEL USUARIO EN SESION */
       localStorage.setItem('userLogin', JSON.stringify(this.apiUser));
       console.log('Usuario Logeado')
       this.guardarDatos = JSON.parse(localStorage.getItem('userLogin'))
       console.log(this.guardarDatos)

       if(this.apiUser) {
          this.status = 'success'
          /* CERRA VENTANA MODAL Y RECARGAR AL ENVIAR FORMULARIO  */
          window.location.reload();

       } else {
         this.status = 'error'
       }

      },
      error => {
        console.error(error)
        console.log(<any>error)
      }
    );
  }
}
