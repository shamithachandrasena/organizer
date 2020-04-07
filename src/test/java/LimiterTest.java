import com.samsl.Limiter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class LimiterTest {
    @Test
    public void testGetSeperatedHostName(){
        Limiter.getSeperatedHostName("localhost,127.0.0.1,localhost,127.0.0.1",1);
    }
}
