package automatizado.teste;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.JavascriptExecutor;

import automatizado.pageObject.Pages.NoticiasPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NoticiasTeste extends Testes_testebase {

  public static NoticiasPO noticiasPage;

  @BeforeClass
  public static void prepararTestes() {
    driver.get("https://bauxiteresidue.ufma.br/pages/noticias.php");
    noticiasPage = new NoticiasPO(driver);
  }

  @Test
  public void TC001_deveMostarOpcoesDeIdiomas() {

    noticiasPage.selecionarIdiomaElement.click();

    String portugues = noticiasPage.idiomaPortuguesElement.getText();
    assertEquals("Português", portugues);
    String ingles = noticiasPage.idiomaInglesElement.getText();
    assertEquals("Inglês", ingles);

    noticiasPage.selecionarIdiomaElement.click();
  }

  @Test
  public void TC002_deveMostrarOpcoesDeIdiomasEDeixarAPaginaEmIngles() {

    noticiasPage.selecionarIdiomaElement.click();
    noticiasPage.idiomaInglesElement.click();

    String msgIncio = noticiasPage.buttonInicio.getText();
    assertEquals("Home", msgIncio);

  }

  @Test
  public void TC003_deveMostrarOpcoesDeIdiomasEDeixarAPaginaEmPortugues() {

    noticiasPage.selecionarIdiomaElement.click();
    noticiasPage.idiomaPortuguesElement.click();

    String msgIncio = noticiasPage.buttonInicio.getText();
    assertEquals("Início", msgIncio);

  }

  @Test
  public void TC004_deveAcessarAPáginaDeInicioAoClicarNoCampoInicioEVoltarParaNoticias() {

    noticiasPage.buttonInicio.click();
    assertEquals("https://bauxiteresidue.ufma.br/index.php", driver.getCurrentUrl());

    noticiasPage.buttonNoticias.click();
    assertEquals("https://bauxiteresidue.ufma.br/pages/noticias.php", driver.getCurrentUrl());

  }

  @Test
  public void TC005_deveClicarNoBotaoSobreEExibirAsOpcoes() {

    noticiasPage.buttonSobre.click();

    String sobreNosString = noticiasPage.buttonSobreNos.getText();
    assertEquals("Sobre nós", sobreNosString);
    String sobreIntegrantesString = noticiasPage.buttonSobreIntegrantes.getText();
    assertEquals("Integrantes", sobreIntegrantesString);

    noticiasPage.buttonSobre.click();

  }

  @Test
  public void TC006_deveClicarNoBotaoSobreClicarEmSobreNosEVoltarParaNoticias() {

    noticiasPage.buttonSobre.click();
    noticiasPage.buttonSobreNos.click();
    assertEquals("https://bauxiteresidue.ufma.br/pages/sobre.php", driver.getCurrentUrl());

    noticiasPage.buttonNoticias.click();
    assertEquals("https://bauxiteresidue.ufma.br/pages/noticias.php", driver.getCurrentUrl());

  }

  @Test
  public void TC007_deveClicarNoBotaoSobreClicarEmIntegrantesAbrirAPaginaEVoltarParaNoticias() {

    noticiasPage.buttonSobre.click();
    noticiasPage.buttonSobreIntegrantes.click();
    assertEquals("https://bauxiteresidue.ufma.br/pages/membros.php", driver.getCurrentUrl());

    noticiasPage.buttonNoticias.click();
    assertEquals("https://bauxiteresidue.ufma.br/pages/noticias.php", driver.getCurrentUrl());

  }

  @Test
  public void TC008_deveClicarNoBotaoTrabalhosPublicadosAbrirAPaginaEVoltarParaNoticias() {

    noticiasPage.buttonTrabalhosPublicados.click();
    assertEquals("https://bauxiteresidue.ufma.br/pages/trabalhos.php?page=1", driver.getCurrentUrl());

    noticiasPage.buttonNoticias.click();
    assertEquals("https://bauxiteresidue.ufma.br/pages/noticias.php", driver.getCurrentUrl());

  }

  @Test
  public void TC09_deveClicarNoBotaoNoticiasAbrirAPaginaEVoltarParaNoticias() {

    noticiasPage.buttonNoticias.click();
    assertEquals("https://bauxiteresidue.ufma.br/pages/noticias.php", driver.getCurrentUrl());

    noticiasPage.buttonNoticias.click();
    assertEquals("https://bauxiteresidue.ufma.br/pages/noticias.php", driver.getCurrentUrl());

  }

  @Test
  public void TC010_deveAcessarAPaginaDoFormularioDeContatoEVoltarParaNoticias() throws InterruptedException {

    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

    Thread.sleep(1000);
    noticiasPage.buttonFormulariodeContato.click();
    assertEquals("https://bauxiteresidue.ufma.br/pages/contact.php", driver.getCurrentUrl());

    noticiasPage.buttonNoticiasFormContato.click();
    assertEquals("https://bauxiteresidue.ufma.br/pages/noticias.php", driver.getCurrentUrl());

  }

  @Test
  public void TC011_deveExbirUmaPaginaDetalhadaDaNoticiaAoClicarEmAcessar() {

    noticiasPage.buttonAcessarNoticia.click();
    assertEquals("https://bauxiteresidue.ufma.br/pages/news_detailed.php?id=1", driver.getCurrentUrl());
  }

  @Test
  public void TC012_deveExibirUmLinkDeRedirecionamentoParaAPaginaOriginalDaNoticia() throws InterruptedException {

    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

    Thread.sleep(500);
    assertEquals("Ver notícia completa.", noticiasPage.buttonVerNoticiaCompleta.getText());

  }

  @Test
  public void TC013_deveAbrirUmaNovaJanelaAoClicarNoBotaoDeExibirANoticiaCompleta() throws InterruptedException {

    String identificadorJanelaBauxite = driver.getWindowHandle(); // identificador da janela

    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

    Thread.sleep(1000);
    noticiasPage.buttonVerNoticiaCompleta.click();
    Thread.sleep(1000);

    int numeroFinalJanelasAbertas = driver.getWindowHandles().size(); // armezena a quantidade de janelas abertas após
                                                                      // clicar em Acesse
    assertEquals(2, numeroFinalJanelasAbertas); // verifica se existem 2 janelas abertas

    driver.switchTo().window(identificadorJanelaBauxite); // retorna para a janela inicial

  }

  @Test
  public void TC014_deveVoltarParaAPaginaPrincipalDeNoticiasAoClicarNaSetaParaEsquerdaNoCardDetalhadoDaNoticia()
      throws InterruptedException {

    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    jsExecutor.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

    Thread.sleep(500);
    noticiasPage.buttonSetaEsquerda.click();
    assertEquals("https://bauxiteresidue.ufma.br/pages/noticias.php", driver.getCurrentUrl());

  }

  @Test
  public void TC015_deveNavegarEntreOsBotoesDePaginacao() throws InterruptedException {

    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

    Thread.sleep(500);
    noticiasPage.button2Pagination.click();
    assertEquals("https://bauxiteresidue.ufma.br/pages/noticias.php?page=2", driver.getCurrentUrl());

    jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    
    Thread.sleep(500);
    noticiasPage.button1Pagination.click();
    assertEquals("https://bauxiteresidue.ufma.br/pages/noticias.php?page=1", driver.getCurrentUrl());

  }

}
