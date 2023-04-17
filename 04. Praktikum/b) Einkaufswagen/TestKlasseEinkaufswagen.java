public class TestKlasseEinkaufswagen {

    public static void main(String[] args) {

        Einkaufswagen cart = new Einkaufswagen();

        cart.size();
        cart.addToCart("Birne");
        cart.addToCart("Salat");
        cart.addToCart("Paprika");
        cart.showContent();
        cart.size();
        cart.removeFromCart("Salat");
        cart.showContent();
        cart.size();
        cart.addToCart("Tomate");
        cart.addToCart("Fisch");
        cart.showContent();
        cart.size();
        cart.addToCart("Chips");
        cart.showContent();
        cart.size();
        cart.addToCart("Spiel");
    }
}