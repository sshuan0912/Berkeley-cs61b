package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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

        timeAListConstruction();
    }

    /** Creates a table with time that needed for addLast method of different sizes
     * */
    public static void timeAListConstruction() {
        AList<Integer> A = new AList<>(); // empty list for adding elements;
        AList<Integer> N = new AList<>(); // the size of data structure
        AList<Double> time = new AList<>(); // time spent to complete all operations
        AList<Integer> ops = new AList<>(); // the number of calls to addLast

        int LIMIT = 128000;
        /**put values into each Alist */
        for (int n = 1000; n <= LIMIT; n *= 2) {
            N.addLast(n);
            int call_time = 0;
            Stopwatch sw = new Stopwatch();
            for (int i = 1; i <= n; i += 1){
                A.addLast(1);
                call_time += 1;
            }
            double timeInSeconds = sw.elapsedTime(); ///** Stopwatch class to get the time spent */
            time.addLast(timeInSeconds);
            ops.addLast(call_time);
        }

        /**call timing table*/
        printTimingTable(N, time, ops);

    }
}
