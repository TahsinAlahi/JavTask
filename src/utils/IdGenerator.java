package utils;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
    /**
     * AtomicInteger uses CAS (Compare-And-Swap) internally to achieve lock-free thread safety.
     * And as it achieves thread safety without lock it is a bit more light weight than synchronized.
     */
    private static final AtomicInteger id = new AtomicInteger(1);

    /**
     * This is a utility class there's no need to make an object of it
     */
    private IdGenerator() {
        throw new AssertionError("Utility Class");
    }

    /**
     * synchronized could be used here but when the race condition happen only one task gets executed also it uses lock.
     * But the other tasks are either suspended or blocked.
     * And it's expensive to resume a suspending task.
     */
    public static int generateId() {
        return id.incrementAndGet();
    }


}
