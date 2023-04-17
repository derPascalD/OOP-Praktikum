public class TestKlasseOOPCode {
    public static void main(String[] args) {

        int[][] bild1 = {
                {1,0,0},
                {0,0,1},
                {0,0,0},
        };
        int[][] bild2 = {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,1},
                {0,0,0,1}
        };

        OOPCode oopCode1 = new OOPCode(bild1);
        oopCode1.ausgabeBild();
        System.out.println("OOPCode ist: "+ oopCode1.oopCodeSumme()+"\n");
        System.out.println("Maximaler OOPCode: "+ oopCode1.maxOOPCode()+"\n");
        System.out.println("Anzahl der Drehungen: "+ oopCode1.getMaxDrehung()+"\n");

        OOPCode oopCode2 = new OOPCode(bild2);
        oopCode2.ausgabeBild();
        System.out.println("OOPCode ist: "+ oopCode2.oopCodeSumme()+"\n");
        System.out.println("Maximaler OOPCode: "+ oopCode2.maxOOPCode()+"\n");
        System.out.println("Anzahl der Drehungen: "+ oopCode2.getMaxDrehung()+"\n");
    }
}
