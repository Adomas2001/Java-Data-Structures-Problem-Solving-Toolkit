package utils;

import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T>{

    private int front, rear;
    private T[] qArray;

    int max=20;


    public ArrayQueue()
    {
        this.front=this.rear=-1;
        this.qArray= (T[]) new Object[max];
    }
    @Override
    public void Enqueue(T item)
    {
        if (isFull())
        {
            resize();
        }
        if(isEmpty()){
            front++;
        }
        qArray[++rear] = item;
    }
    private void resize() {
        int newSize = qArray.length * 2;
        var tempArray = (T[]) new Object[newSize];

        for (int i = 0; i < qArray.length; i++) {
            tempArray[i] = qArray[i];
        }
        qArray = tempArray;
    }

    @Override
    public T Dequeue()
    {
        if(isEmpty())
            throw new NoSuchElementException();
        T temp = qArray[front];
        if (front==rear)
            front = rear = -1;
        else
            front++;
        return temp;

    }

    @Override
    public T peek() {
        if(isEmpty())
            throw new NoSuchElementException();
        return qArray[front];
    }

    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull()
    {
        return rear == qArray.length-1;
    }
}
