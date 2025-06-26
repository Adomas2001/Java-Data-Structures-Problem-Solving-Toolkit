package utils;

import java.util.EmptyStackException;
import java.util.Iterator;

public class ArrayStack<T> implements Stack<T> {

    private int Max = 20;
    private int size;
    private T[] stack;
    private int top;

    public ArrayStack() {
        this.size = 0;
        this.stack = (T[]) new Object[Max];
        this.top = -1;
    }

    private void resize() {
        int newSize = stack.length * 2;
        var tempArray = (T[]) new Object[newSize];

        for (int i = 0; i < stack.length; i++) {
            tempArray[i] = stack[i];
        }
        stack = tempArray;
    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return stack[top];
        }
        throw new EmptyStackException();
    }

    @Override
    public void push(T item) {
        if (isFull()) {
            resize();
        }
        stack[++top] = item;
        size++;
    }

    private boolean isFull() {
        return size == Max;
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            T remove = peek();
            top--;
            size--;
            return remove;
        }
        throw new EmptyStackException();
    }


    @Override
    public boolean isEmpty() {
        return top < 0;
    }

}
