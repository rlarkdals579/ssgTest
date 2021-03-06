import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private Scanner sc;
    private WiseSayingRepository wiseSayingRepository;

    WiseSayingController(Scanner sc) {
        this.sc = sc;
        wiseSayingRepository = new WiseSayingRepository();
    }

    void write(Rq rq) {
        System.out.print("명언 : ");
        String content = sc.nextLine().trim();
        System.out.print("작가 : ");
        String author = sc.nextLine().trim();
        WiseSaying wiseSaying = wiseSayingRepository.write(content, author);
        System.out.printf("%d번 명언이 등록되었습니다.\n", wiseSaying.id);
    }

    public void modify(Rq rq) {
        int paramId = rq.getIntParam("id", 0);

        if (paramId == 0) {
            System.out.println("수정하실 id를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = wiseSayingRepository.findById(paramId);

        if (wiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
            return;
        }

        System.out.printf("명언(기존) : %s\n", wiseSaying.content);
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.printf("작가(기존) : %s\n", wiseSaying.author);
        System.out.print("작가 : ");
        String author = sc.nextLine();

        wiseSayingRepository.modify(wiseSaying, content, author);

        System.out.printf("%d번 명언이 수정되었습니다.\n", paramId);
    }

    public void list(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------");

        List<WiseSaying> wiseSayings = wiseSayingRepository.findAll();

        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", wiseSaying.id, wiseSaying.content, wiseSaying.author);
        }
    }

    public void remove(Rq rq) {
        int paramId = rq.getIntParam("id", 0);
        if (paramId == 0) {
            System.out.println("삭제하실 id를 입력해주세요.");
            return;
        }

        WiseSaying foundWiseSaying = wiseSayingRepository.findById(paramId);

        if (foundWiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
            return;
        }
        wiseSayingRepository.remove(paramId);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);
    }
}