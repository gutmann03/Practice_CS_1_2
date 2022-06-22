import javax.swing.*;
import java.awt.*;

public class MyToolBar extends JToolBar {
    public JButton pencilButton;
    public JButton eraserButton;
    public JButton lineButton;
    public JButton ovalButton;
    public JButton rectangleButton;
    public JButton starButton;

    MyToolBar(){
        pencilButton = new JButton(new ImageIcon("pencil.png"));
        pencilButton.setSize(new Dimension(25, 25));

        eraserButton = new JButton(new ImageIcon("eraser.png"));
        eraserButton.setSize(new Dimension(25, 25));

        lineButton = new JButton(new ImageIcon("line.png"));
        lineButton.setSize(new Dimension(25, 25));

        ovalButton = new JButton(new ImageIcon("oval.png"));
        ovalButton.setSize(new Dimension(25, 25));

        rectangleButton = new JButton(new ImageIcon("rectangle.png"));
        rectangleButton.setSize(new Dimension(25, 25));

        starButton = new JButton(new ImageIcon("star.png"));
        starButton.setSize(new Dimension(25, 25));




        this.add(pencilButton);
        this.add(eraserButton);
        this.add(lineButton);
        this.add(ovalButton);
        this.add(rectangleButton);
        this.add(starButton);
    }
}
