package utils;

import java.util.EmptyStackException;
import java.util.Iterator;

public class LinkedListStack<T> implements Stack<T> {


    private static class StudentNode<T> {
        private T Data;
        private StudentNode<T> Next;
        private StudentNode<T> Previous;

        private StudentNode(T data) {

        }

        private StudentNode(T data, StudentNode<T> NAddress, StudentNode<T> PAddress) {
            this.Data = data;
            this.Next = NAddress;
            this.Previous = PAddress;
        }

    }

    public StudentNode<T> head;
    public StudentNode<T> tail;


    public LinkedListStack() {
        this.head = null;
        this.tail = null;

    }

    @Override
    public void push(T item) {
        StudentNode<T> p = new StudentNode<T>(item, head, null);
        if (!isEmpty())
            head.Previous = p;
        else
            tail = p;
        head = p;
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            T last = head.Data;
            //head.Next.Previous =null;
            head = head.Next;
            return last;
        }
        throw new EmptyStackException();
    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return head.Data;
        }
        throw new EmptyStackException();
    }

    @Override
    public boolean isEmpty() {
        if (head == null)
            return true;
        else
            return false;
    }
}




