package site.bulibucai.msg;

public class Message {

    private String contents;

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "Message{" +
                "contents='" + contents + '\'' +
                '}';
    }
}
