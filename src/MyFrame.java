import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    public JPanel upperPanel;
    public JPanel mainPanel;

    public MyToolBar tb = new MyToolBar();

    private State state;

    MyFrame(){
        state = State.DO_NOTHING;
        this.setTitle("Graphical editor");
        this.setTitle("Graphical editor");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLayout(null);

        ImageIcon image = new ImageIcon("icon.png");
        this.setIconImage(image.getImage());

        tb.pencilButton.addActionListener(this);
        tb.eraserButton.addActionListener(this);
        tb.lineButton.addActionListener(this);
        tb.ovalButton.addActionListener(this);
        tb.rectangleButton.addActionListener(this);
        tb.starButton.addActionListener(this);

        // setting upper panel
        upperPanel = new JPanel();
        upperPanel.setBounds(0, 0, this.getWidth(), 40);
        upperPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        upperPanel.add(tb);
        this.add(upperPanel);

        // setting main panel
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.blue);
        mainPanel.setBounds(0, 40, this.getWidth(), this.getHeight() - 20);
        this.add(mainPanel);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (tb.pencilButton == e.getSource()) {
            state = State.USE_PENCIL;
        } else if (tb.eraserButton == e.getSource()){
            state = State.USE_ERASER;
        } else if (tb.lineButton == e.getSource()){
            state = State.MAKE_LINE;
        } else if (tb.ovalButton == e.getSource()){
            state = State.MAKE_OVAL;
        } else if (tb.rectangleButton == e.getSource()){
            state = State.MAKE_RECTANGLE;
        } else if (tb.starButton == e.getSource()){
            state = State.MAKE_STAR;
        }

        System.out.println(state);
    }
}
