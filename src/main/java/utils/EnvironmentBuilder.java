package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static java.util.Arrays.asList;
import static net.serenitybdd.core.Serenity.setSessionVariable;
import static org.junit.Assert.fail;
import static utils.Props.getProp;
import static utils.Props.loadRunConfigProps;


public class EnvironmentBuilder {


    public static final String FRONTEND_URL_UNDER_TEST;
    public static final String BROWSER_USING;
    public static final String TAGS_USING;
    public static final String HEADLESS;
    public static final String EMAILSENTPAGE;
    public static final String DEVICEREGISTRATIONPAGE;
    public static final String ORDERCOINSPAGE;
    public static final String VIEWUPDATEPAGE;
    public static final String LOGINPAGE;
    public static final String FORGOTPASSWORDPAGE;
    public static final String LOGOUTPAGE;
    public static final String HOMEPAGE;
    public static final String MAINTENANCEPAGE;
    public static final String BRANCHPERFORMANCEPAGE;
    public static final String ITINCIDENTPAGE;
    public static final String BRANCHMESSAGINGPAGE;
    public static final String FAQPAGE;
    public static final String CONFIGURATIONLANDINGPAGE;
    public static final String COMPARINGSALESVALUESPAGE;
    public static final String COMPARINGSALESVOLUMESPAGE;
    public static final String ITSMLANDINGPAGE;
    public static final String SETTINGSPAGE;
    public static final String FORCEDLOGOUTPAGE;
    public static final String MANAGEANDPUBLISHMESSAGESPAGE;
    public static final String EXPIRYINACTIVITY;
    public static final String KNOWLEDGEBASE;
    public static final String NEWSESSIONDETECTED;
    public static final String MESSAGELANDINGPAGE;
    public static final String SENTMESSAGEPAGE;
    public static final String REPORTINGMESSAGEPAGE;
    public static final String BATCHMESSAGEPAGE;
    public static final String REGISTRATIONSTEP1;
    public static final String REGISTRATIONSTEP2;
    public static final String ALREADYREGISTERED;
    public static final String REGISTRATIONOK;

    //**SERVICES ENDPOINTS*/
    public static final String CUSTOMER_SESSIONS_BY_USER;
    public static final String CUSTOMER_SESSIONS_BY_TRADING_DATE;
    public static final String CUSTOMER_SESSIONS_AVERAGE_BASKET_PER_DAY;
    public static final String CUSTOMER_SESSIONS_AVERAGE_BASKET;
    public static final String CUSTOMER_SESSIONS_BY_HOUR;
    public static final String COUNT_CUSTOMER_SESSIONS_BY_USER;
    public static final String LOGIN;
    public static final String BSS_BACKEND_PROXY_AUTH_DEVELOPMENT_API_INVALIDATE_BEARER_TOKEN;
    public static final String NOTIFICATIONS;
    public static final String BEARER;
    public static final String NOTIFY;
    public static final String CHECKPOLICY;
    public static final String POLICIES;
    public static final String BRANCH_BY_USER;
    public static final String AUTHENTICATE;
    public static final String DECRYPT_JWE;
    public static final String DECRYPT;
    public static final String CHECK_PASSWORD_POLICY;
    public static final String SUBPILLARS;
    public static final String PILLARS;
    public static final String INCOME_REPORTING_GROUPS_BY_CODE;
    public static final String INCOME_REPORTING_GROUPS;
    public static final String PREFERENCES_POID_USER_PREFERENCE;
    public static final String PREFERENCES_POID;
    public static final String SYSTEM_PREFERENCES;
    public static final String SALES_VOLUMES_VALUES_INC_REP;
    public static final String TOTAL_SALES_VOLUMES_VALUES;
    public static final String CALCULATE_INCOMING;
    public static final String SALES_BY_USER_VOLUMES_VALUES;
    public static final String FIND_EMPLOYEE_BY_BRANCH_FADCODE;
    public static final String TOTAL_SALES_BY_USER_VOLUMES_VALUES;
    public static final String TOP_XSALES_BY_VOL;
    public static final String TOP_XSALES_BY_VAL;
    public static final String SALES_VOLUMES_VALUES_INC_REP_REAL_TIME;
    public static final String LOGOUT;
    public static final String IN_OTP;
    public static final String RESETTING_PASSWORD;
    public static final String PASSWORD_RESET;
    public static final String IN_MAINTENANCE;
    public static final String IN_MAINTENANCE_ON;
    public static final String FACTORAUTH;
    public static final String SUBMIT_FIRST_TIME_OTP;
    public static final String FORCE_LOGOUT;
    public static final String IN_MAINTENANCE_OFF;
    public static final String VISIBILITY_LOGOUT;
    public static final String lOGIN;
    public static final String PUBLIC_KEY;
    public static final String CHANGE_PASSWORD;
    public static final String RANDOM_SECURITY_QUESTION;
    public static final String VALIDATE_ANSWERED_SECURITY_QUESTIONS;
    public static final String SIGNING_KEYS;
    public static final String SWAGGER_API;
    public static final String FORGOT_PASSWORD;
    public static final String RESET_PASSWORD;
    public static final String RESET_A_USER_PASSWORD;
    public static final String EUMTOKEN;
    public static final String GENERATETOKEN;
    public static final String FORGEROCKEUM_URL;
    public static final String FORGEROCKTOKEN_URL;
    public static final String REFRESH_BEARER_TOKEN;
    public static final String PRIVILEGES;
    public static final String EXIST_TOKEN;
    public static final String BANNER;
    public static final String MESSAGE;
    public static final String MESSAGE_SENT;
    public static final String MESSAGE_USER_POID;
    public static final String MESSAGE_UNREADMESSAGES_USER_POID;
    public static final String MESSAGE_USER_POID_MESSAGEID;
    public static final String MESSAGE_USER_POID_PRIORITY;
    public static final String ACKNOWLEDGED_MESSAGE;
    public static final String MESSAGE_ID;
    public static final String MESSAGE_READ;
    public static final String EUM_V1_CHANGE_PASSWORD;
    public static final String REVOKE_TOKEN;
    public static final String REVOKE_TOKEN_ALL;
    public static final String COIN_ORDER;

