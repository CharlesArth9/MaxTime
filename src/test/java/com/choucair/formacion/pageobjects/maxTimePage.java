package com.choucair.formacion.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.awaitility.Awaitility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

//@DefaultUrl("https://www.tiendasjumbo.co/supermercado/despensa/te-infusiones-e-instantaneos")
@DefaultUrl("https://www.tiendasjumbo.co")
//@DefaultUrl("https://cutt.ly/JeukmvJ")
//@DefaultUrl("https://cutt.ly/UeorwqO")
public class maxTimePage extends PageObject {
    @FindBy(xpath = "//span[contains(text(),'CATEGORÍAS')]")
    WebElementFacade btnCategoria;
    @FindBy (xpath = "//body/div/div/div/ul/li[1]/span[1]/a[1]/span[1]")
    WebElementFacade catSupermercado;
    @FindBy (xpath = "//span[contains(text(),'Despensa')]")
    WebElementFacade catDespensa;
      @FindBy (xpath = "(//button[@data-productid]//span[@class='product-add-to-cart__text'][contains(.,'Comprar')])[1]")
    WebElementFacade btnComprar;

    // ==================  METODO DE ESPERA  =======================
    private static Callable<Boolean> succesfullCondition(){
        return new Callable<Boolean>() {
            public Boolean call() throws Exception{
                Boolean allMessagesProcessed = true;
                return allMessagesProcessed;
            }
        };
    }
    // ==============================================================
    public void login() {
        $("//input[contains(@id,'Logon_v0_MainLayoutEdit_xaf_l30_xaf_dviUserName_Edit_I')]").type("cmestral");
        $("td.dxic input[type='password']").type("2619rey9");
        $("//a[@href='javascript:;']").click();
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
        WebElement buscarProyecto = $("tr td#Vertical_v11_MainLayoutEdit_xaf_l135_xaf_dviProyecto_Edit_Find_B");
        WebElement buscarServicio = $("//td[@id='Vertical_v11_MainLayoutEdit_xaf_l160_xaf_dviServicio_Edit_Find_B']");
        a.moveToElement(buscarProyecto).click(buscarProyecto).build().perform();
        waitFor(2).seconds();
        iframe.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe")));
        //  getDriver().switchTo().frame(getDriver().findElement(By.xpath("(//iframe)[1]")));
        a.moveToElement(findBy("//td[@id='Dialog_v6_LE_v7_tccell0_4']")).click().build().perform();
        waitFor(5).seconds();
        a.click(findBy("table[id*='TipoHora'] input[id*='TipoHora_Edit_DD_I']"));
        $("table[id*='TipoHora'] input[id*='TipoHora_Edit_DD_I']").typeAndTab("H. Choucair");
        a.moveToElement(buscarServicio,748,400).click().build().perform();
        waitFor(3).seconds();
        iframe.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("(//iframe)[1]")));
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


     public void slide(){
     //   WebElement slider = getDriver().findElement(By.xpath("//div[@aria-labelledby='filter-toolbar-price-handle']"));
       //  new Actions(getDriver()).dragAndDropBy(slider,-188,0).build().perform();
         ((JavascriptExecutor)getDriver()).executeScript("document.getElementsByClassName('fl-slider__handle')[0].style.left='20%'");

     }



    public void seleccionarCategoria () throws AWTException, InterruptedException {
        Actions act = new Actions(getDriver());
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        List<WebElementFacade> divs = findAll("li.despensa li");
        int count = divs.size();
        System.out.println("================== "  +count+  " ========================");
            act.moveToElement(btnCategoria).perform();
            act.moveToElement(catSupermercado).perform();
            act.moveToElement(catDespensa).perform();


        WebElement hijo = getDriver().findElement(By.cssSelector("li.despensa li:nth-of-type(16) a"));
        js.executeScript("arguments[0].scrollIntoView();", hijo);
        hijo.click();
    //    getDriver().manage().deleteAllCookies();
    //   getDriver().manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS );
    //   getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS );
    //   Thread.sleep(5000);

        // ==================  METODO DE ESPERA  =======================

        try {
            Awaitility.await().forever().pollInterval(8000, TimeUnit.MILLISECONDS).until(succesfullCondition());
        }catch (Exception e){
            e.getMessage();
        }
       // ===================================================================
    //    waitForTextToAppear("Supermercado");
        /*act.moveToElement(findBy("span.selection"));
        $("select[class*='order-by-select']").selectByIndex(2);*/
        /*By div = By.cssSelector("div.shelf-order-by");
        By select = By.cssSelector("select[class*='order-by-select']");

        ExpectedCondition expectedCondition = ExpectedConditions.visibilityOfNestedElementsLocatedBy(div, select);
        System.out.println(expectedCondition.toString());*/
       //  waitFor("select[class*='order-by-select']").getDriver().findElement(By.xpath("//span[contains(@id,'select2-g6ek-container')]")).click();
      //  WebDriverWait waite = new WebDriverWait(getDriver(), 10);
     //   waite.until(ExpectedConditions.visibilityOfElementLocated(By.id("select2-g6ek-container")));
    //  waitFor(5).seconds();
       $("//*[@id='search-results-page']/div[29]/div/div[2]/div[3]/div[2]/div[1]/span/span[1]").click();



        // FORMAS DE SCROLL

     // js.executeScript("arguments[0].scrollIntoView();", hijo);
     // Scroll.to(hijo);
     // new ScrollToBy(hijo);
     // new ScrollToWebElement(hijo);
     // js.executeScript("window.scrollTo(0, document.body.scrollHeight)");


     // BUSCAR ELEMENTOS VISIBLES ANIDADOS (PADRES E HIJOS)

       /* By padre = By.xpath("//li[@class='despensa']//ul");
          By hijo = By.cssSelector("li.despensa li:nth-of-type(16) a");

        ExpectedCondition expectedCondition = ExpectedConditions.visibilityOfNestedElementsLocatedBy(padre, hijo);
        System.out.println(expectedCondition.toString()); */

      //      }
     //   }


}

}


