package com.automationtest.frontend.stepdefinitions;

import com.automationtest.frontend.steps.MeLogueoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class MeLogueoStepDefinitions {

    @Steps MeLogueoStep logueoStep;

    @Dado("^Navego a la pagina web$")
    public void loginWeb(){
    logueoStep.loginWeb();
    }
    @Cuando("^Introduzco mi usuario y mi contraseña correctamente$")
    public void introduzcoCredenciales(){
    logueoStep.introducirCredenciales();
    }
    @Entonces("^Entro en la aplicacion de Edmodo$")
    public void entrarEnLaAplicacion(){
    logueoStep.funcionDeLogin();
    }

    @Cuando("^Introduzco mi usuario y mi contraseña incorrectamente$")
    public void introduzcoCredencialesIncorrectos(){
        logueoStep.introducirCredencialesErroneos();
        logueoStep.funcionDeLoginErroneo();
    }
    @Entonces("^Aparecerá un mensaje de error$")
    public void noEntroEnLaAplicacion(){
    logueoStep.mensajeDeError();
    }

}
