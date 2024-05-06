package org.mypay.membership.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.mypay.common.PersistenceAdapter;
import org.mypay.membership.application.port.out.FindMembershipPort;
import org.mypay.membership.application.port.out.ModifyMembershipPort;
import org.mypay.membership.application.port.out.RegisterMembershipPort;
import org.mypay.membership.domain.MemberShip;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort, ModifyMembershipPort {

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

    @Override
    public MembershipJpaEntity modifyMembership(MemberShip.MemberShipId memberShipId, MemberShip.MemberShipName memberShipName, MemberShip.MemberShipEmail memberShipEmail, MemberShip.MemberShipAddress memberShipAddress, MemberShip.MemberShipIsValid memberShipIsValid, MemberShip.MemberShipIsCorp memberShipIsCorp) {
        // update membership Info
        MembershipJpaEntity membershipJpaEntity = membershipRepository.getById(Long.parseLong(memberShipId.getMemberShipId()));
        membershipJpaEntity.setName(memberShipName.getMemberShipName());
        membershipJpaEntity.setAddress(memberShipAddress.getMemberShipAddress());
        membershipJpaEntity.setEmail(memberShipEmail.getMemberShipEmail());
        membershipJpaEntity.setCorp(memberShipIsCorp.isMemberShipIsCorp());
        membershipJpaEntity.setValid(memberShipIsValid.isMemberShipIsValid());

        // save
        MembershipJpaEntity updatedMembership = membershipRepository.save(membershipJpaEntity);

        // return
        return updatedMembership;
    }
}
