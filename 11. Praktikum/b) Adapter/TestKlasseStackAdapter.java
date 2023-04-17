public class TestKlasseStackAdapter {

    public static void main(String[] args) {

        StackAdapter<Integer> test1 = new Stacktest<>();

        System.out.println("Item "+ test1.push(3)+" Oben drauf gelegt.");
        System.out.println("Item "+ test1.push(5)+" Oben drauf gelegt.");
        System.out.println("Item "+ test1.push(10)+" Oben drauf gelegt.");
        System.out.println("Inhalt: "+ test1.empty());
        System.out.println("Oberstes Item: " +test1.peek());
        System.out.println("Geloeschtes Item: " +test1.pop());
        System.out.println("Oberstes Item: " +test1.peek());
        System.out.println("Geloeschtes Item: " +test1.pop());
        System.out.println("Oberstes Item: " +test1.peek());
        System.out.println("Geloeschtes Item: " +test1.pop());
        System.out.println("Inhalt: "+ test1.empty());
        System.out.println("Oberstes Item: " +test1.peek());
    }
}
