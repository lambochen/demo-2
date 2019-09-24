package club.chenlinghong.demo.javaeight.completablefuture;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @Description CompletableFuture 使用示例
 * @Author chenlinghong
 * @Date 2019/9/25 0:01
 */
@Slf4j
public class CompletableFutureDemo {

    ExecutorService executor = Executors.newCachedThreadPool();

    /**
     * 同步版本
     */
    @Test
    public void sync() throws InterruptedException {
        long startTime = System.currentTimeMillis();

        int oneProviderResult = provider();
        int twoProviderResult = provider();
        int oneConsumerResult = consumer(oneProviderResult);
        int twoConsumerResult = consumer(twoProviderResult);
        log.info("sync: one={}, two={}", oneConsumerResult, twoConsumerResult);

        long endTime = System.currentTimeMillis();
        log.info("sync time={}", (endTime - startTime));
    }

    /**
     * 同步版本
     *
     * @throws InterruptedException
     */
    @Test
    public void syncOther() throws InterruptedException {
        long startTime = System.currentTimeMillis();

        log.info("syncOther: one={}, two={}", consumer(provider()), consumer(provider()));

        log.info("syncOther: time={}", System.currentTimeMillis() - startTime);
    }

    /**
     * FutureTask 版本
     */
    @Test
    public void futureTask() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newCachedThreadPool();
        // 创建 provider 任务
        FutureTask<Integer> oneFuture = new FutureTask<>(() -> provider());
        FutureTask<Integer> twoFuture = new FutureTask<>(() -> provider());
        // 提交 provider 任务
        executor.submit(oneFuture);
        executor.submit(twoFuture);
        // 获取中间数据
        Integer oneProviderResult = oneFuture.get();
        Integer twoProviderResult = twoFuture.get();

        // 创建 consumer 任务
        FutureTask<Integer> threeFuture = new FutureTask<>(() -> consumer(oneProviderResult));
        FutureTask<Integer> fourFuture = new FutureTask<>(() -> consumer(twoProviderResult));
        // 提交 consumer 任务
        executor.submit(threeFuture);
        executor.submit(fourFuture);
        // 获取结果
        Integer oneConsumerResult = threeFuture.get();
        Integer twoConsumerResult = fourFuture.get();

        log.info("sync: one={}, two={}", oneConsumerResult, twoConsumerResult);

        log.info("syncOther: time={}", System.currentTimeMillis() - startTime);
    }


    /**
     * CompletableFuture 版本
     */
    @Test
    public void completableFutureTest() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newCachedThreadPool();
        CompletableFuture<Integer> one = CompletableFuture
                .supplyAsync(() -> {
                    try {
                        return provider();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return 0;
                    }
                }, executor)
                .thenApplyAsync((res) -> {
                    try {
                        return consumer(res);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return 0;
                    }
                }, executor);

        CompletableFuture<Integer> two = CompletableFuture
                .supplyAsync(() -> {
                    try {
                        return provider();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return 0;
                    }
                }, executor)
                .thenApplyAsync((res) -> {
                    try {
                        return consumer(res);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return 0;
                    }
                }, executor);

        /**
         * 等待执行，需要等待 one, two 两个任务均执行完毕
         */
        CompletableFuture.allOf(one, two);

        log.info("sync: one={}, two={}", one.get(), two.get());

        log.info("syncOther: time={}", System.currentTimeMillis() - startTime);
    }

    /**
     * CompletableFuture 版本
     */
    @Test
    public void completableFutureTest_01() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();

        CompletableFuture<Integer> one = completableFutureExecute();
        CompletableFuture<Integer> two = completableFutureExecute();
        /**
         * 等待执行，需要等待 one, two 两个任务均执行完毕
         */
        CompletableFuture.allOf(one, two);
        log.info("sync: one={}, two={}", one.get(), two.get());

        log.info("syncOther: time={}", System.currentTimeMillis() - startTime);
    }

    private CompletableFuture<Integer> completableFutureExecute() {
        return CompletableFuture
                .supplyAsync(() -> {
                    try {
                        return provider();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return 0;
                    }
                }, executor)
                .thenApplyAsync((res) -> {
                    try {
                        return consumer(res);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return 0;
                    }
                }, executor);
    }


    /**
     * 生产者，比作需要提前进行执行的操作
     *
     * @return
     */
    public int provider() throws InterruptedException {
        log.info("provider time={}", System.currentTimeMillis());
        // 模拟耗时操作
        Thread.sleep(3000);
        return 1;
    }

    /**
     * 消费者，耗时操作
     */
    public int consumer(int message) throws InterruptedException {
        log.info("consumer time={}", System.currentTimeMillis());
        // 模拟耗时操作
        Thread.sleep(3000);
        log.info("consumer message={}, time={}", message, System.currentTimeMillis());
        return message * 2;
    }

}
