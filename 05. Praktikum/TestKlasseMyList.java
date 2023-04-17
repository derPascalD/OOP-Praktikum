public class TestKlasseMyList {
    public static void main(String[] args) {

        MyList list = new MyList();

        list.addToList(0, 1);
        list.addToList(1, 6);
        list.addToList(0, 5);
        list.addToList(1, 1);
        list.addToList(1, 1);
        list.addToList(2, 3);
        list.addToList(2, 3);
        list.addToList(2, 4);
        System.out.println("");
        list.ausgabe();

        list.removeFromList(1);
        System.out.println("");
        list.ausgabe();

        list.kombiZahl(12);
        System.out.println("");

        list.sortList();
        System.out.println("Sortiert:");
        list.ausgabe();

        System.out.println(list.removeDuplicates()+" Element/e geloescht.");
        System.out.println("");
        list.ausgabe();


    }
}