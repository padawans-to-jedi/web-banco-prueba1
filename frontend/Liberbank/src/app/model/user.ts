export class User {

    constructor(
        public userID: string,
        public name: string,
        public surname: string,
        public phone: string,
        public email: string,
        public address: {
            street: string,
            country: string,
            number: string,
            floor: string,
            postalCode: string,
        },
        public products: {
            productID: string,
            productName: string
        }
    ) {}


}