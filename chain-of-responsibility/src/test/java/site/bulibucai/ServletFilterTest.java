package site.bulibucai;

import org.junit.Test;
import site.bulibucai.servlet.Request;
import site.bulibucai.servlet.Response;
import site.bulibucai.servlet.filter.FilterChain;
import site.bulibucai.servlet.filter.GenericFilterChain;
import site.bulibucai.servlet.filter.HtmlFilter;
import site.bulibucai.servlet.filter.SensitiveFilter;

/**
 * 对 site.bulibucai.servlet 包下，关于 Filter 责任链设计模式的测试。
 */
public class ServletFilterTest {

    @Test
    public void testTheWholeFilterChain() {
        FilterChain genericFilterChain = new GenericFilterChain();
        genericFilterChain.addFilter(new HtmlFilter()).addFilter(new SensitiveFilter());

        Request request = new Request();
        request.setContents("yes");
        Response response = new Response();

        genericFilterChain.doFilter(request, response);
    }

    @Test
    public void testPartOfFilterChain() {
        FilterChain genericFilterChain = new GenericFilterChain();
        genericFilterChain.addFilter(new HtmlFilter()).addFilter(new SensitiveFilter());

        Request request = new Request();
        request.setContents("no");
        Response response = new Response();

        genericFilterChain.doFilter(request, response);
    }
}
