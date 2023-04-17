
public class TestKlasseDatenverarbeitung {
    public static void main(String[] args) {

        Datenverarbietung a1 = new Abstand1();
        a1.ladenVerarbeitenSpeichern("src/iris-2.data.txt");

        Datenverarbietung a2 = new Abstand2();
        a2.ladenVerarbeitenSpeichern("src/iris-2.data.txt");
    }
}
