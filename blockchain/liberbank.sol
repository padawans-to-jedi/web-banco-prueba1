pragma solidity >=0.4.21 <0.6.0;

contract DemoBank {

 address owner;

 struct transfer {
     uint8 paymentType;
     int amount;
     uint orderId;
 }
 mapping(uint => transfer[]) public operations;

 event EventAddPaymentOrder(uint indexed userId, uint indexed orderId, uint8 indexed paymentType, int amount);

 constructor() public {
   owner = msg.sender;
 }

 modifier restricted() {
   if (msg.sender == owner) _;
 }

 function addPaymentOrder(uint userId, uint orderId, uint8 paymentType, int amount) external restricted {
   transfer memory newTransfer = transfer(paymentType, amount, orderId);
   operations[userId].push(newTransfer);
   emit EventAddPaymentOrder(userId, orderId, paymentType, amount);
 }

}