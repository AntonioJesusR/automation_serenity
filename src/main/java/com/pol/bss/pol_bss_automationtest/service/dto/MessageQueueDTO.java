package com.pol.bss.pol_bss_automationtest.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class MessageQueueDTO {
    private String code;
    private String title;
    private String text;
    private String topic;
}
