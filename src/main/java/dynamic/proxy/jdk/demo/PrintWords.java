package dynamic.proxy.jdk.demo;

import java.util.List;

/**
 * @author zhaihs
 * @date 2019/11/5
 */
public interface PrintWords {
    /**
     * 打印 list 集合中的 字符串
     *
     * @param strList
     */
    void print(List<String> strList);
}
