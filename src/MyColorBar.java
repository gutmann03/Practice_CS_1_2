import javax.swing.*;
import java.awt.*;

public class MyColorBar extends JToolBar {
    JButton colorButton;
    JButton redButton;
    JButton orangeButton;
    JButton yellowButton;
    JButton greenButton;
    JButton blueButton;
    JButton cyanButton;
    JButton magentaButton;
    JButton whiteButton;
    JButton blackButton;

    public MyColorBar(){
        colorButton = new JButton();
        colorButton.setBackground(Color.black);
        colorButton.setSize( 40, 40);


        redButton = new JButton();
        redButton.setBackground(Color.red);
        redButton.setSize( 20, 20);


        orangeButton = new JButton();
        orangeButton.setBackground(Color.orange);
        orangeButton.setSize( 20, 20);


        yellowButton = new JButton();
        yellowButton.setBackground(Color.yellow);
        yellowButton.setSize( 20, 20);


        greenButton = new JButton();
        greenButton.setBackground(Color.green);
        greenButton.setSize( 20, 20);


        blueButton = new JButton();
        blueButton.setBackground(Color.blue);
        blueButton.setSize( 20, 20);


        cyanButton = new JButton();
        cyanButton.setBackground(Color.cyan);
        cyanButton.setSize( 20, 20);


        magentaButton = new JButton();
        magentaButton.setBackground(Color.magenta);
        magentaButton.setSize( 20, 20);


        whiteButton = new JButton();
        whiteButton.setBackground(Color.white);
        whiteButton.setSize( 20, 20);


        blackButton = new JButton();
        blackButton.setBackground(Color.black);
        blackButton.setSize( 20, 20);

        //this.add(colorbutton);
        this.add(redButton);
        this.add(orangeButton);
        this.add(yellowButton);
        this.add(greenButton);
        this.add(blueButton);
        this.add(cyanButton);
        this.add(magentaButton);
        this.add(whiteButton);
        this.add(blackButton);

        this.setLayout(new FlowLayout());
    }


}
