package com.plgrim.dddshop.member.application.internal.queryservices;

import com.plgrim.dddshop.member.domain.model.aggregates.Member;
import com.plgrim.dddshop.member.domain.service.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberQueryService {

    private MemberRepository memberRepository;
    
    public MemberQueryService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    
    public Member findByCreateMemberId(String createMemberId) throws Exception {
        Optional<Member> member = memberRepository.findByCreateMemberIdCreateMemberId(createMemberId);
        if(!member.isEmpty()) {
            return member.get();
        } else {
            throw new Exception("Member is not exist!!");
        }
    }
    
    public List<Member> findAll() {
        return memberRepository.findAll();
    }
}
