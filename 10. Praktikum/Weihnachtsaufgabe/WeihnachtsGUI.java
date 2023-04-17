import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WeihnachtsGUI extends JFrame implements ActionListener{

    private JLabel autor = new JLabel("Autor: ");

    private JTextField textfeld = new JTextField("Text");

    private JRadioButton tannenbaum = new JRadioButton("Tannenbaum");

    private JRadioButton wald = new JRadioButton("Wald");

    private JCheckBox santa = new JCheckBox("Santa");

    private JButton start = new JButton("Start");

    private JLabel status = new JLabel("-");

    static int x;
    static int y;
    static int endeWald = 0;
    static int endeBaum = 0;
    static int endeSanta = 0;

    static boolean bewegeRunter = false;
    static boolean bewegeHoch = false;
    static Image bild;


    Leinwand leinwand = new Leinwand();

    JPanel auswahlGesamt = new JPanel(new BorderLayout());

    JPanel auswahlOben = new JPanel(new FlowLayout());

    JPanel auswahlMitte = new JPanel(new BorderLayout());

    JPanel auswahlUnten = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));

    JPanel auswahlButtons = new JPanel((new GridLayout(3, 1, 100, 0)));

    JPanel statusleiste = new JPanel(new BorderLayout());

    WeihnachtsGUI() {
        setLayout(new BorderLayout());
        add(leinwand, BorderLayout.CENTER);
        auswahl();
        unten();
        toolTip();
        new Bewegung();
    }


    /**
     * Tool Tip Text
     */
    void toolTip() {
        start.setToolTipText("Zum Starten des Programmes, hier klicken!");
        tannenbaum.setToolTipText("Sorgt dafuer, das ein Tannenbaum angezeigt wird.");
        wald.setToolTipText("Sorgt dafuer, das ein ganzer Wald von Baeumen erscheint.");
        santa.setToolTipText("Sorgt dafuer das Santa erscheint.");
        autor.setToolTipText("Ersteller des Programmes.");
        textfeld.setToolTipText("Eingabe des Autors.");
        statusleiste.setToolTipText("Statusleiste");

    }

    /**
     * Die Methode baut erstellt rechte Seite des Fensters zusammen.
     */
    private void auswahl() {

        // Erstellt oben Rechts die Sachen
        add(auswahlGesamt, BorderLayout.EAST);
        auswahlOben.add(autor);
        textfeld.setPreferredSize(new Dimension(200, 20));
        auswahlOben.add(textfeld);
        auswahlGesamt.add(auswahlOben, BorderLayout.NORTH);

        // Erstellt die Mitte
        auswahlGesamt.add(auswahlMitte, BorderLayout.CENTER);

        // Hinzufügen der Buttons in das Panel
        auswahlButtons.setBorder(BorderFactory.createTitledBorder("Parameter"));
        auswahlButtons.add(tannenbaum);

        auswahlButtons.add(wald);
        auswahlButtons.add(santa);


        // Buttons miteinander verbinden
        ButtonGroup gruppe = new ButtonGroup();
        gruppe.add(tannenbaum);
        gruppe.add(wald);
        auswahlMitte.add(auswahlButtons, BorderLayout.NORTH);

        // Erstellt die untere Hälfte
        auswahlGesamt.add(auswahlUnten, BorderLayout.SOUTH);
        start.setPreferredSize(new Dimension(250, 25));
        auswahlUnten.add(start);

        tannenbaum.addActionListener(this);
        wald.addActionListener(this);
        santa.addActionListener(this);
        start.addActionListener(this);

    }

    /**
     * Die Methode erstellt die Statusleiste im Fenster.
     */
    public void unten() {
        add(statusleiste, BorderLayout.SOUTH);
        statusleiste.add(status, BorderLayout.WEST);
    }

    /**
     * Hier werden aktionen durchgeführt vom Benutzer.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (tannenbaum.isSelected()) {
            if (santa.isSelected()) {
                status.setText("Tannenbaum und Santa");
            } else {
                status.setText("Tannenbaum");
            }
        } else if (wald.isSelected()) {
            if (santa.isSelected()) {
                status.setText("Wald und Santa");
            } else {
                status.setText("Wald");
            }
        } else if (santa.isSelected()) {
            status.setText("Santa");
        }

        if (tannenbaum.isSelected() && e.getSource() == start) {
            if (santa.isSelected()) {
                endeBaum = 1;
                endeSanta = 1;
                leinwand.repaint();
                x = 0;
                y = 0;
                leinwand.animieren.start();
                leinwand.maleBaum(leinwand.getGraphics());
                leinwand.malSanta(leinwand.getGraphics());
            } else {
                endeBaum = 1;
                leinwand.repaint();
                leinwand.animieren.start();
                leinwand.maleBaum(leinwand.getGraphics());
            }
        } else if (wald.isSelected() && e.getSource() == start) {

            if (santa.isSelected()) {
                endeWald = 1;
                endeSanta = 1;
                leinwand.repaint();
                x = 0;
                y = 0;
                leinwand.animieren.start();
                leinwand.wald(leinwand.getGraphics());
                leinwand.malSanta(leinwand.getGraphics());

            } else {
                endeWald = 1;
                leinwand.repaint();
                leinwand.animieren.start();
                leinwand.wald(leinwand.getGraphics());

            }
        } else if (santa.isSelected() && e.getSource() == start) {
            endeSanta = 1;
            leinwand.animieren.start();
            leinwand.repaint();
            x = 0;
            y = 0;
            leinwand.animieren.start();
            leinwand.malSanta(leinwand.getGraphics());

        } else {
            endeWald = 0;
            endeBaum = 0;
            endeSanta = 0;
            leinwand.animieren.stop();
            leinwand.repaint();
            x = 0;
            y = 0;
        }
    }
}