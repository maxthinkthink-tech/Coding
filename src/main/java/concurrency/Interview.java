package concurrency;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Interview {
    public Long getSum(long[] values, long timeout, TimeUnit unit) throws Exception {
        // thread: key - values index
//         value : sleep time
        Map<Integer, Long> vMap = new LinkedHashMap<>();
        int threadCnt = values.length;
        List<Thread> threads = new LinkedList<>();
        for (int i = 0; i < threadCnt; i++) {
            long curTimeout = values[i];
            int index = i;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // skip
                        // if (curTimeout > timeout) {}
                        //
                        unit.sleep(curTimeout);
                        // data processing
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                    vMap.put(index, curTimeout);
                }
            });
            t.start();
            threads.add(t);
        }

        // sleep
        unit.sleep(timeout);
        //        notifyAll();

        // result
        long res = 0;
        for (Long v : vMap.values()) {
            res += v;
        }
        return res;
    }
}
