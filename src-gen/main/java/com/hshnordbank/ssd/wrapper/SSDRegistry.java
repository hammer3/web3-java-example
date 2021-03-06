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
    private static final String BINARY = "6060604052341561000c57fe5b5b6115cb8061001c6000396000f30060606040523615610060576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680631dc9bace14610075578063277ae4d2146100bf578063a484b3d01461021a578063c52046de14610317575b341561006857fe5b6100735b610000565b565b005b341561007d57fe5b6100a9600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050610341565b6040518082815260200191505060405180910390f35b34156100c757fe5b6100fc600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803590602001909190505061038e565b604051808c73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018b60ff1660ff1681526020018a73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001897cffffffffffffffffffffffffffffffffffffffffffffffffffffffffff19167cffffffffffffffffffffffffffffffffffffffffffffffffffffffffff191681526020018881526020018781526020018660ff1660ff1681526020018563ffffffff1663ffffffff1681526020018463ffffffff1663ffffffff1681526020018360ff1660ff1681526020018281526020019b50505050505050505050505060405180910390f35b341561022257fe5b6102d5600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919080357cffffffffffffffffffffffffffffffffffffffffffffffffffffffffff191690602001909190803590602001909190803590602001909190803560ff1690602001909190803563ffffffff1690602001909190803563ffffffff1690602001909190803560ff1690602001909190803590602001909190803560001916906020019091905050610973565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b341561031f57fe5b610327610b96565b604051808215151515815260200191505060405180910390f35b6000600060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208054905090505b919050565b600060006000600060006000600060006000600060006000600060008f73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208d8154811015156103f257fe5b906000526020600020900160005b9054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050808173ffffffffffffffffffffffffffffffffffffffff1663c19d93fb6000604051602001526040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401809050602060405180830381600087803b151561048e57fe5b60325a03f1151561049b57fe5b5050506040518051905060038111156104b057fe5b8273ffffffffffffffffffffffffffffffffffffffff1663c3df65466000604051602001526040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401809050602060405180830381600087803b151561051c57fe5b60325a03f1151561052957fe5b505050604051805190508373ffffffffffffffffffffffffffffffffffffffff1663e5a6b10f6000604051602001526040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401809050602060405180830381600087803b151561059f57fe5b60325a03f115156105ac57fe5b505050604051805190508473ffffffffffffffffffffffffffffffffffffffff16630deae51a6000604051602001526040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401809050602060405180830381600087803b151561062257fe5b60325a03f1151561062f57fe5b505050604051805190508573ffffffffffffffffffffffffffffffffffffffff16637c3a00fd6000604051602001526040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401809050602060405180830381600087803b15156106a557fe5b60325a03f115156106b257fe5b505050604051805190508673ffffffffffffffffffffffffffffffffffffffff1663bd7097e16000604051602001526040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401809050602060405180830381600087803b151561072857fe5b60325a03f1151561073557fe5b505050604051805190508773ffffffffffffffffffffffffffffffffffffffff16633b39e5ae6000604051602001526040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401809050602060405180830381600087803b15156107ab57fe5b60325a03f115156107b857fe5b505050604051805190508873ffffffffffffffffffffffffffffffffffffffff1663d59624b46000604051602001526040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401809050602060405180830381600087803b151561082e57fe5b60325a03f1151561083b57fe5b505050604051805190508973ffffffffffffffffffffffffffffffffffffffff166342f889b26000604051602001526040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401809050602060405180830381600087803b15156108b157fe5b60325a03f115156108be57fe5b505050604051805190508a73ffffffffffffffffffffffffffffffffffffffff1663e235ad2f6000604051602001526040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401809050602060405180830381600087803b151561093457fe5b60325a03f1151561094157fe5b505050604051805190509b509b509b509b509b509b509b509b509b509b509b505b509295989b509295989b9093969950565b60006000600060008d73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090508b8b8b8b8b8b8b8b8b8b6109ca610ba0565b808b73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018a7cffffffffffffffffffffffffffffffffffffffffffffffffffffffffff19167cffffffffffffffffffffffffffffffffffffffffffffffffffffffffff191681526020018981526020018881526020018760ff1660ff1681526020018663ffffffff1663ffffffff1681526020018563ffffffff1663ffffffff1681526020018460ff1660ff16815260200183815260200182600019166000191681526020019a5050505050505050505050604051809103906000f0801515610abe57fe5b9150808054806001018281610ad39190610bb0565b916000526020600020900160005b84909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550507f55ea21a9e4af98f7771f2e85b2284eefe0fc3f111ea491b875785fb4942c1b0d82604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390a15b509a9950505050505050505050565b6000600190505b90565b60405161099e80610c0283390190565b815481835581811511610bd757818360005260206000209182019101610bd69190610bdc565b5b505050565b610bfe91905b80821115610bfa576000816000905550600101610be2565b5090565b9056006060604052341561000c57fe5b6040516101408061099e833981016040528080519060200190919080519060200190919080519060200190919080519060200190919080519060200190919080519060200190919080519060200190919080519060200190919080519060200190919080519060200190919050505b898073ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614156100b557610000565b600460019054906101000a900463ffffffff16600460059054906101000a900463ffffffff168063ffffffff168263ffffffff1611156100f457610000565b6001600060006101000a81548160ff0219169083600381111561011357fe5b021790555033600060016101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508c600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508b600160146101000a81548162ffffff02191690837d010000000000000000000000000000000000000000000000000000000000900402179055508a6002819055508960038190555088600460006101000a81548160ff021916908360ff16021790555087600460016101000a81548163ffffffff021916908363ffffffff16021790555086600460056101000a81548163ffffffff021916908363ffffffff16021790555085600460096101000a81548160ff021916908360ff1602179055508460058190555083600681600019169055505b5b50505b50505050505050505050505b6107118061028d6000396000f300606060405236156100d9576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630deae51a146100ee57806312424e3f146101145780631d143848146101265780633b39e5ae1461017857806342f889b2146101aa5780634dc415de146101d65780637022b58e146101e85780637c3a00fd146101fa578063904c609414610220578063bd7097e11461024e578063c19d93fb1461027a578063c3df6546146102ae578063d59624b414610300578063e235ad2f14610332578063e5a6b10f14610358575b34156100e157fe5b6100ec5b610000565b565b005b34156100f657fe5b6100fe6103be565b6040518082815260200191505060405180910390f35b341561011c57fe5b6101246103c4565b005b341561012e57fe5b61013661047e565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b341561018057fe5b6101886104a4565b604051808263ffffffff1663ffffffff16815260200191505060405180910390f35b34156101b257fe5b6101ba6104ba565b604051808260ff1660ff16815260200191505060405180910390f35b34156101de57fe5b6101e66104cd565b005b34156101f057fe5b6101f8610587565b005b341561020257fe5b61020a610641565b6040518082815260200191505060405180910390f35b341561022857fe5b610230610647565b60405180826000191660001916815260200191505060405180910390f35b341561025657fe5b61025e61064d565b604051808260ff1660ff16815260200191505060405180910390f35b341561028257fe5b61028a610660565b6040518082600381111561029a57fe5b60ff16815260200191505060405180910390f35b34156102b657fe5b6102be610673565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b341561030857fe5b610310610699565b604051808263ffffffff1663ffffffff16815260200191505060405180910390f35b341561033a57fe5b6103426106af565b6040518082815260200191505060405180910390f35b341561036057fe5b6103686106b5565b60405180827cffffffffffffffffffffffffffffffffffffffffffffffffffffffffff19167cffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916815260200191505060405180910390f35b60025481565b600060009054906101000a900460ff16600060038111156103e157fe5b8160038111156103ed57fe5b1415156103f957610000565b600060019054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561045557610000565b6001600060006101000a81548160ff0219169083600381111561047457fe5b02179055505b5b50565b600060019054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600460019054906101000a900463ffffffff1681565b600460099054906101000a900460ff1681565b600060009054906101000a900460ff16600160038111156104ea57fe5b8160038111156104f657fe5b14151561050257610000565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561055e57610000565b6003600060006101000a81548160ff0219169083600381111561057d57fe5b02179055505b5b50565b600060009054906101000a900460ff16600160038111156105a457fe5b8160038111156105b057fe5b1415156105bc57610000565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561061857610000565b6002600060006101000a81548160ff0219169083600381111561063757fe5b02179055505b5b50565b60035481565b60065481565b600460009054906101000a900460ff1681565b600060009054906101000a900460ff1681565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600460059054906101000a900463ffffffff1681565b60055481565b600160149054906101000a90047d01000000000000000000000000000000000000000000000000000000000002815600a165627a7a723058207f0f1fa43412e32d38d4ed33a58b0bef6360111d4efdf7b8fd9ab4b61db5d56a0029a165627a7a72305820b0fe1ca3a63d77301405893a1c00bca8b0176bfa227557c6abd565cf1f6c4e5f0029";

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
