package org.mypay.membership.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.mypay.common.WebAdapter;
import org.mypay.membership.application.port.in.RegisterMembershipCommand;
import org.mypay.membership.application.port.in.RegisterMembershipUseCase;
import org.mypay.membership.domain.MemberShip;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMemberShipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping(path = "/membership/register")
    MemberShip register(@RequestBody RegisterMembershipRequest request) {
        // request

        // request -> command
        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .isValid(true)
                .isCorp(request.isCorp())
                .build();

        // UseCase (param : command)
        return registerMembershipUseCase.registerMembership(command);
    }

}
