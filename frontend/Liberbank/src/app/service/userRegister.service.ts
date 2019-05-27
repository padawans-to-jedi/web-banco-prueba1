import { Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { UserRegistre } from '../model/userRegistre';
import { GLOBAL } from '../model/Global';
import { sha256 } from 'js-sha256';
  
@Injectable()

export class UserRegistreService {

    public url: string;

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

}
