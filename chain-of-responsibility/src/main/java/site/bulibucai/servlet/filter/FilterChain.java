package site.bulibucai.servlet.filter;

import site.bulibucai.servlet.Request;
import site.bulibucai.servlet.Response;

/**
 * 该接口用于获取并调用责任链上的下一个 Filter 结点。
 */
public interface FilterChain {
    void doFilter(Request request, Response response);

    FilterChain addFilter(Filter filter);
}