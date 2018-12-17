package Testate.Testat21.MultipleStrings.src;

public class MultipleStrings {

    private String[] texts;

    public MultipleStrings(int n){
        texts = new String[Math.abs(n)];
    }

    public boolean addAtPosition(String s, int p){
        if (p < 0 || p >texts.length-1){
            return false;
        }
        texts[p] = s;
        return true;
    }

    public int size(){
        int size = 0;
        for (String s : texts){
            if (s != null)
                size++;
        }
        return size;
    }

    public int atEnd(String end){
        int count = 0;
        for (String text : texts){
            if (text != null && text.endsWith(end))
                count++;
        }
        return count;
    }

    public boolean inAll(char s){
        CharSequence c = "s";
        boolean result = true;
        for (String text : texts){
            if (text != null && !text.contains(c));
                result = false;
        }
        return result;
    }

    public void replace(char c, char r){
        CharSequence s = "c";
        CharSequence p = "r";
        for (String text : texts){
            if (text != null && text.contains(s)){
                text = text.replace(c,r);
            }
        }
    }
}
