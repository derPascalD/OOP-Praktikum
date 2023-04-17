public class Rahmen {

    /**
     * In der Methode gebe ich den Inhalt eines Arrays mit einem Rahmen aus Sternchen aus.
     */
    public void rahmenBilden(String[] array) {

        if (array.length == 0 || array == null) {
            System.out.println("Array ist leer.");
            System.out.println();
            System.exit(0);
        }

        // Wert des längsten Wortes.
        int laenge = 0;

        // Hiermit schaue ich, was das längste Wort ist.
        for (int i = 0; i < array.length; i++) {

            if (array[i].length() > laenge) {
                laenge = array[i].length();
            }
        }

        for (int l = 0; l < laenge+4; l++) {
            System.out.print("*");
        }
        System.out.println();

        /*
        Hier sorge ich dafür, dass immer einzeln der Inhalt eines Arrays ausgegeben wird
        und die passenden Leerzeichen gesetzt werden, sowie die Sternchen.
         */
        for (int k = 0; k < array.length; k++) {

            System.out.print("* "+array[k]);
            for (int j = 0; j< laenge+2-array[k].length() ; j++) {

                if (j+1 == laenge+2-array[k].length()) {

                    System.out.print("*");
                }
                else  {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        for (int m = 0; m < laenge+4; m++) {
            System.out.print("*");
        }
        System.out.println("\n");
    }
}
