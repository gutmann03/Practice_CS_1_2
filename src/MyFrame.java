import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    public JMenuItem saveAsItem = new JMenuItem("Save as...", new ImageIcon("src/images/saveAs.png"));
    public JMenuItem exitItem = new JMenuItem("Exit", new ImageIcon("src/images/exit.png"));

    public MyToolBar tb = new MyToolBar();

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


        tb.pencilButton.addActionListener(this);
        tb.eraserButton.addActionListener(this);
        tb.brushButton.addActionListener(this);
        tb.strongBrushButton.addActionListener(this);
        tb.lineButton.addActionListener(this);
        tb.ovalButton.addActionListener(this);
        tb.rectangleButton.addActionListener(this);
        tb.starButton.addActionListener(this);

        // setting upper panel
        upperPanel = new JPanel();
        upperPanel.setBounds(0, 0, MAX_WIDTH, 40);
        upperPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        upperPanel.add(tb);
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
    public void actionPerformed(ActionEvent e){
        if(tb.pencilButton == e.getSource()){
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
        }

        if(e.getSource() == openItem){
            JFileChooser jf = new  JFileChooser();
            int result = jf.showOpenDialog(null);
            if(result==JFileChooser.APPROVE_OPTION){
                try{
                    fileName = jf.getSelectedFile().getAbsolutePath();
                    File iF = new File(fileName);
                    jf.addChoosableFileFilter(new TextFileFilter(".png"));
                    jf.addChoosableFileFilter(new TextFileFilter(".jpg"));
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
                TextFileFilter pngFilter = new TextFileFilter(".png");
                TextFileFilter jpgFilter = new TextFileFilter(".jpg");
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
                TextFileFilter pngFilter = new TextFileFilter(".png");
                TextFileFilter jpgFilter = new TextFileFilter(".jpg");
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
