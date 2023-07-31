package org.mypay.membership.application.service;

import lombok.RequiredArgsConstructor;
import org.mypay.membership.adapter.out.persistence.MembershipJpaEntity;
import org.mypay.membership.adapter.out.persistence.MembershipMapper;
import org.mypay.membership.application.port.in.RegisterMembershipCommand;
import org.mypay.membership.application.port.in.RegisterMembershipUseCase;
import org.mypay.membership.application.port.out.RegisterMembershipPort;
import org.mypay.membership.domain.MemberShip;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Member;

@RequiredArgsConstructor
@Transactional
@Service
public class RegisterMembershipService implements RegisterMembershipUseCase {

    private final RegisterMembershipPort registerMembershipPort;
    private final MembershipMapper membershipMapper;
    @Override
    public MemberShip registerMembership(RegisterMembershipCommand command) {

        MembershipJpaEntity jpaEntity = registerMembershipPort.createMembership(
                new MemberShip.MemberShipName(command.getName()),
                new MemberShip.MemberShipEmail(command.getEmail()),
                new MemberShip.MemberShipAddress(command.getAddress()),
                new MemberShip.MemberShipIsValid(command.isValid()),
                new MemberShip.MemberShipIsCorp(command.isCorp()));

        // entity -> Membership;
        return MembershipMapper.mapToDomainEntity(jpaEntity);
    }
}
