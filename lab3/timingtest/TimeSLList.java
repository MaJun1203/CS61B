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
        AList<Integer> Ns=new AList<>();
        AList<Double> times=new AList<>();
        AList<Integer> ops=new AList<>();

        //set Ns
        int N=1000;
        for(int i=0;i<8;i++){
            Ns.addLast(N);
            N*=2;
        }

        //set times
        int M=1000;
        SLList L=new SLList(0);

        for(int n=0;n<999;n++){
            L.addLast(n);
        }
        Stopwatch sw=new Stopwatch();
        for(int q=0;q<10000;q++){
            L.getLast();
        }
        double timeInSeconds=sw.elapsedTime();
        times.addLast(timeInSeconds);
        for(int m=0;m<7;m++)
        {
            for(int n=0;n<M;n++){
                L.addLast(n);
            }
            M=M*2;
            double time1=sw.elapsedTime();
            for(int p=0;p<10000;p++){
                L.getLast();
            }
            double time2=sw.elapsedTime();
            double res=time2-time1;
            times.addLast(res);
        }


        //set ops
        for(int j=0;j<8;j++){
            ops.addLast(10000);
        }


        printTimingTable(Ns,times,ops);
    }

}
