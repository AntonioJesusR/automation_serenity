package com.pol.bss.pol_bss_automationtest.service.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageRecipientDto {
    private String recipient;
    private Integer recipientType;

}
