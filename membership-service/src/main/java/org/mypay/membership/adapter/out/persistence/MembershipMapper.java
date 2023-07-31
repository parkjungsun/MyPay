package org.mypay.membership.adapter.out.persistence;

import org.mypay.membership.domain.MemberShip;
import org.springframework.stereotype.Component;

@Component
public class MembershipMapper {
    public static MemberShip mapToDomainEntity(MembershipJpaEntity membershipJpaEntity) {
        return MemberShip.generateMember(
            new MemberShip.MemberShipId(membershipJpaEntity.getMembershipId()+""),
            new MemberShip.MemberShipName(membershipJpaEntity.getName()),
            new MemberShip.MemberShipEmail(membershipJpaEntity.getEmail()),
            new MemberShip.MemberShipAddress(membershipJpaEntity.getAddress()),
            new MemberShip.MemberShipIsValid(membershipJpaEntity.isValid()),
            new MemberShip.MemberShipIsCorp(membershipJpaEntity.isCorp())
        );
    }
}
