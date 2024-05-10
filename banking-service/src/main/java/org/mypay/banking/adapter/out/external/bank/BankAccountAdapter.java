package org.mypay.banking.adapter.out.external.bank;

import lombok.RequiredArgsConstructor;
import org.mypay.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import org.mypay.banking.adapter.out.persistence.SpringDataRegisteredBankAccountRepository;
import org.mypay.banking.application.port.out.RegisterBankAccountPort;
import org.mypay.banking.application.port.out.RequestBankAccountInfoPort;
import org.mypay.banking.domain.RegisteredBankAccount;
import org.mypay.common.ExternalSystemAdapter;
import org.mypay.common.PersistenceAdapter;

@ExternalSystemAdapter
@RequiredArgsConstructor
public class BankAccountAdapter implements RequestBankAccountInfoPort {

    @Override
    public BankAccount getBankAccountInfo(GetBankAccountRequest request) {

        return new BankAccount(request.getBankName(), request.getBankAccountNumber(), true);
    }
}
