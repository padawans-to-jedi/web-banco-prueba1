import { Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { UserRegistre } from '../model/userRegistre';
import { Login } from '../model/login';
import { User } from '../model/user';
import { Cuenta } from '../model/cuenta';

import { GLOBAL } from '../model/Global';

import { sha256 } from 'js-sha256';

@Injectable()

export class UserRegistreService {

    public url: string;
    public apiUser: User;

    constructor(
       public _http: HttpClient
    ) {
        this.url = GLOBAL.url
        this.apiUser  = JSON.parse(localStorage.getItem('userLogin'));
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

    updateUser( user: User): Observable<any> {

        let json = JSON.stringify(user);
        console.log(user)
        let headers = new HttpHeaders().set('Content-Type', 'application/json').set('Authorization','Bearer '+ this.apiUser.bearer);
        console.log(headers)
        return this._http.put(this.url + 'users/'+  user.userID, json, {headers: headers})
    }


    getAccount() {

    }

}
