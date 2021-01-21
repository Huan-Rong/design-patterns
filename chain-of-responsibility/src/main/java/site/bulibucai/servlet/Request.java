package site.bulibucai.servlet;

public class Request {
    private String contents;

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "Request{" +
                "contents='" + contents + '\'' +
                '}';
    }
}
