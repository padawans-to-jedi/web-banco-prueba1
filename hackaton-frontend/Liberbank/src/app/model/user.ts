export class User {

    constructor(
        public userID: string,
        public name: string,
        public surname: string,
        public phone: string,
        public email: string,
        public address: Address
    ) {}


}

export class Address {
    constructor( 
        public street: string,
        public country: string,
        public number: string,
        public floor: string,
        public postalCode: string
    ){}
}