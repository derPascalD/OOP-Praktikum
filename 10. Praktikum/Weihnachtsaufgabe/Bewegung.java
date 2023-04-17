import java.util.Timer;
import java.util.TimerTask;

public class Bewegung {

    Timer bewegen;

    /**
     * Hier werden die Eingaben des Benutzers verarbeitet,
     * damit ein Objekt sich hoch und runterbewegt.
     */
    public Bewegung() {
        bewegen = new Timer();
        bewegen.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {

                if (WeihnachtsGUI.bewegeHoch) {

                    if (WeihnachtsGUI.y >= 20) {
                        WeihnachtsGUI.y -= 1;
                    }
                } else if (WeihnachtsGUI.bewegeRunter) {

                    if(WeihnachtsGUI.y <= 200) {
                        WeihnachtsGUI.y += 1;
                    }
                }
            }

        }, 0, 6);
    }
}
