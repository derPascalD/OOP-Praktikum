import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class tastaturEingaben implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Eingabe des Users von der Tastatur, die dann verarbeitet werden.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            WeihnachtsGUI.bewegeHoch = true;

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            WeihnachtsGUI.bewegeRunter = true;
        }
    }
    /**
     * Eingabe des Users von der Tastatur, die dann verarbeitet werden.
     */
    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            WeihnachtsGUI.bewegeHoch = false;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            WeihnachtsGUI.bewegeRunter = false;
        }
    }
}
