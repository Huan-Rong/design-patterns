package site.bulibucai.servlet.filter;

import site.bulibucai.servlet.Request;
import site.bulibucai.servlet.Response;

/**
 * Filter 定义了责任链上的每一个处理结点。该接口有以下 2 种作用。
 *
 * 1.负责当前结点所应该完成的责任；
 * 2.判断是否要将执行流程交给下一个结点 Filter 处理；
 */
public interface Filter {
    void doFilter(Request request, Response response, FilterChain filterChain);
}
