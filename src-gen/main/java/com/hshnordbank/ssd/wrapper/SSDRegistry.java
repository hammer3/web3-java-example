package com.hshnordbank.ssd.wrapper;

import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes3;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint32;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.<br>
 * <strong>Do not modify!</strong><br>
 * Please use {@link org.web3j.codegen.SolidityFunctionWrapperGenerator} to update.
 *
 * <p>Generated with web3j version 2.1.0.
 */
public final class SSDRegistry extends Contract {
    private static final String BINARY = "6060604052341561000c57fe5b5b610eb08061001c6000396000f300606060405236156100465763ffffffff60e060020a6000350416631dc9bace811461005b578063277ae4d214610089578063a484b3d014610127578063c52046de14610198575b341561004e57fe5b6100595b610000565b565b005b341561006357fe5b610077600160a060020a03600435166101bc565b60408051918252519081900360200190f35b341561009157fe5b6100a8600160a060020a03600435166024356101db565b60408051600160a060020a039c8d16815260ff9b8c16602082015299909b16898c0152600160e860020a03199097166060890152608088019590955260a087019390935290861660c086015263ffffffff90811660e0860152166101008401529092166101208201526101408101919091529051908190036101600190f35b341561012f57fe5b61017c600160a060020a0360043516600160e860020a03196024351660443560643560ff60843581169063ffffffff60a43581169160c4359091169060e43516610104356101243561061b565b60408051600160a060020a039092168252519081900360200190f35b34156101a057fe5b6101a8610745565b604080519115158252519081900360200190f35b600160a060020a0381166000908152602081905260409020545b919050565b600060006000600060006000600060006000600060006000600060008f600160a060020a0316600160a060020a031681526020019081526020016000208d81548110151561022557fe5b906000526020600020900160005b9054906101000a9004600160a060020a031690508081600160a060020a031663c19d93fb6000604051602001526040518163ffffffff1660e060020a028152600401809050602060405180830381600087803b151561028e57fe5b60325a03f1151561029b57fe5b505060405151905060038111156102ae57fe5b82600160a060020a031663c3df65466000604051602001526040518163ffffffff1660e060020a028152600401809050602060405180830381600087803b15156102f457fe5b60325a03f1151561030157fe5b5050506040518051905083600160a060020a031663e5a6b10f6000604051602001526040518163ffffffff1660e060020a028152600401809050602060405180830381600087803b151561035157fe5b60325a03f1151561035e57fe5b5050506040518051905084600160a060020a0316630deae51a6000604051602001526040518163ffffffff1660e060020a028152600401809050602060405180830381600087803b15156103ae57fe5b60325a03f115156103bb57fe5b5050506040518051905085600160a060020a0316637c3a00fd6000604051602001526040518163ffffffff1660e060020a028152600401809050602060405180830381600087803b151561040b57fe5b60325a03f1151561041857fe5b5050506040518051905086600160a060020a031663bd7097e16000604051602001526040518163ffffffff1660e060020a028152600401809050602060405180830381600087803b151561046857fe5b60325a03f1151561047557fe5b5050506040518051905087600160a060020a0316633b39e5ae6000604051602001526040518163ffffffff1660e060020a028152600401809050602060405180830381600087803b15156104c557fe5b60325a03f115156104d257fe5b5050506040518051905088600160a060020a031663d59624b46000604051602001526040518163ffffffff1660e060020a028152600401809050602060405180830381600087803b151561052257fe5b60325a03f1151561052f57fe5b5050506040518051905089600160a060020a03166342f889b26000604051602001526040518163ffffffff1660e060020a028152600401809050602060405180830381600087803b151561057f57fe5b60325a03f1151561058c57fe5b505050604051805190508a600160a060020a031663e235ad2f6000604051602001526040518163ffffffff1660e060020a028152600401809050602060405180830381600087803b15156105dc57fe5b60325a03f115156105e957fe5b505050604051805190509b509b509b509b509b509b509b509b509b509b509b505b509295989b509295989b9093969950565b600160a060020a038a1660009081526020819052604081208b8b8b8b8b8b8b8b8b8b61064561074b565b600160a060020a03909a168a52600160e860020a031990981660208a01526040808a0197909752606089019590955260ff938416608089015263ffffffff92831660a0890152911660c08701521660e0850152610100840152610120830191909152519081900361014001906000f08015156106bd57fe5b91508080548060010182816106d2919061075b565b916000526020600020900160005b8154600160a060020a038087166101009390930a8381029102199091161790915560408051918252517f55ea21a9e4af98f7771f2e85b2284eefe0fc3f111ea491b875785fb4942c1b0d92509081900360200190a15b509a9950505050505050505050565b60015b90565b6040516106de806107a783390190565b81548183558181151161077f5760008381526020902061077f918101908301610785565b5b505050565b61074891905b8082111561079f576000815560010161078b565b5090565b9056006060604052341561000c57fe5b604051610140806106de83398101604090815281516020830151918301516060840151608085015160a086015160c087015160e0880151610100890151610120909901519698959694959394929391929091905b8980600160a060020a031633600160a060020a0316141561008057610000565b60045463ffffffff610100820481169165010000000000900416808211156100a757610000565b600080546001919060ff191682805b021790555033600060016101000a815481600160a060020a030219169083600160a060020a031602179055508c600160006101000a815481600160a060020a030219169083600160a060020a031602179055508b600160146101000a81548162ffffff02191690837d010000000000000000000000000000000000000000000000000000000000900402179055508a6002819055508960038190555088600460006101000a81548160ff021916908360ff16021790555087600460016101000a81548163ffffffff021916908363ffffffff16021790555086600460056101000a81548163ffffffff021916908363ffffffff16021790555085600460096101000a81548160ff021916908360ff1602179055508460058190555083600681600019169055505b5b50505b50505050505050505050505b6104e2806101fc6000396000f300606060405236156100bf5763ffffffff60e060020a6000350416630deae51a81146100d457806312424e3f146100f65780631d143848146101085780633b39e5ae1461013457806342f889b21461015d5780634dc415de146101835780637022b58e146101955780637c3a00fd146101a7578063904c6094146101c9578063bd7097e1146101eb578063c19d93fb14610211578063c3df654614610245578063d59624b414610271578063e235ad2f1461029a578063e5a6b10f146102bc575b34156100c757fe5b6100d25b610000565b565b005b34156100dc57fe5b6100e4610301565b60408051918252519081900360200190f35b34156100fe57fe5b6100d2610307565b005b341561011057fe5b61011861035f565b60408051600160a060020a039092168252519081900360200190f35b341561013c57fe5b610144610373565b6040805163ffffffff9092168252519081900360200190f35b341561016557fe5b61016d610384565b6040805160ff9092168252519081900360200190f35b341561018b57fe5b6100d261039a565b005b341561019d57fe5b6100d26103f2565b005b34156101af57fe5b6100e461044a565b60408051918252519081900360200190f35b34156101d157fe5b6100e4610450565b60408051918252519081900360200190f35b34156101f357fe5b61016d610456565b6040805160ff9092168252519081900360200190f35b341561021957fe5b61022161045f565b6040518082600381111561023157fe5b60ff16815260200191505060405180910390f35b341561024d57fe5b610118610468565b60408051600160a060020a039092168252519081900360200190f35b341561027957fe5b610144610477565b6040805163ffffffff9092168252519081900360200190f35b34156102a257fe5b6100e461048c565b60408051918252519081900360200190f35b34156102c457fe5b6102cc610492565b604080517fffffff00000000000000000000000000000000000000000000000000000000009092168252519081900360200190f35b60025481565b6000805460ff16905b81600381111561031c57fe5b1461032657610000565b60005433600160a060020a03908116610100909204161461034657610000565b600080546001919060ff191682805b02179055505b5b50565b6000546101009004600160a060020a031681565b600454610100900463ffffffff1681565b6004546901000000000000000000900460ff1681565b60005460ff1660015b8160038111156103af57fe5b146103b957610000565b60015433600160a060020a039081169116146103d457610000565b600080546003919060ff1916600183610355565b02179055505b5b50565b60005460ff1660015b81600381111561040757fe5b1461041157610000565b60015433600160a060020a0390811691161461042c57610000565b600080546002919060ff1916600183610355565b02179055505b5b50565b60035481565b60065481565b60045460ff1681565b60005460ff1681565b600154600160a060020a031681565b60045465010000000000900463ffffffff1681565b60055481565b60015474010000000000000000000000000000000000000000900460e860020a02815600a165627a7a72305820b4bd659982cefdcafb55045ebc879b95c4fa5e9b51578d153665a444d51b5a450029a165627a7a72305820ec71cbe31d544b49ace4f98e2e945d062e72f83dbd599d95b10765515936cf7c0029";

