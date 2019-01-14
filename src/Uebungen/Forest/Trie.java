package Uebungen.Forest;

import java.util.LinkedList;

public class Trie {

    private char token;
    private boolean end;
    private LinkedList<Trie> children;

    public Trie (){
        children = new LinkedList<Trie>();
    }

    public Trie ( char c ){
        token = c;
        end = true;
        children = new LinkedList<Trie>();
    }

    public boolean isLeaf(){
        return children.size() == 0;
    }

    public char getToken(){
        return token;
    }

    public boolean isEnd() {
        return end;
    }
}
