package com.pol.bss.pol_bss_automationtest;


import java.util.ArrayList;
import java.util.List;

/**
 * Class to hold used OTP during the execution of scenarios
 */
public class OtpUsed {

    private static List<Integer> usedOTP = new ArrayList<>();

    /**
     * Add an already used OTP to the List
     *
     * @param used
     */
    public static void addUsedOTP(Integer used) {
        usedOTP.add(used);
    }

    /**
     * checks whether an otp has already been used
     *
     * @param used
     * @return
     */
    public static Boolean alreadyUsed(Integer used) {
        return usedOTP.contains(used);
    }

    /**
     * Retrieves the current used otps.
     *
     * @return
     */
    public static List<Integer> getUsedOTP() {
        return usedOTP;
    }


}
