package com.pol.bss.pol_bss_automationtest.service;

import static org.junit.Assert.fail;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import net.serenitybdd.rest.SerenityRest;

public class BaseService  {

    public static Response request(String url, HttpMethod httpMethod, RequestSpecification requestSpecification) {
        Response response;
        requestSpecification = addLogsAndDefaultHeaders(requestSpecification);
        switch (httpMethod) {
            case GET:
                response = requestSpecification.get(url);
                break;
            case POST:
                response = requestSpecification.post(url);
                break;
            case PUT:
                response = requestSpecification.put(url);
                break;
            case DELETE:
                response = requestSpecification.delete(url);
                break;
            default:
                throw new IllegalArgumentException("Http method not recognised: " + httpMethod.toString());
        }
        response.prettyPrint();
        return response;
    }

       private static RequestSpecification addLogsAndDefaultHeaders(RequestSpecification requestSpecification) {
        return requestSpecification
                .header(new Header("Content-Type", "application/json"))
                .log()
                .all();
    }

    /**
     * Performs a GET request to the given url, passing as query params the parameters specified
     *
     * @param url: full url to perform the request against.
     * @param map: query parameters to pass in.
     * @return Response obtained from the request
     */
    public static Response getWithParams(String url, Map<String, String> map) {
        return request(url, HttpMethod.GET, SerenityRest.given().queryParams(map));
    }



    /**
     * Performs a GET request to the given url
     *
     * @param url: full url to perform the request against.
     * @return Response obtained from the request
     */
    public static Response get(String url) {

        return request(url, HttpMethod.GET, SerenityRest.given());
    }

    /**
     * Performs a POST request to the given url
     *
     * @param url:  full url to perform the request against.
     * @param body: object to be converted as the post body
     * @return Response obtained from the request
     */
    public static Response post(String url, Object body) {
        return request(url, HttpMethod.POST, SerenityRest.given().body(body));
    }



}
