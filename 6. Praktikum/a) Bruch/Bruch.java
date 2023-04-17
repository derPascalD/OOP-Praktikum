public class Bruch {

    private int zaehler;
    private int nenner;

    Bruch(int zaehler, int nenner) {

        // Hier überprüfe ich Minus Zahlen und wandel sie um.
        if (zaehler > 0 && nenner < 0 ) {

            nenner = nenner * -1;
            zaehler = zaehler * -1;
        } else if (nenner < 0 && zaehler < 0) {
            nenner = nenner * -1;
        }

        this.zaehler = zaehler;

        // Überprüfung ob der Nenner 0 ist.
        if (nenner == 0) {
            System.out.println("Der Nenner darf nicht 0 sein.");
            System.exit(0);
        }
        else{

            this.nenner = nenner;
        }
    }

    /**
     * Hier werden die 2 Brüche miteinander addiert und in ein neues Objekt gepackt.
     */
    Bruch add(Bruch f) {


        int neuerZaehler;
        int neuerNenner = this.nenner;

        if (f.nenner == nenner) {

            neuerZaehler = f.zaehler + zaehler;
        } else {
            neuerZaehler = (f.nenner * zaehler) + (nenner * f.zaehler);
            neuerNenner = this.nenner * f.nenner;
        }
        Bruch a = new Bruch(neuerZaehler, neuerNenner);
        return a;
    }

    /**
     * Hier werden die 2 Brüche miteinander multipliziert und in ein neues Objekt gepackt.
     */
    Bruch multiply(Bruch f) {

        int neuerZaehler;
        int neuerNenner;

        neuerZaehler = f.zaehler * this.zaehler;
        neuerNenner = f.nenner * this.nenner;

        Bruch b = new Bruch(neuerZaehler, neuerNenner);

        return b;
    }

    /**
     * Mit der Methode gebe ich die Brüche aus.
     */
    public String toString() {

        return this.zaehler + "/" + this.nenner;
    }
}

