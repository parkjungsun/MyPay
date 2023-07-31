package org.mypay.membership.adapter.out.persistence;

import common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.mypay.membership.application.port.out.FindMembershipPort;
import org.mypay.membership.application.port.out.RegisterMembershipPort;
import org.mypay.membership.domain.MemberShip;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort {

    private final SpringDataMembershipRepository membershipRepository;

    @Override
    public MembershipJpaEntity createMembership(MemberShip.MemberShipName memberShipName, MemberShip.MemberShipEmail memberShipEmail, MemberShip.MemberShipAddress memberShipAddress, MemberShip.MemberShipIsValid memberShipIsValid, MemberShip.MemberShipIsCorp memberShipIsCorp) {
        return membershipRepository.save(
            new MembershipJpaEntity(
                    memberShipName.getMemberShipName(),
                    memberShipEmail.getMemberShipEmail(),
                    memberShipAddress.getMemberShipAddress(),
                    memberShipIsValid.isMemberShipIsValid(),
                    memberShipIsCorp.isMemberShipIsCorp()
            )
        );
    }


    @Override
    public MembershipJpaEntity findMembership(MemberShip.MemberShipId membershipId) {
        return membershipRepository.getById(Long.parseLong(membershipId.getMemberShipId()));
    }
}
