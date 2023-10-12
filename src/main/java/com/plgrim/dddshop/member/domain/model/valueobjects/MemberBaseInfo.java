package com.plgrim.dddshop.member.domain.model.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MemberBaseInfo {

    @Column(name = "member_name", unique = true, updatable= true)
    private String memberName;
}
