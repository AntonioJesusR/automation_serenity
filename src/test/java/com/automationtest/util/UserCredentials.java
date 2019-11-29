package com.automationtest.util;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
@NoArgsConstructor
public class UserCredentials {


    private String username;
    private String password;
    private String passHashed;


}
