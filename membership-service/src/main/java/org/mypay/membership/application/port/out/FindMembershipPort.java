package org.mypay.membership.application.port.out;

import org.mypay.membership.adapter.out.persistence.MembershipJpaEntity;
import org.mypay.membership.domain.MemberShip;

public interface FindMembershipPort {

    MembershipJpaEntity findMembership(
            MemberShip.MemberShipId membershipId
    );
}
