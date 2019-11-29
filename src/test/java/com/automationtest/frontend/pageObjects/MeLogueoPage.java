package com.automationtest.frontend.pageObjects;

import com.automationtest.util.SeleniumWait;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.WhenPageOpens;
import org.junit.Assert;


public class MeLogueoPage extends PageObject {
    @FindBy(name="username")
    private WebElementFacade inputUsuario;

    @FindBy(id="password")
    private WebElementFacade inputContraseña;

    @FindBy(id="qa-test-lightbox-login")
    private WebElementFacade botonDeLogin;

    @FindBy(xpath="//*[@id=\"root\"]/div/div/div/div/div[2]/div/div[2]/div/div")
    private WebElementFacade mensajeDeError;

    @FindBy(id="qa-test-profile-card-avatar")
    private WebElementFacade avatar;

    @WhenPageOpens
    public void init(){
    getDriver().get("https:/www.google.com");
    }

    public void Logueo(String usuario,String contraseña){
        inputUsuario.sendKeys(usuario);
        inputContraseña.sendKeys(contraseña);
    }

    public void clickEnLogin(){
        botonDeLogin.click();
    }

    public void comprueboLaPaginaDestino(){
        SeleniumWait.waitVisibility(this.getDriver(),5,avatar);
        Assert.assertEquals(this.getDriver().getCurrentUrl(),"https://new.edmodo.com/home");
    }

    public void  mostrarMensajeDeError(){
      Assert.assertTrue(mensajeDeError.isVisible());
    }

}
