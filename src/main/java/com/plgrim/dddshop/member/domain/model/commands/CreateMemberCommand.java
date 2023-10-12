package com.plgrim.dddshop.member.domain.model.commands;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateMemberCommand {
    private String memberId;
    private String memberName;
    
    public CreateMemberCommand(String memberName) {
        this.memberName = memberName;
    }
}
