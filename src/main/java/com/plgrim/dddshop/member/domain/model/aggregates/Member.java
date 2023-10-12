package com.plgrim.dddshop.member.domain.model.aggregates;

import com.plgrim.dddshop.member.domain.model.commands.CreateMemberCommand;
import com.plgrim.dddshop.member.domain.model.valueobjects.MemberBaseInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
public class Member extends AbstractAggregateRoot<Member> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private CreateMemberId createMemberId;

    @Embedded
    private MemberBaseInfo memberBaseInfo;

    public Member(CreateMemberCommand createMemberCommand) {
    this.createMemberId = new CreateMemberId(createMemberCommand.getMemberId());
    this.memberBaseInfo = new MemberBaseInfo(createMemberCommand.getMemberName());
    }
}