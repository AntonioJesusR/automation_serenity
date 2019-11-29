package com.automationtest.frontend.pageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebElement;

import static com.automationtest.SessionVariables.BUSQUEDA;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;

public class BusquedaEnEdmodoPage extends PageObject {
    @FindBy(xpath="//*[@id=\"LoggedInHeader\"]/div/div[2]/div[2]/input")
    private WebElementFacade buscador;


    public void buscador(){
        String palabra = sessionVariableCalled(BUSQUEDA);
        buscador.click();
        buscador.sendKeys(palabra);
        buscador.sendKeys(Keys.ENTER);
    }

    public void tabs() {
        RemoteWebElement Lista = getDriver().findElement(By.className("search-page-tab-list"));
        int elementos = Lista.findElements(By.tagName("li")).size();
        for ( int x=0 ; x<elementos ; x++) {
            Lista.findElements(By.tagName("li")).get(x).click();
        }
    }
}
