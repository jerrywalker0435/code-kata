package com.algo.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyu201
 * @date 2021/6/10
 */
public class LRUBasedArray<T> {

    private static final int DEFAULT_CAPACITY=(1<<3);

    private int capacity;

    private int count;

    private T[] value;

    private Map<T,Integer> holder;


    public LRUBasedArray(){
        this(DEFAULT_CAPACITY);
    }

    public LRUBasedArray(int capacity) {
        this.capacity = capacity;
        value =(T[]) new Object[capacity];
        count = 0;
        holder = new HashMap<T, Integer>(capacity);
    }

    public void offer(T object){
        if (object == null) {
            throw new IllegalArgumentException("缓存容器不支持null");
        }
        Integer index = holder.get(object);
        if (index == null) {
            if (isFull()) {
                removeAndCache(object);
            }else {
                cache(object,count);
            }
        } else {
          update(index);
        }
    }

    public void update(Integer end) {
        T target = value[end];
        rightShift(end);
        value[0] = target;
        holder.put(target,0);
    }

    public void cache(T object,int end){
        rightShift(end);
        value[0] = object;
        holder.put(object,0);
        count++;
    }

    public boolean isContain(T object){
        return holder.containsKey(object);
    }
    public boolean isEmpty(){
        return count == 0;
    }

    private void rightShift(int end) {
        for (int i = end -1; i >= 0; i--) {
            value[i+1] = value[i];
            holder.put(value[i],i+1);
        }
    }

    private void removeAndCache(T object) {
        T key = value[--count];
        holder.remove(key);
        cache(object,count);
    }


    private boolean isFull() {
        return count == capacity;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(value[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("===无参测试===");
        LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
        lru.offer(1);
        lru.offer(2);
        lru.offer(3);
        lru.offer(4);
        System.out.println(lru);
        lru.offer(5);
        lru.offer(6);
        lru.offer(7);
        lru.offer(8);
        System.out.println(lru);
        lru.offer(9);
        lru.offer(1);

        System.out.println(lru);




    }
}
