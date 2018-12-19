package Testate.Testat32;

public class DoublyLinkedList
{
    private Element first, last;
    private int size;

    public DoublyLinkedList()
    {
        first = last = null;
        size = 0;
    }

    public int size()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }

    public void add( Object content ) 
    {
        Element e = new Element( content );
        if ( isEmpty() ) 
        {
            first = last = e;
        }
        else 
        {
            last.connectAsSucc( e );
            last = e;
        }
        size++;
    }

    public void addFirst( Object content ) 
    {
        Element e = new Element( content );
        if ( isEmpty() ) 
        {
            first = last = e;
        }
        else 
        {
            first.connectAsPred( e );
            first = e;
        }
        size++;
    }

    public Object getFirst() 
    {
        if ( !isEmpty() )
        {
            return first.getContent();
        }
        else
        {
            throw new RuntimeException();
        }
    }

    public Object get( int index ) 
    {
        if ( index >= 0 && index < size )
        {
            Element current = first;
            for ( int i = 0; i < index; i++ )
            {
                current = current.getSucc();
            }
            return current.getContent();
        }
        else
        {
            throw new RuntimeException();
        }
    }

    public Object removeFirst()
    {
        if ( !isEmpty() ) 
        {
            Object result = first.getContent();
            if ( first.hasSucc() )
            {
                first = first.getSucc();
                first.disconnectPred();
            }
            else
            {
                first = last = null;
            }
            size--;
            return result;
        }
        else
        {
            throw new RuntimeException();
        }
    }

    public void showAll()
    {
        Element current = first;
        while ( current != null )
        {
            System.out.print( current.getContent().toString() );
            if ( current != last )
            {
                System.out.print(", ");
            }
            current = current.getSucc();
        }
        System.out.println();
    }

    public void clear(){
        last = first = null;
    }

    public Object getLast(){
        return last;
    }

    public boolean contains(Object o){
        Element current = first;
        while (current.getContent().equals(o)){
            if (current == last)
                break;
            current = current.getSucc();
        }
        return current.getContent().equals(o);
    }

    public int count(Object o){
        int count = 0;
        for (Element e = first; e != last; e = e.getSucc()){
            if (e.getContent().equals(o))
                count++;
        }
        count = last.getContent().equals(o) ? count + 1 : count;
        return count;
    }

    public boolean allEqual(){
        boolean result = true;
        Element current = first.getSucc();
        while (result && current.hasSucc()){
            if (!current.getContent().equals(first))
                result = false;
            current = current.getSucc();
        }
        if (!last.getContent().equals(first))
            result = false;
        return result;
    }

    public boolean containsDouble(){
        boolean result = false;
        Element current = first;
        for (int i = 0; i < size; i++){
            Element compare = current.getSucc();
            for (int k = i+1; k < size; k++){
                if (compare.getContent().equals(current)) {
                    result = true;
                    break;
                }
                compare = compare.getSucc();
            }
            current = current.getSucc();
            if (result)
                break;
        }
        return result;
    }

    public void insert(int n, Object o){
        if (n >= size || n < 0)
            throw new IndexOutOfBoundsException();
        else if (n == 0){
            new Element(o).connectAsSucc(first);
            first = first.getPred();
            size++;
        }
        else {
            Element index = first;
            for (int i = 1; i <= n; i++)
                index = index.getSucc();
            if (index.hasSucc()) {
                Element temp = index.getSucc();
                index.connectAsSucc(new Element(o));
                index.getSucc().connectAsSucc(temp);
                size++;
            }
            else {
                index.connectAsSucc(new Element(o));
                last = index.getSucc();
                size++;
            }
        }
    }

    public void toArray(Object[] arr){
        Element current = first;
        for (int i = 0; i < arr.length; i++){
            if (i >= size)
                arr[i] = null;
            else {
                arr[i] = current;
                if (current != null)
                    current = current.getSucc();
            }
        }
    }

    public DoublyLinkedList flip(){
        DoublyLinkedList result = new DoublyLinkedList();
        Element current = last;
        for (int n = 0; n < size; n++){
            result.add(current.getContent());
            current = current.getPred();
        }
        return result;
    }
}
