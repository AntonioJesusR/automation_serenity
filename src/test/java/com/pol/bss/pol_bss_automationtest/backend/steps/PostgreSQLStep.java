package com.pol.bss.pol_bss_automationtest.backend.steps;

import com.pol.bss.pol_bss_automationtest.postgreSQL.PostgreSQL;
import com.pol.bss.pol_bss_automationtest.util.UserCredentials;
import net.thucydides.core.annotations.Step;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.pol.bss.pol_bss_automationtest.SessionVariables.*;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static net.serenitybdd.core.Serenity.setSessionVariable;

public class PostgreSQLStep {

    private Connection connection;



    @Step
    public void disableVisibilityPreferences() throws SQLException {
        setSessionVariable(BRANCH).to("userpreferences");
        connection = PostgreSQL.connectToPostgres();
        String query = "UPDATE public.system_visibility_config SET active='0'";
        Statement stmt = null;
        stmt = connection.createStatement();
        stmt.executeUpdate(query);

    }
    @Step
    public void enableVisibilityPreferences() throws SQLException {
        setSessionVariable(BRANCH).to("userpreferences");
        connection = PostgreSQL.connectToPostgres();
        String query = "UPDATE public.system_visibility_config SET active='1'";
        Statement stmt = null;
        stmt = connection.createStatement();
        stmt.executeUpdate(query);

        if (stmt != null) {
            stmt.close();
            System.out.println("Statement1 closed successfully");
        }


        if (connection != null) {
            connection.close();
            System.out.println("Connection closed successfully");
        }

    }

    public void enablePreferencesWalkthrough()  throws SQLException{


        UserCredentials userCredentials = sessionVariableCalled(USER_CREDENTIALS);

        setSessionVariable(BRANCH).to("userpreferences");
        connection = PostgreSQL.connectToPostgres();
        String query = "SELECT preferences FROM public.userprefs WHERE user_poid='"+userCredentials.getUsername()+"'";
        Statement stmt = null;
        stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {

            String[] resultQuery = rs.getString(1).split(",");
            // true: disable
            // false: enable

            if(resultQuery[2].contains("true")) {
                String walkthroughPreference = "{\"serviceNowWarningHide\":true,\"walkthroughAll\":false,\"walkthroughHome\":false}";
                String queryUpdate = "UPDATE public.userprefs SET preferences='"+walkthroughPreference+"'";
                Statement stmtUpdate = null;
                stmtUpdate = connection.createStatement();
                stmtUpdate.executeUpdate(queryUpdate);
            }
        }

    }

    public void disablePreferencesWalkthrough() throws SQLException {


        UserCredentials userCredentials = sessionVariableCalled(USER_CREDENTIALS);

        setSessionVariable(BRANCH).to("userpreferences");
        connection = PostgreSQL.connectToPostgres();
        String query = "SELECT preferences FROM public.userprefs WHERE user_poid='"+userCredentials.getUsername()+"'";
        Statement stmt = null;
        Statement stmtUpdate = null;
        stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {

            String[] resultQuery = rs.getString(1).split(",");
            // true: disable
            // false: enable

            if(resultQuery[2].contains("false")) {
                String walkthroughPreference = "{\"serviceNowWarningHide\":true,\"walkthroughAll\":false,\"walkthroughHome\":true}";
                String queryUpdate = "UPDATE public.userprefs SET preferences='"+walkthroughPreference+"'";

                stmtUpdate = connection.createStatement();
                stmtUpdate.executeUpdate(queryUpdate);
            }
        }

        if (stmtUpdate != null) {
            stmtUpdate.close();
            System.out.println("Statement2 closed successfully");
        }
        if (stmt != null) {
            stmt.close();
            System.out.println("Statement1 closed successfully");
        }

        if (connection != null) {
            connection.close();
            System.out.println("Connection closed successfully");
        }

    }

