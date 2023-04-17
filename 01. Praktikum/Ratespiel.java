import java.util.Scanner;

public class Ratespiel {

	public static void main(String[] args) {

		// Methode rateZahl() wird Aufgerufen in der main Methode.
		rateZahl();
	}
	/**
	 * Die Methode rateZahl() beinhaltet einen Algorithmus der dafür sorgt, das
	 * eine Zahl zwischen 0-100 generiert wird und man versuchen muss sie zu erraten.
	 * Habe hier eine WHile Schleife mit Bedingungen benutzt, die erst endet
	 * wenn die eingegebene Zahl richtig erraten wurde.
	 */
	public static void rateZahl() {

		// Eine Zahl zwischen 0-100 wird hier zufällig generiert.
		int randomNumber = (int) (Math.random() * 101.0);

		// Die Variable "versuche" speichert die Versuche.
		int versuche = 0;

		// Ausgabe für den Benutzer, was genau man machen soll.
		System.out.println("//Willkommen beim Zahlenratenspiel//");
		System.out.println("Bitte tippen Sie eine Zahl zwischen 0 und 100 ein!");

		while (true) {

			Scanner sc = new Scanner(System.in);

			/*
			Hier wird die Methode nextInt(); aus der Klasse Scanner aufgerufen und in die
			Variable readInt gespeichert.
			 */
			int readInt = sc.nextInt();

			// Addiert immer 1 hinzu.
			versuche++;

			//  In der if Bedingung wird geschaut, ob die Zufallszahl mit der eingabe Zahl übereinstimmt.
			if (randomNumber == readInt) {

				// Ausgabe für den User wenn die Zahl erfolgreich erraten wurde.
				System.out.println("Geschafft! Die Zufallszahl war " + randomNumber);
				System.out.println("Du hast " + versuche + " Versuche dafür gebraucht");

				// Beendet die Schleife und das Programm wenn die if Bedingung erfüllt ist.
				break;

				// Die Bedingung sorgt dafür das geschaut wird, ob die eingegebene Zahl größer als die Zufallszahl ist.
			} else if (randomNumber < readInt) {

				// Gibt dem User den Tipp das die Zufallszahl kleiner sein muss.
				System.out.println("Zufallszahl ist kleiner!");
				System.out.println("Versuchen Sie es erneut");

				// Wenn keiner der anderen Bedingungen zutrifft, wird die else Bedingung ausgeführt.
			} else {

				// Gibt dem User den Tipp das die Zufallszahl groesser sein muss.
				System.out.println("Zufallszahl ist groesser");
				System.out.println("Beim naechsten Versuch, bist du ein Schritt weiter;)");
			}
		}
	}
}
