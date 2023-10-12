package com.plgrim.dddshop.member.domain.model.aggregates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Getter
public class CreateMemberId {
    @Column(name="create_member_id")
    private String createMemberId;
}