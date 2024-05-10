package org.mypay.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisteredBankAccount {

    @Getter private final String registeredBankAccountId;
    @Getter private final String memberShipId;
    @Getter private final String bankName;
    @Getter private final String bankAccountNumber;
    @Getter private final boolean linkedStatusIsValid;

    public static RegisteredBankAccount generateRegisteredBankAccount (
            RegisteredBankAccount.RegisteredBankAccountId registeredBankAccountId,
            RegisteredBankAccount.MemberShipId memberShipId,
            RegisteredBankAccount.BankName bankName,
            RegisteredBankAccount.BankAccountNumber bankAccountNumber,
            RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid
    ) {
        return new RegisteredBankAccount(
                registeredBankAccountId.registeredBankAccountId,
                memberShipId.memberShipId,
                bankName.bankName,
                bankAccountNumber.bankAccountNumber,
                linkedStatusIsValid.linkedStatusIsValid
        );
    }

    @Value
    public static class RegisteredBankAccountId {
        String registeredBankAccountId;
        public RegisteredBankAccountId(String value) {this.registeredBankAccountId = value;}
    }
    @Value
    public static class MemberShipId {
        String memberShipId;
        public MemberShipId(String value) {this.memberShipId = value;}
    }
    @Value
    public static class BankName {
        String bankName;
        public BankName(String value) {this.bankName = value;}
    }
    @Value
    public static class BankAccountNumber {
        String bankAccountNumber;
        public BankAccountNumber(String value) {this.bankAccountNumber = value;}
    }
    @Value
    public static class LinkedStatusIsValid {
        boolean linkedStatusIsValid;
        public LinkedStatusIsValid(boolean value) {this.linkedStatusIsValid = value;}
    }
}
