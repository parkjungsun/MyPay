package org.mypay.banking.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.mypay.banking.application.port.out.RegisterBankAccountPort;
import org.mypay.banking.domain.RegisteredBankAccount;
import org.mypay.common.PersistenceAdapter;

@PersistenceAdapter
@RequiredArgsConstructor
public class RegisteredBankAccountPersistenceAdapter implements RegisterBankAccountPort {

    private final SpringDataRegisteredBankAccountRepository bankAccountRepository;

    @Override
    public RegisteredBankAccountJpaEntity createRegisteredBankAccount(RegisteredBankAccount.MemberShipId memberShipId, RegisteredBankAccount.BankName bankName, RegisteredBankAccount.BankAccountNumber bankAccountNumber, RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid) {
        return bankAccountRepository.save(
                new RegisteredBankAccountJpaEntity(
                    memberShipId.getMemberShipId(),
                    bankName.getBankName(),
                    bankAccountNumber.getBankAccountNumber(),
                    linkedStatusIsValid.isLinkedStatusIsValid()
                )
        );
    }
}
