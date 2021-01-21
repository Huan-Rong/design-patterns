package site.bulibucai.servlet.filter;

import site.bulibucai.servlet.Request;
import site.bulibucai.servlet.Response;

import java.util.ArrayList;
import java.util.List;

public class GenericFilterChain implements FilterChain {

    private int index = 0;

    private List<Filter> filterChain = new ArrayList<>();

    @Override
    public FilterChain addFilter(Filter filter) {
        filterChain.add(filter);
        return this;
    }

    @Override
    public void doFilter(Request request, Response response) {
        if (index < filterChain.size()) {
            filterChain.get(index++).doFilter(request, response, this);
        }
    }
}
