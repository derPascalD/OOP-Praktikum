public class SpielstaerkeRD {

    private int geschwindigkeitR;
    private int geschwindigkeitD;
    private int intelligenzR;
    private int intelligenzD;

    private int spielstaerkeD;
    private int spielstaerkeR;

    private int prozentZahl;
    private int minusPlus;

    Gui gui;
    SpielstaerkeRD(Gui gui){
        this.gui = gui;

    }

    /**
     * Hier setze ich die Spielstärken der Figuren.
     */
    void eigenschalftenSetzen(){


        geschwindigkeitD = (int) (Math.random()*3)+6;
        geschwindigkeitR = (int) (Math.random()*3)+6;
        intelligenzD = (int) (Math.random()*3)+6;
        intelligenzR = (int) (Math.random()*3)+6;
        prozentZahl = (int) (Math.random()*21);
        minusPlus = (int) (Math.random()*2);


        spielstaerkeD = geschwindigkeitD+intelligenzD*2;

        if(minusPlus == 1){
            prozentZahl = 100+prozentZahl;
            spielstaerkeD = (spielstaerkeD*prozentZahl)/100;


        }else{
            prozentZahl = 100-prozentZahl;
            spielstaerkeD = (spielstaerkeD*prozentZahl)/100;
        }

        prozentZahl = (int) (Math.random()*21);
        minusPlus = (int) (Math.random()*2);

        spielstaerkeR = 2*geschwindigkeitR +intelligenzR;

        if(minusPlus == 1){
            prozentZahl = 100+prozentZahl;
            spielstaerkeR = (spielstaerkeR*prozentZahl)/100;

        }else{
            prozentZahl = 100-prozentZahl;
            spielstaerkeR = (spielstaerkeR*prozentZahl)/100;
        }


        gui.getInformationD().setText("Spielstärke: "+spielstaerkeD);
        gui.getInformationR().setText("Spielstärke: "+spielstaerkeR);

    }

    public int getSpielstaerkeD() {
        return spielstaerkeD;
    }

    public void setSpielstaerkeD(int spielstaerkeD) {
        this.spielstaerkeD = spielstaerkeD;
    }

    public int getSpielstaerkeR() {
        return spielstaerkeR;
    }

    public void setSpielstaerkeR(int spielstaerkeR) {
        this.spielstaerkeR = spielstaerkeR;
    }
}
