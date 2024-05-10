package org.mypay.banking.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.mypay.banking.application.port.in.RegisterBankAccountCommand;
import org.mypay.banking.application.port.in.RegisterBankAccountUseCase;
import org.mypay.banking.domain.RegisteredBankAccount;
import org.mypay.common.WebAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {

    private final RegisterBankAccountUseCase registerBankAccountUseCase;

    @PostMapping(path = "/banking/account/register")
    RegisteredBankAccount register(@RequestBody RegisterBankAccountRequest request) {
        // request

        // request -> command
        RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
                .membershipId(request.getMembershipId())
                .bankName(request.getBankName())
                .bankAccountNumber(request.getBankAccountNumber())
                .isValid(request.isValid())
                .build();

        // UseCase (param : command)
        RegisteredBankAccount registeredBankAccount = registerBankAccountUseCase.registerBankAccount(command);

        if (registeredBankAccount == null) {
            return null;
        }

        return registerBankAccountUseCase.registerBankAccount(command);
    }

}
