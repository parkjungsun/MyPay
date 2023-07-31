package org.mypay.membership.adapter.in.web;

import common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.mypay.membership.application.port.in.FindMembershipCommand;
import org.mypay.membership.application.port.in.FindMembershipUseCase;
import org.mypay.membership.application.port.in.RegisterMembershipCommand;
import org.mypay.membership.domain.MemberShip;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class FindMembershipController {

    private final FindMembershipUseCase findMembershipUseCase;

    @GetMapping(path = "/membership/{membershipId}")
    ResponseEntity<MemberShip> findMembershipByMemberId(@PathVariable String membershipId) {
        FindMembershipCommand command = FindMembershipCommand
                .builder()
                .membershipId(membershipId)
                .build();

        MemberShip membership = findMembershipUseCase.findMembership(command);

        return ResponseEntity.ok(membership);
    }
}
