package deque;

import java.util.Iterator;

public class LinkedListDeque<Xiaoma> implements Deque<Xiaoma>, Iterable<Xiaoma> {
    private IntNode sentinel;
    private int size = 0;
    private class IntNode<Xiaoma>{
        public IntNode prev;
        public IntNode next;
        public Xiaoma item;

        /**
         *
         * @param x The value in linked list.
         * @param pre_y The previous node of the linked list.
         * @param nex_z The next node of the linked list.
         */
        public IntNode(Xiaoma x, IntNode pre_y, IntNode nex_z){
            item = x;
            prev = pre_y;
            next = nex_z;
        }
    }
    public LinkedListDeque(){
        sentinel = new IntNode(0, null, null);
    }

    /**
     * Add element to the begin of the linked lis.
     * @param x The element will be added.
     */
    public void addFirst(Xiaoma x){
        if(sentinel.next != null){
            IntNode add_list = new IntNode(x,sentinel,sentinel.next);
            sentinel.next = add_list;
            add_list.next.prev = add_list;
        }else{
            IntNode add_list = new IntNode(x, sentinel, sentinel);
            sentinel = new IntNode(0, add_list, add_list);
        }
        size++;
    }

    /**
     * Add element to the end of the linked lis.
     * @param x The element will be added.
     */
    public void addLast(Xiaoma x){
        if(sentinel.next != null){
            IntNode add_list = new IntNode(x,sentinel.prev,sentinel);
            sentinel.prev.next=add_list;
            sentinel.prev=add_list;
        }else{
            IntNode add_list = new IntNode(x, sentinel, sentinel);
            sentinel = new IntNode(0, add_list, add_list);
        }
        size++;
    }

    /**
     *Determine whether the linked list is empty.
     * @return true of false.
     */
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }


    /**
     * Return the size of the list.
     * @return size
     */
    public int size(){
        return size;
    }

    /**
     * Prints the items in the deque from first to last,
     * separated by a space. Once all the items have been
     * printed, print out a new line.
     */
    public void printDeque(){
        int p_size = size;
        IntNode p = sentinel;
        while(p_size != 0){
            System.out.print(p.next.item + " ");
            p = p.next;
            p_size -= 1;
        }
        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     * @return The item of the first of the list.
     */
    public Xiaoma removeFirst(){
        if(size == 0){
            return null;
        }else{
            Xiaoma res = (Xiaoma) sentinel.next.item;
            if(size==1){
                sentinel.next = null;
                sentinel.prev = null;
            }else{
                sentinel.next.next.prev = sentinel;
                sentinel.next = sentinel.next.next;
            }
            size -= 1;
            return res;
        }
    }

    /**
     *  Removes and returns the item at the back of the deque.
     *  If no such item exists, returns null.
     * @return The item of the last of the list.
     */
    public Xiaoma removeLast(){
        if(size == 0){
            return null;
        }else{
            Xiaoma res = (Xiaoma) sentinel.prev.item;
            if(size == 1){
                sentinel.next = null;
                sentinel.prev = null;
            }else{
                sentinel.prev.prev.next=sentinel;
                sentinel.prev=sentinel.prev.prev;
            }
            size -=1;
            return res;
        }
    }

    /**
     * Gets the item at the given index, where 0 is the front,
     * 1 is the next item, and so forth. If no such item exists,returns null.
     * @param index The index of the linked list element.
     * @return The element on the index of the list.
     */
    public Xiaoma get(int index){
        if(index >= size){
            return null;
        }else{
            IntNode p = sentinel;
            while(index > -1){
                p=p.next;
                index -= 1;
            }
            return (Xiaoma)p.item;
        }
    }

    /**
     * Same as get, but uses recursion.
     * @param index The index of the linked list element.
     * @return The element on the index of the list.
     */
    public Xiaoma getRecursive(int index){
        if(index >= size){
            return null;
        }else{
            IntNode p = sentinel;
            if(index == 0){
                return (Xiaoma)p.next.item;
            }else{
                p = p.next;
                return getRecursive(index - 1);
            }
        }
    }

    @Override
    public Iterator<Xiaoma> iterator(){
       return new ArraySetIterator();
    }
    public class ArraySetIterator implements Iterator<Xiaoma>{
        private int wizPos;
        public ArraySetIterator(){
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return get(wizPos) != null;
        }

        @Override
        public Xiaoma next() {
            Xiaoma returnItem = get(wizPos);
            wizPos += 1;
            return returnItem;
        }
    }

    @Override
    public boolean equals(Object obj) {
        Deque<Xiaoma> o =(Deque<Xiaoma>) obj;
        if(this.size != o.size()){
            return false;
        }
        if(obj instanceof Deque){
            for(int i = 0; i < size; i++){
                if(!this.get(i).equals(o.get(i))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        LinkedListDeque<Integer> mylink = new LinkedListDeque<Integer>();
//        mylink.addFirst(10);
//        mylink.addFirst(5);
//        mylink.addLast(15);
//        System.out.println("mylink.size = " + mylink.size());
//        System.out.println(mylink.get(2));
//        System.out.println(mylink.getRecursive(1));
//        for(int i : mylink){
//            System.out.println(i);
//        }
//        ArrayDeque<Integer> kk = new ArrayDeque<>();
//        kk.addFirst(15);
//        kk.addFirst(10);
//        kk.addFirst(5);
//        System.out.println(kk.size());
//        System.out.println(kk.equals(mylink));
    }
}
