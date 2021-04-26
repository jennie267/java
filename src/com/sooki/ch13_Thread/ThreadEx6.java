package com.sooki.ch13_Thread;

import javax.swing.*;

/**
 * 쓰레드 하나
 * 입력이 끝나야 숫자가 출력됨
 */
public class ThreadEx6 {
    public static void main(String[] args) throws Exception{
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은  " + input + " 입니다.");

        for (int i=10; i>0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);     // 1초 지연
            } catch (Exception e) {}
        }
    }
}
