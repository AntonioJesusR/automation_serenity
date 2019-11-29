package com.automationtest;

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
