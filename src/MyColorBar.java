import javax.swing.*;
import java.awt.*;

public class MyColorBar extends JToolBar {
    JButton colorbutton;
    JButton redbutton;
    JButton orangebutton;
    JButton yellowbutton;
    JButton greenbutton;
    JButton bluebutton;
    JButton cyanbutton;
    JButton magentabutton;
    JButton whitebutton;
    JButton blackbutton;

    public MyColorBar(){
        colorbutton = new JButton();
        colorbutton.setBackground(Color.black);
        colorbutton.setSize( 40, 40);


        redbutton = new JButton();
        redbutton.setBackground(Color.red);
        redbutton.setSize( 20, 20);


        orangebutton = new JButton();
        orangebutton.setBackground(Color.orange);
        orangebutton.setSize( 20, 20);


        yellowbutton = new JButton();
        yellowbutton.setBackground(Color.yellow);
        yellowbutton.setSize( 20, 20);


        greenbutton = new JButton();
        greenbutton.setBackground(Color.green);
        greenbutton.setSize( 20, 20);


        bluebutton = new JButton();
        bluebutton.setBackground(Color.blue);
        bluebutton.setSize( 20, 20);


        cyanbutton = new JButton();
        cyanbutton.setBackground(Color.cyan);
        cyanbutton.setSize( 20, 20);


        magentabutton = new JButton();
        magentabutton.setBackground(Color.magenta);
        magentabutton.setSize( 20, 20);


        whitebutton = new JButton();
        whitebutton.setBackground(Color.white);
        whitebutton.setSize( 20, 20);


        blackbutton = new JButton();
        blackbutton.setBackground(Color.black);
        blackbutton.setSize( 20, 20);

        //this.add(colorbutton);
        this.add(redbutton);
        this.add(orangebutton);
        this.add(yellowbutton);
        this.add(greenbutton);
        this.add(bluebutton);
        this.add(cyanbutton);
        this.add(magentabutton);
        this.add(whitebutton);
        this.add(blackbutton);

        this.setLayout(new FlowLayout());
    }


}
