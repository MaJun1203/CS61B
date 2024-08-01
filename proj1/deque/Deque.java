package deque;

public interface Deque<Xiaoma>{
    public int size = 0;
    public void addFirst(Xiaoma x);
    public void addLast(Xiaoma x);
    public Xiaoma removeFirst();
    public Xiaoma removeLast();
    public Xiaoma get(int index);
    public int size();
    default boolean isEmpty(){
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }
}
