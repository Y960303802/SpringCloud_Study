package com.xizi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;


@SpringBootTest
class Gateway8989ApplicationTests {

    @Test
    void contextLoads() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }

}
