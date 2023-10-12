package com.plgrim.dddshop.member.infrastructure.repositories.jpa;

import com.plgrim.dddshop.member.domain.model.aggregates.Member;
import com.plgrim.dddshop.member.domain.service.MemberRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberJPARepository extends MemberRepository, JpaRepository<Member, Long> {
    Member save(Member member);
    Optional<Member> findByCreateMemberIdCreateMemberId(String createMemberId);
    List<Member> findAll();
}