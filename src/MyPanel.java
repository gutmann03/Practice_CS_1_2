import jdk.dynalink.support.AbstractRelinkableCallSite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;

class MyPanel extends JPanel {
    public BufferedImage image;
    public int xStart, yStart, xEnd, yEnd;
    public State state;
    public Color mainColor = Color.black;
    public boolean isFilled = false;
    public int size = 1;

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
                        g2.setStroke(new BasicStroke(size));
                        g2.drawLine(xStart, yStart, e.getX(), e.getY());
                        break;
                    case USE_ERASER:
                        g2.setStroke(new  BasicStroke(size * 5));
                        g2.setColor(Color.WHITE);
                        g2.drawLine(xStart, yStart, e.getX(), e.getY());
                        break;
                    case USE_BRUSH:
                        g2.setStroke(new  BasicStroke(size * 3));
                        g2.drawLine(xStart, yStart, e.getX(), e.getY());
                        break;
                    case USE_STRONG_BRUSH:
                        g2.setStroke(new  BasicStroke(size * 5));
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
                        g2.setStroke(new BasicStroke(size));
                        g2.drawLine(xStart, yStart, xStart + 1, yStart + 1);
                        break;
                    case USE_ERASER:
                        g2.setStroke(new  BasicStroke(size * 5));
                        g2.setColor(Color.WHITE);
                        g2.drawLine(xStart, yStart, xStart + 1, yStart + 1);
                        break;
                    case USE_BRUSH:
                        g2.setStroke(new  BasicStroke(size * 3));
                        g2.drawLine(xStart, yStart, xStart + 1, yStart + 1);
                        break;
                    case USE_STRONG_BRUSH:
                        g2.setStroke(new  BasicStroke(size * 5));
                        g2.drawLine(xStart, yStart, xStart + 1, yStart + 1);
                        break;
                    case MAKE_STAR:
                        g2.setStroke(new BasicStroke(size * 2));
                        int x1 = xStart;
                        int y1 = yStart;
                        double[][] points = {
                                {x1, y1}, {x1 + 75, y1 - 10}, {x1 + 100, y1 - 75}, {x1 + 125, y1 - 10},
                                {x1 + 200, y1 - 10 }, {x1 + 150, y1 + 45}, {x1 + 160, y1 + 105}, {x1 + 100, y1 + 65},
                                {x1 + 40, y1 + 105}, {x1 + 50, y1 + 35}, {x1, y1}
                        };
                        GeneralPath star = new GeneralPath();
                        star.moveTo(points[0][0], points[0][1]);
                        for (int k = 1; k < points.length; k++)
                            star.lineTo(points[k][0], points[k][1]);
                        star.closePath();

                        if(isFilled) g2.fill(star);
                        else g2.draw(star);
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
                g2.setStroke(new BasicStroke(size * 3));
                int  x1 = xEnd, x2 = xStart, y1 = yEnd, y2 = yStart;
                if(xEnd > xStart){
                    x2 = xEnd;
                    x1 = xStart;
                }
                if(yEnd > yStart) {
                    y2 = yStart;
                    y1 = yStart;
                }
                switch(state){
                    case MAKE_LINE:
                        g.drawLine(xEnd, yEnd, e.getX(), e.getY());
                        break;
                    case MAKE_OVAL:
                        if(isFilled) g.fillOval(x1, y1, (x2-x1), (y2-y1));
                        else g.drawOval(x1, y1, (x2-x1), (y2-y1));
                        break;
                    case MAKE_RECTANGLE:
                        if(isFilled) g.fillRect(x1, y1, (x2-x1), (y2-y1));
                        else g.drawRect(x1, y1, (x2-x1), (y2-y1));
                        break;
                    case MAKE_ARCH:
                        if(isFilled) g.fillArc(x1, y1, (x2 - x1), (y2 - y1), 0, 180);
                        else g.drawArc(x1, y1, (x2 - x1), (y2 - y1), 0, 180);
                        break;
                    case MAKE_ROUND_RECT:
                        if(isFilled) g.fillRoundRect(x1, y1, (x2-x1), (y2-y1), 50, 50);
                        else g.drawRoundRect(x1, y1, (x2-x1), (y2-y1), 50, 50);
                        break;
                    case MAKE_TRIANGLE:
                        double[][] points = {{xStart, yStart}, {xEnd, yStart}, {xEnd, yEnd}};
                        GeneralPath triangle = new GeneralPath();
                        triangle.moveTo(points[0][0], points[0][1]);
                        for (int k = 1; k < points.length; k++)
                            triangle.lineTo(points[k][0], points[k][1]);
                        triangle.closePath();

                        if(isFilled) g2.fill(triangle);
                        else g2.draw(triangle);
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

    public void clean(Graphics g){
        g.setColor(Color.white);
        g.drawRect(0, 0, 3200, 3200);
        MyPanel.this.repaint();
    }
}