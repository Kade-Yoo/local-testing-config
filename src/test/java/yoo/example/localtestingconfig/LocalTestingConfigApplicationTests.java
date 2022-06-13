package yoo.example.localtestingconfig;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LocalTestingConfigApplicationTests extends IntegrationTests {

    @Test
    void contextLoads() {
        mockMvc.getClass();
    }

}
