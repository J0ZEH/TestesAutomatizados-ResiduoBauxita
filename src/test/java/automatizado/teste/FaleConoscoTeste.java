package automatizado.teste;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import automatizado.pageObject.Pages.FaleConoscoPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FaleConoscoTeste extends Testes_testebase {

    public static FaleConoscoPO faleConoscoPage;

    @BeforeClass
    public static void prepararTestes() {
        driver.get("https://bauxiteresidue.ufma.br/pages/contact.php");
        faleConoscoPage = new FaleConoscoPO(driver);
    }

    @Test
    public void TC001_deveMostarOpcoesDeIdiomas() {

        faleConoscoPage.selecionarIdiomaElement.click();

        String portugues = faleConoscoPage.idiomaPortuguesElement.getText();
        assertEquals("Português", portugues);
        String ingles = faleConoscoPage.idiomaInglesElement.getText();
        assertEquals("Inglês", ingles);

        faleConoscoPage.selecionarIdiomaElement.click();
    }

    @Test
    public void TC002_deveMostrarOpcoesDeIdiomasEDeixarAPaginaEmIngles() {

        faleConoscoPage.selecionarIdiomaElement.click();
        faleConoscoPage.idiomaInglesElement.click();

        String msgIncio = faleConoscoPage.buttonInicio.getText();
        assertEquals("Home", msgIncio);

    }

    @Test
    public void TC003_deveMostrarOpcoesDeIdiomasEDeixarAPaginaEmPortugues() {

        faleConoscoPage.selecionarIdiomaElement.click();
        faleConoscoPage.idiomaPortuguesElement.click();

        String msgIncio = faleConoscoPage.buttonInicio.getText();
        assertEquals("Início", msgIncio);

    }

    @Test
    public void TC004_deveAcessarAPáginaDeInicioAoClicarNoCampoInicioEVoltarFaleConosco() throws InterruptedException {

        faleConoscoPage.buttonInicio.click();
        assertEquals("https://bauxiteresidue.ufma.br/index.php", driver.getCurrentUrl());

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(500);
        faleConoscoPage.buttonFormulariodeContato.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/contact.php", driver.getCurrentUrl());

    }

    @Test
    public void TC005_deveClilcarNoBotaoSobreEExibirAsOpcoes() {

        faleConoscoPage.buttonSobre.click();

        String sobreNosString = faleConoscoPage.buttonSobreNos.getText();
        assertEquals("Sobre nós", sobreNosString);
        String sobreIntegrantesString = faleConoscoPage.buttonSobreIntegrantes.getText();
        assertEquals("Integrantes", sobreIntegrantesString);

        faleConoscoPage.buttonSobre.click();

    }

    @Test
    public void TC006_deveClicarNoBotaoSobreClicarEmSobreNosEVoltarParaFaleConosco() throws InterruptedException {

        faleConoscoPage.buttonSobre.click();
        faleConoscoPage.buttonSobreNos.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/sobre.php", driver.getCurrentUrl());

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(500);
        faleConoscoPage.buttonFormulariodeContato.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/contact.php", driver.getCurrentUrl());

    }

    @Test
    public void TC007_deveClicarNoBotaoSobreClicarEmIntegrantesAbrirAPaginaEVoltarParaFaleConosco()
            throws InterruptedException {

        faleConoscoPage.buttonSobre.click();
        faleConoscoPage.buttonSobreIntegrantes.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/membros.php", driver.getCurrentUrl());

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(500);
        faleConoscoPage.buttonFormulariodeContato.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/contact.php", driver.getCurrentUrl());

    }

    @Test
    public void TC008_deveClicarNoBotaoTrabalhosPublicadosAbrirAPaginaEVoltarParaFaleConosco()
            throws InterruptedException {

        faleConoscoPage.buttonTrabalhosPublicadosPageElement.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=1", driver.getCurrentUrl());

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(500);
        faleConoscoPage.buttonFormulariodeContato.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/contact.php", driver.getCurrentUrl());

    }

    @Test
    public void TC009_deveClicarNoBotaoNoticiasAbrirAPaginaEVoltarParaFaleConosco() throws InterruptedException {

        faleConoscoPage.buttonNoticiasPageElement.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/noticias.php", driver.getCurrentUrl());

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(1000);
        faleConoscoPage.buttonFormulariodeContato.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/contact.php", driver.getCurrentUrl());

    }

    @Test
    public void TC010_deveClicarNoBotaoDoFormularioDeContatoEContinuarEmFaleConosco() throws InterruptedException {

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        Thread.sleep(1000);
        faleConoscoPage.buttonFormularioDeContatoPageElement.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/contact.php", driver.getCurrentUrl());

    }

    @Test
    public void TC011_devePermitirQueOUsuarioEscrevaNoCampoNome() {

        faleConoscoPage.limparCampos();
        faleConoscoPage.inputNome.sendKeys("Usuário Teste");

    }

    @Test
    public void TC012_devePermitirQueOUsuarioEscrevaNoCampoEmail() {

        faleConoscoPage.limparCampos();
        faleConoscoPage.inputEmail.sendKeys("usuario@gmail.com" + Keys.TAB);

    }

    @Test
    public void TC013_devePermitirQueOUsuarioEscrevaNoCampoMensagem() {

        faleConoscoPage.limparCampos();
        faleConoscoPage.inputMensagem.sendKeys("Lorem ipsum dolor sit amet." + Keys.TAB);

    }

    @Test
    public void TC014_deveImpedirQueOUsuarioEnvieUmaMensagemApenasComOCampoNomePreenchido()
            throws InterruptedException {

        driver.navigate().refresh();
        Thread.sleep(500);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
        Thread.sleep(1000);

        faleConoscoPage.limparCampos();
        faleConoscoPage.inputNome.sendKeys("Usuário Teste" + Keys.TAB);

        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        Thread.sleep(500);
        faleConoscoPage.buttonEnviar.click();

        assertEquals("", faleConoscoPage.alertaEnvioMensagem.getText());

    }

    @Test
    public void TC015_deveImpedirQueOUsuarioEnvieUmaMensagemApenasComOCampoEmailPreenchido()
            throws InterruptedException {

        driver.navigate().refresh();
        Thread.sleep(500);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
        Thread.sleep(1000);

        faleConoscoPage.limparCampos();
        faleConoscoPage.inputEmail.sendKeys("usuario@gmail.com" + Keys.TAB);

        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        Thread.sleep(500);
        faleConoscoPage.buttonEnviar.click();

        assertEquals("", faleConoscoPage.alertaEnvioMensagem.getText());

    }

    @Test
    public void TC016_deveImpedirQueOUsuarioEnvieUmaMensagemApenasComOCampoMensagemPreenchido()
            throws InterruptedException {

        driver.navigate().refresh();
        Thread.sleep(500);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
        Thread.sleep(1000);

        faleConoscoPage.limparCampos();
        faleConoscoPage.inputMensagem.sendKeys("Lorem ipsum dolor sit amet." + Keys.TAB);

        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        Thread.sleep(500);
        faleConoscoPage.buttonEnviar.click();

        assertEquals("", faleConoscoPage.alertaEnvioMensagem.getText());

    }

    @Test
    public void TC017_deveImpedirQueOUsuarioEnvieUmaMensagemApenasComUmEmailInvalido() throws InterruptedException {

        driver.navigate().refresh();
        Thread.sleep(500);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
        Thread.sleep(1000);

        faleConoscoPage.limparCampos();
        faleConoscoPage.inputEmail.sendKeys("u$ua.4rio%gmailcombr." + Keys.TAB);

        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        Thread.sleep(500);
        faleConoscoPage.buttonEnviar.click();

        assertEquals("", faleConoscoPage.alertaEnvioMensagem.getText());

    }

    @Test
    public void deveExibirUmAlertaDeConfirmacaoQueAMensagemFoiEnviada() throws InterruptedException {

        driver.navigate().refresh();
        Thread.sleep(500);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
        Thread.sleep(1000);

        faleConoscoPage.limparCampos();
        faleConoscoPage.inputNome.sendKeys("Usuário Teste" + Keys.TAB);
        faleConoscoPage.inputEmail.sendKeys("usuario@gmail.com" + Keys.TAB);
        faleConoscoPage.inputMensagem.sendKeys("Lorem ipsum dolor sit amet." + Keys.TAB);

        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        Thread.sleep(500);
        faleConoscoPage.buttonEnviar.click();

        Thread.sleep(1000);
        assertEquals("mensagem enviada com sucesso! Aguarde um retorno através do email inserido.",
                faleConoscoPage.alertaEnvioMensagem.getText());

    }

}