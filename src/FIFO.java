import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.NoSuchElementException;

;


public class FIFO implements Queue{

    private ArrayList<Object> queue;
    private int currentSize = 0;
    private int maxSize = 0;

    public FIFO() {
        this.queue = new ArrayList<>();
    }

    public static void main(String[] args) {
        FIFOmain.main(args);
    }

    public boolean equals(Object f) {
        if (this.getClass() != f.getClass()) return false;

        FIFO compareObject = (FIFO) f;

        ArrayList<Object> compareThis = this.queue;
        ArrayList<Object> compareThat = compareObject.queue;

        if(compareThis.size() != compareThat.size()) return false;

        for (int index = 0; index < compareThis.size(); index++) {
            Object itemThis = compareThis.get(index);
            Object itemThat = compareThat.get(index);

            //Black magic if block
            if (itemThis == null ? itemThat != null : !itemThis.equals(itemThat)) {
                return false;
            }
        }
        return true;

    }

    public String toString(){
        String toString = "Queue: ";
        for(Object i : this.queue){
            toString += "(" + String.valueOf(i) + ") ";

        }

        return toString;
    }

    public void add(Object item) {
        this.queue.add(item);
        currentSize = this.size();
        if (currentSize >= maxSize) {
            maxSize = currentSize;
        }
    }

    public void removeFirst() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            this.queue.remove(0);
            currentSize = this.size();
        }
    }

    public Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return this.queue.get(0);
        }
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int maxSize(){
        return maxSize;
    }


}
