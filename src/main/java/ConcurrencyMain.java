import sun.nio.ch.ThreadPool;

import java.util.concurrent.*;

public class ConcurrencyMain {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("test");
            }
        });

        ExecutorService threadPool = new ThreadPoolExecutor(10,
                20,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(100),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return null;
                    }
                },
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

                    }
                }
        );

        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("execute");
            }
        });
        service.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("submit");
            }
        });

        Thread.currentThread().interrupt();


    }
}
