package site.bulibucai.msg.filter;

import site.bulibucai.msg.Message;

public interface Filter {

    /**
     * @param msg
     * @return 当返回值为 true，继续执行 FilterChain 中的下个 Filter；否则结束整个 FilterChain 的执行。
     */
    boolean doFilter(Message msg);
}
