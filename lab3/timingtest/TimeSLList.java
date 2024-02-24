package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        SLList<Integer> S = new SLList<>();
        AList<Integer> Ns = new AList<>(); // the size of data structure
        AList<Double> times = new AList<>(); // time spent to complete all operations
        AList<Integer> ops = new AList<>(); // the number of calls to addLast

        int M = 1000;
        int LIMIT = 64000;
        /**put values into each Alist */
        for (int n = 1000; n <= LIMIT; n *= 2) {
            Ns.addLast(n);
            for (int i = 1; i <= n; i += 1){
                S.addLast(i);
            }
            Stopwatch sw = new Stopwatch();
            int call_time = 0;
            for (int j = 1; j <= M; j += 1) {
                S.getLast();
                call_time += 1;
            }
            double timeInSeconds = sw.elapsedTime(); ///** Stopwatch class to get the time spent */
            times.addLast(timeInSeconds);
            ops.addLast(call_time);
        }
        /**call timing table*/
        printTimingTable(Ns, times, ops);
    }

}
