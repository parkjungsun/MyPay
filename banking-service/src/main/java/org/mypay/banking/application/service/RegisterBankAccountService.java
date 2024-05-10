package org.mypay.banking.application.service;

import lombok.RequiredArgsConstructor;
import org.mypay.banking.adapter.out.external.bank.BankAccount;
import org.mypay.banking.adapter.out.external.bank.GetBankAccountRequest;
import org.mypay.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import org.mypay.banking.adapter.out.persistence.RegisteredBankAccountMapper;
import org.mypay.banking.application.port.in.RegisterBankAccountCommand;
import org.mypay.banking.application.port.in.RegisterBankAccountUseCase;
import org.mypay.banking.application.port.out.RegisterBankAccountPort;
import org.mypay.banking.application.port.out.RequestBankAccountInfoPort;
import org.mypay.banking.domain.RegisteredBankAccount;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

    private final RegisterBankAccountPort registerBankAccountPort;
    private final RequestBankAccountInfoPort requestBankAccountInfoPort;
    @Override
    public RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command) {

        // 은행 계좌를 등록해야하는 서비스 (비즈니스 로직)

        // 0. (멤버 서비스 확인) 여기서는 skip

        // 1. 등록된 계좌인지 확인한다
        //    - 외부의 은행에 이 계좌 정상인지 확인
        //    - Biz Logic -> External System [Port -> Adapter 통해서 나간다] : hexagonal
        BankAccount accountInfo = requestBankAccountInfoPort.getBankAccountInfo(new GetBankAccountRequest(command.getBankName(), command.getBankAccountNumber()));
        boolean accountInfoValid = accountInfo.isValid();

        if (accountInfoValid) {
        // 2-1. 등록가능한 계좌라면 등록한다.
            
            // 등록 정보 저장
            RegisteredBankAccountJpaEntity savedAccountInfo = registerBankAccountPort.createRegisteredBankAccount(
                    new RegisteredBankAccount.MemberShipId(command.getMembershipId() + ""),
                    new RegisteredBankAccount.BankName(command.getBankName()),
                    new RegisteredBankAccount.BankAccountNumber(command.getBankAccountNumber()),
                    new RegisteredBankAccount.LinkedStatusIsValid(command.isValid())
            );
            return RegisteredBankAccountMapper.mapToDomainEntity(savedAccountInfo);
        } else {
            // 2-2. 등록가능하지 않는 계좌라면, 예외 리턴
            return null;
        }
    }

}
