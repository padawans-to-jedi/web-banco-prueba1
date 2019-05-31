import { Component, OnInit } from '@angular/core';
import { UserRegistreService } from '../../service/userRegister.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [UserRegistreService]
})
export class HomeComponent implements OnInit {
  public identity;

  constructor(
    private _userRegisterService: UserRegistreService,
  ) { }

  ngOnInit() {
    this.identity = this._userRegisterService.getUserLogin();
    console.log(this.identity)
  }

}
