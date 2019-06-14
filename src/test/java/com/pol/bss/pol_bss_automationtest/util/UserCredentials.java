package com.pol.bss.pol_bss_automationtest.util;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
@NoArgsConstructor
public class UserCredentials {

    private static final String BASIC = "Basic ";
    private String username;
    private String password;
    private String passHashed;


}