    public static final String HELP_AND_HOW_LOTTERY;
    public static final String DEFAULT_AUTOMATION_PASSWORD = "Password_123";
    public static final String LEGAL_SPECIAL_CHARACTERS = "\"^;()#@:~,.+=_-*?\"";
    public static final int CLOCK_AT_WHICH_TO_WAIT_FOR_NEW_OTP = 27;
    public static final String LOGIN_HEADER = "Login";
    public static final String REGISTER_DEVICE_HEADER = "Register Device";
    private static final String LOGIN_FEEDBACK_MESSAGE = "The credentials you have entered are incorrect";


    private static Logger logger = LoggerFactory.getLogger(EnvironmentBuilder.class);

    static {

        loadRunConfigProps("/automation.yml");

        FRONTEND_URL_UNDER_TEST = getTheFrontEndURLForEnvironmentUnderTest("https://new.edmodo.com/home");
        BROWSER_USING = getTheBrowserToUse();
        TAGS_USING = tagsToUse();
        HEADLESS = "";
        headless();


//        POSTGRES TEST
    /*       POSTGRESQL_BRANCHMESSAGING_URL = format(getProp("POSTGRESQL_BASE_URL_MESSAGING"), ENVIRONMENT_UNDER_TEST.toLowerCase());
        POSTGRESQL_BRANCHMESSAGING_USERNAME = getProp(ENVIRONMENT_UNDER_TEST + "_branchmessaging_username");
        POSTGRESQL_BRANCHMESSAGING_PASSWORD = getProp(ENVIRONMENT_UNDER_TEST + "_branchmessaging_password");

        POSTGRESQL_ORGANIZATION_URL = format(getProp("POSTGRESQL_BASE_URL_ORGANIZATION"), ENVIRONMENT_UNDER_TEST.toLowerCase());
        POSTGRESQL_ORGANIZATION_USERNAME = getProp(ENVIRONMENT_UNDER_TEST + "_organization_username");
        POSTGRESQL_ORGANIZATION_PASSWORD = getProp(ENVIRONMENT_UNDER_TEST + "_organization_password");

        POSTGRESQL_USERPREFERENCES_URL = format(getProp("POSTGRESQL_BASE_URL_USERPREFERENCES"), ENVIRONMENT_UNDER_TEST.toLowerCase());
        POSTGRESQL_USERPREFERENCES_USERNAME = getProp(ENVIRONMENT_UNDER_TEST + "_userpreferences_username");
        POSTGRESQL_USERPREFERENCES_PASSWORD = getProp(ENVIRONMENT_UNDER_TEST + "_userpreferences_password");

        POSTGRESQL_COINORDER_URL = format(getProp("POSTGRESQL_BASE_URL_COINORDER"), ENVIRONMENT_UNDER_TEST.toLowerCase());
        POSTGRESQL_COINORDER_USERNAME = getProp(ENVIRONMENT_UNDER_TEST + "_coinorder_username");
        POSTGRESQL_COINORDER_PASSWORD = getProp(ENVIRONMENT_UNDER_TEST + "_coinorder_password");

        POSTGRESQL_AUTHORISATION_URL = format(getProp("POSTGRESQL_BASE_URL_AUTHORISATION"), ENVIRONMENT_UNDER_TEST.toLowerCase());
        POSTGRESQL_AUTHORISATION_USERNAME = getProp(ENVIRONMENT_UNDER_TEST + "_authorisation_username");
        POSTGRESQL_AUTHORISATION_PASSWORD = getProp(ENVIRONMENT_UNDER_TEST + "_authorisation_password");
*/


        logger.info("Browser Using to test = {}", BROWSER_USING);
        logger.info("Tags using to test = {}", TAGS_USING);

        BATCHMESSAGEPAGE = getUrls("BatchMessagePage");
        EMAILSENTPAGE = getUrls("EmailSentPage");
        FORGOTPASSWORDPAGE = getUrls("ForgotPasswordPage");
        DEVICEREGISTRATIONPAGE = getUrls("DeviceRegistrationPage");
        LOGINPAGE = getUrls("LoginPage");
        LOGOUTPAGE = getUrls("LogoutPage");
        HOMEPAGE = getUrls("HomePage");
        MAINTENANCEPAGE = getUrls("MaintenancePage");
        BRANCHPERFORMANCEPAGE = getUrls("BranchPerformancePage");
        ITINCIDENTPAGE = getUrls("ITIncidentPage");
        ITSMLANDINGPAGE = getUrls("ITSMLandingPage");
        BRANCHMESSAGINGPAGE = getUrls("BranchMessaging");
        FAQPAGE = getUrls("FaqPage");
        KNOWLEDGEBASE = getUrls("KnowledgeBase");
        CONFIGURATIONLANDINGPAGE = getUrls("ConfigurationLandingPage");
        COMPARINGSALESVALUESPAGE = getUrls("ComparingSalesValuesPage");
        COMPARINGSALESVOLUMESPAGE = getUrls("ComparingSalesVolumesPage");
        SETTINGSPAGE = getUrls("SettingsPage");
        FORCEDLOGOUTPAGE = getUrls("ForcedLogoutPage");
        MANAGEANDPUBLISHMESSAGESPAGE = getUrls("ManageAndPublishMessagesPage");
        EXPIRYINACTIVITY = getUrls("ExpiryInactivity");
        ORDERCOINSPAGE = getUrls("OrderCoinsPage");
        VIEWUPDATEPAGE = getUrls("ViewUpdatePage");


        //GET VARIABLES*/

        //AuthService
        LOGOUT = getVariable("Logout");
        IN_OTP = getVariable("InOtp");
        RESETTING_PASSWORD = getVariable("ResettingPassword");
        PASSWORD_RESET = getVariable("PasswordReset");
        IN_MAINTENANCE = getVariable("InMaintenance");
        IN_MAINTENANCE_ON = getVariable("InMaintenanceOn");
        FACTORAUTH = getVariable("FactorAuth");
        SUBMIT_FIRST_TIME_OTP = getVariable("SubmitFirstTimeOtp");
        FORCE_LOGOUT = getVariable("ForceLogout");
        IN_MAINTENANCE_OFF = getVariable("InMaintenanceOff");
        VISIBILITY_LOGOUT = getVariable("VisibilityLogout");
        lOGIN = getVariable("Login");
        PUBLIC_KEY = getVariable("PublicKey");
        CHANGE_PASSWORD = getVariable("ChangePassword");
        RANDOM_SECURITY_QUESTION = getVariable("RandomSecurityQuestion");
        VALIDATE_ANSWERED_SECURITY_QUESTIONS = getVariable("ValidateAnsweredSecurityQuestions");
        SIGNING_KEYS = getVariable("SigningKeys");
        SWAGGER_API = getVariable("SwaggerApi");
        FORGOT_PASSWORD = getVariable("ForgotPassword");
        RESET_PASSWORD = getVariable("ResetPassword");
        RESET_A_USER_PASSWORD = getVariable("ResetUserPassword");
        EUMTOKEN = getVariable("EumToken");
        GENERATETOKEN = getVariable("GenerateToken");
        FORGEROCKEUM_URL = getVariable("ForgeRockEumUrl");
        FORGEROCKTOKEN_URL = getVariable("ForgeRockTokenUrl");
        REFRESH_BEARER_TOKEN = getVariable("RefreshBearerToken");
        BEARER = getVariable("Bearer")+ " ";
        PRIVILEGES = getVariable("Privileges");
        EXIST_TOKEN = getVariable("ExistToken");
        REVOKE_TOKEN = getVariable("RevokeToken");
        REVOKE_TOKEN_ALL = getVariable("RevokeTokenAll");

        //BannerService
        BANNER = getVariable("Banner");

        //BranchMessagesService
        MESSAGE = getVariable("Message");
        MESSAGE_SENT = getVariable("MessageSent");
        MESSAGE_USER_POID = getVariable("MessageUserPoid");
        MESSAGE_UNREADMESSAGES_USER_POID = getVariable("MessageUnreadMessagesUserPoid");
        MESSAGE_USER_POID_MESSAGEID = getVariable("MessageUserPoidMessageId");
        MESSAGE_USER_POID_PRIORITY = getVariable("MessageUserPoidPriority");
        ACKNOWLEDGED_MESSAGE = getVariable("AcknowledgedMessage");
        MESSAGE_ID = getVariable("MessageId");
        MESSAGE_READ = getVariable("MessageRead");

        //ChangePasswordService
        EUM_V1_CHANGE_PASSWORD = getVariable("EumV1ChangePassowrd");


        //CashManagement
        COIN_ORDER = getVariable("CoinOrder");

        //GET VARIABLES*/
        CUSTOMER_SESSIONS_BY_USER= getVariable("CUSTOMER_SESSIONS_BY_USER");
        CUSTOMER_SESSIONS_BY_TRADING_DATE = getVariable("CUSTOMER_SESSIONS_BY_TRADING_DATE");
        CUSTOMER_SESSIONS_AVERAGE_BASKET_PER_DAY = getVariable("CUSTOMER_SESSIONS_AVERAGE_BASKET_PER_DAY");
        CUSTOMER_SESSIONS_AVERAGE_BASKET = getVariable ("CUSTOMER_SESSIONS_AVERAGE_BASKET");
        CUSTOMER_SESSIONS_BY_HOUR = getVariable ("CUSTOMER_SESSIONS_BY_HOUR");
        COUNT_CUSTOMER_SESSIONS_BY_USER = getVariable("COUNT_CUSTOMER_SESSIONS_BY_USER");
        LOGIN = getVariable("LOGIN");
        BSS_BACKEND_PROXY_AUTH_DEVELOPMENT_API_INVALIDATE_BEARER_TOKEN = getVariable("INVALIDATE_BEARER_TOKEN");
        NOTIFICATIONS = getVariable ("NOTIFICATIONS");
        NOTIFY = getVariable ("NOTIFY");
        CHECKPOLICY = getVariable("CHECKPOLICY");
        POLICIES = getVariable ("POLICIES");
        BRANCH_BY_USER = getVariable ("BRANCH_BY_USER");
        AUTHENTICATE = getVariable("AUTHENTICATE");
        DECRYPT_JWE =   getVariable("DECRYPT_JWE");
        DECRYPT = getVariable("DECRYPT");
        CHECK_PASSWORD_POLICY = getVariable ("CHECK_PASSWORD_POLICY");
        SUBPILLARS = getVariable ("SUBPILLARS");
        PILLARS = getVariable ("PILLARS");
        INCOME_REPORTING_GROUPS_BY_CODE = getVariable ("INCOME_REPORTING_GROUPS_BY_CODE");
        INCOME_REPORTING_GROUPS = getVariable("INCOME_REPORTING_GROUPS");
        PREFERENCES_POID_USER_PREFERENCE = getVariable("PREFERENCES_POID_USER_PREFERENCE");
        PREFERENCES_POID = getVariable("PREFERENCES_POID");
        SYSTEM_PREFERENCES = getVariable("SYSTEM_PREFERENCES");
        SALES_VOLUMES_VALUES_INC_REP = getVariable ("SALES_VOLUMES_VALUES_INC_REP");
        TOTAL_SALES_VOLUMES_VALUES = getVariable("TOTAL_SALES_VOLUMES_VALUES");
        CALCULATE_INCOMING = getVariable("CALCULATE_INCOMING");
        SALES_BY_USER_VOLUMES_VALUES = getVariable("SALES_BY_USER_VOLUMES_VALUES");
        FIND_EMPLOYEE_BY_BRANCH_FADCODE = getVariable ("FIND_EMPLOYEE_BY_BRANCH_FADCODE");
        TOTAL_SALES_BY_USER_VOLUMES_VALUES = getVariable("TOTAL_SALES_BY_USER_VOLUMES_VALUES");
        TOP_XSALES_BY_VOL = getVariable ("TOP_XSALES_BY_VOL");
        TOP_XSALES_BY_VAL = getVariable("TOP_XSALES_BY_VAL");
        SALES_VOLUMES_VALUES_INC_REP_REAL_TIME = getVariable("SALES_VOLUMES_VALUES_INC_REP_REAL_TIME");


        NEWSESSIONDETECTED = getUrls("NewSessionDetected");
        MESSAGELANDINGPAGE = getUrls("MessageLandingPage");
        SENTMESSAGEPAGE = getUrls("SentMessagePage");
        REPORTINGMESSAGEPAGE = getUrls("ReportingMessagePage");
        HELP_AND_HOW_LOTTERY= getProp("HELP_AND_HOW_LOTTERY");
        REGISTRATIONSTEP1 = getUrls("RegistrationStep1");
        REGISTRATIONSTEP2 = getUrls("RegistrationStep2");
        ALREADYREGISTERED = getUrls("AlreadyRegistered");
        REGISTRATIONOK = getUrls("RegistrationOk");

    }

