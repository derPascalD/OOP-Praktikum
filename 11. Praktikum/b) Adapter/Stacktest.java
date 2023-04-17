import java.util.ArrayList;

public class Stacktest<T> implements StackAdapter<T>{

    ArrayList<T> stack = new ArrayList<>();

    /**
     * Wird überprüft, ob der Inhalt des Arrays Leer ist oder nicht.
     */
    @Override
    public boolean empty() {
        if(stack.size() > 0){
            return true;
        }else{
            return false;
        }
    }
    /**
     * Wird ein Item hinzugefügt und gibt es zurück.
     */
    @Override
    public T push(T item) {
        stack.add(item);
        return (item);
    }

    /**
     * Wird ein Item gelöscht und das gelöschte Item wird zurückgegeben.
     */
    @Override
    public T pop() {
        if(stack.size() > 0){
            return stack.remove(stack.size()-1);
        }else{
            throw new RuntimeException();
        }
    }

    /**
     * Gibt aus, was das letzte Item in der Arraylist ist.
     */
    @Override
    public T peek() {
        if(stack.size() > 0){

            return stack.get(stack.size()-1);

        }else{
            throw new RuntimeException();
        }
    }
}
