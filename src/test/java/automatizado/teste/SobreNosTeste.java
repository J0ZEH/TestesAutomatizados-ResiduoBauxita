package automatizado.teste;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.JavascriptExecutor;

import automatizado.pageObject.Pages.SobreNosPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SobreNosTeste extends Testes_testebase {

    public static SobreNosPO sobreNosPage;

    @BeforeClass
    public static void prepararTestes(){
        driver.get("https://bauxiteresidue.ufma.br/pages/sobre.php");
        sobreNosPage = new SobreNosPO(driver);
    }

    @Test
    public void TC001_deveMostarOpcoesDeIdiomas(){
        
        sobreNosPage.selecionarIdiomaElement.click();

        String portugues = sobreNosPage.idiomaPortuguesElement.getText();
        assertEquals("Português", portugues);
        String ingles = sobreNosPage.idiomaInglesElement.getText();
        assertEquals("Inglês", ingles);

        sobreNosPage.selecionarIdiomaElement.click();
    }


    @Test
    public void TC002_deveMostrarOpcoesDeIdiomasEDeixarAPaginaEmIngles(){

        sobreNosPage.selecionarIdiomaElement.click();
        sobreNosPage.idiomaInglesElement.click();
    
        String msgIncio = sobreNosPage.buttonInicio.getText();
        assertEquals("Home", msgIncio);

    }

    @Test
    public void TC003_deveMostrarOpcoesDeIdiomasEDeixarAPaginaEmPortugues(){

        sobreNosPage.selecionarIdiomaElement.click();
        sobreNosPage.idiomaPortuguesElement.click();

        String msgIncio = sobreNosPage.buttonInicio.getText();
        assertEquals("Início", msgIncio);
    
    }

    @Test
    public void TC004_deveAcessarAPáginaDeInicioAoClicarNoCampoInicioEVoltarParaSobreNos(){

        sobreNosPage.buttonInicio.click();
        assertEquals("https://bauxiteresidue.ufma.br/index.php", driver.getCurrentUrl());

        sobreNosPage.buttonSobre.click();
        sobreNosPage.buttonSobreNos.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/sobre.php", driver.getCurrentUrl());

    }

    @Test
    public void TC005_deveClilcarNoBotaoSobreEExibirAsOpcoes(){

        sobreNosPage.buttonSobre.click();

        String sobreNosString = sobreNosPage.buttonSobreNos.getText();
        assertEquals("Sobre nós", sobreNosString);
        String sobreIntegrantesString = sobreNosPage.buttonSobreIntegrantes.getText();
        assertEquals("Integrantes", sobreIntegrantesString);

        sobreNosPage.buttonSobre.click();

    }

    @Test 
    public void TC006_deveClicarNoBotaoSobreClicarEmSobreNosEContinuarNaPagina(){

        sobreNosPage.buttonSobre.click();
        sobreNosPage.buttonSobreNos.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/sobre.php", driver.getCurrentUrl());

    }

    @Test
    public void TC007_deveClicarNoBotaoSobreClicarEmIntegrantesAbrirAPaginaEVoltarParaOInicio(){

        sobreNosPage.buttonSobre.click();
        sobreNosPage.buttonSobreIntegrantes.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/membros.php", driver.getCurrentUrl());
        
        sobreNosPage.buttonSobre.click();
        sobreNosPage.buttonSobreNos.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/sobre.php", driver.getCurrentUrl());

    }

    @Test
    public void TC008_deveClicarNoBotaoTrabalhosPublicadosAbrirAPaginaEVoltarParaSobreNos(){

        sobreNosPage.buttonTrabalhosPublicados.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=1", driver.getCurrentUrl());

        sobreNosPage.buttonSobre.click();
        sobreNosPage.buttonSobreNos.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/sobre.php", driver.getCurrentUrl());

    }

    @Test
    public void TC09_deveClicarNoBotaoNoticiasAbrirAPaginaEVoltarParaSobreNos(){

        sobreNosPage.buttonNoticias.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/noticias.php", driver.getCurrentUrl());

        sobreNosPage.buttonSobre.click();
        sobreNosPage.buttonSobreNos.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/sobre.php", driver.getCurrentUrl());


    }

    @Test
    public void TC010_deveAcessarAPaginaDoFormularioDeContatoEVoltarParaSobreNos() throws InterruptedException{

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        
        Thread.sleep(500);
        sobreNosPage.buttonFormulariodeContato.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/contact.php", driver.getCurrentUrl());

        sobreNosPage.buttonSobre.click();
        sobreNosPage.buttonSobreNos.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/sobre.php", driver.getCurrentUrl());

    }



    
    
}
