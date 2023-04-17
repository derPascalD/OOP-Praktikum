public class BioTest {
    public static void main(String[] args) {

        // Wird ein Objekt der Klasse Pflanze erstellt
        Pflanze alge = new Pflanze();
        alge.setzeBezeichnung("Alge");
        alge.setzeBeschreibung("Silber");

        Pflanze gras = new Pflanze();
        gras.setzeBezeichnung("Gras");
        gras.setzeBeschreibung("Gruen");

        Pflanze beeren = new Pflanze();
        beeren.setzeBezeichnung("Beeren");
        beeren.setzeBeschreibung("Rot");

        // Wird ein Objekt der Klasse Tier erstellt
        Tier fisch = new Tier();
        fisch.setzeBezeichnung("Fisch");
        fisch.uebergabePflanzenFutter(alge);

        Tier zebra = new Tier();
        zebra.setzeBezeichnung("Zebra");
        zebra.uebergabePflanzenFutter(gras);

        Tier baer = new Tier();
        baer.setzeBezeichnung("Baer");
        baer.uebergabePflanzenFutter(beeren);
        baer.uebergabeTierFutter(fisch);

        Tier loewe = new Tier();
        loewe.setzeBezeichnung("Loewe");
        loewe.uebergabeTierFutter(zebra);

        // Gibt aus, welches Tier ein Fleischfresser, Pflanzenfresser oder Allesfresser ist
        System.out.println(zebra.rueckgabeBezeichnung() + zebra.fressart());
        System.out.println(loewe.rueckgabeBezeichnung() + loewe.fressart());
        System.out.println(baer.rueckgabeBezeichnung() + baer.fressart());
    }
}
