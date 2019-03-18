package sample;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Figure extends JPanel implements ActionListener {
    private static int maxWidth;
    private static int maxHeight;
    private Timer timer;

    private double angle = 0;
    private double scale = 1;
    private double delta = 0.01;

    public Figure() {
        timer = new Timer(5, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);

        g2d.setBackground(new Color(0, 128, 255));
        g2d.clearRect(0, 0, maxWidth, maxHeight);

        g2d.translate(maxWidth / 2, maxHeight / 2);

        BasicStroke bs2 = new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        g2d.setStroke(bs2);
        g2d.drawRect(-320, -320, 640, 640);

        double[][] trianglePoints = {{160.0, 10.0}, {130.0, 150.0}, {280.0, 140.0}};

        GeneralPath triangle = new GeneralPath();
        triangle.moveTo(trianglePoints[0][0], trianglePoints[0][1]);
        for (int k = 1; k < trianglePoints.length; k++)
            triangle.lineTo(trianglePoints[k][0], trianglePoints[k][1]);
        triangle.closePath();

        GradientPaint gp = new GradientPaint(
                -20, -20,
                new Color(192, 192, 192),
                100, 20,
                new Color(0, 128, 128),
                true
        );

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) scale));
        g2d.rotate(angle, 10, -5);
        g2d.setColor(new Color(255, 255, 255));
        g2d.fillRect(30, -25, 150, 150);
        g2d.setPaint(gp);
        g2d.fill(triangle);

        int xpoints[] = {-15, 130, 60, -33};
        int ypoints[] = {60, 70, 210, 170};
        int npoints = 4;

        g2d.setColor(new Color(0, 255, 128));
        g2d.fillPolygon(xpoints, ypoints, npoints);

        g2d.setColor(new Color(255,255,0));
        g2d.draw(new Line2D.Double(20, -45, 200, -45));
        g2d.draw(new Line2D.Double(20, -45, 20, 10));
        g2d.draw(new Line2D.Double(200, -45, 200, 10));

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 750);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(new Figure());

        frame.setVisible(true);

        Dimension size = frame.getSize();
        Insets insets = frame.getInsets();
        maxWidth = size.width - insets.left - insets.right - 1;
        maxHeight = size.height - insets.top - insets.bottom - 1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (scale < 0.01 || scale > 0.99)
            delta = -delta;

        scale += delta;
        angle -= 0.01;

        repaint();
    }
}