    private SSDRegistry(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private SSDRegistry(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<LogNewSSDEventResponse> getLogNewSSDEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("logNewSSD", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event,transactionReceipt);
        ArrayList<LogNewSSDEventResponse> responses = new ArrayList<LogNewSSDEventResponse>(valueList.size());
        for(EventValues eventValues : valueList) {
            LogNewSSDEventResponse typedResponse = new LogNewSSDEventResponse();
            typedResponse.ssd = (Address)eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogNewSSDEventResponse> logNewSSDEventObservable() {
        final Event event = new Event("logNewSSD", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST,DefaultBlockParameterName.LATEST, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogNewSSDEventResponse>() {
            @Override
            public LogNewSSDEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                LogNewSSDEventResponse typedResponse = new LogNewSSDEventResponse();
                typedResponse.ssd = (Address)eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public Future<Uint256> getSSDCount(Address counterparty) {
        Function function = new Function("getSSDCount", 
                Arrays.<Type>asList(counterparty), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<List<Type>> getSSD(Address counterparty, Uint256 index) {
        Function function = new Function("getSSD", 
                Arrays.<Type>asList(counterparty, index), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint8>() {}, new TypeReference<Address>() {}, new TypeReference<Bytes3>() {}, new TypeReference<Uint256>() {}, new TypeReference<Int256>() {}, new TypeReference<Uint8>() {}, new TypeReference<Uint32>() {}, new TypeReference<Uint32>() {}, new TypeReference<Uint8>() {}, new TypeReference<Uint256>() {}));
        return executeCallMultipleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> createSSD(Address counterparty, Bytes3 currency, Uint256 nominal, Int256 interestRate, Uint8 interestRateDecimalUnits, Uint32 valueDate, Uint32 maturityDate, Uint8 structured, Uint256 denominationSize, Bytes32 contractHash) {
        Function function = new Function("createSSD", Arrays.<Type>asList(counterparty, currency, nominal, interestRate, interestRateDecimalUnits, valueDate, maturityDate, structured, denominationSize, contractHash), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Bool> isDeployed() {
        Function function = new Function("isDeployed", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public static Future<SSDRegistry> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialValue) {
        return deployAsync(SSDRegistry.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialValue);
    }

    public static Future<SSDRegistry> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialValue) {
        return deployAsync(SSDRegistry.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialValue);
    }

    public static SSDRegistry load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SSDRegistry(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static SSDRegistry load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SSDRegistry(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class LogNewSSDEventResponse {
        public Address ssd;
    }
}
