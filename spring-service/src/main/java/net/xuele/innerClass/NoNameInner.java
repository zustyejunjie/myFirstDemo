package net.xuele.innerClass;

/**
 *
 * 简化代码，匿名内部类只能使用一次
 *
 * Created by yejunjie on 2016/12/21.
 */
public class NoNameInner {

    public static void main(String[] args) {
        //
        Thread t = new Thread(){
            public void run(){
                for (int i = 1; i <= 5; i++) {
                    System.out.println(i + " ");
                }
            }
        };

        t.start();


        Runnable r = new Runnable() {
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.print(i + " ");
                }
            }
        };
        Thread t1 = new Thread(r);
        t1.start();
    }
}
