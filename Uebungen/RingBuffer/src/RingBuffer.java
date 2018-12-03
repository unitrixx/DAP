public class RingBuffer {

    private int limit;
    private int size;
    private BufferElement first;
    private BufferElement last;

    public RingBuffer(int n){
        limit = n;
        first = null;
        last = first;
        size = 0;
    }

    public Student peek(){
        if (first == null)
            throw new RuntimeException();
        return first.getStudent();
    }

    public void push(Student s){
        if (size >= limit)
            throw new RuntimeException();
        else if (first == null){
            first = new BufferElement(s);
            last = first;
        }
        else {
            BufferElement temp = new BufferElement(s);
            last.setNext(temp);
            last = temp;
        }
        size++;
    }

    public Student pop(){
        if (first == null)
            throw new RuntimeException();
        Student oldest = first.getStudent();
        first = first.getNext();
        return oldest;
    }

    public int size(){
        return limit;
    }

    public int countElements(){
        return size;
    }
}
