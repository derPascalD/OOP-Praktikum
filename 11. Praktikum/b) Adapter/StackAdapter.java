public interface StackAdapter<T> {

    boolean empty();

    T push (T item);

    T pop();

    T peek();
}
