package gh2;

import deque.ArrayDeque;
import deque.Deque;

//Note: This file will not compile until you complete the Deque implementations
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final
     * means the values cannot be changed at runtime. We'll discuss this and
     * other topics in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
     private Deque<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        buffer = new ArrayDeque<Double>();
        for(int i = 0;i < Math.round(SR/frequency);i++){
            buffer.addLast(0.0);
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        //
        //       Make sure that your random numbers are different from each
        //       other. This does not mean that you need to check that the numbers
        //       are different from each other. It means you should repeatedly call
        //       Math.random() - 0.5 to generate new random numbers for each array index.
        Deque<Double> new_deque = new ArrayDeque<>();
        for(int i = 0;i < buffer.size();i++){
            double r = Math.random() -0.5;
            new_deque.addLast(r);
        }
        buffer = new_deque;
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        double c = buffer.removeFirst();
        buffer.addLast((c + buffer.get(0))*0.996/2);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        // TODO: Return the correct thing.
        double res = buffer.get(0);
        return res;
    }
}
