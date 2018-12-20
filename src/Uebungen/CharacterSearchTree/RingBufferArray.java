package Uebungen.CharacterSearchTree;

public class RingBufferArray {

    private int head;
    private int tail;
    private CharacterSearchTree[] trees;

    public RingBufferArray(int n){
        trees = new CharacterSearchTree[n];
        head = 0;
        tail = 1;
    }

    public CharacterSearchTree peek(){
        if (trees[head%trees.length] == null)
            throw new RuntimeException("Buffer is empty!");
        return trees[head%trees.length];
    }

    public CharacterSearchTree pop(){
        if (trees[head%trees.length] == null)
            throw new RuntimeException("Buffer is empty!");
        CharacterSearchTree ret = trees[head%trees.length];
        trees[head%trees.length] = null;
        head++;
        return ret;
    }

    public void push(CharacterSearchTree s){
        if (tail == head)
            throw new RuntimeException("Buffer reached limit!");
        else {
            trees[(tail-1)%trees.length] = s;
            tail++;
        }
    }

    public int countElements(){
        if (trees[head%trees.length] == null)
            return 0;
        return tail - head;
    }

    public int size(){
        return trees.length;
    }
}
