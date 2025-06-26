package utils;

public interface Queue<T>
{
    public void Enqueue(T item);
    public T Dequeue();
    public T peek();
    public boolean isEmpty();
}
