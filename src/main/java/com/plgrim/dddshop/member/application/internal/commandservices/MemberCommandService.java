package com.plgrim.dddshop.member.application.internal.commandservices;

import com.plgrim.dddshop.member.domain.model.aggregates.CreateMemberId;
import com.plgrim.dddshop.member.domain.model.commands.CreateMemberCommand;
import com.plgrim.dddshop.member.domain.model.aggregates.Member;
import com.plgrim.dddshop.member.domain.service.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MemberCommandService {

    private MemberRepository memberRepository;

    public MemberCommandService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public CreateMemberId createMember(CreateMemberCommand createMemberCommand) {
        String random = UUID.randomUUID().toString().toUpperCase();
        createMemberCommand.setMemberId(random.substring(0, random.indexOf("-")));
        Member member = new Member(createMemberCommand);
        memberRepository.save(member);
        return new CreateMemberId(random);
    }
}
