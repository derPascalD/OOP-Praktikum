public class TestKlasseBild {

    public static void main(String[] args) {

        Bild bild1 = new Bild();
        Bild bild2 = new Bild();

        int[][] array1 = {
                {1,1,0,1},
                {0,1,0,1},
                {0,1,1,1},
                {1,0,1,0}
        };

        int[][] array2 = {
                {0,0,1,1,0},
                {0,1,0,1,1},
                {1,0,0,1,1},
                {0,1,0,1,0}
        };

        bild1.setArrayD(array1);
        bild1.flipAndInvert();

        bild2.setArrayD(array2);
        bild2.flipAndInvert();
    }
}
