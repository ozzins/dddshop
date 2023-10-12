package com.plgrim.dddshop.member.interfaces.rest.dto;

import com.plgrim.dddshop.member.interfaces.rest.validation.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMemberResource {
    @NotBlank(message = "please, Member Name input")
    private String memberName;

    @Phone
    private String phone;
}
