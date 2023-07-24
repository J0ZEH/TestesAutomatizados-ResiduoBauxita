package automatizado.pageObject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NoticiasPO extends BasePO {

    // #region botoes header
    @FindBy(css = "body > header > div > div.logo-select > a > img")
    public WebElement buttonLogoHeader;

    @FindBy(css = "#idiomas > div.dropdown-name")
    public WebElement selecionarIdiomaElement;

    @FindBy(css = "#idiomas > div.dropdown-options > a:nth-child(1) > p")
    public WebElement idiomaPortuguesElement;

    @FindBy(css = "#idiomas > div.dropdown-options > a:nth-child(2) > p")
    public WebElement idiomaInglesElement;

    @FindBy(css = "body > header > div > div.menu-nav > ul > li:nth-child(1) > a")
    public WebElement buttonInicio;

    @FindBy(css = "#drop-about > div.dropdown-name")
    public WebElement buttonSobre;

    @FindBy(css = "#drop-about > div.dropdown-options > a:nth-child(1)")
    public WebElement buttonSobreNos;

    @FindBy(css = "#drop-about > div.dropdown-options > a:nth-child(2)")
    public WebElement buttonSobreIntegrantes;

    @FindBy(css = "body > header > div > div.menu-nav > ul > li:nth-child(5) > a")
    public WebElement buttonTrabalhosPublicados;

    @FindBy(css = "body > header > div > div.menu-nav > ul > li:nth-child(6) > a")
    public WebElement buttonNoticias;
    // #endregion botoes header

     //#region botoes footer
    @FindBy(css = "body > footer > div > a")
    public WebElement buttonLogoFooter;

    @FindBy(css = "body > footer > div > div.social > div > a:nth-child(1)")
    public WebElement buttonEmailFooter;

    @FindBy(css = "body > footer > div > div.social > div > a:nth-child(2) > p")
    public WebElement buttonTwitterFooter;

    @FindBy(css = "body > footer > div > div.social > div > a:nth-child(3)")
    public WebElement buttonInstagramFooter;

    @FindBy(css = "body > footer > div > div.social > a > button")
    public WebElement buttonFaleConoscoFooter;

    @FindBy(css = "body > footer > div > div.social > div > a:nth-child(2) > button")
    public WebElement buttonFormulariodeContato;
    //#endregion botoes footer

    @FindBy(css = "body > div > header > div > div.menu-nav > ul > li:nth-child(6) > a")
    public WebElement buttonNoticiasFormContato;

    @FindBy(css = "#direita-baixo > button")
    public WebElement buttonAcessarNoticia;

    @FindBy(css = "body > div > section > div.texto > a")
    public WebElement buttonVerNoticiaCompleta;

    @FindBy(css = "body > div > section > div.cima > div.voltar > a > img")
    public WebElement buttonSetaEsquerda;

    @FindBy(css = "#section_news > div > div.pagination > a:nth-child(1)")
    public WebElement button1Pagination;

    @FindBy(css = "#section_news > div > div.pagination > a:nth-child(2)")
    public WebElement button2Pagination;


    public NoticiasPO(WebDriver driver) {
        super(driver);
    }
    
}
