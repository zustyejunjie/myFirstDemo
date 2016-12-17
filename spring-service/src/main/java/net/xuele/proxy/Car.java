package net.xuele.proxy;

import java.util.Random;

/**
 * Created by yejunjie on 2016/12/14.
 */
public class Car implements  Moveable{
    public void move() throws Exception {
        Thread.sleep(new Random().nextInt(1000));
        System.out.println("汽车行驶中…");
    }
}