    @Step
    public void checkSessionToken(String username) throws SQLException {

        setSessionVariable(BRANCH).to("authorisation");
        connection = PostgreSQL.connectToPostgres();
        String query = "SELECT client_id FROM public.oauth_access_token";
        String queryDelete = "DELETE FROM public.oauth_access_token WHERE client_id='"+username+"'";
        Statement stmt = null;
        Statement stmt2 = null;
        stmt = connection.createStatement();

        System.out.println("POID FOR DELETING: "+ username);
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            System.out.println("Result query: "+rs.getString(1) );
            if(username.equals(rs.getString(1))){


                stmt2 = connection.createStatement();
                System.out.println("Auth delete for poid");
                Integer rsDelete = stmt2.executeUpdate(queryDelete);
                assert (rsDelete.equals(1));
            }

        }
        if (stmt2 != null) {
            stmt2.close();
            System.out.println("Statement closed successfully");
        }

        if (stmt != null) {
            stmt.close();
            System.out.println("Statement closed successfully");
        }

        if (connection != null) {
            connection.close();
            System.out.println("Connection closed successfully");
        }

    }

    @Step
    public void getIDLastMessageDB() throws SQLException {
        setSessionVariable(BRANCH).to("authorisation");
        connection = com.pol.bss.pol_bss_automationtest.postgreSQL.PostgreSQL.connectToPostgres();
        String query = "SELECT id FROM public.branch_message ORDER BY created_date desc LIMIT 1";
        Statement stmt = null;
        stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            System.out.println("ID "+rs.getString(1));
            setSessionVariable(MESSAGE_ID_LIST).to(rs.getString(1));
        }

        if (stmt != null) {
            stmt.close();
            System.out.println("Statement closed successfully");
        }

        if (connection != null) {
            connection.close();
            System.out.println("Connection closed successfully");
        }

    }


    @Step
    public void getBranchesByUser(String userPoid) throws SQLException {
        setSessionVariable(BRANCH).to("authorisation");
        connection = com.pol.bss.pol_bss_automationtest.postgreSQL.PostgreSQL.connectToPostgres();
        String query = "SELECT branch_fad_code FROM public.branch_user WHERE user_poid = '"+userPoid+"'";

        Statement stmt = null;
        stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        List<String> fadCodes = new ArrayList<>();
        while (rs.next()) {
            System.out.println("FAD CODE "+rs.getString(1));
            fadCodes.add(rs.getString(1));
        }


        setSessionVariable(BRANCH_FAD_CODE).to(fadCodes);

        if (stmt != null) {
            stmt.close();
            System.out.println("Statement closed successfully");
        }

        if (connection != null) {
            connection.close();
            System.out.println("Connection closed successfully");
        }

    }

    @Step
    public void getBranchesInfoByUser(String userPoid) throws SQLException {
        setSessionVariable(BRANCH).to("authorisation");
        connection = com.pol.bss.pol_bss_automationtest.postgreSQL.PostgreSQL.connectToPostgres();
        String fadCode = "SELECT branch_fad_code FROM public.branch_user WHERE user_poid = '"+userPoid+"'";
        String name = "SELECT branch_name FROM public.branch_user WHERE user_poid = '"+userPoid+"'";
        String address = "SELECT address FROM public.branch_user WHERE user_poid = '"+userPoid+"'";
        Statement stmt = null;
        stmt = connection.createStatement();

        List<String> fadCodes = new ArrayList<>();
        Map<String,String> names = new HashMap<>();
        Map<String,String> address2 = new HashMap<>();

        int nameCount = 0;
        int addressCount =0;

        ResultSet rs1 = stmt.executeQuery(fadCode);
        while (rs1.next()) {


            System.out.println("FAD CODE "+rs1.getString(1));
            fadCodes.add(rs1.getString(1));
        }

        ResultSet rs2 = stmt.executeQuery(name);
        while (rs2.next()) {
            System.out.println("NAME "+rs2.getString(1));
            names.put(fadCodes.get(nameCount),rs2.getString(1));
            nameCount++;
        }

        ResultSet rs3 = stmt.executeQuery(address);
        while (rs3.next()) {
            System.out.println("ADDRESS "+rs3.getString(1));
            address2.put(fadCodes.get(addressCount),rs3.getString(1));
            addressCount++;
        }


        setSessionVariable(BRANCH_FAD_CODE).to(fadCodes);
        setSessionVariable(BRANCH_NAME).to(names);
        setSessionVariable(ADDRESS).to(address2);

        if (stmt != null) {
            stmt.close();
            System.out.println("Statement closed successfully");
        }

        if (connection != null) {
            connection.close();
            System.out.println("Connection closed successfully");
        }

    }

    public void deleteOrderCoins() throws SQLException{

        setSessionVariable(BRANCH).to("coinorder");
        connection = com.pol.bss.pol_bss_automationtest.postgreSQL.PostgreSQL.connectToPostgres();

        String query = "Delete FROM public.coin_order WHERE orderfadcode='0020141' AND order_status='S'";
        Statement stmt = null;
        stmt = connection.createStatement();
        stmt.executeUpdate(query);
    }

    public void getOrderCoinsByUser() throws SQLException{
        UserCredentials user = sessionVariableCalled(USER_CREDENTIALS);
        this.getBranchesByUser(user.getUsername());
        List<String> fadCodes = sessionVariableCalled(BRANCH_FAD_CODE);
        System.out.println("FADCODE: "+fadCodes.get(0));
        setSessionVariable(BRANCH).to("coinorder");
        Date fecha = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        String a = dateFormat.format(cal.getTime());
        connection = com.pol.bss.pol_bss_automationtest.postgreSQL.PostgreSQL.connectToPostgres();
        String query = "Select id FROM public.coin_order WHERE orderfadcode='"+fadCodes.get(0)+"' AND user_id='"+user.getUsername()+"' AND cutoff_date_time > '"+a+"' AND order_status = 'S' ORDER BY version desc LIMIT 1";
        Statement stmt = null;
        stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        List<String> ids = new ArrayList<>();
        while (rs.next()) {
            ids.add(rs.getString(1));
        }

        setSessionVariable(ORDER_ID).to(ids);

        if (stmt != null) {
            stmt.close();
            System.out.println("Statement closed successfully");
        }

        if (connection != null) {
            connection.close();
            System.out.println("Connection closed successfully");
        }


    }

    public void setOldOrder(String id) throws SQLException{
        UserCredentials user = sessionVariableCalled(USER_CREDENTIALS);
        this.getBranchesByUser(user.getUsername());
        List<String> fadCodes = sessionVariableCalled(BRANCH_FAD_CODE);
        setSessionVariable(BRANCH).to("coinorder");
        connection = com.pol.bss.pol_bss_automationtest.postgreSQL.PostgreSQL.connectToPostgres();
        Date fecha = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.add(Calendar.DAY_OF_WEEK, -7);
        String a = dateFormat.format(cal.getTime());
        System.out.println(a);

        String query = "Update public.coin_order SET cutoff_date_time = '"+a+"' WHERE id='"+id+"'";

        Statement stmt = null;
        stmt = connection.createStatement();
        Integer rs = stmt.executeUpdate(query);
        assert (rs.equals(1));

        if (stmt != null) {
            stmt.close();
            System.out.println("Statement closed successfully");
        }

        if (connection != null) {
            connection.close();
            System.out.println("Connection closed successfully");
        }


    }

    public void deleteOrderCoinsById(List<String> ids) throws SQLException{

        setSessionVariable(BRANCH).to("coinorder");
        connection = com.pol.bss.pol_bss_automationtest.postgreSQL.PostgreSQL.connectToPostgres();
        Statement stmt = null;
        stmt = connection.createStatement();
        String query = "Delete FROM public.coin_order WHERE id='"+ids.get(0)+"'";
        System.out.println(query);
        stmt.executeUpdate(query);
        if (stmt != null) {
            stmt.close();
            System.out.println("Statement closed successfully");
        }
        if (connection != null) {
            connection.close();
            System.out.println("Connection closed successfully");
        }
    }
}
