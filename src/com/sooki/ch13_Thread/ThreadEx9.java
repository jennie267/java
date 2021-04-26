package com.sooki.ch13_Thread;

/**
 * 쓰레드 그룹
 */
public class ThreadEx9 {
    public static void main(String[] args) throws Exception{
        ThreadGroup main = Thread.currentThread().getThreadGroup();
        ThreadGroup group1 = new ThreadGroup("Group 1");
        ThreadGroup group2 = new ThreadGroup("Group 2");

        // ThreadGroup(ThreadGroup parent, String name)
        ThreadGroup subGroup1 = new ThreadGroup(group1, "Sub Group 1");
        
        group1.setMaxPriority(3);   // 쓰레드 그룹 group 1의 최대우선순위를 3으로 변경

        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);     // 쓰레드 1초 지연
                } catch (InterruptedException e){}
            }
        };

        // Thread(ThreadGroup tg, Runnable r, String name)
        new Thread(group1, r, "th1").start();
        new Thread(subGroup1, r, "th2").start();
        new Thread(group2, r, "th3").start();

        System.out.println(">> List of ThreadGroup  : " + main.getName()
                            + ", Active ThreadGroup  : " + main.activeGroupCount()
                            + ", Active Thread  : " + main.activeCount());
        main.list();

    }
}
