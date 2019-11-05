package dynamic.proxy.jdk.demo;

import com.sun.deploy.util.StringUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaihs
 * @date 2019/11/5
 */
public class WordFilter {
    private static String targetMethodName = "print";
    private static final String SENSITIVE_WORDS = "sb";

    static Words words = new Words();
    static PrintWords proxyInstance = (PrintWords) Proxy.newProxyInstance(words.getClass().getClassLoader(), words.getClass().getInterfaces(), new InvocationHandler() {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (targetMethodName.equals(method.getName())) {
                List<String> strList = (List<String>) args[0];

                for (int i = 0; i < strList.size(); i++) {
                    String str = strList.get(i);
                    if (str.contains(SENSITIVE_WORDS)) {
                        str = str.replaceAll(SENSITIVE_WORDS, new String(new char[SENSITIVE_WORDS.length()]).replace("\0", "*"));
                        strList.set(i, str);
                    }
                }

                return method.invoke(words, strList);
            }
            return method.invoke(words, args);
        }
    });

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>(3);
        strings.add("zz sb");
        strings.add("sb zz");
        strings.add("zz");
        System.out.println(strings);
        proxyInstance.print(strings);
    }
}
