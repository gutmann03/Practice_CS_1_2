import javax.swing.*;
import java.awt.*;

public class MyToolBar extends JToolBar {
    public JButton nothingButton;
    public JButton pencilButton;
    public JButton eraserButton;
    public JButton brushButton;
    public JButton strongBrushButton;
    public JButton lineButton;
    public JButton ovalButton;
    public JButton rectangleButton;
    public JButton starButton;
    public JButton archButton;
    public JButton roundRectButton;
    public JButton triangleButton;

    MyToolBar(){
        nothingButton = new JButton(new ImageIcon("src/images/cursor.png"));
        nothingButton.setSize(new Dimension(25, 25));

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

        archButton = new JButton(new ImageIcon("src/images/h_circle.png"));
        archButton.setSize(new Dimension(25, 25));

        roundRectButton = new JButton(new ImageIcon("src/images/r_rect.png"));
        roundRectButton.setSize(new Dimension(25, 25));

        triangleButton = new JButton(new ImageIcon("src/images/triangle.png"));
        triangleButton.setSize(new Dimension(25, 25));

        this.add(nothingButton);
        this.add(pencilButton);
        this.add(eraserButton);
        this.add(brushButton);
        this.add(strongBrushButton);
        this.add(lineButton);
        this.add(ovalButton);
        this.add(rectangleButton);
        this.add(starButton);
        this.add(archButton);
        this.add(roundRectButton);
        this.add(triangleButton);
    }
}
