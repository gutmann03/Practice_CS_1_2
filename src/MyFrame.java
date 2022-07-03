import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyFrame extends JFrame implements ActionListener {
    private final int MAX_WIDTH = 900, MAX_HEIGHT = 700;

    String fileName;
    public JPanel upperPanel;
    public MyPanel mainPanel;

    public JMenuBar mb = new JMenuBar();
    public JMenu fileMenu = new JMenu("File");
    public JMenuItem openItem = new JMenuItem("Open", new ImageIcon("src/images/open.png"));
    public JMenuItem saveItem = new JMenuItem("Save", new ImageIcon("src/images/save.png"));
    public JMenuItem saveAsItem = new JMenuItem("Save as...", new ImageIcon("src/images/save.png"));
    public JMenuItem exitItem = new JMenuItem("Exit", new ImageIcon("src/images/exit.png"));

    public JButton cleanButton;
    public JCheckBox isFilled;
    public MyComboBox comboBox = new MyComboBox();

    public MyToolBar tb = new MyToolBar();
    public MyColorBar cb = new MyColorBar();

    MyFrame(){
        this.setTitle("Graphical editor");
        this.setMinimumSize(new Dimension(MAX_WIDTH, MAX_HEIGHT));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setMinimumSize(new Dimension(1020, 760));
        this.setLayout(null);
        ImageIcon frameImage = new ImageIcon("src/images/icon.png");
        this.setIconImage(frameImage.getImage());

        openItem.addActionListener(this);
        saveAsItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.add(exitItem);
        mb.add(fileMenu);
        this.setJMenuBar(mb);

        tb.nothingButton.addActionListener(this);
        tb.pencilButton.addActionListener(this);
        tb.eraserButton.addActionListener(this);
        tb.brushButton.addActionListener(this);
        tb.strongBrushButton.addActionListener(this);
        tb.lineButton.addActionListener(this);
        tb.ovalButton.addActionListener(this);
        tb.rectangleButton.addActionListener(this);
        tb.starButton.addActionListener(this);
        tb.archButton.addActionListener(this);
        tb.roundRectButton.addActionListener(this);
        tb.triangleButton.addActionListener(this);

        cb.colorButton.addActionListener(this);
        cb.blackButton.addActionListener(this);
        cb.yellowButton.addActionListener(this);
        cb.magentaButton.addActionListener(this);
        cb.orangeButton.addActionListener(this);
        cb.redButton.addActionListener(this);
        cb.whiteButton.addActionListener(this);
        cb.cyanButton.addActionListener(this);
        cb.greenButton.addActionListener(this);
        cb.blueButton.addActionListener(this);

        // setting upper panel
        upperPanel = new JPanel();
        upperPanel.setBounds(0, 0, MAX_WIDTH, 40);
        upperPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        upperPanel.add(tb);
        upperPanel.add(cb.colorButton);
        upperPanel.add(cb);
        isFilled = new JCheckBox("make filled");
        isFilled.addActionListener(this);
        upperPanel.add(isFilled);
        comboBox.addActionListener(this);
        upperPanel.add(comboBox);
        cleanButton = new JButton("CLEAN!");
        cleanButton.addActionListener(this);
        upperPanel.add(cleanButton);
        this.add(BorderLayout.NORTH, upperPanel);

        // setting main panel
        mainPanel = new MyPanel();
        mainPanel.setLocation(0, 40);
        Container ControlHost = this.getContentPane();
        JScrollPane scroll = new JScrollPane(mainPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        ControlHost.add(scroll);
        scroll.setBounds(0, 40, MAX_WIDTH - 20, MAX_HEIGHT - 100);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(tb.nothingButton == e.getSource()){
            mainPanel.state = State.DO_NOTHING;
        }else if(tb.pencilButton == e.getSource()){
            mainPanel.state = State.USE_PENCIL;
        }else if(tb.eraserButton == e.getSource()){
            mainPanel.state = State.USE_ERASER;
        }else if(tb.brushButton == e.getSource()){
            mainPanel.state = State.USE_BRUSH;
        }else if(tb.strongBrushButton == e.getSource()){
            mainPanel.state = State.USE_STRONG_BRUSH;
        }else if(tb.lineButton == e.getSource()){
            mainPanel.state = State.MAKE_LINE;
        }else if(tb.ovalButton == e.getSource()){
            mainPanel.state = State.MAKE_OVAL;
        }else if(tb.rectangleButton == e.getSource()){
            mainPanel.state = State.MAKE_RECTANGLE;
        }else if(tb.starButton == e.getSource()){
            mainPanel.state = State.MAKE_STAR;
        }else if(tb.archButton == e.getSource()){
            mainPanel.state = State.MAKE_ARCH;
        }else if(tb.roundRectButton == e.getSource()){
            mainPanel.state = State.MAKE_ROUND_RECT;
        }else if(tb.triangleButton == e.getSource()){
            mainPanel.state = State.MAKE_TRIANGLE;
        }

        if(cb.whiteButton == e.getSource()){
            mainPanel.mainColor = Color.white;
            cb.colorButton.setBackground(Color.white);
        }else if(cb.blackButton == e.getSource()){
            mainPanel.mainColor = Color.black;
            cb.colorButton.setBackground(Color.black);
        }else if(cb.blueButton == e.getSource()){
            mainPanel.mainColor = Color.blue;
            cb.colorButton.setBackground(Color.blue);
        }else if(cb.cyanButton == e.getSource()){
            mainPanel.mainColor = Color.cyan;
            cb.colorButton.setBackground(Color.cyan);
        }else if(cb.redButton == e.getSource()){
            mainPanel.mainColor = Color.red;
            cb.colorButton.setBackground(Color.red);
        }else if(cb.yellowButton == e.getSource()){
            mainPanel.mainColor = Color.yellow;
            cb.colorButton.setBackground(Color.yellow);
        }else if(cb.orangeButton == e.getSource()){
            mainPanel.mainColor = Color.orange;
            cb.colorButton.setBackground(Color.orange);
        }else if(cb.magentaButton == e.getSource()){
            mainPanel.mainColor = Color.magenta;
            cb.colorButton.setBackground(Color.magenta);
        }else if(cb.greenButton == e.getSource()){
            mainPanel.mainColor = Color.green;
            cb.colorButton.setBackground(Color.green);
        }

        mainPanel.isFilled = isFilled.isSelected();
        mainPanel.size = comboBox.getSelectedIndex() + 1;

        if(cleanButton == e.getSource()){
            mainPanel.image = new BufferedImage(3200, 3200, BufferedImage.TYPE_INT_RGB);
            Graphics2D d2 = (Graphics2D) mainPanel.image.createGraphics();
            d2.setColor(Color.white);
            d2.fillRect(0, 0, 3200, 3200);
            mainPanel.repaint();
        }

        if(e.getSource() == openItem){
            JFileChooser jf = new  JFileChooser();
            int result = jf.showOpenDialog(null);
            if(result==JFileChooser.APPROVE_OPTION){
                try{
                    fileName = jf.getSelectedFile().getAbsolutePath();
                    File iF = new File(fileName);
                    jf.addChoosableFileFilter(new ExtFileFilter(".png"));
                    jf.addChoosableFileFilter(new ExtFileFilter(".jpg"));
                    mainPanel.image = ImageIO.read(iF);
                    mainPanel.setSize(mainPanel.image.getWidth(), mainPanel.image.getWidth());
                    mainPanel.repaint();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(this, "Something went wrong");
                }
            }
        }else if(e.getSource() == saveItem){
            try{
                JFileChooser jf = new  JFileChooser();
                ExtFileFilter pngFilter = new ExtFileFilter(".png");
                ExtFileFilter jpgFilter = new ExtFileFilter(".jpg");
                if(fileName == null){
                    jf.addChoosableFileFilter(pngFilter);
                    jf.addChoosableFileFilter(jpgFilter);
                    int result = jf.showSaveDialog(null);
                    if(result == JFileChooser.APPROVE_OPTION){
                        fileName = jf.getSelectedFile().getAbsolutePath();
                    }
                }
                if(jf.getFileFilter()==pngFilter){
                    ImageIO.write(mainPanel.image, "png", new  File(fileName+".png"));
                }else{
                    ImageIO.write(mainPanel.image, "jpeg", new  File(fileName+".jpg"));
                }
            }catch(IOException ex){
                JOptionPane.showMessageDialog(this, "Something went wrong");
            }
        }else if(e.getSource() == saveAsItem){
            try{
                JFileChooser jf = new  JFileChooser();
                ExtFileFilter pngFilter = new ExtFileFilter(".png");
                ExtFileFilter jpgFilter = new ExtFileFilter(".jpg");
                jf.addChoosableFileFilter(pngFilter);
                jf.addChoosableFileFilter(jpgFilter);
                int result = jf.showSaveDialog(null);
                if(result==JFileChooser.APPROVE_OPTION){
                    fileName = jf.getSelectedFile().getAbsolutePath();
                }
                if(jf.getFileFilter()==pngFilter){
                    ImageIO.write(mainPanel.image, "png", new  File(fileName+".png"));
                }
                else{
                    ImageIO.write(mainPanel.image, "jpeg", new  File(fileName+".jpg"));
                }
            }
            catch(IOException ex){
                JOptionPane.showMessageDialog(this, "Something went wrong");
            }
        }else if(e.getSource() == exitItem){
            System.exit(0);
        }
    }

    public void paint(Graphics g)
    {
        super.paint(g);
    }
}
