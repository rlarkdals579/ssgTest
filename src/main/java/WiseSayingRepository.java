import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    List<WiseSaying> wiseSayings;
    int wiseSayingLastId;


    WiseSayingRepository() {
        wiseSayings = new ArrayList<>();
        wiseSayingLastId = 0;
    }
    public WiseSaying write(String content, String author) {
        int id = ++wiseSayingLastId;
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);


        return wiseSaying;
    }
    public WiseSaying findById(int paramId) {
        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.id == paramId) {
                return wiseSaying;
            }
        }

        return null;
    }
    public List<WiseSaying> findAll(){
        return wiseSayings;
    }
    public void remove(int paramId) {
        WiseSaying foundWiseSaying = findById(paramId);
        wiseSayings.remove(foundWiseSaying);

    }
    public void modify(WiseSaying wiseSaying, String content, String author) {
        WiseSaying wiseSayings = findById(wiseSaying.id);

        wiseSayings.content = content;
        wiseSayings.author = author;


    }
}
