package com.demo;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author liuxi
 * 线程池创建线程的方法
 * 线程池的物种主要参数
 * 1.线程同时执行数量
 * 2.线程的最大数量
 * 3.空闲线程的存活时间
 * 4.空间线程的存活时间单位
 * 5.线程队列，corePoolSize 满了的时候，将线程放入队列
 * 6.创建线程的工厂
 * 7.拒绝策略（当线程池中的数量超过maximumPoolSize时执行）
 */
public class ThreadTest {

    public static void main(String[] args) {

        ThreadPoolExecutor tol = new ThreadPoolExecutor(2, 5, 1000,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);

    }
}

class TaskCallable implements Callable<Boolean> {
    private int ina;

    private TaskCallable(int ina) {
        this.ina = ina;
    }

    @Override
    public Boolean call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "ina");
        if (ina / 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
