package site.bulibucai.servlet.filter;

import site.bulibucai.servlet.Request;
import site.bulibucai.servlet.Response;

public class HtmlFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        System.out.println("html filter: request");
        if (request.getContents().equals("no")) {
            return;
        }
        filterChain.doFilter(request, response);
        System.out.println("html filter: response");
    }
}
