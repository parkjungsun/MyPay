package org.mypay.banking.application.port.in;

import org.mypay.banking.domain.RegisteredBankAccount;
import org.mypay.common.UseCase;

@UseCase
public interface RegisterBankAccountUseCase {

    RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command);

}
