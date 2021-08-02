package com.concurrency.ch4.s1;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zhangyu201
 * @date 2021/8/2
 */
public class Server {
    private final ThreadPoolExecutor executor;

    public Server() {
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        RejectedTaskController controller = new RejectedTaskController();
        executor.setRejectedExecutionHandler(controller);
    }
    public void executeTask(Task task){
        System.out.printf("Server: A new task has arrived\n");
        executor.execute(task);
        System.out.printf("Server: Pool Size:%d\n",executor.getPoolSize());
        System.out.printf("Server: Active Count:%d\n",executor.getActiveCount());
        System.out.printf("Server: Task Count:%d\n",executor.getTaskCount());
        System.out.printf("Server: Task Completed Tasks:%d\n",executor.getCompletedTaskCount());
    }

    public void endServer(){
        executor.shutdown();
    }

    public static void main(String[] args) {
        Server server = new Server();
        System.out.printf("Main: Starting.\n");
        for (int i = 0; i < 100; i++) {
            Task task = new Task("Task"+i);
            server.executeTask(task);
        }
        System.out.printf("Main: Shutting down the Executor.\n");
        server.endServer();
        System.out.printf("Main: Sending another Task.\n");
        Task task = new Task("Rejected Task");
        server.executeTask(task);
        System.out.printf("Main: End.\n");
    }

}
