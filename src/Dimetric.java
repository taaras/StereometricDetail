import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Taras Shvyryd
 */
public class Dimetric extends JFrame{
    private JPanel panel1;
    private JPanel canvas;
    private JSpinner moveX;
    private JSpinner moveY;
    private JSpinner moveZ;
    private JSpinner shiftX;
    private JSpinner shiftY;
    private JSpinner shiftZ;
    private JSpinner scaleX;
    private JSpinner scaleY;
    private JSpinner scaleZ;
    private JButton rebuildButton;

    /**
     * Provides current moving, shifting and scaling values
     * Data stored in format
     * {
     *     {moveX, moveY, moveZ},
     *     {shiftX, shiftY, shiftZ},
     *     {scaleX, scaleY, scaleZ}
     * }
     */
    private double[][] currentData = new double[][]{
            {0.0, 0.0, 0.0},
            {0.0, 0.0, 0.0},
            {1.0, 1.0, 1.0}
    };
    private JSpinner[][] inputBinding;

    public Dimetric() {
        super("Деталь в диметрії");
        setContentPane(panel1);
        pack();
        setBounds(250, 50, 900, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        rebuildButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < 2; i++)
                    for(int j = 0; j < 3; j++)
                        currentData[i][j] += Double.parseDouble(inputBinding[i][j].getValue().toString());

                for (int j = 0, i = 2; j < 3; j++)
                    currentData[i][j] *= (double)inputBinding[i][j].getValue();

                repaint();
            }
        });

        initElements();
    }

    private void initElements() {
        inputBinding = new JSpinner[][]{
                {moveX, moveY, moveZ},
                {shiftX, shiftY, shiftZ},
                {scaleX, scaleY, scaleZ}
        };

        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 2; j++)
                inputBinding[i][j].setModel(new SpinnerNumberModel(0.0, -100.0, 100.0, 1.0));

        for (int j = 0, i = 2; j < 3; j++)
            inputBinding[i][j].setModel(new SpinnerNumberModel(1.0, 0.05, 10.0, 0.05));

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawAxis(g);
        drawDetail(g);
    }

    private void drawDetail(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2.5f));
        g2d.setColor(Color.BLUE);
        Point p;

        Polygon pol = new Polygon();
        p = dimetricProjection(0, 0, 0);
        pol.add(p.x, p.y);
        p = dimetricProjection(0, 0, 200);
        pol.add(p.x, p.y);
        p = dimetricProjection(200, 0, 200);
        pol.add(p.x, p.y);
        p = dimetricProjection(200, 0, 0);
        pol.add(p.x, p.y);
        p = dimetricProjection(0, 0, 0);
        pol.add(p.x, p.y);
        g2d.setColor(Color.GRAY);
        //g2d.fillPolygon(pol.getXPoints(), pol.getYPoints(), pol.getXPoints().length);
        g2d.setColor(Color.BLUE);
        g2d.drawPolygon(pol.getXPoints(), pol.getYPoints(), pol.getXPoints().length);
        pol = new Polygon();

        p = dimetricProjection(0, 0, 0);
        pol.add(p.x, p.y);
        p = dimetricProjection(0, 100, 0);
        pol.add(p.x, p.y);
        p = dimetricProjection(200, 100, 0);
        pol.add(p.x, p.y);
        p = dimetricProjection(200, 0, 0);
        pol.add(p.x, p.y);
        p = dimetricProjection(0, 0, 0);
        pol.add(p.x, p.y);
        g2d.setColor(Color.GRAY);
        //g2d.fillPolygon(pol.getXPoints(), pol.getYPoints(), pol.getXPoints().length);
        g2d.setColor(Color.BLUE);
        g2d.drawPolygon(pol.getXPoints(), pol.getYPoints(), pol.getXPoints().length);
        pol = new Polygon();

        p = dimetricProjection(0, 0, 0);
        pol.add(p.x, p.y);
        p = dimetricProjection(0, 0, 200);
        pol.add(p.x, p.y);
        p = dimetricProjection(0, 50, 200);
        pol.add(p.x, p.y);
        p = dimetricProjection(0, 50, 100);
        pol.add(p.x, p.y);
        p = dimetricProjection(0, 75, 100);
        pol.add(p.x, p.y);
        p = dimetricProjection(0, 100, 75);
        pol.add(p.x, p.y);
        p = dimetricProjection(0, 100, 0);
        pol.add(p.x, p.y);
        p = dimetricProjection(0, 0, 0);
        pol.add(p.x, p.y);
        g2d.setColor(Color.GRAY);
        //g2d.fillPolygon(pol.getXPoints(), pol.getYPoints(), pol.getXPoints().length);
        g2d.setColor(Color.BLUE);
        g2d.drawPolygon(pol.getXPoints(), pol.getYPoints(), pol.getXPoints().length);
        pol = new Polygon();

        p = dimetricProjection(0, 0, 200);
        pol.add(p.x, p.y);
        p = dimetricProjection(0, 50, 200);
        pol.add(p.x, p.y);
        p = dimetricProjection(200, 50, 200);
        pol.add(p.x, p.y);
        p = dimetricProjection(200, 0, 200);
        pol.add(p.x, p.y);
        p = dimetricProjection(0, 0, 200);
        pol.add(p.x, p.y);
        g2d.setColor(Color.GRAY);
        //g2d.fillPolygon(pol.getXPoints(), pol.getYPoints(), pol.getXPoints().length);
        g2d.setColor(Color.BLUE);
        g2d.drawPolygon(pol.getXPoints(), pol.getYPoints(), pol.getXPoints().length);
        pol = new Polygon();

        p = dimetricProjection(200, 0, 0);
        pol.add(p.x, p.y);
        p = dimetricProjection(200, 0, 200);
        pol.add(p.x, p.y);
        p = dimetricProjection(200, 50, 200);
        pol.add(p.x, p.y);
        p = dimetricProjection(200, 50, 100);
        pol.add(p.x, p.y);
        p = dimetricProjection(200, 75, 100);
        pol.add(p.x, p.y);
        p = dimetricProjection(200, 100, 75);
        pol.add(p.x, p.y);
        p = dimetricProjection(200, 100, 0);
        pol.add(p.x, p.y);
        p = dimetricProjection(200, 0, 0);
        pol.add(p.x, p.y);
        g2d.setColor(Color.GRAY);
        //g2d.fillPolygon(pol.getXPoints(), pol.getYPoints(), pol.getXPoints().length);
        g2d.setColor(Color.BLUE);
        g2d.drawPolygon(pol.getXPoints(), pol.getYPoints(), pol.getXPoints().length);
        pol = new Polygon();

        p = dimetricProjection(0, 100, 0);
        pol.add(p.x, p.y);
        p = dimetricProjection(0, 100, 75);
        pol.add(p.x, p.y);
        p = dimetricProjection(200, 100, 75);
        pol.add(p.x, p.y);
        p = dimetricProjection(200, 100, 0);
        pol.add(p.x, p.y);
        p = dimetricProjection(0, 100, 0);
        pol.add(p.x, p.y);
        g2d.setColor(Color.GRAY);
        //g2d.fillPolygon(pol.getXPoints(), pol.getYPoints(), pol.getXPoints().length);
        g2d.setColor(Color.BLUE);
        g2d.drawPolygon(pol.getXPoints(), pol.getYPoints(), pol.getXPoints().length);
        pol = new Polygon();

        p = dimetricProjection(0, 100, 75);
        pol.add(p.x, p.y);
        p = dimetricProjection(0, 75, 100);
        pol.add(p.x, p.y);
        p = dimetricProjection(200, 75, 100);
        pol.add(p.x, p.y);
        p = dimetricProjection(200, 100, 75);
        pol.add(p.x, p.y);
        p = dimetricProjection(0, 100, 75);
        pol.add(p.x, p.y);
        g2d.setColor(Color.GRAY);
        //g2d.fillPolygon(pol.getXPoints(), pol.getYPoints(), pol.getXPoints().length);
        g2d.setColor(Color.BLUE);
        g2d.drawPolygon(pol.getXPoints(), pol.getYPoints(), pol.getXPoints().length);
        pol = new Polygon();

        p = dimetricProjection(0, 75, 100);
        pol.add(p.x, p.y);
        p = dimetricProjection(0, 50, 100);
        pol.add(p.x, p.y);
        p = dimetricProjection(200, 50, 100);
        pol.add(p.x, p.y);
        p = dimetricProjection(200, 75, 100);
        pol.add(p.x, p.y);
        p = dimetricProjection(0, 75, 100);
        pol.add(p.x, p.y);
        g2d.setColor(Color.GRAY);
        //g2d.fillPolygon(pol.getXPoints(), pol.getYPoints(), pol.getXPoints().length);
        g2d.setColor(Color.BLUE);
        g2d.drawPolygon(pol.getXPoints(), pol.getYPoints(), pol.getXPoints().length);
        pol = new Polygon();

        p = dimetricProjection(0, 50, 100);
        pol.add(p.x, p.y);
        p = dimetricProjection(0, 50, 200);
        pol.add(p.x, p.y);
        p = dimetricProjection(200, 50, 200);
        pol.add(p.x, p.y);
        p = dimetricProjection(200, 50, 100);
        pol.add(p.x, p.y);
        p = dimetricProjection(0, 50, 100);
        pol.add(p.x, p.y);
        g2d.setColor(Color.GRAY);
        //g2d.fillPolygon(pol.getXPoints(), pol.getYPoints(), pol.getXPoints().length);
        g2d.setColor(Color.BLUE);
        g2d.drawPolygon(pol.getXPoints(), pol.getYPoints(), pol.getXPoints().length);
        pol = new Polygon();
    }

    private void drawAxis(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int x1, y1;//x coordinates
        int x3, y3;//y coordinates
        int x2, y2;//z coordinates

        int x0 = canvas.getWidth()/2;
        int y0 = canvas.getHeight()/2;
        x1 = (int) (x0 + 250 * Math.cos(-43 * Math.PI/180));
        y1 = (int) (y0 - 250 * Math.sin(-43 * Math.PI/180));
        x2 = (int) (x0 + 250 * Math.cos(90 * Math.PI/180));
        y2 = (int) (y0 - 250 * Math.sin(90 * Math.PI/180));
        x3 = (int) (x0 + 250 * Math.cos(187 * Math.PI/180));
        y3 = (int) (y0 - 250 * Math.sin(187 * Math.PI/180));

        g2d.drawLine(x0, y0, x1, y1);
        g2d.drawLine(x0, y0, x3, y3);
        g2d.drawLine(x0, y0, x2, y2);

        g2d.drawString("X", x1+5, y1+5);
        g2d.drawString("Y", x2+5, y2+5);
        g2d.drawString("Z", x3-5, y3+5);
    }

    public Point dimetricProjection(int x, int y, int z){
        double[][] resMatr = new double[4][4];
        double[][] proecMatr = new double[4][4];

        //матриця переміщення
            double xMove = currentData[0][0];//(int) moveX.getValue();
            double yMove = currentData[0][1];//(int) moveY.getValue();
            double zMove = currentData[0][2];//(int) moveZ.getValue();
            double[][] moveMatr = new double[][]{
                    {1, 0, 0, 0},
                    {0, 1, 0, 0},
                    {0, 0, 1, 0},
                    {0, 0, 0, 1}
            };
            moveMatr[3][0] = xMove;
            moveMatr[3][1] = yMove;
            moveMatr[3][2] = zMove;

        //матриця повороту навколо X
            double angleX = currentData[1][0]/*(int) shiftX.getValue()*/ * 0.0174532925199433;
            double[][] shiftMatrX = new double[][]{
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0}
            };
            shiftMatrX[0][0] = 1;
            shiftMatrX[1][1] = Math.cos(angleX);
            shiftMatrX[2][2] = Math.cos(angleX);
            shiftMatrX[3][3] = 1;
            shiftMatrX[1][2] = Math.sin(angleX);
            shiftMatrX[2][1] = - Math.sin(angleX);

        //матриця повороту навколо Y
            double angleY = currentData[1][1]/*(int) shiftY.getValue()*/ * 0.0174532925199433;
            double[][] shiftMatrY = new double[][]{
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0}
            };
            shiftMatrY[0][0] = Math.cos(angleY);
            shiftMatrY[1][1] = 1;
            shiftMatrY[2][2] = Math.cos(angleY);
            shiftMatrY[3][3] = 1;
            shiftMatrY[2][0] = Math.sin(angleY);
            shiftMatrY[0][2] = - Math.sin(angleY);

        //матриця повороту навколо Z
            double angleZ = currentData[1][2]/*(int)shiftZ.getValue()*/ * 0.0174532925199433;
            double [][] shiftMatrZ = new double[][]{
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0}
            };
            shiftMatrZ[0][0] = Math.cos(angleZ);
            shiftMatrZ[1][1] = Math.cos(angleZ);
            shiftMatrZ[1][0] = - Math.sin(angleZ);
            shiftMatrZ[0][1] = Math.sin(angleZ);
            shiftMatrZ[2][2] = 1;
            shiftMatrZ[3][3] = 1;

        //масштабування
            double[][] scaleMatr = new double[][]{
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0}
            };
            scaleMatr[0][0] = currentData[2][0];//(double)scaleX.getValue();
            scaleMatr[1][1] = currentData[2][1];//(double)scaleY.getValue();
            scaleMatr[2][2] = currentData[2][2];//(double)scaleZ.getValue();
            scaleMatr[3][3] = 1;

        //заповнення результуючої матриці
        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 4; j++)
                for(int k = 0; k < 4; k++)
                    for(int l = 0; l < 4; l++)
                        for(int m = 0; m < 4; m++)
                            for(int n = 0; n < 4; n++)
                                resMatr[i][j] += shiftMatrX[i][n] * shiftMatrY[n][m] * shiftMatrZ[m][l] * scaleMatr[l][k] * moveMatr[k][j];

        //матриця повороту відносно осі Х
        double rad = 0.0174532925199433;
        double xAng = 160 * rad;
        double[][] shiftMatrAxisX = new  double[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        shiftMatrAxisX[0][0] = 1;
        shiftMatrAxisX[1][1] = Math.cos(xAng);
        shiftMatrAxisX[2][2] = Math.cos(xAng);
        shiftMatrAxisX[3][3] = 1;
        shiftMatrAxisX[1][2] = Math.sin(xAng);
        shiftMatrAxisX[2][1] = - Math.sin(xAng);

        //матриця повороту відносно осі Z
        double yAng = 110 * rad;
        double[][] shiftMatrAxisZ = new double[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        shiftMatrAxisZ[0][0] = Math.cos(yAng);
        shiftMatrAxisZ[1][1] = 1;
        shiftMatrAxisZ[2][2] = Math.cos(yAng);
        shiftMatrAxisZ[3][3] = 1;
        shiftMatrAxisZ[2][0] = Math.sin(yAng);
        shiftMatrAxisZ[0][2] = - Math.sin(yAng);

        //заповнення матриці проекціювання
        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 4; j++)
                for(int k = 0; k < 4; k++)
                    proecMatr[i][j] += shiftMatrAxisZ[i][k] * shiftMatrAxisX[k][j];

        double xn, yn, zn, w = 1.0;
        double[] det = new double[]{x/w, y/w, z/w, w/w};
        xn = det[0]*resMatr[0][0] + det[1]*resMatr[1][0] + det[2]*resMatr[2][0] + det[3]*resMatr[3][0];
        yn = det[0]*resMatr[0][1] + det[1]*resMatr[1][1] + det[2]*resMatr[2][1] + det[3]*resMatr[3][1];
        zn = det[0]*resMatr[0][2] + det[1]*resMatr[1][2] + det[2]*resMatr[2][2] + det[3]*resMatr[3][2];
        w = det[0]*resMatr[0][3] + det[1]*resMatr[1][3] + det[2]*resMatr[2][3] + det[3]*resMatr[3][3];

        det = new double[]{xn/w, yn/w, zn/w, w/w};
        xn = det[0]*proecMatr[0][0] + det[1]*proecMatr[1][0] + det[2]*proecMatr[2][0] + det[3]*proecMatr[3][0];
        yn = det[0]*proecMatr[0][1] + det[1]*proecMatr[1][1] + det[2]*proecMatr[2][1] + det[3]*proecMatr[3][1];
        zn = det[0]*proecMatr[0][2] + det[1]*proecMatr[1][2] + det[2]*proecMatr[2][2] + det[3]*proecMatr[3][2];
        w = det[0]*proecMatr[0][3] + det[1]*proecMatr[1][3] + det[2]*proecMatr[2][3] + det[3]*proecMatr[3][3];

        return new Point((int)-xn + canvas.getWidth()/2, (int)yn + canvas.getHeight()/2);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Dimetric();
            }
        });
    }
}
