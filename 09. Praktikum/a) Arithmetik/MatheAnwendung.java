public class MatheAnwendung {

    public static void main(String[] args) {
        RechenwegMal multiplikation= new RechenwegMal();
        RechenwegPlus addition = new RechenwegPlus();
        RechenwegMinus subtraktion = new RechenwegMinus();

        System.out.println("Arithmetik");

        Arithmetik arithmetik = new Arithmetik();
        arithmetik.bestimmeRechenweg(multiplikation);
        System.out.println("Ergebnis: "+ arithmetik.berechne(3.5,2.0));
        arithmetik.bestimmeRechenweg(addition);
        System.out.println("Ergebnis: "+ arithmetik.berechne(3.5,2.0));
        arithmetik.bestimmeRechenweg(subtraktion);
        System.out.println("Ergebnis: "+ arithmetik.berechne(3.5,2.0));


        System.out.println("\nArithmetik Generisch");
        ArithmetikGenerisch<Rechenweg> arithmetikGenerisch = new ArithmetikGenerisch<>();
        arithmetikGenerisch.bestimmeRechenweg(multiplikation);
        System.out.println("Ergebnis: "+ arithmetikGenerisch.berechne(5.4,2.8));
        arithmetikGenerisch.bestimmeRechenweg(addition);
        System.out.println("Ergebnis: "+ arithmetikGenerisch.berechne(3.5,2.5));
        arithmetikGenerisch.bestimmeRechenweg(subtraktion);
        System.out.println("Ergebnis: "+ arithmetikGenerisch.berechne(3.5,2.5));

    }
}