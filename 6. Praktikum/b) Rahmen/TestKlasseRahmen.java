public class TestKlasseRahmen {

    public static void main(String[] args) {

        String [] array1 = new String[]{"Rahmen","sind","toll"};
        String [] array2 = new String[]{"Das ist","ein","Test"};

        Rahmen rahmen = new Rahmen();

        rahmen.rahmenBilden(array1);
        rahmen.rahmenBilden(array2);
    }
}
