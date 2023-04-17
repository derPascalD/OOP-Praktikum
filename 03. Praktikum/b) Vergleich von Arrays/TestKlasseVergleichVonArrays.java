public class TestKlasseVergleichVonArrays {

    public static void main(String[] args) {

        // Erstellung von zwei Arrays
        int [] a = {1,2,3,4};
        int [] b = {3,1,6,2};

        int [] x = {3,5,1,3};
        int [] y = {1,5,3,3};

        VergleichVonArrays vergleichVonArrays = new VergleichVonArrays();

        System.out.println("Vergleich a mit b: " +vergleichVonArrays.isEqual(a,b));
        System.out.println("Vergleich x mit y: " +vergleichVonArrays.isEqual(x,y));
    }
}
