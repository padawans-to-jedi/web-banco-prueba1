import { Component, OnInit } from '@angular/core';
import { User } from '../../model/user';
import { UserRegistreService } from '../../service/userRegister.service';

@Component({
  selector: 'app-datos-personales',
  templateUrl: './datos-personales.component.html',
  styleUrls: ['./datos-personales.component.css'],
  providers: [UserRegistreService]
})
export class DatosPersonalesComponent implements OnInit {
  public datosUsuario;
  public datosUsuarioModificado: User;
  public showForm: boolean;
  public status: string;

  constructor(
    public _userRegistreService: UserRegistreService
  ) { 
    this.datosUsuario = JSON.parse(localStorage.getItem('userLogin'));
    this.showForm = true;
  }

  ngOnInit() {

   
    console.log(this.datosUsuario.bearer)
  
  }

  modificar() {
   
      this._userRegistreService.updateUser(this.datosUsuario).subscribe(
        response => {
          console.log(response)

          localStorage.setItem('userLogin', JSON.stringify(this.datosUsuario));
          console.log('Usuario modificado')

          if(response) {
            console.log("Registro completado")
            this.status = 'success'
            this.showForm = false;
  
          } else {
            this.status = 'error'
            this.showForm = false;
          }
        },
        error => {
          console.error(error)
        }
      )    
  }

}
