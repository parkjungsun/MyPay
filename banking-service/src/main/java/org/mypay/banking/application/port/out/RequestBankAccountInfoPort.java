package org.mypay.banking.application.port.out;

import org.mypay.banking.adapter.out.external.bank.BankAccount;
import org.mypay.banking.adapter.out.external.bank.GetBankAccountRequest;

public interface RequestBankAccountInfoPort {
    BankAccount getBankAccountInfo(GetBankAccountRequest request);
}
