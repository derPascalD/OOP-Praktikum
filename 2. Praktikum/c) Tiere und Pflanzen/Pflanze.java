// Durch das Schlüsselwort "extends" erbt Pflanze die Methoden und Attribute der Klasse Lebewesen
public class Pflanze extends Lebewesen {
    private String textuelleBeschreibung;

    /** Die Methode bekommt ein Parameter übergeben, der dann in der textuellen Beschreibung abgespeichert wird
     *
     * @param derName
     */
    public void setzeBeschreibung(String derName){

        this.textuelleBeschreibung = derName;
    }

    /**Die Methode kann die textuelle Beschreibung zurückgeben
     *
     * @return
     */
    public String rueckgabeTextuelleBeschreibung() {

        return textuelleBeschreibung;
    }
}
