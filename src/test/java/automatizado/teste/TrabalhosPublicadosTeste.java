package automatizado.teste;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import automatizado.pageObject.Pages.TrabalhosPublicadosPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrabalhosPublicadosTeste extends Testes_testebase {

    public static TrabalhosPublicadosPO trabalhosPublicadosPage;

    @BeforeClass
    public static void prepararTestes(){
        driver.get("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=1");
        trabalhosPublicadosPage = new TrabalhosPublicadosPO(driver);
    }
    
    @Test
    public void TC001_deveMostarOpcoesDeIdiomas(){
        
        trabalhosPublicadosPage.selecionarIdiomaElement.click();

        String portugues = trabalhosPublicadosPage.idiomaPortuguesElement.getText();
        assertEquals("Português", portugues);
        String ingles = trabalhosPublicadosPage.idiomaInglesElement.getText();
        assertEquals("Inglês", ingles);

        trabalhosPublicadosPage.selecionarIdiomaElement.click();
    }

    @Test
    public void TC002_deveMostrarOpcoesDeIdiomasEDeixarAPaginaEmIngles(){

        trabalhosPublicadosPage.selecionarIdiomaElement.click();
        trabalhosPublicadosPage.idiomaInglesElement.click();

        String msgIncio = trabalhosPublicadosPage.buttonInicio.getText();
        assertEquals("Home", msgIncio);

    }

    @Test
    public void TC003_deveMostrarOpcoesDeIdiomasEDeixarAPaginaEmPortugues(){

        trabalhosPublicadosPage.selecionarIdiomaElement.click();
        trabalhosPublicadosPage.idiomaPortuguesElement.click();

        String msgIncio = trabalhosPublicadosPage.buttonInicio.getText();
        assertEquals("Início", msgIncio);


    }


    @Test
    public void TC004_deveAcessarAPáginaDeInicioAoClicarNoCampoInicioEVoltarParaTrabalhosPublicados(){

        trabalhosPublicadosPage.buttonInicio.click();
        assertEquals("https://bauxiteresidue.ufma.br/index.php", driver.getCurrentUrl());

        trabalhosPublicadosPage.buttonTrabalhosPublicados.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=1", driver.getCurrentUrl());

    }

    @Test
    public void TC005_deveClilcarNoBotaoSobreEExibirAsOpcoes() throws InterruptedException{

        trabalhosPublicadosPage.buttonSobre.click();

        String sobreNosString = trabalhosPublicadosPage.buttonSobreNos.getText();
        Thread.sleep(500);
        assertEquals("Sobre nós", sobreNosString);
        String sobreIntegrantesString = trabalhosPublicadosPage.buttonSobreIntegrantes.getText();
        assertEquals("Integrantes", sobreIntegrantesString);

        trabalhosPublicadosPage.buttonSobre.click();

    }

    @Test 
    public void TC006_deveClicarNoBotaoSobreClicarEmSobreNosAbrirAPaginaEVoltarParaTrabalhosPublicados(){

        trabalhosPublicadosPage.buttonSobre.click();
        trabalhosPublicadosPage.buttonSobreNos.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/sobre.php", driver.getCurrentUrl());
        
        trabalhosPublicadosPage.buttonTrabalhosPublicados.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=1", driver.getCurrentUrl());

    }

    @Test
    public void TC007_deveClicarNoBotaoSobreClicarEmIntegrantesAbrirAPaginaEVoltarParaTrabalhosPublicados(){

        trabalhosPublicadosPage.buttonSobre.click();
        trabalhosPublicadosPage.buttonSobreIntegrantes.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/membros.php", driver.getCurrentUrl());

        trabalhosPublicadosPage.buttonTrabalhosPublicados.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=1", driver.getCurrentUrl());

    }

    @Test
    public void TC008_deveClicarNoBotaoTrabalhosPublicadosEContinuarNaPagina(){

        trabalhosPublicadosPage.buttonTrabalhosPublicados.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=1", driver.getCurrentUrl());
    }

    @Test
    public void TC009_deveClicarNoBotaoNoticiasAbrirAPaginaEVoltarParaTrabalhosPublicados(){

        trabalhosPublicadosPage.buttonNoticias.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/noticias.php", driver.getCurrentUrl());

        trabalhosPublicadosPage.buttonTrabalhosPublicados.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=1", driver.getCurrentUrl());


    }

    @Test
    public void TC010_deveBuscarTrabalhoPorTitulo() throws InterruptedException{

        trabalhosPublicadosPage.limparCampos();
        trabalhosPublicadosPage.inputTitulo.sendKeys("producao do agregado" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        //jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);"); //rola a página inteira para baixo
        jsExecutor.executeScript("window.scrollTo(0, 400);"); //rola 0 pixels na horizontal e 400 pixels na vertical

        Thread.sleep(500);
        trabalhosPublicadosPage.buttonVerMais.click();
        
        assertEquals("RESUMO:", trabalhosPublicadosPage.textoResumo.getText());//verifica se abriu o resumo
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("", trabalhosPublicadosPage.textoResumo.getText());//verifica se fechou o resumo

        String identificadorJanelaBauxite = driver.getWindowHandle(); //salva o identificado da página de trabalhos publicados para poder voltar para ela no final do caso de teste

        trabalhosPublicadosPage.buttonAcesse.click();
        Thread.sleep(500); //espera um segundo para que a janela seja aberta

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); //armezena a quantidade de janelas abertas após clicar em Acesse
        assertEquals(2, numeroFinalJanelasAbertas); //verifica se existem 2 janelas abertas
    
        driver.switchTo().window(identificadorJanelaBauxite); //retorna para a janela inicial


    }
    
    @Test
    public void TC011_deveBuscarTrabalhoPorAutor() throws InterruptedException{

        trabalhosPublicadosPage.limparCampos();
        trabalhosPublicadosPage.inputAutor.sendKeys("souza" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();


        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 400);");
        
        Thread.sleep(500);
        trabalhosPublicadosPage.buttonVerMais.click();
        Thread.sleep(500);
        assertEquals("RESUMO:", trabalhosPublicadosPage.textoResumo.getText());
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("", trabalhosPublicadosPage.textoResumo.getText());

        String identificadorJanelaBauxite = driver.getWindowHandle(); 

        trabalhosPublicadosPage.buttonAcesse.click();
        Thread.sleep(500); 

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); 
        assertEquals(2, numeroFinalJanelasAbertas); 
    
        driver.switchTo().window(identificadorJanelaBauxite);

    }

    @Test
    public void TC012_deveBuscarTrabalhoPorPalavraChave() throws InterruptedException{

        trabalhosPublicadosPage.limparCampos();
        trabalhosPublicadosPage.inputPalavraChave.sendKeys("lama vermelha" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 400);");
        
        Thread.sleep(500);       
        trabalhosPublicadosPage.buttonVerMais.click();
        Thread.sleep(500);
        assertEquals("RESUMO:", trabalhosPublicadosPage.textoResumo.getText());
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("", trabalhosPublicadosPage.textoResumo.getText());

        String identificadorJanelaBauxite = driver.getWindowHandle(); 

        trabalhosPublicadosPage.buttonAcesse.click();
        Thread.sleep(500); 

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); 
        assertEquals(2, numeroFinalJanelasAbertas); 
    
        driver.switchTo().window(identificadorJanelaBauxite);
        

    }

    @Test
    public void TC013_deveBuscarTrabalhoPorAnoDePublicacao() throws InterruptedException{

        trabalhosPublicadosPage.limparCampos();
        trabalhosPublicadosPage.inputAnoDePublicacao.sendKeys("2022" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();
  
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 400);");
        
        Thread.sleep(500);   
        trabalhosPublicadosPage.buttonVerMais.click();
        Thread.sleep(500);
        assertEquals("RESUMO:", trabalhosPublicadosPage.textoResumo.getText());
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("", trabalhosPublicadosPage.textoResumo.getText());

        String identificadorJanelaBauxite = driver.getWindowHandle(); 

        trabalhosPublicadosPage.buttonAcesse.click();
        Thread.sleep(500); 

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); 
        assertEquals(2, numeroFinalJanelasAbertas); 
    
        driver.switchTo().window(identificadorJanelaBauxite);

 
    }

    @Test
    public void TC014_deveBuscarTrabalhoPorTituloEPorAutor() throws InterruptedException{
        
        trabalhosPublicadosPage.limparCampos();
        trabalhosPublicadosPage.inputTitulo.sendKeys("producao do agregado" + Keys.TAB);
        trabalhosPublicadosPage.inputAutor.sendKeys("souza" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 400);");
        
        Thread.sleep(500);
        trabalhosPublicadosPage.buttonVerMais.click();
        Thread.sleep(500);
        assertEquals("RESUMO:", trabalhosPublicadosPage.textoResumo.getText());
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("", trabalhosPublicadosPage.textoResumo.getText());

        String identificadorJanelaBauxite = driver.getWindowHandle(); 

        trabalhosPublicadosPage.buttonAcesse.click();
        Thread.sleep(500); 

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); 
        assertEquals(2, numeroFinalJanelasAbertas); 
    
        driver.switchTo().window(identificadorJanelaBauxite);

    }

    @Test
    public void TC015_deveBuscarTrabalhoPorTituloEPalavraChave() throws InterruptedException{

        trabalhosPublicadosPage.limparCampos();
        trabalhosPublicadosPage.inputTitulo.sendKeys("producao do agregado" + Keys.TAB);
        trabalhosPublicadosPage.inputPalavraChave.sendKeys("lama vermelha" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 400);");
        
        Thread.sleep(500);
        trabalhosPublicadosPage.buttonVerMais.click();
        Thread.sleep(500);
        assertEquals("RESUMO:", trabalhosPublicadosPage.textoResumo.getText());
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("", trabalhosPublicadosPage.textoResumo.getText());

        String identificadorJanelaBauxite = driver.getWindowHandle(); 

        trabalhosPublicadosPage.buttonAcesse.click();
        Thread.sleep(500); 

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); 
        assertEquals(2, numeroFinalJanelasAbertas); 
    
        driver.switchTo().window(identificadorJanelaBauxite);

    }

    @Test
    public void TC016_deveBuscarTrabalhoPorTituloEAnoDePublicacao() throws InterruptedException{

        trabalhosPublicadosPage.limparCampos();
        trabalhosPublicadosPage.inputTitulo.sendKeys("producao do agregado" + Keys.TAB);
        trabalhosPublicadosPage.inputAnoDePublicacao.sendKeys("2022" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 400);");
        
        Thread.sleep(500);
        trabalhosPublicadosPage.buttonVerMais.click();
        Thread.sleep(500);
        assertEquals("RESUMO:", trabalhosPublicadosPage.textoResumo.getText());
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("", trabalhosPublicadosPage.textoResumo.getText());

        String identificadorJanelaBauxite = driver.getWindowHandle(); 

        trabalhosPublicadosPage.buttonAcesse.click();
        Thread.sleep(500);

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); 
        assertEquals(2, numeroFinalJanelasAbertas); 
    
        driver.switchTo().window(identificadorJanelaBauxite);

    }

    @Test
    public void TC017_deveBuscarTrabalhoPorAutorEPalavraChave() throws InterruptedException{
        
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 0);");

        trabalhosPublicadosPage.limparCampos();
        trabalhosPublicadosPage.inputAutor.sendKeys("souza" + Keys.TAB);
        trabalhosPublicadosPage.inputPalavraChave.sendKeys("lama vermelha" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        jsExecutor.executeScript("window.scrollTo(0, 400);");
        
        Thread.sleep(500);
        trabalhosPublicadosPage.buttonVerMais.click();
        Thread.sleep(500);
        assertEquals("RESUMO:", trabalhosPublicadosPage.textoResumo.getText());
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("", trabalhosPublicadosPage.textoResumo.getText());

        String identificadorJanelaBauxite = driver.getWindowHandle(); 

        trabalhosPublicadosPage.buttonAcesse.click();
        Thread.sleep(500); 

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); 
        assertEquals(2, numeroFinalJanelasAbertas); 
    
        driver.switchTo().window(identificadorJanelaBauxite);

    }

    @Test
    public void TC018_deveBuscarTrabalhoPorAutorEAnoDePublicacao() throws InterruptedException{

        trabalhosPublicadosPage.limparCampos();
        trabalhosPublicadosPage.inputAutor.sendKeys("souza" + Keys.TAB);
        trabalhosPublicadosPage.inputAnoDePublicacao.sendKeys("2022" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 400);");
        
        Thread.sleep(500);
        trabalhosPublicadosPage.buttonVerMais.click();
        Thread.sleep(500);
        assertEquals("RESUMO:", trabalhosPublicadosPage.textoResumo.getText());
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("", trabalhosPublicadosPage.textoResumo.getText());

        String identificadorJanelaBauxite = driver.getWindowHandle(); 

        trabalhosPublicadosPage.buttonAcesse.click();
        Thread.sleep(500); 

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); 
        assertEquals(2, numeroFinalJanelasAbertas); 
    
        driver.switchTo().window(identificadorJanelaBauxite);

    }

    @Test
    public void TC019_deveBuscarTrabalhoPorPalavraChaveEAnoDePublicacao() throws InterruptedException{

        trabalhosPublicadosPage.limparCampos();
        trabalhosPublicadosPage.inputPalavraChave.sendKeys("lama vermelha" + Keys.TAB);
        trabalhosPublicadosPage.inputAnoDePublicacao.sendKeys("2022" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 400);");
        
        Thread.sleep(500);
        trabalhosPublicadosPage.buttonVerMais.click();
        Thread.sleep(500);
        assertEquals("RESUMO:", trabalhosPublicadosPage.textoResumo.getText());
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("", trabalhosPublicadosPage.textoResumo.getText());

        String identificadorJanelaBauxite = driver.getWindowHandle(); 

        trabalhosPublicadosPage.buttonAcesse.click();
        Thread.sleep(500); 

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); 
        assertEquals(2, numeroFinalJanelasAbertas); 
    
        driver.switchTo().window(identificadorJanelaBauxite);

    }

    @Test
    public void TC020_deveBuscarTrabalhoPorTituloAutorEPalavraChave() throws InterruptedException{

        trabalhosPublicadosPage.limparCampos();
        trabalhosPublicadosPage.inputTitulo.sendKeys("producao do agregado" + Keys.TAB);
        trabalhosPublicadosPage.inputAutor.sendKeys("souza" + Keys.TAB);
        trabalhosPublicadosPage.inputPalavraChave.sendKeys("lama vermelha" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 400);");
        
        Thread.sleep(500);
        trabalhosPublicadosPage.buttonVerMais.click();
        Thread.sleep(500);
        assertEquals("RESUMO:", trabalhosPublicadosPage.textoResumo.getText());
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("", trabalhosPublicadosPage.textoResumo.getText());

        String identificadorJanelaBauxite = driver.getWindowHandle(); 

        trabalhosPublicadosPage.buttonAcesse.click();
        Thread.sleep(500); 

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); 
        assertEquals(2, numeroFinalJanelasAbertas); 
    
        driver.switchTo().window(identificadorJanelaBauxite);


    }

    @Test
    public void TC021_deveBuscarTrabalhoPorTituloAutorEAnoDePublicacao() throws InterruptedException{

        trabalhosPublicadosPage.limparCampos();
        trabalhosPublicadosPage.inputTitulo.sendKeys("producao do agregado" + Keys.TAB);
        trabalhosPublicadosPage.inputAutor.sendKeys("souza" + Keys.TAB);
        trabalhosPublicadosPage.inputAnoDePublicacao.sendKeys("2022" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 400);");
        
        Thread.sleep(500);
        trabalhosPublicadosPage.buttonVerMais.click();
        Thread.sleep(500);
        assertEquals("RESUMO:", trabalhosPublicadosPage.textoResumo.getText());
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("", trabalhosPublicadosPage.textoResumo.getText());

        String identificadorJanelaBauxite = driver.getWindowHandle(); 

        trabalhosPublicadosPage.buttonAcesse.click();
        Thread.sleep(500); 

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); 
        assertEquals(2, numeroFinalJanelasAbertas); 
    
        driver.switchTo().window(identificadorJanelaBauxite);

    }

    @Test
    public void TC022_deveBuscarTrabalhoPorTituloPalavraChaveEAnoDePublicacao() throws InterruptedException{

        trabalhosPublicadosPage.limparCampos();
        trabalhosPublicadosPage.inputTitulo.sendKeys("producao do agregado" + Keys.TAB);
        trabalhosPublicadosPage.inputPalavraChave.sendKeys("lama vermelha" + Keys.TAB);
        trabalhosPublicadosPage.inputAnoDePublicacao.sendKeys("2022" + Keys.TAB);
        trabalhosPublicadosPage.buttonPesquisar.click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 400);");
        
        Thread.sleep(500);
        trabalhosPublicadosPage.buttonVerMais.click();
        Thread.sleep(500);
        assertEquals("RESUMO:", trabalhosPublicadosPage.textoResumo.getText());
        trabalhosPublicadosPage.buttonVerMais.click();
        assertEquals("", trabalhosPublicadosPage.textoResumo.getText());

        String identificadorJanelaBauxite = driver.getWindowHandle(); 

        trabalhosPublicadosPage.buttonAcesse.click();
        Thread.sleep(500); 

        int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); 
        assertEquals(2, numeroFinalJanelasAbertas); 
    
        driver.switchTo().window(identificadorJanelaBauxite);

    }

    @Test
    public void TC023_deveNavegarEntreOsBotõesDePaginação() throws InterruptedException{

        trabalhosPublicadosPage.buttonTrabalhosPublicados.click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        
        //Clica no botão de paginação 1 e verifica se está na página correspondente
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(500);
        trabalhosPublicadosPage.button1Pagination.click();
        Thread.sleep(500);
        assertEquals("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=1&titulo=&autor=&palavra_chave=&ano_publicacao=", driver.getCurrentUrl());

        //Clica no botão de paginação 2 e verifica se está na página correspondente
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(500);
        trabalhosPublicadosPage.button2Pagination.click();
        Thread.sleep(500);
        assertEquals("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=2&titulo=&autor=&palavra_chave=&ano_publicacao=", driver.getCurrentUrl());

        //Clica no botão de paginação 3 e verifica se está na página correspondente
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(500);
        trabalhosPublicadosPage.button3Pagination.click();
        Thread.sleep(500);
        assertEquals("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=3&titulo=&autor=&palavra_chave=&ano_publicacao=", driver.getCurrentUrl());

        //Clica no botão de paginação 4 e verifica se está na página correspondente
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(500);
        trabalhosPublicadosPage.button4Pagination.click();
        Thread.sleep(500);
        assertEquals("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=4&titulo=&autor=&palavra_chave=&ano_publicacao=", driver.getCurrentUrl());

        //Clica no botão de paginação 5 e verifica se está na página correspondente
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(500);
        trabalhosPublicadosPage.button5Pagination.click();
        Thread.sleep(500);
        assertEquals("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=5&titulo=&autor=&palavra_chave=&ano_publicacao=", driver.getCurrentUrl());

        //Clica no botão de paginação 6 e verifica se está na página correspondente
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(500);
        trabalhosPublicadosPage.button6Pagination.click();
        Thread.sleep(500);
        assertEquals("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=6&titulo=&autor=&palavra_chave=&ano_publicacao=", driver.getCurrentUrl());

        //Clica no botão de paginação 7 e verifica se está na página correspondente
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(500);
        trabalhosPublicadosPage.button7Pagination.click();
        Thread.sleep(500);
        assertEquals("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=7&titulo=&autor=&palavra_chave=&ano_publicacao=", driver.getCurrentUrl());

        //Clica no botão de paginação 8 e verifica se está na página correspondente
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(500);
        trabalhosPublicadosPage.button8Pagination.click();
        Thread.sleep(500);
        assertEquals("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=8&titulo=&autor=&palavra_chave=&ano_publicacao=", driver.getCurrentUrl());

        //Clica no botão de paginação 9 e verifica se está na página correspondente
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(500);
        trabalhosPublicadosPage.button9Pagination.click();
        Thread.sleep(500);
        assertEquals("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=9&titulo=&autor=&palavra_chave=&ano_publicacao=", driver.getCurrentUrl());

        //Clica no botão de paginação 10 e verifica se está na página correspondente
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(500);
        trabalhosPublicadosPage.button10Pagination.click();
        Thread.sleep(500);
        assertEquals("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=10&titulo=&autor=&palavra_chave=&ano_publicacao=", driver.getCurrentUrl());

        //Clica no botão de paginação 11 e verifica se está na página correspondente
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(500);
        trabalhosPublicadosPage.button11Pagination.click();
        Thread.sleep(500);
        assertEquals("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=11&titulo=&autor=&palavra_chave=&ano_publicacao=", driver.getCurrentUrl());

    }

    @Test
    public void TC024_deveAcessarAPaginaDoFormularioDeContatoEVoltarParaTrabalhosPublicados() throws InterruptedException{

        trabalhosPublicadosPage.limparCampos();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        
        Thread.sleep(500);
        trabalhosPublicadosPage.buttonFormulariodeContato.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/contact.php", driver.getCurrentUrl());

        trabalhosPublicadosPage.buttonTrabalhosPublicadosFormdeContato.click();
        assertEquals("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=1", driver.getCurrentUrl());

    }


}



