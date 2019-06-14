package com.pol.bss.pol_bss_automationtest;


import java.util.ArrayList;
import java.util.List;

/**
 * Class to hold used OTP during the execution of scenarios
 */
public class DniUsed {

    private static String DniUsed;

    public static void setDniUsed(String dni) {
        DniUsed=dni;
    }

    public static String getDniUsed() {
        return DniUsed;
    }

}
