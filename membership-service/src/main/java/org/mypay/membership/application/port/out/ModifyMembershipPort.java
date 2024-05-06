package org.mypay.membership.application.port.out;

import org.mypay.membership.adapter.out.persistence.MembershipJpaEntity;
import org.mypay.membership.domain.MemberShip;

public interface ModifyMembershipPort {

    MembershipJpaEntity modifyMembership(
            MemberShip.MemberShipId memberShipId
            , MemberShip.MemberShipName memberShipName
            , MemberShip.MemberShipEmail memberShipEmail
            , MemberShip.MemberShipAddress memberShipAddress
            , MemberShip.MemberShipIsValid memberShipIsValid
            , MemberShip.MemberShipIsCorp memberShipIsCorp);
}
