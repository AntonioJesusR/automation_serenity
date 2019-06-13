package com.pol.bss.pol_bss_automationtest.frontend.steps;

import com.pol.bss.pol_bss_automationtest.engine.UiSteps;
import com.pol.bss.pol_bss_automationtest.frontend.pageObjects.MeLogueoPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class MeLogueoStep extends UiSteps {

    MeLogueoPage page;
    //AQUI DEFINIREMOS LO QUE HAREMOS EN CADA METODO LLAMANDO A LOS DIFERENTESCONPONENTES
    @Step("Navego a la pagina de Edmodo")
    public void navegoAEdmodo(){
    page.init();
    }

    @Step("Cogeremos los input y lo rellenaremos correctamente")
    public void introducirCredenciales(){
    page.Logueo("antoniojesus994","Aj94Rv19");
    }

    @Step("Cogeremos los input y lo rellenaremos incorrectamente")
    public void introducirCredencialesErroneos(){
    page.Logueo("usuarioInvalido","ContraseñaInvalida");
    }

    @Step("Accionamos el botón de Login y compruebo que estoy en la URL correcta")
    public void funcionDeLogin(){
        page.clickEnLogin();
        page.comprueboLaPaginaDestino();
    }

    @Step("Accionamos el botón de Login")
    public void funcionDeLoginErroneo(){
    page.clickEnLogin();
    }

    @Step("Mensaje de error aparece")
    public void mensajeDeError(){
    page.mostrarMensajeDeError();
    }



}
