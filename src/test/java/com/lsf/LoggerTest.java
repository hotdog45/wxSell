package com.lsf;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//import lombok.extern.slf4j.Slf4j;


/**
 * Created by lishunfeng on 2018/7/30.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {


//    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1() {

        log.info("info||||||||||||||||||||||");
        log.debug("debug||||||||||||||||||||");
        log.error("error||||||||||||||||||||");




    }
}
