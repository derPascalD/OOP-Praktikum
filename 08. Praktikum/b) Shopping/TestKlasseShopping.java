public class TestKlasseShopping {
    public static void main(String[] args) {

        Warenkorb warenkorb1 = new Warenkorb();
        Artikel buch1 = new Buch(1, 12.26, "Pascal Daniel", "Das Buch", 2022);
        Artikel buch2 = new Buch(4, 23.33, "Pascal Rene", "Das Raetsel", 2002);
        Artikel dvd1 = new DVD(3, 17.79, "Java: Ein Mysterium lebt", "2:21");
        Artikel kleidung1 = new Kleidung(2, 22.20, "T-Shirt", "M", "blau");
        Artikel kleidung2 = new Kleidung(7, 30.20, "Pullover", "L", "schwarz");

        warenkorb1.addArtikel(buch1);
        warenkorb1.addArtikel(buch2);
        warenkorb1.addArtikel(dvd1);
        warenkorb1.removeArtikel(buch1);
        warenkorb1.addArtikel(kleidung1);
        warenkorb1.addArtikel(kleidung2);

        warenkorb1.zeigeWarenkorb();
    }
}
