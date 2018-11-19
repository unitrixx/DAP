public class BoxTest {

    public static void main (String[] args){
        Box first = new Box(2,2,2);
        Box second = new Box(3,4,6);
        Box third = new Box(7,5,6);
        Box fourth = new Box(8,9,3);

        System.out.println("isCube: ");
        System.out.println("first: " + first.isCube());
        System.out.println("second: " + second.isCube());
        System.out.println("third: " + third.isCube());

        System.out.println(" ");

        System.out.println("encloses: ");
        System.out.println("first encloses second: " + first.encloses(second));
        System.out.println("first encloses third: " + first.encloses(third));
        System.out.println("second encloses first: " + second.encloses(first));
        System.out.println("second encloses third: " + second.encloses(third));
        System.out.println("third encloses first: " + third.encloses(first));
        System.out.println("third encloses second: " + third.encloses(second));
        System.out.println("second encloses fourth: " + second.encloses(fourth));
        System.out.println("fourth encloses second: " + fourth.encloses(second));
    }
}
