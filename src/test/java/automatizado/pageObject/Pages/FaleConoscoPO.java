package automatizado.pageObject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FaleConoscoPO extends BasePO {

    // #region botoes header
    @FindBy(css = "body > header > div > div.logo-select > a > img")
    public WebElement buttonLogoHeader;

    @FindBy(css = "#idiomas > div.dropdown-name")
    public WebElement selecionarIdiomaElement;

    @FindBy(css = "#idiomas > div.dropdown-options > a:nth-child(1) > p")
    public WebElement idiomaPortuguesElement;

    @FindBy(css = "#idiomas > div.dropdown-options > a:nth-child(2) > p")
    public WebElement idiomaInglesElement;

    @FindBy(css = "body > div > header > div > div.menu-nav > ul > li:nth-child(1) > a")
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

    // #region botoes footer
    @FindBy(css = "body > footer > div > a")
    public WebElement buttonLogoFooter;

    @FindBy(css = "body > footer > div > div.social > div > a:nth-child(1)")
    public WebElement buttonEmailFooter;

    @FindBy(css = "body > footer > div > div.social > div > a:nth-child(2) > p")
    public WebElement buttonTwitterFooter;

    @FindBy(css = "body > footer > div > div.social > div > a:nth-child(3)")
    public WebElement buttonInstagramFooter;

    @FindBy(css = "body > footer > div > div.social > div > a:nth-child(2) > button")
    public WebElement buttonFormulariodeContato;
    // #endregion botoes footer

    @FindBy(css = "#nome")
    public WebElement inputNome;

    @FindBy(css = "#email")
    public WebElement inputEmail;

    @FindBy(css = "#mensagem")
    public WebElement inputMensagem;

    @FindBy(css = "#envio-mensagem > form > button")
    public WebElement buttonEnviar;

    @FindBy(css = "#texto-alerta")
    public WebElement alertaEnvioMensagem;

    @FindBy(css = "#mensagem_alert_int > div.mini-header > div > a > img")
    public WebElement fecharAlertaEnvioMensagem;

    @FindBy(css = "body > div > footer > div > div.social > div > a:nth-child(2) > button")
    public WebElement buttonFormularioDeContatoPageElement;

    @FindBy(css = "body > div > header > div > div.menu-nav > ul > li:nth-child(5) > a")
    public WebElement buttonTrabalhosPublicadosPageElement;

    @FindBy(css = "body > div > header > div > div.menu-nav > ul > li:nth-child(6) > a")
    public WebElement buttonNoticiasPageElement;
    
    public FaleConoscoPO(WebDriver driver) {
        super(driver);
        
    }

    public void limparCampos(){
        inputEmail.clear();
        inputEmail.clear();
        inputMensagem.clear();
    }
    
}
