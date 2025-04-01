import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class DoceriaGUI extends JFrame {
    public DoceriaGUI() {
        setTitle("Doceria Nosso Doce");
        setSize(600, 600);
        setLocation(0, 0);
        setResizable(false);
        getContentPane().setBackground(Color.lightGray);
    }

    public static void main(String[] args) {
        DoceriaGUI janela = new DoceriaGUI();
        janela.setVisible(true);
        WindowListener fechadorDeJanela = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        janela.addWindowListener(fechadorDeJanela);

    }
}
