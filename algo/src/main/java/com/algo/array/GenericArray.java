package com.algo.array;

/**
 * @author zhangyu201
 * @date 2021/6/8
 */
public class GenericArray<T> {
    private T[] data;
    private int size;

    public GenericArray(int capacity){
        this.data = (T[])new Object[capacity];
        this.size = 0;
    }

    public GenericArray(){
        this(10);
    }

    public int getCapacity(){
        return this.data.length;
    }

    public int count(){
        return this.size;
    }
    public boolean isEmpty(){
        return size==0;
    }

    public void set(int index,T e) {
        checkIndex(index);
        data[index] = e;
    }
    public T get(int index){
        checkIndex(index);
        return data[index];
    }

    public boolean contains(T e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    public int find(T e){
        for (int i = 0; i < size ; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public void add(int index,T e){
        checkIndexForAdd(index);
        if(size == data.length){
            resize(2*data.length);
        }
        for (int i = size -1; i >= index ; i--) {
            data[i+1] = data[i];
        }
        data[index]=e;
        size++;
    }

    public void addFirst(T e){
        add(0,e);
    }

    public void addLast(T e){
        add(size,e);
    }

    public T remove(int index){
        checkIndex(index);
        T ret = data[index];

        for (int i = index + 1; i < size ; i++) {
           data[i-1] =data[i];
        }
        size--;
        data[size]=null;

        if(size==data.length/4 && data.length/2!=0){
            resize(data.length/2);
        }

        return ret;

    }

    public T removeFirst(){
        return remove(0);
    }

    public T removeLast(){
        return remove(size-1);
    }

    public T removeElement(T e){
        int index = find(e);
        if(index!=-1){
            return remove(index);
        }
        return null;
    }


    private void resize(int capacity) {
        T[] newData = (T[])new Object[capacity];
        for (int i = 0; i < size ; i++) {
           newData[i] = data[i];
        }
        data = newData;
    }
    private void checkIndex(int index) {
        if(index<0 || index>=size){
            throw new IllegalArgumentException("index illegal");
        }
    }
    private void checkIndexForAdd(int index) {
        if(index<0 || index>size){
            throw new IllegalArgumentException("index illegal");
        }
    }
}
