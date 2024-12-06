import org.example.ll.Command;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandTest {

    @Test
    public void test1() {
        Command cmd = new Command("삭제?id=10");
        assertThat(cmd.getActionName().equals("삭제"));    //"삭제"
    }

    @Test
    public void test2() {
        Command cmd = new Command("삭제?id=10");
        assertThat(cmd.getParam("id")).isEqualTo("10");    //"10"
    }

    @Test
    public void test3() {
        Command cmd = new Command("삭제?id=10");
        assertThat(cmd.getParam("number")).isNull();    //null
    }

    @Test
    public void test4() {
        Command cmd = new Command("삭제?id=10");
        assertThat(cmd.getParam("number", "없음")).isEqualTo("없음");    //"삭제"
    }

    @Test
    public void test5() {
        Command cmd = new Command("삭제?id=10");
        assertThat(cmd.getParamAsInt("id")).isEqualTo(10);    //"삭제"
    }
}
