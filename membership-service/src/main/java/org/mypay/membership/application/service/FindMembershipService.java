package org.mypay.membership.application.service;

import lombok.RequiredArgsConstructor;
import org.mypay.membership.adapter.out.persistence.MembershipJpaEntity;
import org.mypay.membership.adapter.out.persistence.MembershipMapper;
import org.mypay.membership.application.port.in.FindMembershipCommand;
import org.mypay.membership.application.port.in.FindMembershipUseCase;
import org.mypay.membership.application.port.out.FindMembershipPort;
import org.mypay.membership.domain.MemberShip;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Member;

@RequiredArgsConstructor
@Transactional
@Service
public class FindMembershipService implements FindMembershipUseCase {

    private final FindMembershipPort findMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public MemberShip findMembership(FindMembershipCommand command) {
        MembershipJpaEntity entity =  findMembershipPort.findMembership(new MemberShip.MemberShipId(command.getMembershipId()));

        return membershipMapper.mapToDomainEntity(entity);
    }
}
