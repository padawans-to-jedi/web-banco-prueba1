export class Cuenta {
    constructor(
      public data: Data
    ) {

    }
}

export class Data {

  constructor(
    public resourceId: string,
    public iban: string,
    public currency: string,
    public product: string
  ) {}
}
