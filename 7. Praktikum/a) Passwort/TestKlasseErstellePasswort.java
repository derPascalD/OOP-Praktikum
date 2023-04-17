public class TestKlasseErstellePasswort {

    public static void main(String[] args) {

        PasswortGenerator passwort1 = new PasswortGenerator();
        PasswortGenerator passwort2 = new PasswortGenerator();

        passwort1.erstellePasswort("java ist eine objekt-orientierte sprache");
        passwort2.erstellePasswort("Java ist auch eine Insel (von Christian Ullenboom)");

        passwort1.ausgabePasswort();
        passwort2.ausgabePasswort();
    }
}