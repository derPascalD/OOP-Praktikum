// Durch das Schlüsselwort "extends" erbt Pflanze die Methoden und Attribute der Klasse Lebewesen
public class Tier extends Lebewesen {

        // Instanzvariablen die geschützt sind und nur in der Klasse aufrufbar sind
        private String isstPflanzen = "-";
        private String isstTiere = "-";

        /**
         * Die Methode fresssart() sorgt dafür, das geschaut wird, ob die Nahrung des Tieres ein Tier,
         * eine Pflanze oder beides ist. Je nachdem was das tier frisst, wird seine jeweilige fressart ausgegeben.
         * Die fressart wird dann in der Methode abgespeichert und
         * kann in der main Methode aufgerufen werden und ausgegeben werden
         */
        public String fressart() {

                if (this.isstPflanzen != "-" && this.isstTiere == "-") {

                        return " ist ein Pflanzenfresser.";

                }
                else if (this.isstTiere != "-" && this.isstPflanzen == "-") {

                        return " ist ein Fleischfresser.";
                }
                else if  (this.isstTiere == "-" && this.isstPflanzen == "-") {

                        return "";
                }
                else {
                        return  " ist ein Allesfresser.";
                }
        }
        /**
         * In dieser Methode wird ein Objekt der Klasse Pflanze übergeben. Pflanze ist in dem Fall der Datentyp.
         * Die Methode sorgt dafür, dass das Objekt der Klasse Pflanze die Nahrung übergibt und es in der
         * Variable isstPflanze abspeichert.
         *
         * @param futter
         */
        public void uebergabePflanzenFutter(Pflanze futter) {

            isstPflanzen = futter.rueckgabeBezeichnung();
        }

        /**
         * In dieser Methode wird ein Objekt der Klasse Tier übergeben. Tier ist in dem Fall der Datentyp.
         * Die Methode sorgt dafür, dass das Objekt der Klasse Tier die Nahrung übergibt und es in der
         * Variable isstTiere abspeichert.
         *
         * @param futter
         */
        public void uebergabeTierFutter(Tier futter) {

            isstTiere = futter.rueckgabeBezeichnung();
        }
}



