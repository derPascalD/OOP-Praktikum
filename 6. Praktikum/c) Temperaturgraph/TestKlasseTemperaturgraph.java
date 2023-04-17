public class TestKlasseTemperaturgraph {

    public static void main(String[] args) {

        Temperaturgraph temperaturgraph = new Temperaturgraph(2004);

        temperaturgraph.addTemperatur(1,15);
        temperaturgraph.addTemperatur(2,14);
        temperaturgraph.addTemperatur(3,13);
        temperaturgraph.addTemperatur(4,15);
        temperaturgraph.addTemperatur(5,11);
        temperaturgraph.addTemperatur(6,11);
        temperaturgraph.addTemperatur(7,12);
        temperaturgraph.addTemperatur(8,13);
        temperaturgraph.addTemperatur(9,11);
        temperaturgraph.addTemperatur(10,12);
        temperaturgraph.addTemperatur(11,11);
        temperaturgraph.addTemperatur(12,11);

        temperaturgraph.plotGraph();
    }
}
