package org.mypay.membership.adapter.out.persistence;

import org.mypay.membership.domain.MemberShip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMembershipRepository extends JpaRepository<MembershipJpaEntity, Long> {
}
