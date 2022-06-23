import javax.swing.*;
import java.awt.*;

public class MyToolBar extends JToolBar {
    public JButton pencilButton;
    public JButton eraserButton;
    public JButton brushButton;
    public JButton strongBrushButton;
    public JButton lineButton;
    public JButton ovalButton;
    public JButton rectangleButton;
    public JButton starButton;

    MyToolBar(){
        pencilButton = new JButton(new ImageIcon("src/images/pencil.png"));
        pencilButton.setSize(new Dimension(25, 25));

        eraserButton = new JButton(new ImageIcon("src/images/eraser.png"));
        eraserButton.setSize(new Dimension(25, 25));

        brushButton = new JButton(new ImageIcon("src/images/brush.png"));
        brushButton.setSize(new Dimension(25, 25));

        strongBrushButton = new JButton(new ImageIcon("src/images/strong_brush.png"));
        strongBrushButton.setSize(new Dimension(25, 25));

        lineButton = new JButton(new ImageIcon("src/images/line.png"));
        lineButton.setSize(new Dimension(25, 25));

        ovalButton = new JButton(new ImageIcon("src/images/oval.png"));
        ovalButton.setSize(new Dimension(25, 25));

        rectangleButton = new JButton(new ImageIcon("src/images/rectangle.png"));
        rectangleButton.setSize(new Dimension(25, 25));

        starButton = new JButton(new ImageIcon("src/images/star.png"));
        starButton.setSize(new Dimension(25, 25));




        this.add(pencilButton);
        this.add(eraserButton);
        this.add(brushButton);
        this.add(strongBrushButton);
        this.add(lineButton);
        this.add(ovalButton);
        this.add(rectangleButton);
        this.add(starButton);
    }
}
