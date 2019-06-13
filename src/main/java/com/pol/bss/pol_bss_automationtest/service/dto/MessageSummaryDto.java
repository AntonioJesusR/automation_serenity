package com.pol.bss.pol_bss_automationtest.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageSummaryDto {
    private Long id;
    private String subject;
    private String bodyPreview;
    private Integer priority;
    private String dateSent;
    private String publisher;
    private String author;
    private Boolean read;
    private Boolean stats;
}
