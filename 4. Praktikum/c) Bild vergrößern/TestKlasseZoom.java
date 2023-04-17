public class TestKlasseZoom {

    public static void main(String[] args) {

        int[][] array1 = {
                {1,7,0},
                {1,0,3},
                {0,2,1},
        };

        int[][] array2 = {
                {1,0,2},
                {4,2,4},
                {2,0,1},
        };

        Zoom zoom1 = new Zoom(array1);
        Zoom zoom2 = new Zoom(array2);

        // Als Parameter übergibt man hier den Vergrößerungsfaktor.
        ausgabeBild(zoom1.zoom(2));
        ausgabeBild(zoom1.zoom(3));

        ausgabeBild(zoom2.zoom(2));
        ausgabeBild(zoom2.zoom(3));
    }

    // Die Methode sorgt beim Aufruf dafür, dass das Array bzw. das Spielfeld in der Konsole ausgegeben wird.
    public static void ausgabeBild(int[][] arrayD) {

        System.out.println("Ausgabe:");
        for (int i = 0; i < arrayD.length; i++) {
            for (int j = 0; j < arrayD[i].length; j++) {
                System.out.print(arrayD[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
