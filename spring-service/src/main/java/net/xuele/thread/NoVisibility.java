package net.xuele.thread;

/**
 * Created by yejunjie on 2016/12/6.
 *
 * 输出42  多线程情况下 有可能出现两种异常情况
 * 1：输出0  读线程读到了ready的变化，但是没有读到number的新值  重排序 先执行了ready
 * 2：无线循坏  ready修改过以后 读线程没有读到数据
 */
public class NoVisibility {

    private static Boolean ready;
    private static int number;


    public static class readerThread extends Thread{

        public void run(){

            while (!ready)
                Thread.yield();
            System.out.println(number);

        }
    }

    public static void main(String[] args) {
        new readerThread().start();
        number = 42;
        ready = true;
    }
}
