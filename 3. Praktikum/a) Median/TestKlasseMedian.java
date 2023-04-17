public class TestKlasseMedian {

    public static void main(String[] args) {

        int[] array1 = {12,16,2,63,55,8};
        int[] array2 = {42,7,543,77,87,876,143};

        Median medianBerechnen = new Median();
        System.out.println("Beim Array 1 ist der Median: " + medianBerechnen.median(array1)+".");
        System.out.println("Beim Array 2 ist der Median: " + medianBerechnen.median(array2)+".");
    }
}