public class WiseSaying {
    int id;
    String content;
    String author;


    public WiseSaying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;

    }
    @Override
    public String toString() {
        return "Saying{" +
                "id=" + id +
                ", words='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}