package org.mypay.membership.application.port.in;

import org.mypay.common.UseCase;
import org.mypay.membership.domain.MemberShip;

@UseCase
public interface RegisterMembershipUseCase {

    MemberShip registerMembership(RegisterMembershipCommand command);

}
