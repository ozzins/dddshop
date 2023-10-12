package com.plgrim.dddshop.member.domain.service;

import com.plgrim.dddshop.member.domain.model.aggregates.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findByCreateMemberIdCreateMemberId(String createMemberId);
    List<Member> findAll();
}
