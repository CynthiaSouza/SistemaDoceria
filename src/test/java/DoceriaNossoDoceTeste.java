import java.io.IOException;

public class DoceriaNossoDoceTeste {
    public static void main(String[] args) {
        try {
            DoceriaNossoDoce sistema = new DoceriaNossoDoce();

            //cadastro
            sistema.cadastraDoce("Brownie", "001", 10, "Delicioso brownie de chocolate com recheio de ninho.", 100);
            sistema.cadastraDoce("Pudim", "002", 10, "Pudim de leite condensado.", 100);

            //pesquisa
            System.out.println("Pesquisa Brownie: " + sistema.pesquisaDoce("Brownie"));

            //atualização
            sistema.atualizaDoce("Brownie", "002", 12, "Brownie com gotas de chocolate meio amargo", 150);

            //remoção
            sistema.removaDoce("Pudim", 10);

            //persistência
            sistema.salvarDados();

            //recuperação de dados
            sistema.recuperarDados();
            System.out.println("Pesquisa após recuperação: " + sistema.pesquisaDoce("Pudim"));

        } catch (IOException | DoceInexistenteException e) {
            e.printStackTrace();
        }
    }
}
