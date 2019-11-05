package dynamic.proxy.jdk.demo;

import java.util.List;

/**
 * @author zhaihs
 * @date 2019/11/5
 */
public class Words implements PrintWords {

    @Override
    public void print(List<String> strList) {
        System.out.println(strList);
    }
}
