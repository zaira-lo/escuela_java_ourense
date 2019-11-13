/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.concurrencia;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author pc
 */
public class MyThread implements Runnable{

    private List<Integer> myList;
    private Object host;

    public MyThread(List<Integer> list, Object object) {
        this.myList = list;
        this.host = object;
    }

    private void updateList(int i) {
        synchronized (this.host) {
            myList.add(i);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            updateList(i);
        }
        System.out.println("end: " + myList.size());
    }
    
 

}

