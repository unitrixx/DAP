package Uebungen.RingBuffer;

public class RingBufferArray {

    private int head;
    private int tail;
    private Student[] students;

    public RingBufferArray(int n){
        students = new Student[n];
        head = 0;
        tail = 1;
    }

    public Student peek(){
        if (students[head%students.length] == null)
            throw new RuntimeException("Buffer is empty!");
        return students[head%students.length];
    }

    public Student pop(){
        if (students[head%students.length] == null)
            throw new RuntimeException("Buffer is empty!");
        Student ret = students[head%students.length];
        students[head%students.length] = null;
        head++;
        return ret;
    }

    public void push(Student s){
        if (tail == head)
            throw new RuntimeException("Buffer reached limit!");
        else {
            students[tail%students.length] = s;
            tail++;
        }
    }

    public int countElements(){
        if (students[head%students.length] == null)
            return 0;
        return tail - head;
    }

    public int size(){
        return students.length;
    }
}
