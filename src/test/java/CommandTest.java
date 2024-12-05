import org.example.ll.Command;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandTest {

    @Test
    public void test1() {
        Command cmd = new Command("삭제?id=10");
        assertThat(cmd.getActionName().equals("삭제"));    //"삭제"

    }
}
