public class BufferElement {

    private Student student;
    private BufferElement next;

    public BufferElement(Student s){
        student = s;
        next = null;
    }

    public Student getStudent(){
        return student;
    }

    public BufferElement getNext(){
        return next;
    }

    public void setNext(BufferElement n){
        next = n;
    }
}
