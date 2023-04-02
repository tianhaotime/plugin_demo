package com.example.myapplication;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

import okhttp3.OkHttpClient;

public class App extends Application {
    ThreadPoolExecutor executor;
    @Override
    public void onCreate() {
        super.onCreate();
//        PriorityBlockingQueue<Runnable> workQueue = new PriorityBlockingQueue<Runnable>(10, Comparator.reverseOrder());
//        PriorityBlockingQueue<Integer> p1 = new PriorityBlockingQueue<Integer>();
//
//        for (int i = 0; i < 5; i++) {
//            p1.add(new Random().nextInt(100));
//        }
//        for (int i = 0; i < 5; i++) {
//            Log.d("aaa",""+p1.peek());
//        }
//        Iterator<Integer> iterator = p1.iterator();
//        while (iterator.hasNext()){
//            Log.d("aaa","---"+iterator.next());
//        }
        AtomicInteger atomicInteger = new AtomicInteger();
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        Log.d("aking","---优先级  "+Thread.currentThread().getPriority());
        List<Runnable> list = new ArrayList<>((int) (134));
        PriorityBlockingQueue<MyRunnable> p = new PriorityBlockingQueue<MyRunnable>();
        for (int i = 0; i <1; i++) {
            MyRunnable runnable = new MyRunnable(  );
            runnable.setTag(i);
            list.add(runnable);
            p.add(runnable);
        }
        executor = new ThreadPoolExecutor(0, 10, 60,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(1 )/*new LinkedBlockingQueue<>(2)*/,new  MyThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());


        executor.execute(new Runnable() {
            @Override
            public void run() {
                Log.d("aking",executor.getCorePoolSize() +"任务一"+ executor.getPoolSize());
                while (true){}
            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Log.d("aking","任务2");
            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Log.d("aking","任务3");
            }
        });
    }

    class MyRunnable implements Runnable, Comparable<MyRunnable> {
        private int tag;

        @Override
        public int compareTo(MyRunnable o) {
            return  tag-o.getTag();
        }

        @Override
        public void run() {
            Log.d("aking", "---index---" + tag + "---线程名称---" + Thread.currentThread().getName()+"---优先级  "+Thread.currentThread().getPriority());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public int getTag() {
            return tag;
        }

        public void setTag(int tag) {
            this.tag = tag;
        }
    }

    class MyThreadFactory implements ThreadFactory{
        int p;
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
//            t.setPriority(++p);
            return t;
        }
    }
}