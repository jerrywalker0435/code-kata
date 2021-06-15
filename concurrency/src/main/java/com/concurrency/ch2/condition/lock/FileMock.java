package com.concurrency.ch2.condition.lock;

/**
 * @author zhangyu201
 * @date 2021/6/15
 */
public class FileMock {
    private String[] content;
    private int index;


    public FileMock(int size,int length) {
        this.content = new String[size];
        for (int i = 0; i < size; i++) {
            StringBuffer buffer = new StringBuffer(length);
            for (int j = 0; j < length; j++) {
                int randomCharacter = (int) (Math.random()*255);
                buffer.append((char)randomCharacter);
            }
            content[i] = buffer.toString();
        }
        index = 0;
    }
    public boolean hasMoreLines(){
        return index < content.length;
    }

    public String getLine(){
        if (this.hasMoreLines()) {
            System.out.printf("Mock: %s\n",content.length-index);
            return content[index++];
        }
        return null;
    }

}
