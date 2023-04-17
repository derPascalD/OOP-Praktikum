public class TestKlasseBruch {
    public static void main(String[] args) {

        Bruch bruch1 = new Bruch(-2,2);
        Bruch bruch2 = new Bruch(1,-2);
        Bruch addition = bruch1.add(bruch2);
        Bruch multiplikation = bruch1.multiply(bruch2);

        System.out.println("Bruch 1: "+bruch1);
        System.out.println("");
        System.out.println("Bruch 2: "+bruch2);
        System.out.println();
        System.out.println("Addition:");
        System.out.println(addition.toString());
        System.out.println("");
        System.out.println("Multiplikation:");
        System.out.println(multiplikation.toString());
    }
}