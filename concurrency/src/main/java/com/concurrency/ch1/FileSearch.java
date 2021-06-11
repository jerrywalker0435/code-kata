package com.concurrency.ch1;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangyu201
 * @date 2021/6/10
 */
public class FileSearch implements Runnable{
    private String initPath;
    private String fileName;

    public FileSearch(String initPath, String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        File file = new File(initPath);
        if(file.isDirectory()){
            try {
                directoryProcess(file);
            } catch (InterruptedException exception) {
                System.out.printf("%s:The search has been interrupted",Thread.currentThread().getName());
            }
        }
    }

    private void directoryProcess(File file) throws InterruptedException {
        File list[] = file.listFiles();
        if (list!=null) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].isDirectory()) {
                    directoryProcess(list[i]);
                }else {
                    fileProcess(file);
                }
            }
            if (Thread.interrupted()) {
                System.out.println("throw interrupte excpetion");
                throw new InterruptedException();
            }
        }
    }

    private void fileProcess(File file) throws InterruptedException {
        if (file.getName().equals(fileName)) {
            System.out.printf("%s:%s\n",Thread.currentThread().getName(),file.getAbsolutePath());
        }

        if(Thread.interrupted()){
            throw new InterruptedException();
        }
    }

    public static void main(String[] args) {
        FileSearch searcher = new FileSearch("/Users/jerry.zhang/WorkSpace/practice/code-kata","rose");
        Thread thread = new Thread(searcher );
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        thread.interrupt();

    }
}
