package com.plgrim.dddshop.member.interfaces.rest.transform;

import com.plgrim.dddshop.member.domain.model.commands.CreateMemberCommand;
import com.plgrim.dddshop.member.interfaces.rest.dto.CreateMemberResource;

public class CreateMemberCommandDTOAssembler {

    public static CreateMemberCommand toCommandFromDTO(CreateMemberResource createMemberResource) {
        return new CreateMemberCommand(
            createMemberResource.getMemberName()
        );
    }
}
