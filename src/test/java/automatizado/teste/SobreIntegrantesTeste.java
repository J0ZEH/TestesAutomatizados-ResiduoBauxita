package automatizado.teste;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.JavascriptExecutor;

import automatizado.pageObject.Pages.SobreIntegrantesPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SobreIntegrantesTeste extends Testes_testebase {

    public static SobreIntegrantesPO sobreIntegrantesPage;

    @BeforeClass
    public static void prepararTestes(){
        driver.get("https://bauxiteresidue.ufma.br/pages/membros.php");
        sobreIntegrantesPage = new SobreIntegrantesPO(driver);
    }

    @Test
    public void TC001_deveMostarOpcoesDeIdiomas() throws InterruptedException{
        
        sobreIntegrantesPage.selecionarIdiomaElement.click();

        String portugues = sobreIntegrantesPage.idiomaPortuguesElement.getText();
        assertEquals("Português", portugues);
        String ingles = sobreIntegrantesPage.idiomaInglesElement.getText();
        Thread.sleep(500);
        assertEquals("Inglês", ingles);

        sobreIntegrantesPage.selecionarIdiomaElement.click();
    }


    @Test
    public void TC002_deveMostrarOpcoesDeIdiomasEDeixarAPaginaEmIngles(){

        sobreIntegrantesPage.selecionarIdiomaElement.click();
        sobreIntegrantesPage.idiomaInglesElement.click();
    
        String msgIncio = sobreIntegrantesPage.buttonInicio.getText();
        assertEquals("Home", msgIncio);

    }

    @Test
    public void TC003_deveMostrarOpcoesDeIdiomasEDeixarAPaginaEmPortugues(){

        sobreIntegrantesPage.selecionarIdiomaElement.click();
        sobreIntegrantesPage.idiomaPortuguesElement.click();

        String msgIncio = sobreIntegrantesPage.buttonInicio.getText();
        assertEquals("Início", msgIncio);
    
    }

    @Test
    public void TC004_deveAcessarAPáginaDeInicioAoClicarNoCampoInicioEVoltarParaSobreIntegrantes(){

        sobreIntegrantesPage.buttonInicio.click();
        assertEquals("https://bauxiteresidue.ufma.br/index.php", driver.getCurrentUrl());

        sobreIntegrantesPage.buttonSobre.click();
        sobreIntegrantesPage.buttonSobreIntegrantes.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/membros.php", driver.getCurrentUrl());

    }

    @Test
    public void TC005_deveClilcarNoBotaoSobreEExibirAsOpcoes(){

        sobreIntegrantesPage.buttonSobre.click();

        String sobreNosString = sobreIntegrantesPage.buttonSobreNos.getText();
        assertEquals("Sobre nós", sobreNosString);
        String sobreIntegrantesString = sobreIntegrantesPage.buttonSobreIntegrantes.getText();
        assertEquals("Integrantes", sobreIntegrantesString);

        sobreIntegrantesPage.buttonSobre.click();

    }

    @Test 
    public void TC006_deveClicarNoBotaoSobreClicarEmSobreNosEVoltarParaSobreIntegrantes() throws InterruptedException{

        Thread.sleep(500);
        sobreIntegrantesPage.buttonSobre.click();
        sobreIntegrantesPage.buttonSobreNos.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/sobre.php", driver.getCurrentUrl());

        sobreIntegrantesPage.buttonSobre.click();
        sobreIntegrantesPage.buttonSobreIntegrantes.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/membros.php", driver.getCurrentUrl());


    }

    @Test
    public void TC007_deveClicarNoBotaoSobreClicarEmIntegrantesEContinuarNaPagina() throws InterruptedException{

        Thread.sleep(500);
        sobreIntegrantesPage.buttonSobre.click();
        sobreIntegrantesPage.buttonSobreIntegrantes.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/membros.php", driver.getCurrentUrl());

    }

    @Test
    public void TC008_deveClicarNoBotaoTrabalhosPublicadosAbrirAPaginaEVoltarParaSobreIntegrantes(){

        sobreIntegrantesPage.buttonTrabalhosPublicados.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=1", driver.getCurrentUrl());

        sobreIntegrantesPage.buttonSobre.click();
        sobreIntegrantesPage.buttonSobreIntegrantes.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/membros.php", driver.getCurrentUrl());

    }

    @Test
    public void TC09_deveClicarNoBotaoNoticiasAbrirAPaginaEVoltarParaSobreIntegrantes() throws InterruptedException{

        sobreIntegrantesPage.buttonNoticias.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/noticias.php", driver.getCurrentUrl());

        Thread.sleep(500);
        sobreIntegrantesPage.buttonSobre.click();
        sobreIntegrantesPage.buttonSobreIntegrantes.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/membros.php", driver.getCurrentUrl());


    }

    @Test
    public void TC010_deveExibirOCardDeInformacoesSobreOsMembrosLideresAbrirOCurriculoLattesEFecharOCardDeInformacoes() throws InterruptedException{
        
        //ana lucia alexandre de oliveira
        sobreIntegrantesPage.verMaisAna.click();
        assertEquals("Ana Lucia Alexandre de Oliveira Zandomeneghi", sobreIntegrantesPage.nomeCompletoAna.getText());

        String identificadorJanelaBauxite = driver.getWindowHandle(); //salva o identificado da página de trabalhos publicados para poder voltar para ela no final do caso de teste

        //rola o card de informações pra o botao ficar visivel
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", sobreIntegrantesPage.buttonCurriculoLattesAna);
        Thread.sleep(500); //espera meio segundo para rolar o card
        sobreIntegrantesPage.buttonCurriculoLattesAna.click();
        Thread.sleep(500); //espera meio segundo para que a janela seja aberta

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); //armezena a quantidade de janelas abertas após clicar em Curriculo Lattes
        assertEquals(2, numeroFinalJanelasAbertas); //verifica se existem 2 janelas abertas
    
        driver.switchTo().window(identificadorJanelaBauxite); //retorna para a janela inicial
        
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", sobreIntegrantesPage.buttonFecharCard);//rola o card para cima ate que o botão de fechar fique visivel
        Thread.sleep(500); //espera meio segundo
        sobreIntegrantesPage.buttonFecharCard.click(); //fecha o card

        //wener miranda teixeira dos santos
        Thread.sleep(500);
        sobreIntegrantesPage.verMaisWerner.click();
        assertEquals("Wener Miranda Teixeira Dos Santos", sobreIntegrantesPage.nomeCompletoWerner.getText());

        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", sobreIntegrantesPage.buttonCurriculoLattesWerner);
        Thread.sleep(500); 
        sobreIntegrantesPage.buttonCurriculoLattesAna.click();
        Thread.sleep(500); 

        assertEquals(2, numeroFinalJanelasAbertas);

        driver.switchTo().window(identificadorJanelaBauxite);

        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", sobreIntegrantesPage.buttonFecharCard);
        Thread.sleep(500);
        sobreIntegrantesPage.buttonFecharCard.click();  
    }

    @Test
    public void TC011_deveExbirOCardDeInformacoesSobreOsColaboradoresAbrirOCurriculoLattesEFechaOCardDeInformacoes() throws InterruptedException{
        
        //luis carlos alves venancio
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 400);");
        
        Thread.sleep(500);
        sobreIntegrantesPage.verMaisLuisCarlos.click();
        assertEquals("Luis Carlos Alves Venâncio", sobreIntegrantesPage.nomeCompletoLuisCarlos.getText());

        String identificadorJanelaBauxite = driver.getWindowHandle();

        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", sobreIntegrantesPage.buttonCurriculoLattesLuisCarlos);
        Thread.sleep(500);
        sobreIntegrantesPage.buttonCurriculoLattesLuisCarlos.click();
        Thread.sleep(500); 

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); 
        assertEquals(2, numeroFinalJanelasAbertas); 
        driver.switchTo().window(identificadorJanelaBauxite);
        
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", sobreIntegrantesPage.buttonFecharCard);
        Thread.sleep(500); 
        sobreIntegrantesPage.buttonFecharCard.click(); 
 
        //jose edvar aguiar
        Thread.sleep(500);
        jsExecutor.executeScript("window.scrollTo(0, 400);");
        Thread.sleep(500);
        sobreIntegrantesPage.verMaisJoseEdvar.click();
        assertEquals("José Edvar Aguiar", sobreIntegrantesPage.nomeCompletoJoseEdvar.getText());

        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", sobreIntegrantesPage.buttonCurriculoLattesJoseEdvar);
        Thread.sleep(500);
        sobreIntegrantesPage.buttonCurriculoLattesJoseEdvar.click();
        Thread.sleep(500); 

        assertEquals(2, numeroFinalJanelasAbertas); 
        driver.switchTo().window(identificadorJanelaBauxite);
        
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", sobreIntegrantesPage.buttonFecharCard);
        Thread.sleep(500); 
        sobreIntegrantesPage.buttonFecharCard.click(); 

        //maira silva ferreira
        Thread.sleep(500);
        jsExecutor.executeScript("window.scrollTo(0, 400);");
        Thread.sleep(500);
        sobreIntegrantesPage.verMaisMairaSilva.click();
        assertEquals("Maira Silva Ferreira", sobreIntegrantesPage.nomeCompletoMairaSilva.getText());

        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", sobreIntegrantesPage.buttonFecharCard);
        Thread.sleep(500); 
        sobreIntegrantesPage.buttonFecharCard.click(); 

    }

    @Test
    public void TC012_deveExbirOCardDeInformacoesSobreOsHomenageadosEFecharOCardDeInformacoes() throws InterruptedException{

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        Thread.sleep(500);

        sobreIntegrantesPage.verMaisHelderB.click();
        assertEquals("Helder B Teixeira", sobreIntegrantesPage.nomeCompletoHelderB.getText());

        sobreIntegrantesPage.buttonFecharCard.click();
    
    }

    @Test
    public void TC013_deveAcessarAPaginaDoFormularioDeContatoEVoltarParaSobreIntegrantes() throws InterruptedException{

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        
        Thread.sleep(500);
        sobreIntegrantesPage.buttonFormulariodeContato.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/contact.php", driver.getCurrentUrl());

        sobreIntegrantesPage.buttonSobre.click();
        sobreIntegrantesPage.buttonSobreIntegrantes.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/membros.php", driver.getCurrentUrl());

    }

    
}
