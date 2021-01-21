package site.bulibucai.msg.filter;

import site.bulibucai.msg.Message;

public class SensitiveFilter implements Filter {
    @Override
    public boolean doFilter(Message msg) {
        System.out.println("Sensitive Filter: " + msg.getContents());
        return false;
    }
}
