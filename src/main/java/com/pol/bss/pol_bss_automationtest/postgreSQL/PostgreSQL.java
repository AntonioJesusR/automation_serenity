package com.pol.bss.pol_bss_automationtest.postgreSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static com.pol.bss.pol_bss_automationtest.SessionVariables.BRANCH;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static org.junit.Assert.fail;

        public class PostgreSQL {

            public static Connection connectToPostgres() {
                Connection connection = null;
                Properties props = new Properties();
                String sql = sessionVariableCalled(BRANCH);
                String url ="";
                /*
                System.out.println("SQL: "+sql);
                System.out.println("ENV: "+ENVIRONMENT_UNDER_TEST);
                if(ENVIRONMENT_UNDER_TEST.equals("TEST")){
                if(sql.equalsIgnoreCase("organization")){
                    props.setProperty("user", POSTGRESQL_ORGANIZATION_USERNAME);
                    props.setProperty("password", POSTGRESQL_ORGANIZATION_PASSWORD);
                    url = POSTGRESQL_ORGANIZATION_URL;
                }else if(sql.equalsIgnoreCase("userpreferences")){
                    props.setProperty("user", POSTGRESQL_USERPREFERENCES_USERNAME);
                    props.setProperty("password", POSTGRESQL_USERPREFERENCES_PASSWORD);
                    url = POSTGRESQL_USERPREFERENCES_URL;
                }else if(sql.equalsIgnoreCase("branchmessaging")){
                    props.setProperty("user", POSTGRESQL_BRANCHMESSAGING_USERNAME);
                    props.setProperty("password", POSTGRESQL_BRANCHMESSAGING_PASSWORD);
                    url = POSTGRESQL_BRANCHMESSAGING_URL;
                }
                else if(sql.equalsIgnoreCase("coinorder")){
                    props.setProperty("user", POSTGRESQL_COINORDER_USERNAME);
                    props.setProperty("password", POSTGRESQL_COINORDER_PASSWORD);
                    url = POSTGRESQL_COINORDER_URL;
                }else if(sql.equalsIgnoreCase("authorisation")){
                    props.setProperty("user", POSTGRESQL_AUTHORISATION_USERNAME);
                    props.setProperty("password", POSTGRESQL_AUTHORISATION_PASSWORD);
                    url = POSTGRESQL_AUTHORISATION_URL;
                }
                }
                */
                props.setProperty("ssl", "require");
                try {
                        connection = DriverManager.getConnection(url, props);
                    } catch (SQLException e) {
                        System.out.println("Connection Failed! See below for more details");
                        e.printStackTrace();
                        fail("unable to connect to postgress");
                    }
                if (connection != null) {
                        System.out.println("You made it, take control your database now!");
                    } else {
                        System.out.println("Failed to make connection!");
                    }
                return connection;



        }

        }
