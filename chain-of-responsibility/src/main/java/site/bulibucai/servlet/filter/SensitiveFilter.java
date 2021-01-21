package site.bulibucai.servlet.filter;

import site.bulibucai.servlet.Request;
import site.bulibucai.servlet.Response;

public class SensitiveFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        System.out.println("sensitive filter: request");
        filterChain.doFilter(request, response);
        System.out.println("sensitive filter: response");
    }
}
