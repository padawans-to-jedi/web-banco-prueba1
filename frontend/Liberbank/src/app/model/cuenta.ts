export class Cuenta {

    constructor(
      public data: Data[]
    ) {}
}

export class Data {

  constructor(
    public resourceId: string,
    public iban: string,
    public currency: string,
    public product: string
  ) {}
}

export class BreakdownAccounts {

  constructor(
    public transaccion: TransaccionData[]
  ) {}

}

export class TransaccionData {

  constructor(
    public transactionId: string,
    public entryReference: string,
    public bookingDate: string,
    public amount: Amount,
    public balances: Balances
  ) {}
}

export class Amount{

  constructor(
    public currency: string,
    public amount: 0
  ) {}
}

export class Balances {

  constructor(
    public closingBooked: closingBooked
  ) {}
}

export class LastChangeDateTime {
  constructor(
    public lastChangeDateTime: string
  ) {}
}

export class closingBooked {

  constructor(
    public lastChangeDateTime: LastChangeDateTime,
    public amount: Amount
    ) {}
}
