import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class Kreisaussschnitt implements ActionListener {

    private final JFrame fenster = new JFrame();
    private final JPanel rechteSeite = new JPanel();
    private final JButton start = new JButton("Start");
    private final Font font = new Font("Arial", Font.BOLD,17);
    private final JSlider groesse = new JSlider(JSlider.VERTICAL,1,10,3);
    private final JLabel l1 = new JLabel("1x1");
    private final JLabel l2 = new JLabel("5x5");
    private final JLabel l3 = new JLabel("10x10");
    private final Hashtable<Integer, JLabel> label = new Hashtable<>();

    Leinwand leinwand = new Leinwand();
    Kreisaussschnitt(){
        fenster.setLayout(new BorderLayout());
        fenster.add(leinwand,BorderLayout.CENTER);
        fenster.setSize(730,655);
        fenster.setTitle("Kreisausschnitt");
        fenster.setResizable(false);
        fenster.setVisible(true);
        rechteSeite();
    }

    /**
     * In der Methode erstelle ich die rechte Seite des Fensters.
     */
    void rechteSeite(){
        start.setPreferredSize(new Dimension(100,40));
        start.setFont(font);
        start.addActionListener(this);

        l1.setFont(font);
        l2.setFont(font);
        l3.setFont(font);

        groesse.setMinorTickSpacing(1);
        groesse.setPaintTicks(true);
        label.put(1, l1);
        label.put(5, l2);
        label.put(10, l3);

        groesse.setPaintLabels(true);

        rechteSeite.setLayout(new BorderLayout());
        rechteSeite.setPreferredSize(new Dimension(100, fenster.getHeight()));
        rechteSeite.add(groesse,BorderLayout.WEST);
        rechteSeite.add(start,BorderLayout.SOUTH);

        fenster.add(rechteSeite,BorderLayout.EAST);
        groesse.setLabelTable(label);

    }

    /**
     * Hier werden Aktionen durchgeführt.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == start){
            leinwand.setWert(groesse.getValue());
            leinwand.male(leinwand.getGraphics());
        }
    }
}
