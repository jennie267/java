package study.book.java.ch13_Thread;

/**
 * Daemon Thread
 * 다른 일반 쓰레드의 작업을 돕는 보조적인 쓰레드
 * 일반쓰레드가 종료되면 데몬 쓰레드는 강제적으로 자동 종료됨
 * ex 가비지 컬렉터, 화면자동갱신 등
 */
public class ThreadEx10 implements Runnable{
    static boolean autoSave = false;

    public static void main(String[] args) {
        Thread t = new Thread(new ThreadEx10());
        t.setDaemon(true);  // 이 부분이 없으면 종료되지 않는다.
        t.start();

        for (int i = 0; i <=10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            System.out.println(i);

            if (i==5)
                autoSave = true;
        }
        System.out.println("프로그램을 종료합니다.");
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2*1000);
            } catch (InterruptedException e) {}

            // autoSave의 값이 true이면 autoSave()를 호출한다.
            if (autoSave) {
                autoSave();
            }
        }
    }

    public void autoSave() {
        System.out.println("작업파일이 자동저장되었습니다.");
    }
}
