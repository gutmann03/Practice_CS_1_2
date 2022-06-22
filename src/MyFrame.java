import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public JPanel upperPanel;
    public JPanel leftPanel;
    public JPanel mainPanel;

    private State state;

    MyFrame(){
        state = State.DO_NOTHING;
        this.setTitle("Graphical editor");
        this.setTitle("Graphical editor");
        this.setSize(1000, 700);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLayout(null);

        ImageIcon image = new ImageIcon("images/icon.png");
        this.setIconImage(image.getImage());

        this.upperPanel = new JPanel();
        this.upperPanel.setBackground(Color.black);
        this.upperPanel.setBounds(0, 0, this.getWidth(), 20);
        this.add(this.upperPanel);

        this.leftPanel = new JPanel();
        this.leftPanel.setBackground(Color.red);
        this.leftPanel.setBounds(0, 20, 30, this.getHeight() - 20);
        this.add(this.leftPanel);

        this.mainPanel = new JPanel();
        this.mainPanel.setBackground(Color.blue);
        this.mainPanel.setBounds(30, 20, this.getWidth() - 30, this.getHeight() - 20);
        this.add(this.mainPanel);
    }
}
