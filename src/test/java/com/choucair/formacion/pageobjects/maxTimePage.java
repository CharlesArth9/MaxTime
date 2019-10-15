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
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

//@DefaultUrl("https://www.tiendasjumbo.co")
@DefaultUrl("https://cutt.ly/JeukmvJ")
//@DefaultUrl("https://cutt.ly/UeorwqO")

public class maxTimePage extends PageObject{
     @FindBy(xpath = "//span[contains(text(),'CATEGORÍAS')]")
     private WebElementFacade btnCategoria;
     @FindBy(xpath = "//body/div/div/div/ul/li[1]/span[1]/a[1]/span[1]")
     private WebElementFacade catSupermercado;
     @FindBy(xpath = "//span[contains(text(),'Despensa')]")
     private WebElementFacade catDespensa;

     // ============ INSTANCIAS =============
     WebDriverWait espera = new WebDriverWait( getDriver(), 20 ); // TIEMPO EXPLICITO
     JavascriptExecutor js = (JavascriptExecutor) getDriver();
     Actions accion = new Actions( getDriver() );
     Robot robot = new Robot();

     public maxTimePage() throws AWTException{
     }

     // ==================  METODO DE ESPERA  =======================
     private static Callable <Boolean> condicionEstaCompleta(){
          return new Callable <Boolean>(){
               public Boolean call() throws Exception{
                    Boolean allMessagesProcessed = true;
                    return allMessagesProcessed;
               }
          };
     }

     // ==============================================================
     public void login(String usuario, String pass){
          $( "//input[contains(@id,'Logon_v0_MainLayoutEdit_xaf_l30_xaf_dviUserName_Edit_I')]" ).type( usuario );
          $( "td.dxic input[type='password']" ).type( pass );
          $( "//a[@href='javascript:;']" ).click();
          waitFor( 5 ).seconds();
     }

     public void seleccionardia(){
          accion.moveByOffset( 369, 212 ).click().build().perform();
          waitFor( 5 ).seconds();
     }

     public void realizarNuevoReporte() throws AWTException{
          $( "//a[@title='Nuevo Detalle Reporte Dia'][contains(.,'Nuevo')]" ).waitUntilClickable().click();
          waitFor( 2 ).seconds();
          WebElement buscarProyecto = $( "tr td#Vertical_v11_MainLayoutEdit_xaf_l135_xaf_dviProyecto_Edit_Find_B" );
          WebElement buscarServicio = $( "//td[@id='Vertical_v11_MainLayoutEdit_xaf_l160_xaf_dviServicio_Edit_Find_B']" );
          accion.moveToElement( buscarProyecto ).click( buscarProyecto ).build().perform();
          waitFor( 2 ).seconds();
          espera.until( ExpectedConditions.frameToBeAvailableAndSwitchToIt( By.xpath( "//iframe" ) ) );
          accion.moveToElement( findBy( "//td[@id='Dialog_v6_LE_v7_tccell0_4']" ) ).click().build().perform();
          waitFor( 5 ).seconds();
          accion.click( findBy( "table[id*='TipoHora'] input[id*='TipoHora_Edit_DD_I']" ) );
          $( "table[id*='TipoHora'] input[id*='TipoHora_Edit_DD_I']" ).typeAndTab( "H. Choucair" );
          accion.moveToElement( buscarServicio, 748, 400 ).click().build().perform();
          waitFor( 3 ).seconds();
          espera.until( ExpectedConditions.frameToBeAvailableAndSwitchToIt( By.xpath( "(//iframe)[1]" ) ) );
          $( "td.dxic input[value='Text to search...']" ).typeAndEnter( "." );
          waitFor( 3 ).seconds();
     }


     public void slide(){
          //  WebElement slider = getDriver().findElement(By.xpath("//div[@aria-labelledby='filter-toolbar-price-handle']"));
          //  new Actions(getDriver()).dragAndDropBy(slider,-188,0).build().perform();
          js.executeScript( "document.getElementsByClassName('fl-slider__handle')[0].style.left='20%'" );
          //  robot.keyPress( KeyEvent.VK_DOWN );
          //  robot.keyPress( KeyEvent.VK_ENTER );
     }


     public void seleccionarCategoria(){

          List <WebElementFacade> divs = findAll( "li.despensa li" );
          int count = divs.size();
          System.out.println( "================== "+count+" ========================" );
          accion.moveToElement( btnCategoria ).perform();
          accion.moveToElement( catSupermercado ).perform();
          accion.moveToElement( catDespensa ).perform();


          WebElement hijo = getDriver().findElement( By.cssSelector( "li.despensa li:nth-of-type(16) a" ) );
          js.executeScript( "arguments[0].scrollIntoView();", hijo );
          hijo.click();

          //   getDriver().manage().deleteAllCookies();
          //   getDriver().manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS );
          //   getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS );
          //   Thread.sleep(5000);

          // ==================  METODO DE ESPERA  =======================

          try {
               Awaitility.await().forever().pollInterval( 8000, TimeUnit.MILLISECONDS ).until( condicionEstaCompleta() );
          } catch (Exception e) {
               e.getMessage();
          }
          // =================================================================

          $( "//span[contains(@id,'select2-g6ek-container')]" ).click();

          // ============================= ESPERAS ===========================
          //  waitForTextToAppear("Supermercado");
          /*act.moveToElement(findBy("span.selection"));
          $("select[class*='order-by-select']").selectByIndex(2);*/
          /*By div = By.cssSelector("div.shelf-order-by");
          By select = By.cssSelector("select[class*='order-by-select']");

          ExpectedCondition expectedCondition = ExpectedConditions.visibilityOfNestedElementsLocatedBy(div, select);
          System.out.println(expectedCondition.toString());*/
          //  waitFor("select[class*='order-by-select']").getDriver().findElement(By.xpath("//span[contains(@id,'select2-g6ek-container')]")).click();
          //  WebDriverWait waite = new WebDriverWait(getDriver(), 10);
          //   waite.until(ExpectedConditions.visibilityOfElementLocated(By.id("select2-g6ek-container")));
          // =================================================================

          //=================== FORMAS DE SCROLL ============================

          // js.executeScript("arguments[0].scrollIntoView();", hijo);
          // Scroll.to(hijo);
          // new ScrollToBy(hijo);
          // new ScrollToWebElement(hijo);
          // js.executeScript("window.scrollTo(0, document.body.scrollHeight)");


          // ============= BUSCAR ELEMENTOS VISIBLES ANIDADOS (PADRES E HIJOS) ==============

          /* By padre = By.xpath("//li[@class='despensa']//ul");
          By hijo = By.cssSelector("li.despensa li:nth-of-type(16) a");
          ExpectedCondition expectedCondition = ExpectedConditions.visibilityOfNestedElementsLocatedBy(padre, hijo);
          System.out.println(expectedCondition.toString()); */


     }

}


