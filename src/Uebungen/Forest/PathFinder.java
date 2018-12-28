package Uebungen.Forest;

public class PathFinder {
    public static void main (String[] args){
        Forest test = new Forest(7,9);
        PathFinder finder = new PathFinder();
        finder.find(test);
    }

    public boolean find (Forest fo){
        int direction = 0;
        while (!fo.canGoTo(direction) && direction < 4){
            direction++;
        }
        if (find(fo, Forest.getReverseDirection(direction))){

            fo.showTrace();
            return true;
        }
        else return false;
    }

    public boolean find (Forest fo, int comeFrom) {
        fo.show();
        if (fo.found()) {
            fo.setTrace(Forest.getReverseDirection(comeFrom));
            return true;
        }
        boolean deadEnd = true;
        int direction = 0;
        while (deadEnd && direction < 4) {
            if (fo.canGoTo(direction) && direction != comeFrom) {
                deadEnd = false;
            }
            else direction ++;
        }
        if (deadEnd) {
            return false;
        }
        while (direction < 4) {
            fo.moveTo(direction);
            if (find(fo, Forest.getReverseDirection(direction))) {
                fo.setTrace(Forest.getReverseDirection(comeFrom));
                return true;
            }
            else if (direction != comeFrom){
                fo.moveTo(Forest.getReverseDirection(direction));
                direction++;
            }
            else direction++;
        }
        return false;
    }
}
