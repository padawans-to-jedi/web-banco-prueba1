export class Hash {
  constructor(
    public hash: string
  ) {}
}


export class Transactions {
  constructor(
    public debitor: Debitor,
    public creditor: Creditor,
    public ammount: 0

  ) {}
}

export class Debitor {
  constructor(
    public name: string,
    public surname: string
  ) {}
}

export class Creditor {
  constructor(
    public name: string,
    public surname: string
  ) {}
}
