package es.atsistemas.alastria;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.2.0.
 */
public class DemoBank extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5060008054600160a060020a0319163317905561021a806100326000396000f30060806040526004361061004b5763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663c69b16308114610050578063d9c5c05414610076575b600080fd5b34801561005c57600080fd5b5061007460043560243560ff604435166064356100b3565b005b34801561008257600080fd5b50610091600435602435610184565b6040805160ff9094168452602084019290925282820152519081900360600190f35b6100bb6101c9565b60005473ffffffffffffffffffffffffffffffffffffffff1633141561017d57506040805160608101825260ff848116808352602080840186815284860189815260008b8152600180855288822080548083018255908352918590208851600390930201805460ff191692909716919091178655915191850191909155516002909301929092558351858152935192939092879289927f7e098f67211f06c9b594a538ca5853652a0057013cc989f631eb09284959733b929081900390910190a45b5050505050565b60016020528160005260406000208181548110151561019f57fe5b600091825260209091206003909102018054600182015460029092015460ff909116935090915083565b606060405190810160405280600060ff168152602001600081526020016000815250905600a165627a7a72305820cef29b3c607480cbe4cb497d60b00724056e1777b82d051f5196cce6484fc8730029";

    public static final String FUNC_ADDPAYMENTORDER = "addPaymentOrder";

    public static final String FUNC_OPERATIONS = "operations";

    public static final Event EVENTADDPAYMENTORDER_EVENT = new Event("EventAddPaymentOrder", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Uint256>(true) {}, new TypeReference<Uint8>(true) {}, new TypeReference<Int256>() {}));
    ;

    @Deprecated
    protected DemoBank(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected DemoBank(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected DemoBank(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected DemoBank(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> addPaymentOrder(BigInteger userId, BigInteger orderId, BigInteger paymentType, BigInteger amount) {
        final Function function = new Function(
                FUNC_ADDPAYMENTORDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(userId), 
                new org.web3j.abi.datatypes.generated.Uint256(orderId), 
                new org.web3j.abi.datatypes.generated.Uint8(paymentType), 
                new org.web3j.abi.datatypes.generated.Int256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple3<BigInteger, BigInteger, BigInteger>> operations(BigInteger param0, BigInteger param1) {
        final Function function = new Function(FUNC_OPERATIONS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0), 
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}, new TypeReference<Int256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple3<BigInteger, BigInteger, BigInteger>>(
                new Callable<Tuple3<BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple3<BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<BigInteger, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public List<EventAddPaymentOrderEventResponse> getEventAddPaymentOrderEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(EVENTADDPAYMENTORDER_EVENT, transactionReceipt);
        ArrayList<EventAddPaymentOrderEventResponse> responses = new ArrayList<EventAddPaymentOrderEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            EventAddPaymentOrderEventResponse typedResponse = new EventAddPaymentOrderEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.userId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.orderId = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.paymentType = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<EventAddPaymentOrderEventResponse> eventAddPaymentOrderEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, EventAddPaymentOrderEventResponse>() {
            @Override
            public EventAddPaymentOrderEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(EVENTADDPAYMENTORDER_EVENT, log);
                EventAddPaymentOrderEventResponse typedResponse = new EventAddPaymentOrderEventResponse();
                typedResponse.log = log;
                typedResponse.userId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.orderId = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.paymentType = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<EventAddPaymentOrderEventResponse> eventAddPaymentOrderEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EVENTADDPAYMENTORDER_EVENT));
        return eventAddPaymentOrderEventFlowable(filter);
    }

    @Deprecated
    public static DemoBank load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new DemoBank(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static DemoBank load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new DemoBank(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static DemoBank load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new DemoBank(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static DemoBank load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new DemoBank(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<DemoBank> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(DemoBank.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<DemoBank> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(DemoBank.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<DemoBank> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DemoBank.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<DemoBank> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DemoBank.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class EventAddPaymentOrderEventResponse {
        public Log log;

        public BigInteger userId;

        public BigInteger orderId;

        public BigInteger paymentType;

        public BigInteger amount;
    }
}
