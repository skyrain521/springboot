package SpringBootAsync.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by liusj on 2019/8/6
 */
@Service
public class TestService {

    private static final Logger logger = LoggerFactory.getLogger(TestService.class);

    @Async
    public void asyncMethod() {
        sleep();
        logger.info("异步方法内部线程名：" + Thread.currentThread().getName());
    }

    public void syncMethod() {
        sleep();
    }


    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
