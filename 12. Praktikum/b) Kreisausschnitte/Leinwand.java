import javax.swing.*;
import java.awt.*;

public class Leinwand extends JPanel {

    private int wert;

    private int r = (int) (Math.random() * 256);
    private int g = (int) (Math.random() * 256);
    private int b = (int) (Math.random() * 256);

    private int x = 0;
    private int y = 0;
    private int durchmesser;
    private  float winkelSteuck = 0;
    private float winkel = 0;
    Leinwand() {
        this.setBackground(Color.white);
    }

    /**
     * Hier erstelle ich unterschiedliche Kreisdiagramme, je nach Größe die gewählt wird.
     */
    void male(Graphics x1) {
        x1.setColor(Color.white);
        x1.fillRect(0,0,getWidth(),getHeight());

        durchmesser = this.getWidth() / wert;
        winkelSteuck = (360f/(wert*wert));
        winkel = winkelSteuck;
        // Zeilen
        for (int i = 0; i < wert; i++) {
            // Spalten
            for (int j = 0; j < wert; j++) {
                r = (int) (Math.random() * 256);
                g = (int) (Math.random() * 256);
                b = (int) (Math.random() * 256);
                x1.setColor(new Color(r, g, b));
                x1.fillArc(x, y, durchmesser, durchmesser, 0, (int) Math.ceil(winkel));
                x = x + durchmesser;
                winkel = winkel + winkelSteuck;
            }
            y = y + durchmesser;
            x = 0;

        }
        y = 0;
        winkel = 0;
    }

    public void setWert(int wert) {
        this.wert = wert;
    }
}
