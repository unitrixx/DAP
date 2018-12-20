package Uebungen.CharacterSearchTree;

public class CharacterSearchTree
{

    public static void main(String[] args){
        CharacterSearchTree tree = new CharacterSearchTree(new char[]{'g', 'x', 'b', 'a'});
        CharacterSearchTree[] ret = tree.breadthFirstTraversal();
        for (int i = 0; i < ret.length;i++)
            System.out.println(ret[i].getContent().getToken());
    }
    private HuffmanTriple content;
    private CharacterSearchTree leftChild, rightChild;

    public CharacterSearchTree() 
    {
        content = null;
        leftChild = null;
        rightChild = null;
    }

    public CharacterSearchTree( char[] arr){
        for (char t : arr)
            iterativeAdd(t);
    }

    public HuffmanTriple getContent()
    {
        if ( !isEmpty() )
        {
            return content;
        } else {
            throw new IllegalStateException();
        }
    }

    public boolean isEmpty() 
    {
        return content == null;
    }

    public boolean isLeaf() 
    {
        return !isEmpty() && leftChild.isEmpty() && rightChild.isEmpty();
    }

    public void add( char t )
    {
        if ( isEmpty() ) 
        {
            content = new HuffmanTriple( t );
            leftChild = new CharacterSearchTree();
            rightChild = new CharacterSearchTree();
        }
        else
        {
            if ( content.getToken() > t )
            {
                leftChild.add( t );
            }
            else if ( content.getToken() < t )
            {
                rightChild.add( t );
            }
            else
            {
                content.incrementQuantity();
            }
        }
    }

    public void iterativeAdd( char t )
    {
        CharacterSearchTree current = this;
        while ( !current.isEmpty() && current.content.getToken() != t )
        {
            if ( current.content.getToken() > t )
            {
                current = current.leftChild;
            }
            else
            {
                current = current.rightChild;
            }
        }
        if ( current.isEmpty() ) 
        {
            current.content = new HuffmanTriple( t );
            current.leftChild = new CharacterSearchTree();
            current.rightChild = new CharacterSearchTree();
        }
        else
        {
            current.content.incrementQuantity();
        }
    }

    public void add (char t, int q, String c){
        if (!isEmpty()){
            if (content.getToken() == t){
                content.setCode(c);
                for (int i = 0; i < q; i++)
                content.incrementQuantity();
            }
            else if (t < content.getToken()) {
                leftChild.add(t, q, c);
            }
            else rightChild.add(t, q, c);
        }
        else if (isEmpty()){
            content = new HuffmanTriple(t, q);
            content.setCode(c);
            leftChild = new CharacterSearchTree();
            rightChild = new CharacterSearchTree();
        }
    }

    public String getCode( char t )
    {
        if ( !isEmpty() ) 
        {
            if ( content.getToken() > t )
            {
                return leftChild.getCode( t );
            }
            else if ( content.getToken() < t )
            {
                return rightChild.getCode( t );
            }
            else
            {
                return content.getCode();
            }
        }
        else
        {
            throw new IllegalStateException();
        }
    }
    
    public int size() 
    {
        if ( isEmpty() ) 
        {
            return 0;
        }
        else
        {
            return 1 + leftChild.size() + rightChild.size();
        }       
    }

    public void show()
    {
        if ( !isEmpty() ) 
        {
            leftChild.show();
            System.out.println( content.toString() );
            rightChild.show();
        }
    }

    public void showPreOrder(){
        if ( !isEmpty() && !isLeaf()){
            System.out.println(content.toString());
            leftChild.showPreOrder();
            rightChild.showPreOrder();
        }
        else if (!isEmpty() && isLeaf())
            System.out.println("*" + content.toString());

    }

    public int height(){
        if (!isEmpty()) {
            int leftHeight = leftChild.height();
            int rightHeight = rightChild.height();
            return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
        }
        else return 0;
    }

