package org.mypay.membership.application.port.in;

import org.mypay.membership.domain.MemberShip;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface FindMembershipUseCase {

    MemberShip findMembership(FindMembershipCommand command);
}
