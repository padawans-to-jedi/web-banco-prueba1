import { Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { UserRegistre } from '../model/userRegistre';
import { Login } from '../model/login';
import { GLOBAL } from '../model/Global';
import { sha256 } from 'js-sha256';
  
@Injectable()

export class UserRegistreService {

    public url: string;
    public apiUser;

    constructor(
       public _http: HttpClient
    ) {
        this.url = GLOBAL.url
    }

    registrado(userRegister: UserRegistre): Observable<any>{
        userRegister.password = sha256(userRegister.password)
        console.log(userRegister.password)
        let json = JSON.stringify(userRegister);
        let headers = new HttpHeaders().set('Content-Type', 'application/json');
        let uri = 'registry';

        return this._http.post(this.url + uri, json, {headers: headers});

    }

    acceder(user: Login ): Observable<any> {
        user.password = sha256(user.password)
        let json = JSON.stringify(user);
        console.log(user)
        let headers = new HttpHeaders().set('Content-Type', 'application/json');

        return this._http.post(this.url + 'login', json, {headers: headers})
    }

    getUserLogin() {
        
       let apiUser = JSON.parse(localStorage.getItem('userLogin'));
        if(apiUser != 'undefined') {
            this.apiUser = apiUser;
        } else {
            this.apiUser = null;
        }

        return this.apiUser;
    }

}
