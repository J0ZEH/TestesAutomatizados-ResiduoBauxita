package automatizado.pageObject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SobreIntegrantesPO extends BasePO {

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

    @FindBy(css = "body > div > div.lideres > div:nth-child(1) > a > button")
    public WebElement verMaisAna;

    @FindBy(css = "body > div > div.popup > div > div.cima > div.info > h5")
    public WebElement nomeCompletoAna;

    @FindBy(css = "body > div > div.popup > div > a > img")
    public WebElement buttonFecharCard;

    @FindBy(css = "body > div > div.popup > div > div.baixo > a > button")
    public WebElement buttonCurriculoLattesAna;

    @FindBy(css = "body > div > div.lideres > div:nth-child(2) > a > button")
    public WebElement verMaisWerner;

    @FindBy(css = "body > div > div.popup > div > div.cima > div.info > h5")
    public WebElement nomeCompletoWerner;

    @FindBy(css = "body > div > div.popup > div > div.baixo > a > button")
    public WebElement buttonCurriculoLattesWerner;

    @FindBy(css = "body > div > div:nth-child(5) > div:nth-child(1) > a > button")
    public WebElement verMaisLuisCarlos;

    @FindBy(css = "body > div > div.popup > div > div.cima > div.info > h5")
    public WebElement nomeCompletoLuisCarlos;

    @FindBy(css = "body > div > div.popup > div > div.baixo > a > button")
    public WebElement buttonCurriculoLattesLuisCarlos;

    @FindBy(css = "body > div > div:nth-child(5) > div:nth-child(2) > a > button")
    public WebElement verMaisJoseEdvar;

    @FindBy(css = "body > div > div.popup > div > div.cima > div.info > h5")
    public WebElement nomeCompletoJoseEdvar;

    @FindBy(css = "body > div > div.popup > div > div.baixo > a > button")
    public WebElement buttonCurriculoLattesJoseEdvar;

    @FindBy(css = "body > div > div:nth-child(5) > div:nth-child(3) > a > button")
    public WebElement verMaisMairaSilva;

    @FindBy(css = "body > div > div.popup > div > div.cima > div.info > h5")
    public WebElement nomeCompletoMairaSilva;

    @FindBy(css = "body > div > div:nth-child(7) > div > a > button")
    public WebElement verMaisHelderB;

    @FindBy(css = "body > div > div.popup > div > div.cima > div.info > h5")
    public WebElement nomeCompletoHelderB;


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
    // #endregion botoes footer
        

    public SobreIntegrantesPO(WebDriver driver) {
        super(driver);
    }
    
}
