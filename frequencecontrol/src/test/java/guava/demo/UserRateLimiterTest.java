package guava.demo;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.*;

public class UserRateLimiterTest {

    @Test
    public void testSimple() throws InterruptedException {
        // 创建一个限流器（每秒限制流量为5个）
        RateLimiter rateLimiter = RateLimiter.create(5.0);

        for (int i = 0; i < 10; i++) {
            if (rateLimiter.tryAcquire()) {
                System.out.println(LocalTime.now() + " 通过");
            } else {
                System.out.println(LocalTime.now() + " 被限流");
            }
            Thread.sleep(100L);
        }
    }
}