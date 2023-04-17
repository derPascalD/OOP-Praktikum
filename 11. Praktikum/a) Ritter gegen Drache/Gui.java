import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {

    private final Font font = new Font("Cookie", Font.BOLD,25);

    private final JFrame fenster;

    private final JPanel rechteSeite = new JPanel(new BorderLayout());

    private final JPanel oben = new JPanel(new GridLayout(2,1));
    private final JPanel mitte = new JPanel(new BorderLayout());
    private final JPanel unten = new JPanel(new GridLayout(2,1));

    private final JPanel ritterStatus = new JPanel(new FlowLayout(FlowLayout.LEFT));

    private final JPanel dracheStatus = new JPanel(new FlowLayout(FlowLayout.LEFT));

    public final JLabel informationR = new JLabel("Spielstärke:");
    private final JLabel informationD = new JLabel("Spielstärke:");
    private final JLabel information = new JLabel("-");
    private final JLabel ergebnis = new JLabel("Ergebnis: -");
    private final JButton wuerfel = new JButton("Würfeln");

    SpielstaerkeRD rgD = new SpielstaerkeRD(this);
    Spielfeld spielfeld =  new Spielfeld(this, rgD);

    /**
     * Im Constructor erstelle ich das Layout des Fensters und erstelle es.
     */
    Gui(){

        fenster = new JFrame();
        fenster.setTitle("Ritter gegen Drache");

        // Damit lässt sich das Fenster nicht mehr verkleinern und vergrößern.
        fenster.setResizable(false);

        // Setzt die größe des Fensters
        fenster.setSize(736, 528);

        // Wird das Fenster sichtbar oder nicht sichtbar gemacht.
        fenster.setVisible(true);
        fenster.getContentPane().setBackground(Color.BLACK);

        fenster.setLayout(new BorderLayout());

        rechteSeite();

        fenster.add(spielfeld,BorderLayout.CENTER);
        rgD.eigenschalftenSetzen();
    }

    /**
     * Hiermit erste ich die rechte Seite des Fensters.
     */
    void rechteSeite(){

        oben.add(ritterStatus);
        oben.add(dracheStatus);
        mitte.add(information,BorderLayout.CENTER);

        informationD.setFont(font);
        informationR.setFont(font);
        information.setFont(font);
        ergebnis.setFont(font);
        ritterStatus.add(informationR);
        dracheStatus.add(informationD);
        unten.add(wuerfel);
        unten.add(ergebnis);
        wuerfel.addActionListener(this);

        rechteSeite.add(oben, BorderLayout.NORTH);
        rechteSeite.add(mitte,BorderLayout.CENTER);
        rechteSeite.add(unten,BorderLayout.SOUTH);

        ritterStatus.setBorder(BorderFactory.createTitledBorder("Ritter"));
        dracheStatus.setBorder(BorderFactory.createTitledBorder("Drache"));
        information.setBorder(BorderFactory.createTitledBorder("Information"));
        unten.setBorder(BorderFactory.createTitledBorder("Aktion"));

        dracheStatus.setPreferredSize(new Dimension(230,0));
        rechteSeite.setPreferredSize(new Dimension(230,440));

        fenster.add(rechteSeite,BorderLayout.EAST);
    }

    /**
     * Hier werden aktionen durchgeführt zur Laufzeit des Programmes.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == wuerfel){
            spielfeld.wuerfeln();
        }
    }
    public  JLabel getInformationR() {
        return informationR;
    }
    public JLabel getInformationD() {
        return informationD;
    }
    public  JLabel getInformation() {
        return information;
    }
    public JLabel getErgebnis() {
        return ergebnis;
    }

    public JButton getWuerfel() {
        return wuerfel;
    }

    public Font getFont() {
        return font;
    }
}
