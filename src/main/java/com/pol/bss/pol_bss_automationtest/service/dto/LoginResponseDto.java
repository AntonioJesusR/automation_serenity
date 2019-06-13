package com.pol.bss.pol_bss_automationtest.service.dto;

import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {

    private String scope;
    private String idToken;
    private String tokenType;
    private int code;
    private String error;
    private String errorDescription;
    private String lastModified;
    private Map<String, Object> preferences;
    private List<String> privileges;
    private String passwordExpiryDate;
    private String showReminderPassword;
    private String expiryPasswordMessage;
    private Integer unreadMessages;
    private Boolean showLogoutMessage;
    private String logoutMessage;





}