    public int depth(){
        if (isEmpty())
            return -1;
        int left = leftChild.depth();
        int right = rightChild.depth();
        return left > right ? left + 1 : right + 1;
    }

    public int countCharacters(){
        return isLeaf() ? content.getQuantity() :
                leftChild.countCharacters() + rightChild.countCharacters() + content.getQuantity();
    }

    public int longestCode(){
        return height();
    }

    public HuffmanTriple[] toArray()
    {
        if ( !isEmpty() ) 
        {
            HuffmanTriple[] collector = new HuffmanTriple[size()];
            toArray( collector, 0 );
            return collector;
        }
        return new HuffmanTriple[0];
    }

    private int toArray( HuffmanTriple[] collector, int index ) 
    {
        if ( !isEmpty() )
        {
            index = leftChild.toArray( collector, index );
            collector[index] = content;
            index = rightChild.toArray( collector, index + 1 );
        }
        return index;
    }

    public HuffmanTriple minimum(){
        if (isEmpty())
            return null;
        CharacterSearchTree current = this;
        while (!current.isLeaf()){
            current = current.leftChild;
        }
        return current.getContent();
    }

    public boolean hasOnlyCompleteNodes(){
        if (isEmpty())
            return true;
        if (isLeaf())
            return true;
        if (leftChild.isEmpty() != rightChild.isEmpty())
            return false;
        return leftChild.hasOnlyCompleteNodes() && rightChild.hasOnlyCompleteNodes();
    }

    public boolean containsCharacter(char t){
        if (isEmpty())
            return false;
        if (content.getToken() == t)
            return true;
        if (t < content.getToken())
            return leftChild.containsCharacter(t);
        else return rightChild.containsCharacter(t);
    }

    public boolean equalStructure(CharacterSearchTree cst){
        if (isEmpty())
            return cst.isEmpty();
        if (isLeaf() || cst.isLeaf())
            return isLeaf() == cst.isLeaf();
        return leftChild.equalStructure(cst.leftChild) && rightChild.equalStructure(cst.rightChild);
    }

    public CharacterSearchTree rotateNodeToRight(){
        if (isEmpty() || leftChild.isEmpty())
            return this;
        CharacterSearchTree temp = leftChild;
        this.leftChild = leftChild.rightChild;
        temp.rightChild = this;
        return temp;
    }

    public boolean samePath(char t1, char t2){
        char greater = t1 > t2 ? t1 : t2;
        char smaller = t1 > t2 ? t2 : t1;
        if (content.getToken() < greater && content.getToken() > smaller)
            return false;
        if (content.getToken() > greater)
            leftChild.samePath(t1, t2);
        if (content.getToken() < greater)
            rightChild.samePath(t1, t2);
        return containsCharacter(smaller);
    }

    public int[] levelWidths(){
        int[] widths = new int[height()];
        levelWidths(widths, 0);
        return widths;
    }

    private void levelWidths(int[] widths, int level){
        if (!isEmpty()) {
            widths[level]++;
            leftChild.levelWidths(widths, level + 1);
            rightChild.levelWidths(widths, level + 1);
        }
    }

    public int maxLevelWidth(){
        int[] widths = levelWidths();
        int max = 0;
        for (int b : widths){
            if (b > max)
                max = b;
            else continue;
        }
        return max;
    }

    public CharacterSearchTree[] breadthFirstTraversal(){
        CharacterSearchTree[] result = new CharacterSearchTree[size()];
        RingBufferArray buffer = new RingBufferArray(size());
        buffer.push(this);
        int i = 0;
        while (buffer.countElements() != 0){
            CharacterSearchTree current = buffer.pop();
            result[i] = current;
            if (!current.leftChild.isEmpty())
                buffer.push(current.leftChild);
            if (!current.rightChild.isEmpty())
                buffer.push(current.rightChild);
            i++;
        }
        return result;
    }
}
