import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AllocatioNTest {

    private static long totalSize = 0;

    public static void main(String[] args) throws InterruptedException {
        long allocTotal = 512l << 26;
        int largeBlock = 64 << 20;
        int smallBlock = 2 << 10;
        Random random = new Random();
        while (true) {
            allocSmall(random, allocTotal, smallBlock);
            allocLarge(random, allocTotal >> 3, largeBlock);
            System.out.println();
            Thread.sleep(100);
        }
    }

    private static void allocSmall(Random rnd, long total, int chunk) {
        alloc(rnd, total, chunk);
    }

    private static void allocLarge(Random rnd, long total, int chunk) {
        alloc(rnd, total, chunk);
    }

    private static void alloc(Random rnd, long total, int chunk) {
        long start  = System.nanoTime();
        long rem = total;
        while (rem > 0) {
            long mc = totalSize;
            allocChunk(rnd, chunk);
            rem -= (totalSize - mc);
        }
        long time = System.nanoTime() - start;
        System.out.println("Allocated " + String.format("%.1fMiB", 1d * total / (1 << 20)) + " using " + (chunk >> 10) + "KiB chunks - " + TimeUnit.NANOSECONDS.toMillis(time));
    }


    private static void allocChunk(Random random, int chunk) {
        int size = chunk / 10;
        int max = random.nextInt(20) + 1;
        int realsize = size * max;
        byte[] allocated = new byte[realsize];
        totalSize += allocated.length;
    }

}
