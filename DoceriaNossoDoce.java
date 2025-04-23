import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class DoceriaNossoDoce implements Doceria {
    private Map<String, Estoque> doces;

    public DoceriaNossoDoce() throws IOException {
        this.doces = GravadorDeDados.carregarDados();
    }


    @Override
    public boolean cadastraDoce(String nome, String codigo, int preco, String descricao, int quantidade) {
        if (doces.containsKey(nome)) {
            return false;
        }
        doces.put(nome, new Estoque(nome, codigo, preco, descricao, quantidade));
        return true;
    }

    // Sem Streams
//    @Override
//    public Collection<Estoque> pesquisaDoce(String nome) {
//        List<Estoque> pesquisados = new ArrayList<>();
//        for (Estoque doce : doces.values()) {
//            if (doce.getNome().equalsIgnoreCase(nome)) {
//                pesquisados.add(doce);
//            }
//        }
//        return pesquisados;
//    }

    // Com Streams
    @Override
    public Collection<Estoque> pesquisaDoce(String nome) {
        return doces.values().stream()
                .filter(doce -> doce.getNome().equalsIgnoreCase(nome))
                .collect(Collectors.toList());
    }

    @Override
    public boolean atualizaDoce(String nome, String codigo, int preco, String descricao, int quantidade) {
        if (!doces.containsKey(nome)) {
            return false;
        }
        Estoque doce = doces.get(nome);
        doce.setCodigo(codigo);
        doce.setPreco(preco);
        doce.setDescricao(descricao);
        doce.setQuantidade(quantidade);
        return true;
    }

    @Override
    public boolean removaDoce(String nome, int preco) throws DoceInexistenteException {
        if (!doces.containsKey(nome)) {
            throw new DoceInexistenteException("Doce não encontrado");
        }
        doces.remove(nome);
        return true;
    }

    @Override
    public void salvarDados() throws IOException {
        GravadorDeDados.salvarDados(doces);
    }

    @Override
    public void recuperarDados() throws IOException {
        this.doces = GravadorDeDados.carregarDados();
    }
}
