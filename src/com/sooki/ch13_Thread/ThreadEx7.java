package com.sooki.ch13_Thread;

import javax.swing.*;

/**
 * 쓰레드 2개
 * 입력이랑 별개로 동작
 */
public class ThreadEx7 {
    public static void main(String[] args) throws Exception{
        ThreadEx7_1 th1 = new ThreadEx7_1();
        th1.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은  " + input + " 입니다.");
    }
}

class ThreadEx7_1 extends Thread {
    @Override
    public void run() {
        for (int i=10; i>0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);     // 1초 지연
            } catch (Exception e) {}
        }
    }
}
