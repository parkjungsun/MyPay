package org.mypay.banking.application.port.out;

import org.mypay.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import org.mypay.banking.domain.RegisteredBankAccount;

public interface RegisterBankAccountPort {

    RegisteredBankAccountJpaEntity createRegisteredBankAccount (
            RegisteredBankAccount.MemberShipId memberShipId
            , RegisteredBankAccount.BankName bankName
            , RegisteredBankAccount.BankAccountNumber bankAccountNumber
            , RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid);
}
