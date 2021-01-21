package site.bulibucai;

import org.junit.Test;
import site.bulibucai.msg.Message;
import site.bulibucai.msg.filter.FilterChain;
import site.bulibucai.msg.filter.HTMLFilter;
import site.bulibucai.msg.filter.SensitiveFilter;
import site.bulibucai.msg.filter.UrlFilter;

public class MsgFilterTest {

    @Test
    public void testFilterChain() {
        FilterChain filterChain = new FilterChain().addFilter(new HTMLFilter())
                .addFilter(new SensitiveFilter())
                .addFilter(new UrlFilter());
        Message msg = new Message();
        msg.setContents("hello, ian");

        filterChain.doFilter(msg);
    }
}
