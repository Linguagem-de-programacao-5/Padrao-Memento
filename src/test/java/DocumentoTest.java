import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DocumentoTest {

    @Test
    void deveArmazenarVersoes(){
        Documento documento = new Documento();
        HistoricoVersao versao1 = new HistoricoVersao("v1");
        HistoricoVersao versao2 = new HistoricoVersao("v2");
        documento.setVersao(versao1);
        documento.setVersao(versao2);
        assertEquals(2, documento.getVersoes().size());
    }

    @Test
    void deveRetornarVersaoInicial(){
        Documento documento = new Documento();
        HistoricoVersao versao1 = new HistoricoVersao("v1");
        HistoricoVersao versao2 = new HistoricoVersao("v2");
        documento.setVersao(versao1);
        documento.setVersao(versao2);
        documento.restauraVersao(0);
        assertEquals("v1", documento.getVersao().getVersao());
    }

    @Test
    void deveRetornarVersaoAnterior(){
        Documento documento = new Documento();
        HistoricoVersao versao1 = new HistoricoVersao("v1");
        HistoricoVersao versao2 = new HistoricoVersao("v2");
        HistoricoVersao versao3 = new HistoricoVersao("v3");
        documento.setVersao(versao1);
        documento.setVersao(versao2);
        documento.setVersao(versao1);
        documento.setVersao(versao3);
        documento.restauraVersao(0);
        assertEquals("v1", documento.getVersao().getVersao());
    }

    @Test
    void deveRetornarExcecaoIndiceIvalido() {
        try {
            Documento documento = new Documento();
            documento.restauraVersao(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Índice inválido", e.getMessage());
        }
    }
}