import java.util.ArrayList;
import java.util.List;

public class Documento {
    private String conteudo;
    private HistoricoVersao versao;
    private List<HistoricoVersao> memento = new ArrayList<HistoricoVersao>();


    public HistoricoVersao getVersao() {
        return this.versao;
    }

    public void setVersao(HistoricoVersao versao) {
        this.versao = versao;
        this.memento.add(this.versao);
    }

    public void restauraVersao(int indice) {
        if (indice < 0 || indice > this.memento.size() - 1) {
            throw new IllegalArgumentException("Índice inválido");
        }
        this.versao = this.memento.get(indice);
    }

    public List<HistoricoVersao> getVersoes(){
        return this.memento;
    }
}
