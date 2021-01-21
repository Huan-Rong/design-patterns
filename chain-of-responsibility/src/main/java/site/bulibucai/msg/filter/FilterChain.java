package site.bulibucai.msg.filter;

import site.bulibucai.msg.Message;

import java.util.ArrayList;
import java.util.List;

//todo 将 Filter 串成链有什么好处？
public class FilterChain implements Filter {
    //链，即线性表，是一种逻辑概念，其既可以使用数组实现，也可以使用链表实现。
    private final List<Filter> filterChain = new ArrayList<>();

    //返回值为 FilterChain，这是借鉴了链式编程的思路，以此简化开发。
    public FilterChain addFilter(Filter filter) {
        filterChain.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Message msg) {
        for (Filter filter : filterChain) {
            if (!filter.doFilter(msg)) {
                return false;
            }
        }
        return true;
    }
}
