package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    public static void testThreeAddThreeRemove(){
        AListNoResizing<Integer> anr=new AListNoResizing<Integer>();
        BuggyAList<Integer> ba=new BuggyAList<Integer>();
        for(int i=4;i<7;i++){
            anr.addLast(i);
            ba.addLast(i);
        }
        assertEquals(anr.size(),ba.size());
        for(int j=0;j<3;j++){
            assertEquals(anr.removeLast(),ba.removeLast());
        }
    }
    @Test
    public void ranfomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> BA = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                BA.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                System.out.println("size: " + size);
                int ba_size=BA.size();
                assertEquals(size,ba_size);
            }
            else if (operationNumber == 2 && L.size()!=0 && BA.size()!=0){
                //getLast
                int getLast = L.getLast();
                System.out.println("getLast: "+getLast);
                assertEquals(L.getLast(),BA.getLast());
            }
            else if(operationNumber == 3 && L.size()!=0 && BA.size()!=0){
                //removelast
                int removelast = L.removeLast();
                int ba_remmovelast=BA.removeLast();
                System.out.println("removelast: "+removelast);
                assertEquals(removelast,ba_remmovelast);
            }
        }
    }
    public static void main(String[] args) {
        testThreeAddThreeRemove();
        //ranfomizedTest();
    }
}
