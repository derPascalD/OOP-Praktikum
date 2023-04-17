
// die Klasse Lebewesen ist hier in dem fall eine Oberklasse, da die Unterklassen Attribute udn Methoden erben
public class Lebewesen {
    private String bezeichnung;

    /**Die Methode bekommt einen Parameter übergeben, der dann in der Bezeichnung abgespeichert wird
     *
     * @param derName
     */
    public void setzeBezeichnung(String derName) {

        bezeichnung = derName;
    }

    /** Mit dieser Methode kann man die Bezeichnung zurückgeben
     *
     * @return
     */
    public String rueckgabeBezeichnung() {

        return bezeichnung;
    }
}


