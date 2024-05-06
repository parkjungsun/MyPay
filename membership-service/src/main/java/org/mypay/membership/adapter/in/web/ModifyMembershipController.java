package org.mypay.membership.adapter.in.web;

import org.mypay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.mypay.membership.application.port.in.FindMembershipCommand;
import org.mypay.membership.application.port.in.FindMembershipUseCase;
import org.mypay.membership.application.port.in.ModifyMembershipCommand;
import org.mypay.membership.application.port.in.ModifyMembershipUseCase;
import org.mypay.membership.domain.MemberShip;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class ModifyMembershipController {

    private final ModifyMembershipUseCase modifyMembershipUseCase;

    @PostMapping(path = "/membership/modify")
    ResponseEntity<MemberShip> modifyMembershipByMemberId(@RequestBody ModifyMembershipRequest request) {

        ModifyMembershipCommand command = ModifyMembershipCommand.builder()
                .membershipId(request.getMembershipId())
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .isValid(request.isValid())
                .isValid(request.isCorp())
                .build();

        MemberShip membership = modifyMembershipUseCase.modifyMembership(command);

        return ResponseEntity.ok(membership);
    }
}
