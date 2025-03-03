import java.io.IOException;
import java.util.Collection;

public interface Doceria {
    public boolean cadastraDoce(String nome,String codigo ,int preco, String descricao, int quantidade);
    public Collection<Estoque> pesquisaDoce(String nome);
    boolean atualizaDoce(String nome, String codigo, int preco, String descricao, int quantidade);
    public boolean removaDoce(String nome, int preco) throws DoceInexistenteException;
    public void salvarDados() throws IOException;
    public void recuperarDados() throws IOException;
}
