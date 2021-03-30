package pl.edu.pw.fizyka.pojava.spiochy;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainPanel extends JPanel {
    static final Color BG_COLOR = new Color(47, 138, 47);
    static final Color STREET_COLOR = new Color(102,102,102);
    static final Color LINE_COLOR = new Color(255,255,255);

    static final int STREET_WIDTH = 50;
    static final int LINE_WIDTH = 3;

    int width;
    int height;

    int intersectionType;

    BufferedImage lightsImg;
    BufferedImage rightImg;
    BufferedImage rowImg;

    public MainPanel(int iType) {
        this.setBackground(BG_COLOR);

        intersectionType = iType;

        try {
            lightsImg = ImageIO.read(new File("./assets/Lights.png"));
            rightImg = ImageIO.read(new File("./assets/Right.png"));
            rowImg = ImageIO.read(new File("./assets/Row.png"));
        } catch (IOException e) {
            System.out.println("Error occured during loading images.");
            System.exit(1);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        this.paintStreets(g2d);
        this.paintLines(g2d);

        this.paintIntersectionIndicator(g2d);
    }

    private void paintStreets(Graphics2D g2d) {
        g2d.setColor(STREET_COLOR);

        g2d.fillRect(0, (height - STREET_WIDTH) / 2, width, STREET_WIDTH);
        g2d.fillRect((width - STREET_WIDTH) / 2, 0, STREET_WIDTH, height);
    }

    private void paintLines(Graphics2D g2d) {
        g2d.setColor(LINE_COLOR);

        g2d.fillRect(0, (height - LINE_WIDTH) / 2, width, LINE_WIDTH);
        g2d.fillRect((width - LINE_WIDTH) / 2, 0, LINE_WIDTH, height);
    }

    private void paintIntersectionIndicator(Graphics2D g2d) {
        if (intersectionType == 0) {
            g2d.drawImage(lightsImg, null, width / 2 + STREET_WIDTH, height / 2 - lightsImg.getHeight() - STREET_WIDTH);
        } else if (intersectionType == 1) {
            g2d.drawImage(rightImg, null, width / 2 + STREET_WIDTH, height / 2 - rightImg.getHeight() - STREET_WIDTH);
        } else if (intersectionType == 2) {
            g2d.drawImage(rowImg, null, width / 2 + STREET_WIDTH, height / 2 - rowImg.getHeight() - STREET_WIDTH);
        }
    }

    public void updateDimension() {
        Dimension dim = this.getSize();

        width = dim.width;
        height = dim.height;

        this.repaint();
        this.revalidate();
    }

    public void setIntersectionType(int i) {
        this.intersectionType = i;

        this.repaint();
        this.revalidate();
    }
}
