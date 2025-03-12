import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeDados {
    private static final String ARQUIVO = "doceria.dat";
    private static ObjectOutputStream oss;

    public static void salvarDados(Map<String, Estoque> dados) throws IOException {
        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
            oss.writeObject(dados);
        }
    }

    public static Map<String, Estoque> carregarDados() throws IOException {
        File arquivo = new File(ARQUIVO);
        if (!arquivo.exists()) {
            return new HashMap<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
            return (Map<String, Estoque>) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException("Erro ao ler dados", e);
        }
    }
}
