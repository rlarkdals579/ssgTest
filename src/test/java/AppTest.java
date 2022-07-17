import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    @DisplayName("삭제 테스트")
    public void Rq__getIntParam() {
        Rq rq = new Rq("삭제?id=1");
        int id = rq.getIntParam("id", 0);
        assertEquals(1, id);
    }

    @Test
    public void Rq__getIntParam__2() {
        Rq rq = new Rq("검색?id=10&no=1");
        int id = rq.getIntParam("id", 0);
        int no = rq.getIntParam("no", 0);
        assertEquals(10, id);
        assertEquals(1, no);
    }

    @Test
    public void Rq__getPath() {
        Rq rq = new Rq("삭제?id=1");
    }

}
