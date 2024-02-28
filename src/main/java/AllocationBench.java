import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AllocationBench {

    private static long totalSize = 0;

    public static void main(String[] args) throws InterruptedException {
        int largeBlock = 64 << 20;
        int smallBlock = 2 << 10;
        Random random = new Random();
        while (true) {
            allocSmall(random, 200, smallBlock);
            allocLarge(random, 200, largeBlock);
            System.out.println();
            Thread.sleep(100);
        }
    }

    private static void allocSmall(Random rnd, long time, int chunk) {
        alloc(rnd, time, chunk);
    }

    private static void allocLarge(Random rnd, long time, int chunk) {
        alloc(rnd, time, chunk);
    }

    private static void alloc(Random rnd, long time, int chunk) {
        long start  = System.nanoTime();
        long deadline = start + TimeUnit.MILLISECONDS.toNanos(time);
        long total = 0;
        while (System.nanoTime() < deadline) {
            long mc = totalSize;
            allocChunk(rnd, chunk);
            total += (totalSize - mc);
        }
        long passed = System.nanoTime() - start;
        System.out.println("Allocated " + String.format("%.1fMiB", 1d * total / (1 << 20)) + " using " + (chunk >> 10) + "KiB chunks - " + TimeUnit.NANOSECONDS.toMillis(passed));
    }


    private static void allocChunk(Random random, int chunk) {
        int size = chunk / 10;
        int max = random.nextInt(20) + 1;
        int realsize = size * max;
        byte[] allocated = new byte[realsize];
        totalSize += allocated.length;
    }

}
