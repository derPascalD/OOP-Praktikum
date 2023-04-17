public class TestKlasseTicTacToe {
    public static void main(String[] args) {
        TicTacToe spielfeld1 = new TicTacToe();
        spielfeld1.zeigeSpielfeld();
        spielfeld1.macheZug(0,0);
        spielfeld1.zeigeSpielfeld();
        spielfeld1.macheZug(0,1);
        spielfeld1.zeigeSpielfeld();
        spielfeld1.macheZug(1,1);
        spielfeld1.zeigeSpielfeld();
        spielfeld1.macheZug(1,0);
        spielfeld1.zeigeSpielfeld();
        spielfeld1.macheZug(2,2);
        spielfeld1.zeigeSpielfeld();
    }
}
