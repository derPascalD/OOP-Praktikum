import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class Leinwand extends JPanel {

    // Der Timer sorgt dafür, dass die zugehörigen Methoden Inhalt im Scope immer neu aufruft.
    Timer animieren = new Timer(20,this::actionPerformed);

    Leinwand() {
        try {
            WeihnachtsGUI.bild = ImageIO.read(new File("src/santa.png")).getScaledInstance(100, 100, 1);
        } catch (IOException e) {
            System.out.println("Bild konnte nicht geladen werden.");
            System.exit(0);
        }
        this.setBackground(Color.BLACK);
    }

    /**
     * Die Methode sorgt dafür, das Santa hinzugefügt wird und sich weiter bewegt.
     */
    public void malSanta(Graphics g){

        KeyListener keyHandler = new tastaturEingaben();
        this.addKeyListener(keyHandler);
        requestFocus();

        this.getGraphics().fillOval(WeihnachtsGUI.x, WeihnachtsGUI.y-10 ,125, 125);
        this.getGraphics().fillOval(WeihnachtsGUI.x, WeihnachtsGUI.y-10 ,125, 125);
        if (WeihnachtsGUI.bild != null) {
            g.drawImage(WeihnachtsGUI.bild, WeihnachtsGUI.x,WeihnachtsGUI.y,100,100,null);
        }
        WeihnachtsGUI.x++;
        if(WeihnachtsGUI.x + 130 >= this.getWidth()){
            this.getGraphics().fillOval(WeihnachtsGUI.x, WeihnachtsGUI.y-10 ,125, 125);
            this.getGraphics().fillOval(WeihnachtsGUI.x, WeihnachtsGUI.y-10 ,125, 125);
            WeihnachtsGUI.x = 0;
        }
    }

    /**
     * Auf die Methoden wende ich einen Timer an, der dafür sorgt das die Methoden, je nach Einstellung erneut
     * aufgerufen werden.
     */
    private void actionPerformed(ActionEvent actionEvent) {

        if(WeihnachtsGUI.endeWald == 1){
            wald(getGraphics());
            WeihnachtsGUI.endeWald = 0;
        }
        if(WeihnachtsGUI.endeBaum == 1){
            maleBaum(getGraphics());
            WeihnachtsGUI.endeBaum = 0;
        }
        if(WeihnachtsGUI.endeSanta == 1 && WeihnachtsGUI.endeBaum == 0) {
            malSanta(getGraphics());
            maleStern(getGraphics());
            maleSternSchwarz(getGraphics());
        }
    }

    /**
     * Hier wird ein Stern erstellt.
     */
    void maleStern(Graphics g){

        int x = 0;
        int y = 0;
        int ende = 0;
        int groesse = (int) (Math.random()* 2+1);

        // Wird so lange ausgeführt bis die Koordinaten passen für den Stern.
        while( 1 != ende) {

            x = (int) (Math.random() * this.getWidth()+1);

            //Begrenze ich das Bild nach rechts
            if(x+5 > this.getWidth()){

            }else{
                ende = 1;
            }
        }
        ende = 0;

        // Wird so lange ausgeführt bis die Koordinaten passen für den Stern.
        while( 1 != ende) {

            y = (int) (Math.random()* this.getHeight()+1);

            // Begrenze ich das Bild nach unten
            if(y > 300){

            }else{
                ende = 1;
            }
        }
        g.setColor(new Color(231, 223, 219));
        g.fillRect(x,y,groesse,groesse);
    }

    /**
     * Hier werden Sterne übermalt, damit nicht zu viele angezeigt werden.
     */
    void maleSternSchwarz(Graphics g){

        int x = 0;
        int y = 0;
        int ende = 0;

        // Wird so lange ausgeführt bis die Koordinaten passen für den Stern.
        while( 1 != ende) {

            x = (int) (Math.random() * this.getWidth()+1);

            //Begrenze ich das Bild nach rechts
            if(x+25 > this.getWidth()){

            }else{
                ende = 1;
            }
        }
        ende = 0;

        // Wird so lange ausgeführt bis die Koordinaten passen für den Stern.
        while( 1 != ende) {

            y = (int) (Math.random()* this.getHeight()+1);

            // Begrenze ich das Bild nach unten
            if(y > 300){

            }else{
                ende = 1;
            }
        }

        g.setColor(new Color(0, 0, 0));
        g.fillRect(x,y,25,25);
    }

    /**
     * Hier wird ein Baum erstellt mit Dreiecken
     */
    void maleBaum(Graphics g) {

        int xK = 0;
        int yK = 0;
        int ende = 0;
        int xG = (int) (Math.random() * 19);

        // Wird so lange ausgeführt bis die Koordinaten passen für den Baum.
        while( 1 != ende) {

            xK = (int) (Math.random() * this.getWidth()+xG);

            //Begrenze ich das Bild nach rechts
            if(xK+45+xG> this.getWidth()){

            }else{
                ende = 1;
            }
        }
        ende = 0;

        // Wird so lange ausgeführt bis die Koordinaten passen für den Baum.
        while( 1 != ende) {

            yK = (int) (Math.random()* this.getHeight()+310+xG);

            // Begrenze ich das Bild nach unten
            if(yK+71 > this.getHeight()){

            }else{
                ende = 1;
            }
        }

        // Hiermit können alle RGB farben generiert werden.
        int x1 = (int) (Math.random() * 256);
        int x2 = (int) (Math.random() * 256);
        int x3 = (int) (Math.random() * 256);
        
        g.setColor(new Color(x1, x2, x3));

        int[] xKoordinaten= {xK+25, xK+45+xG, (xK+5) -xG};
        int[] yKoordinaten ={yK+40- xG, yK+70,yK+ 70};

        g.fillPolygon (xKoordinaten, yKoordinaten, xKoordinaten.length);

        int[] xKoordinaten2= {xK+25, xK+40+xG,(xK+ 10)-xG};
        int[] yKoordinaten2 ={yK+20- xG,yK+ 50,yK+ 50};

        g.fillPolygon (xKoordinaten2, yKoordinaten2, xKoordinaten.length);

        int[] xKoordinaten3= {xK+ 25, xK+ 35+xG,(xK+ 15)-xG};
        int[] yKoordinaten3 ={yK- xG,yK+30,yK+ 30};

        g.fillPolygon (xKoordinaten3, yKoordinaten3, xKoordinaten.length);
    }

    /**
     * Hier werden zwischen 10 und 100 Bäume generiert
     */
    void wald(Graphics g) {
        int baeume = (int) (Math.random() * 101) + 10;
        for (int i = 0; i < baeume; i++) {
            maleBaum(g);
        }
    }
}
