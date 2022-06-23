import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

class MyPanel extends JPanel {
    public BufferedImage image;
    public int xStart, yStart, xEnd, yEnd;
    public State state;
    public Color mainColor = Color.black;

    public MyPanel(){
        state = State.DO_NOTHING;
        this.setPreferredSize(new Dimension(3200, 3200));
        this.addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e){
                Graphics g = image.getGraphics();
                Graphics2D g2 = (Graphics2D)g;
                g2.setColor(mainColor);
                switch(state){
                    case USE_PENCIL:
                        g2.drawLine(xStart, yStart, e.getX(), e.getY());
                        break;
                    case USE_ERASER:
                        g2.setStroke(new  BasicStroke(3));
                        g2.setColor(Color.WHITE);
                        g2.drawLine(xStart, yStart, e.getX(), e.getY());
                        break;
                    case USE_BRUSH:
                        g2.setStroke(new  BasicStroke(3));
                        g2.drawLine(xStart, yStart, e.getX(), e.getY());
                        break;
                    case USE_STRONG_BRUSH:
                        g2.setStroke(new  BasicStroke(5));
                        g2.drawLine(xStart, yStart, e.getX(), e.getY());
                        break;
                }
                xStart = e.getX();
                yStart = e.getY();

                MyPanel.this.repaint();
            }
        });

        this.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Graphics g = image.getGraphics();
                Graphics2D g2 = (Graphics2D)g;
                g2.setColor(mainColor);
                switch(state){
                    case USE_PENCIL:
                        g2.drawLine(xStart, yStart, xStart + 1, yStart + 1);
                        break;
                    case USE_ERASER:
                        g2.setStroke(new  BasicStroke(3));
                        g2.setColor(Color.WHITE);
                        g2.drawLine(xStart, yStart, xStart + 1, yStart + 1);
                        break;
                    case USE_BRUSH:
                        g2.setStroke(new  BasicStroke(3));
                        g2.drawLine(xStart, yStart, xStart + 1, yStart + 1);
                        break;
                    case USE_STRONG_BRUSH:
                        g2.setStroke(new  BasicStroke(5));
                        g2.drawLine(xStart, yStart, xStart + 1, yStart + 1);
                        break;
                }
                xStart = e.getX();
                yStart = e.getY();

                MyPanel.this.repaint();
            }
            public void mousePressed(MouseEvent e){
                xStart = e.getX();
                yStart = e.getY();
                xEnd = e.getX();
                yEnd = e.getY();
            }
            public void mouseReleased(MouseEvent e){
                Graphics g = image.getGraphics();
                Graphics2D g2 = (Graphics2D)g;
                g2.setColor(mainColor);
                int  x1 = xEnd, x2 = xStart, y1 = yEnd, y2 = yStart;
                if(xEnd > xStart){
                    x2 = xEnd;
                    x1 = xStart;
                }
                if(yEnd > yStart){
                    y2 = yStart;
                    y1 = yStart;
                }
                switch(state){
                    case MAKE_LINE:
                        g.drawLine(xEnd, yEnd, e.getX(), e.getY());
                        break;
                    case MAKE_OVAL:
                        g.drawOval(x1, y1, (x2-x1), (y2-y1));
                        break;
                    case MAKE_RECTANGLE:
                        g.drawRect(x1, y1, (x2-x1), (y2-y1));
                        break;
                }
                xEnd = 0; yEnd = 0;
                MyPanel.this.repaint();
            }
        });
    }

    public void paintComponent (Graphics g){
        if(image == null){
            image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D d2 = (Graphics2D) image.createGraphics();
            d2.setColor(Color.white);
            d2.fillRect(0, 0, this.getWidth(), this.getHeight());
        }
        super.paintComponent(g);
        g.drawImage(image, 0, 0,this);
    }
}