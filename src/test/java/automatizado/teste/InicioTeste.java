package automatizado.teste;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.JavascriptExecutor;


import automatizado.pageObject.Pages.InicioPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InicioTeste extends Testes_testebase {

    public static InicioPO InicioPage;

    @BeforeClass
    public static void prepararTestes(){
        InicioPage = new InicioPO(driver);
    }

 
    @Test
    public void TC001_deveMostarOpcoesDeIdiomas(){
        
        InicioPage.selecionarIdiomaElement.click();

        String portugues = InicioPage.idiomaPortuguesElement.getText();
        assertEquals("Português", portugues);
        String ingles = InicioPage.idiomaInglesElement.getText();
        assertEquals("Inglês", ingles);

        InicioPage.selecionarIdiomaElement.click();
    }


    @Test
    public void TC002_deveMostrarOpcoesDeIdiomasEDeixarAPaginaEmIngles(){

        InicioPage.selecionarIdiomaElement.click();
        InicioPage.idiomaInglesElement.click();
    
        String msgIncio = InicioPage.buttonInicio.getText();
        assertEquals("Home", msgIncio);


    }

    @Test
    public void TC003_deveMostrarOpcoesDeIdiomasEDeixarAPaginaEmPortugues(){

        InicioPage.selecionarIdiomaElement.click();
        InicioPage.idiomaPortuguesElement.click();

        String msgIncio = InicioPage.buttonInicio.getText();
        assertEquals("Início", msgIncio);


    }

    @Test
    public void TC004_deveAcessarAPáginaDeInicioAoClicarNoCampoInicio(){

        InicioPage.buttonInicio.click();
        assertEquals("https://bauxiteresidue.ufma.br/index.php", driver.getCurrentUrl());

    }

    @Test
    public void TC005_deveClilcarNoBotaoSobreEExibirAsOpcoes(){

        InicioPage.buttonSobre.click();

        String sobreNosString = InicioPage.buttonSobreNos.getText();
        assertEquals("Sobre nós", sobreNosString);
        String sobreIntegrantesString = InicioPage.buttonSobreIntegrantes.getText();
        assertEquals("Integrantes", sobreIntegrantesString);

        InicioPage.buttonSobre.click();

    }

    @Test 
    public void TC006_deveClicarNoBotaoSobreClicarEmSobreNosAbrirAPaginaEVoltarParaOInicio(){

        InicioPage.buttonSobre.click();
        InicioPage.buttonSobreNos.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/sobre.php", driver.getCurrentUrl());
        
        InicioPage.buttonInicio.click();
        assertEquals("https://bauxiteresidue.ufma.br/index.php", driver.getCurrentUrl());

    }

    @Test
    public void TC007_deveClicarNoBotaoSobreClicarEmIntegrantesAbrirAPaginaEVoltarParaOInicio(){

        InicioPage.buttonSobre.click();
        InicioPage.buttonSobreIntegrantes.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/membros.php", driver.getCurrentUrl());

        InicioPage.buttonInicio.click();
        assertEquals("https://bauxiteresidue.ufma.br/index.php", driver.getCurrentUrl());

    }

    @Test
    public void TC008_deveClicarNoBotaoTrabalhosPublicadosAbrirAPaginaEVoltarParaOInicio(){

        InicioPage.buttonTrabalhosPublicados.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=1", driver.getCurrentUrl());

        InicioPage.buttonInicio.click();
        assertEquals("https://bauxiteresidue.ufma.br/index.php", driver.getCurrentUrl());

    }

    @Test
    public void TC009_deveClicarNoBotaoNoticiasAbrirAPaginaEVoltarParaOInicio(){

        InicioPage.buttonNoticias.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/noticias.php", driver.getCurrentUrl());

        InicioPage.buttonInicio.click();
        assertEquals("https://bauxiteresidue.ufma.br/index.php", driver.getCurrentUrl());


    }

    @Test
    public void TC010_deveExibirMaisInformacoesDoCardCimentoAoClicarNoBotaoVerMaisEFecharOCard() throws InterruptedException{

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        Thread.sleep(500);
        InicioPage.buttonVerMaisCimento.click();
        assertEquals("Cimento", InicioPage.tituloCard.getText());

    }

    @Test 
    public void TC011_deveExibirMaisInformacoesDoCardConcretoAoClicarNoBotaoVerMaisEFecharOCard() throws InterruptedException{

        driver.navigate().refresh();
        
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        Thread.sleep(500);
        InicioPage.buttonVerMaisConcreto.click();
        assertEquals("Concreto", InicioPage.tituloCard.getText());


    }

    @Test 
    public void TC012_deveExibirMaisInformacoesDoCardCeramicaAoClicarNoBotaoVerMaisEFecharOCard() throws InterruptedException{

        driver.navigate().refresh();
        
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        Thread.sleep(500);
        InicioPage.buttonVerMaisCeramica.click();
        assertEquals("Cerâmica", InicioPage.tituloCard.getText());


    }

    @Test 
    public void TC013_deveExibirMaisInformacoesDoCardBiotecnologiaAoClicarNoBotaoVerMaisEFecharOCard() throws InterruptedException{

        driver.navigate().refresh();
        
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        Thread.sleep(500);
        InicioPage.buttonVerMaisBiotecnologia.click();
        assertEquals("Biotecnologia", InicioPage.tituloCard.getText());


    }

    @Test
    public void TC014_deveAcessarAPaginaDeTrabalhosPublicadosEVoltarParaOInicio() throws InterruptedException{

        driver.navigate().refresh();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        
        Thread.sleep(500);
        InicioPage.buttonInicioFormulariodeContato.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/contact.php", driver.getCurrentUrl());

        jsExecutor.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
        Thread.sleep(500);
        InicioPage.buttonInicioFormContato.click();
        assertEquals("https://bauxiteresidue.ufma.br/index.php", driver.getCurrentUrl());

    }
    




}
