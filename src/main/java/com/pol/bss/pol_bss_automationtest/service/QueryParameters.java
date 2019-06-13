package com.pol.bss.pol_bss_automationtest.service;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
public class QueryParameters {
    private String branchFADCode;
    private String incomeRepGroupCode;
    private String tradingDateFrom;
    private String tradingDateTo;
    private String pillarName;
    private String subpillarName;
    private String huidList;
    private String tradingDate1From;
    private String tradingDate1To;
    private String tradingDate2From;
    private String tradingDate2To;
    private String limit;
    private String user;
    private String postOfficeId;
    private String bearer;
    private Boolean value;
    private String name;
    private String id;
    private String bodyBanner;


}