package com.choucair.formacion.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;


@DefaultUrl("https://cutt.ly/JeukmvJ")
public class maxTimePage extends PageObject {
    public void login() {
        $("//input[contains(@id,'Logon_v0_MainLayoutEdit_xaf_l30_xaf_dviUserName_Edit_I')]").type("cmestral");
        $("td.dxic input[type='password']").type("2619rey9");
        $("//a[@href='javascript:;']").waitUntilClickable().click();
        waitFor(5).seconds();
    }

    public void seleccionardia(){
        new Actions(getDriver()).moveByOffset(369,212).click().build().perform();
        waitFor(5).seconds();
    }

    public void realizarNuevoReporte() throws AWTException {
        $("//a[@title='Nuevo Detalle Reporte Dia'][contains(.,'Nuevo')]").waitUntilClickable().click();
        waitFor(2).seconds();
        WebDriverWait iframe = new WebDriverWait(getDriver(), 5);
        Actions a = new Actions(getDriver());
        WebElement buscarProyecto = $("tr td#Vertical_v6_MainLayoutEdit_xaf_l128_xaf_dviProyecto_Edit_Find_B");
        WebElement buscarServicio = $("//table[@id='Vertical_v6_MainLayoutEdit_xaf_l153_xaf_dviServicio_Edit_Find']");
        a.moveToElement(buscarProyecto).click(buscarProyecto).build().perform();
        waitFor(2).seconds();
        iframe.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("(//iframe)[1]")));
        //  getDriver().switchTo().frame(getDriver().findElement(By.xpath("(//iframe)[1]")));
        a.moveToElement(findBy("//td[@id='Dialog_v7_LE_v8_tccell0_4']")).click().build().perform();
        waitFor(5).seconds();
        a.click(findBy("table[id*='TipoHora'] input[id*='TipoHora_Edit_DD_I']"));
        $("table[id*='TipoHora'] input[id*='TipoHora_Edit_DD_I']").typeAndTab("H. Choucair");
        a.moveToElement(buscarServicio,748,400).click().build().perform();
        waitFor(3).seconds();
        iframe.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("(//iframe)[2]")));
        $("td.dxic input[value='Text to search...']").typeAndEnter(".");
        waitFor(3).seconds();



        /*try {

        if (isElementVisible((By.xpath("(//iframe)[1]")))){
            System.out.println("1");
            waitFor(3).seconds();
            iframe.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("//iframe)[1]"));
        }else if (isElementVisible((By.xpath("(//iframe)[2]")))){
            System.out.println("2");
        }else {
            System.out.println("no sirve esta porquería");
        }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }*/

       // $("td.dxic input[value='Text to search...']").typeAndEnter("Varios Choucair Medellín");
        }






}


