package net.xuele.thread.publishAndEscape;

/**
 * Created by yejunjie on 2016/12/6.
 *
 * 该对象的一个实例传入一个多线程操作中，一个线程对states的操作 其他线程无法得知
 *
 */
public class UnsafeStates {

    private String[] states = new String[]{
      "aa","bb"
    };

    public String[] getStates() {
        return states;
    }

    public void setStates(String[] states) {
        this.states = states;
    }
}
