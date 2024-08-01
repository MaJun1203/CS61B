package deque;

public class ArrayDeque<Xiaoma> implements Deque<Xiaoma>{
    private int size;
    private int nextFirst;
    private int nextLast;
    public Xiaoma[] items;
    public ArrayDeque(){
        items = (Xiaoma[]) new Object[8];
        size=0;
        nextFirst=7;
        nextLast=0;
    }

    /**
     *Add an element to the front of the linked list.
     * @param x The element to add.
     */
    @Override
    public void addFirst(Xiaoma x){
        if(nextFirst == nextLast){
            resetSize(items.length * 2);
            items[nextFirst] = x;
            nextFirst -= 1;
        }else{
            items[nextFirst] = x;
            if(nextFirst - 1 == -1){
                nextFirst = items.length - 1;
            }else{
                nextFirst -= 1;
            }
        }
        size += 1;
    }

    /**
     * Add an element to the last of the linked list.
     * @param x The element to add.
     */
    @Override
    public void addLast(Xiaoma x){
        if(nextFirst == nextLast){
            resetSize(items.length * 2);
            items[nextLast] = x;
            nextLast += 1;
        }else{
            items[nextLast] = x;
            if(nextLast + 1 == items.length){
                nextLast = 0;
            }else{
                nextLast += 1;
            }
        }
        size += 1;
    }

    /**
     *Delete an element from the front of the linked list.
     * @return The delete element.
     */
    @Override
    public Xiaoma removeFirst(){
        if((size - 1) * 4 < items.length && items.length > 8){
            resetSize(items.length/2);
        }
        if(size > 0){
            if(nextFirst + 1 == items.length){
                Xiaoma num = items[0];
                items[0] = null;
                nextFirst = 0;
                size -= 1;
                return num;
            }else{
                Xiaoma num = items[nextFirst + 1];
                items[nextFirst + 1] = null;
                nextFirst += 1;
                size -= 1;
                return num;
            }
        }else{
            return null;
        }
    }

    /**
     * Delete an element from the last of the linked list.
     * @return The delete element.
     */
    @Override
    public Xiaoma removeLast() {
        if((size - 1) * 4 < items.length && items.length > 8){
            resetSize(items.length/2);
        }
        if(size > 0){
            if(nextLast == 0){
                Xiaoma num =items[items.length-1];
                items[items.length-1] = null;
                nextLast = items.length-1;
                size -= 1;
                return num;
            }else{
                Xiaoma num = items[nextLast - 1];
                items[nextLast - 1] = null;
                nextLast -= 1;
                size -= 1;
                return num;
            }
        }else{
            return null;
        }
    }

    /**
     * Get the element of the index in the linked list.
     * @param index The index of the element to get.
     * @return The element corresponding to the index in the linked list
     */
    @Override
    public Xiaoma get(int index){
        if(size == 0){
            return null;
        }
        if(nextFirst + index + 1 >= items.length){
            return items[nextFirst + index + 1 - items.length];
        }else{
            return items[nextFirst + index + 1];
        }
    }
    public int size(){
        return size;
    }
    /**
     * Reset the list's size.
     * @param capacity The new size of the list.
     */
    private void resetSize(int capacity){
        Xiaoma[] new_items = (Xiaoma[]) new Object[capacity];
        for(int i = 0; i < size + 1; i++){
            if(nextFirst + 1 == items.length){
                nextFirst = -1;
            }
            new_items[i] = items[nextFirst + 1];
            nextFirst += 1;
        }
        items = new_items;
        nextFirst = items.length-1;
        nextLast = size;
    }

    /**
     *
     * @return Whether the list is empty.
     */
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }


    public static void main(String[] args) {
        ArrayDeque<Integer> L = new ArrayDeque();
        for(int i=0;i<441;i++){
            L.addLast(0);
        }
        System.out.println(L.get(0));
    }
}
