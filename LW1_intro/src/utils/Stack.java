package utils;

import java.util.Iterator;

public interface Stack<T>  {

    public void push(T item);

    public T pop();

    public T peek();

    public boolean isEmpty();


}
