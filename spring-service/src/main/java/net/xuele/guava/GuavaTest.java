package net.xuele.guava;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yejunjie on 2016/8/29.
 */
public class GuavaTest {

    public static void main(String[] args){

        List<String> a = new ArrayList<String>();
        a.add("a");
        a.add("b");
        a.add("c");
        //拼装字符
        System.out.println(Joiner.on("|").join(a.iterator()));
    }
}