    private static String getVariable(String AutomationProp){
        return getProp(AutomationProp);
    }

    private static String getUrls(String endPoints) {
        return FRONTEND_URL_UNDER_TEST + getProp(endPoints);
    }

    private static String getTheBrowserToUse() {
        String browser = System.getProperty("browser");
        browser = browser == null ? getProp("DEFAULT_BROWSER") : browser;
        System.setProperty("webdriver.driver", browser);
        return browser;
    }

    private static String tagsToUse() {
        String tags = System.getProperty("tags");
        if (tags != null) {
            System.setProperty("cucumber.options", "--tags " + tags.replace("~", "--tags ~"));
        }
        return tags;
    }

    public static void headless() {
        String headless = System.getProperty("chrome.switches");
        setSessionVariable(HEADLESS).to(headless);
    }

    private static String getTheFrontEndURLForEnvironmentUnderTest(String url) {

                System.setProperty("webdriver.base.url",url);
                return url;
        }

    private static String deriveTheCorrectEnvironmentUnderTest() {
        String environmentNameSupplied = System.getProperty("env");
        List<String> listOfValidEnvironments = asList(getProp("VALID_ENVIRONMENTS").split(","));
        if (environmentNameSupplied == null) {
            logger.warn("No environment value was supplied, hence, defaulting to the one specified in the automation.yml file " + getProp("DEFAULT_ENV").toUpperCase());
            return getProp("DEFAULT_ENV").toUpperCase();
        }
        if (!listOfValidEnvironments.contains(environmentNameSupplied.toUpperCase()) || environmentNameSupplied.isEmpty()) {
            fail("Environment value supplied was either empty or not one of the " + listOfValidEnvironments.toString());
        }
        return environmentNameSupplied.toUpperCase();
    }

}