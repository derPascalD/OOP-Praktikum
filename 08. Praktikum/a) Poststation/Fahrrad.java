public class Fahrrad {
    private int ladung = 0;
    private final int maxSpeed;

    private Fahrrad next = null;

    Fahrrad(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    int speed() {

    if (ladung >= maxSpeed) {
            System.out.println("Ladung zu hoch, Fahrraeder bleiben stehen.");
            System.exit(0);
        } else {

        }
        return maxSpeed - ladung;
    }

    public void setLadung(int anzahl) {
        ladung = anzahl;
    }

    public Fahrrad getNext() {
        return next;
    }

    public void setNext(Fahrrad next) {
        this.next = next;
    }

    public int getLadung() {
        return ladung;
    }
}
