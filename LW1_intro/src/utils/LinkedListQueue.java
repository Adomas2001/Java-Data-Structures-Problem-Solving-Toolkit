package utils;

import java.util.EmptyStackException;

public class LinkedListQueue<T> implements Queue<T> {

    private static class StudNode<T>
    {
        private T Data  ;
        private StudNode<T> Next;
        private StudNode<T> Previous;

        private StudNode(T data)
        {

        }
        private StudNode(T data, StudNode<T> NAddress, StudNode<T> PAddress)
        {
            this.Data= data;
            this.Next= NAddress;
            this.Previous= PAddress;
        }
    }

    public LinkedListQueue()
    {
        this.head=null;
        this.tail=null;
    }
    public StudNode<T> head;
    public StudNode<T> tail;

    @Override
    public void Enqueue(T item) 
    {
        StudNode<T> p = new StudNode<T>(item, null, tail);
        if (tail != null)
            tail.Next = p;
        else
            head = p;
        tail = p;
    }

    @Override
    public T Dequeue() {
        if(!isEmpty())
        {
            T first= head.Data;
            head=head.Next;
            return first;
        }
        throw new EmptyStackException();
    }

    @Override
    public T peek()
    {
        if(!isEmpty())
        {
            return head.Data;
        }
        throw new EmptyStackException();
    }

    @Override
    public boolean isEmpty()
    {
        if(head == null)
            return true;
        else
            return false;
    }
}
