package com.pol.bss.pol_bss_automationtest.service.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {

    private Long id;
    private String subject;
    private String body;
    private Integer priority;
    private String dateSent;
    private String publisher;
    private String author;
    private Boolean read;
    private Boolean acknowledged;
    private String attachments;

}
