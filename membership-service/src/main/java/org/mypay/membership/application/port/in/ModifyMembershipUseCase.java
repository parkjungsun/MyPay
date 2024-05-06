package org.mypay.membership.application.port.in;

import org.mypay.membership.domain.MemberShip;

import java.lang.reflect.Member;

public interface ModifyMembershipUseCase {
    MemberShip modifyMembership(ModifyMembershipCommand command);
}
