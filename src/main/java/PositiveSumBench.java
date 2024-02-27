import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PositiveSumBench {

    public static void main(String[] args) {

        new PositiveSumBench().start(args);
    }

    @SuppressWarnings("unused")
    private long sumOfSum;

    private long[] sortedArray;
    private long[] unsortedArray;

    PositiveSumBench() {
        int len = Integer.getInteger("arrayLen", 4 << 20);
        sortedArray = randomArray(len);
        unsortedArray = randomArray(len);
        Arrays.sort(sortedArray);
    }

    public long[] randomArray(int len) {
        long[] array = new long[len];
        Random rnd = new Random(1);
        for (int i = 0; i != array.length; ++i) {
            array[i] = rnd.nextLong();
        }
        return array;
    }

    public void start(String[] args) {
        int limit = Integer.MAX_VALUE;
        if (args.length > 0) {
            limit = Integer.parseInt(args[0]);
        }
        long sortedTime = 0;
        long unsortedTime = 0;

        for (int i = 0; i != 2 * limit; ++i) {
            if (i % 2 == 0) {
                long time = System.nanoTime();
                sumOfSum = positiveSumSorted();
                time = System.nanoTime() - time;
                sortedTime += time;
            } else {
                long time = System.nanoTime();
                sumOfSum = positiveSumUnsorted();
                time = System.nanoTime() - time;
                unsortedTime += time;
            }
            if ((i + 1) % 200 == 0) {
                int n = (i + 1) / 2;
                double sortedAvg = ((double) sortedTime) / n / TimeUnit.SECONDS.toNanos(1);
                double unsortedAvg = ((double) unsortedTime) / n / TimeUnit.SECONDS.toNanos(1);

                System.out.println("\nAverage time for sum element of array after " + n + " iterations");
                System.out.println("Sorted array:     " + sortedAvg);
                System.out.println("Non-sorted array: " + unsortedAvg);
            }
        }

//        double sortedAvg = ((double) sortedTime) / limit / TimeUnit.SECONDS.toNanos(1);
//        double unsortedAvg = ((double) unsortedTime) / limit / TimeUnit.SECONDS.toNanos(1);
//
//        System.out.println("Average time for sum element of array");
//        System.out.println("Sorted array:     " + sortedAvg);
//        System.out.println("Non-sorted array: " + unsortedAvg);
    }

    public long positiveSumSorted() {
        long sum = 0;
        int n = 0;
        while (true) {
            if (sortedArray[n] > 0) {
                sum += 2 * sortedArray[n];
            }
            ++n;
            if (n >= sortedArray.length) {
                return sum;
            }
        }
    }

    public long positiveSumUnsorted() {
        long sum = 0;
        int n = 0;
        while (true) {
            if (unsortedArray[n] > 0) {
                sum += 2 * unsortedArray[n];
            }
            ++n;
            if (n >= unsortedArray.length) {
                return sum;
            }
        }
    }

}
