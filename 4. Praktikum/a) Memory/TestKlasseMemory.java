public class TestKlasseMemory {

    public static void main(String[] args){

        Memory memory = new Memory();

        // Hier trägt man als Parameter einen Wert ein, um die größe des Spielfeldes zu bestimmen.
        memory.visuelleAusgabe(memory.generateField(4));
        memory.visuelleAusgabe(memory.generateField(6));
    }
}