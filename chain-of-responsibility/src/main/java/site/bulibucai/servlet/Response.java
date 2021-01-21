package site.bulibucai.servlet;

public class Response {
    private String contents;

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "Response{" +
                "contents='" + contents + '\'' +
                '}';
    }
}
