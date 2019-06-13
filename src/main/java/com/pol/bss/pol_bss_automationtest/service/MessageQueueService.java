package com.pol.bss.pol_bss_automationtest.service;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import static utils.EnvironmentBuilder.*;

import static com.pol.bss.pol_bss_automationtest.service.BaseService.request;

public class MessageQueueService {


//(LOS VOID SON EN REALIDAD RESPONSE)
    public static void getNotifications(String bearer) {
       // return request(AP_MESSAGE_QUEUE_ENDPOINT + NOTIFICATIONS, HttpMethod.GET, SerenityRest.given().header("Authorization", BEARER + bearer));
    }

    public static void postNotify(String bearer, String notification) {
     //   return request(AP_MESSAGE_QUEUE_ENDPOINT + NOTIFY, HttpMethod.POST, SerenityRest.given().body(notification).header("Authorization", BEARER + bearer));
    }
}
