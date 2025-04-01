import javax.swing.*;
import java.awt.*;

public class DoceriaGUIV2 extends JFrame {
    JLabel linha1 , linha2;
    ImageIcon doceImg = new ImageIcon(getClass().getResource("/imgs/doce.jpg"));
    Image imagem = doceImg.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
    ImageIcon doceRedimencionado = new ImageIcon(imagem);
    
    public DoceriaGUIV2() {
        setTitle("Doceria Nosso Doce");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setResizable(true);
        getContentPane().setBackground(Color.PINK);

        linha1 = new JLabel("Doceria Nosso Doce", JLabel.CENTER);
        linha1.setForeground(Color.BLACK);
        linha1.setFont(new Font("Cardo", Font.BOLD, 24));
        linha2 = new JLabel(doceRedimencionado, JLabel.CENTER);

        getContentPane().setLayout(new GridLayout(3, 1));
        getContentPane().add(linha1);
        getContentPane().add(linha2);
    }

    public static void main(String[] args) {
        JFrame janela = new DoceriaGUIV2();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
