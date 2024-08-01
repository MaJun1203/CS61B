package deque;
import jh61b.junit.In;

import java.util.Comparator;
public class MaxArrayDeque<Xiaoma> extends ArrayDeque<Xiaoma>{
    private Comparator<Xiaoma> comparator;
    public MaxArrayDeque(Comparator<Xiaoma> c){
        super();
        comparator = c;
    }
    public Xiaoma max(){
        if(isEmpty()){
            return null;
        }else{
            return max(this.comparator);
        }
    }
    public Xiaoma max(Comparator<Xiaoma> c){
        if(isEmpty()){
            return null;
        }
        Xiaoma maxElement = get(0);
        for(int i = 1;i<size();i++){
            if(c.compare(get(i),maxElement) > 0){
                maxElement = get(i);
            }
        }
        return maxElement;
    }

    public static void main(String[] args) {

    }
}
