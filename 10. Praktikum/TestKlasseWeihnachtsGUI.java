
public class TestKlasseWeihnachtsGUI {

    public static void main(String[] args) {

        WeihnachtsGUI gui = new WeihnachtsGUI();
        gui.setTitle("WeihnachtsGUI");

        // Damit lässt sich das Fenster nicht mehr verkleinern und vergrößern.
        gui.setResizable(false);

        // Setzt die größe des Fensters
        gui.setSize(1500, 1000);

        // Wird das Fenster sichtbar oder nicht sichtbar gemacht.
        gui.setVisible(true);
    }
}
