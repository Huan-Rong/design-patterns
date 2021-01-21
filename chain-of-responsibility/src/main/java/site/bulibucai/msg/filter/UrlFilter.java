package site.bulibucai.msg.filter;

import site.bulibucai.msg.Message;

public class UrlFilter implements Filter {
    @Override
    public boolean doFilter(Message msg) {
        System.out.println("Url Filter: " + msg.getContents());
        return true;
    }
}
