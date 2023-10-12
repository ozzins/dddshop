package com.plgrim.dddshop.member.interfaces.rest;

import com.plgrim.dddshop.member.application.internal.commandservices.MemberCommandService;
import com.plgrim.dddshop.member.application.internal.queryservices.MemberQueryService;
import com.plgrim.dddshop.member.domain.model.aggregates.CreateMemberId;
import com.plgrim.dddshop.member.domain.model.aggregates.Member;
import com.plgrim.dddshop.member.interfaces.rest.dto.CreateMemberResource;
import com.plgrim.dddshop.member.interfaces.rest.transform.CreateMemberCommandDTOAssembler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Slf4j
@RestController
public class MemberRestController {

    private MemberCommandService memberCommandService;
    private MemberQueryService memberQueryService;

    public MemberRestController(MemberCommandService memberCommandService, MemberQueryService memberQueryService) {
        this.memberCommandService = memberCommandService;
        this.memberQueryService = memberQueryService;
    }

    @PostMapping("/member")
    public ResponseEntity<CreateMemberId> createMember(@Valid @RequestBody CreateMemberResource createMemberResource) {
        CreateMemberId createMemberId = memberCommandService.createMember(
        CreateMemberCommandDTOAssembler.toCommandFromDTO(createMemberResource));
        final URI uri =
            MvcUriComponentsBuilder.fromController(getClass())
            .path("/{id}")
            .buildAndExpand(createMemberId.getCreateMemberId())
            .toUri();
        return ResponseEntity.created(uri).body(createMemberId);
    }

    @GetMapping("/member")
    public Member findByCreateMemberId(@RequestParam String createMemberId) throws Exception {
        return memberQueryService.findByCreateMemberId(createMemberId);
    }

    @GetMapping("/members")
    public List<Member> getAllMembers() {
        return memberQueryService.findAll();
    }

    @PutMapping("/member")
    public String updateMember() {
        return "members";
    }

    @DeleteMapping("/member/{memberId}")
    public String deleteMember(@PathVariable String memberId) {
        return "members";
    }
}