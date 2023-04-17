public class TestKlassePoststation {
    public static void main(String[] args) {
        Fahrrad titanic = new Fahrrad(27);
        Fahrrad poseidon = new Fahrrad(20);
        Fahrrad zeus = new Fahrrad(25);
        Fahrrad prometheus = new Fahrrad(25);
        Fahrrad adler= new Fahrrad(15);

        Fahrradgruppe gruppeAlpha = new Fahrradgruppe();

        gruppeAlpha.addFahrrad(titanic);
        gruppeAlpha.addFahrrad(poseidon);
        gruppeAlpha.addFahrrad(zeus);
        gruppeAlpha.addFahrrad(prometheus);
        gruppeAlpha.addFahrrad(adler);

        System.out.println("Reisegeschwindigkeit: "+ gruppeAlpha.reisegeschwindigkeit() +" km/h");
        gruppeAlpha.addLadung(6);
        System.out.println("Reisegeschwindigkeit: "+ gruppeAlpha.reisegeschwindigkeit() +" km/h");
        gruppeAlpha.addLadung(40);
        System.out.println("Reisegeschwindigkeit: "+ gruppeAlpha.reisegeschwindigkeit() +" km/h");
    }
}