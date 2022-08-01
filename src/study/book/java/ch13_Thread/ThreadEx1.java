package study.book.java.ch13_Thread;

public class ThreadEx1 {
    public static void main(String[] args) {
        // Thread를 상속받은 클래스의 인스턴스 생성
        ThreadEx1_1 t1 = new ThreadEx1_1();

        // Runnable을 구현한 클래스의 인스턴스 생성
        Runnable r = new ThreadEx1_2();
        Thread t2 = new Thread(r);  // 생성자 Thread (Runnable target)

        t1.start();
        t2.start();
        
        // start는 한번만 호출 가능, 두번이상호출시에 IllegalThreadStateException 발생
        // t1.start();
    }
}

class ThreadEx1_1 extends Thread {
    @Override
    public void run() {
        for (int i=0; i<5; i++) {
            // 조상인 Thread의 getName() 호출
            setName("extends Thread");
            System.out.println(getName());
        }
    }
}

class ThreadEx1_2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i<5;i++) {
            //Thread.currentThread();   - 현재 실행중인 Thread 반환
            Thread.currentThread().setName("implements Runnable");
            System.out.println(Thread.currentThread().getName());
        }

    }
}