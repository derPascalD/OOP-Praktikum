public class TestKlasseBild {

    public static void main(String[] args)  {

        Bild bild = new Bild();
        bild.leseBild("C:/Users/pasca/desktop/java.pgm");

        bild.rotiereBild();
        bild.schreibeBild("C:/Users/pasca/desktop/");
    }
}
