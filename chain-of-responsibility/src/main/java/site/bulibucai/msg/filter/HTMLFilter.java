package site.bulibucai.msg.filter;

import site.bulibucai.msg.Message;

public class HTMLFilter implements Filter {
    @Override
    public boolean doFilter(Message msg) {
        System.out.println("Html Filter: " + msg.getContents());
        return true;
    }
}
