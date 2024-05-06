package org.mypay.membership.application.service;

import lombok.RequiredArgsConstructor;
import org.mypay.membership.adapter.out.persistence.MembershipJpaEntity;
import org.mypay.membership.adapter.out.persistence.MembershipMapper;
import org.mypay.membership.application.port.in.ModifyMembershipCommand;
import org.mypay.membership.application.port.in.ModifyMembershipUseCase;
import org.mypay.membership.application.port.in.RegisterMembershipCommand;
import org.mypay.membership.application.port.in.RegisterMembershipUseCase;
import org.mypay.membership.application.port.out.ModifyMembershipPort;
import org.mypay.membership.application.port.out.RegisterMembershipPort;
import org.mypay.membership.domain.MemberShip;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class ModifyMembershipService implements ModifyMembershipUseCase {

    private final ModifyMembershipPort modifyMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public MemberShip modifyMembership(ModifyMembershipCommand command) {
        MembershipJpaEntity jpaEntity = modifyMembershipPort.modifyMembership(
                new MemberShip.MemberShipId(command.getMembershipId()),
                new MemberShip.MemberShipName(command.getName()),
                new MemberShip.MemberShipEmail(command.getEmail()),
                new MemberShip.MemberShipAddress(command.getAddress()),
                new MemberShip.MemberShipIsValid(command.isValid()),
                new MemberShip.MemberShipIsCorp(command.isCorp())
        );
        // entity -> Membership;
        return MembershipMapper.mapToDomainEntity(jpaEntity);
    }
}
