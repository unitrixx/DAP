package Testate.Testat42;

public class Testumgebung
{
    public static void main( String[] args )
    {
        IntIntPairs testPairs = new IntIntPairs( 20 );
        testPairs.put(7,3); testPairs.put(4,3); testPairs.put(1,-9); testPairs.put(6,6); testPairs.put(2,8); 
        testPairs.put(41,12); testPairs.put(9,-11); testPairs.put(8,12); testPairs.put(5,-60); testPairs.put(14,18); 
        testPairs.put(0,12); testPairs.put(-9,-16); testPairs.put(0,0); testPairs.put(17,32); testPairs.put(1,1);

        System.out.println("Beispiel: " + testPairs.accumulate( (k,v) -> { if (k==0) { return v; } else { return 0; } } ) );

        System.out.println("Beispiel: " + sumUp( testPairs ) );

        System.out.println("zweitens: " + testPairs.accumulate( (k,v) -> k % 2 == 0 ? 1 : 0 ) );

        /*/
        System.out.println("drittens: ");
        testPairs.show();
        testPairs.remove( (k,v) -> k == 6);
        testPairs.show();
        //*/

        /*/
        System.out.println("viertens: ");
        testPairs.show();
        testPairs.manipulate( (k,v) -> k*10, (k,v) -> v);
        testPairs.show();
        //*/

        /*/
        IntIntPairs result1 = testPairs.extract( (k,v) -> v % 3 == 0);
        System.out.println("fünftens: ");
        testPairs.show();
        result1.show();
        //*/

        /*/
        System.out.println("sechstens: " + testPairs.accumulate( (k,v) -> v >= 10 ? 1 : 0));
        //*/

        /*/
        System.out.println("siebtens: ");
        testPairs.show();
        testPairs.manipulate( (k,v) -> v > 3 ? k+5 : k, (k,v) -> v);
        testPairs.show();
        //*/

        /*/
        System.out.println("achtens: ");
        testPairs.show();
        testPairs.remove( (k,v) -> v < 0);
        testPairs.show();
        //*/

        /*/
        System.out.println("neuntens: ");
        testPairs.show();
        testPairs.manipulate( (k,v) -> k, (k,v) -> v*2);
        testPairs.show();
        //*/

        /*/
        System.out.println("zehntens: ");
        testPairs.show();
        testPairs.extract( (k,v) -> true).show();
        //*/

        /*/
        System.out.println("elftens: ");
        testPairs.show();
        testPairs.remove( (k,v) -> k == v);
        testPairs.show();
        //*/

        /*/
        System.out.println("zwölftens: " + testPairs.accumulate( (k,v) -> v));
        //*/

        /*/
        System.out.println("dreizehntens: ");
        testPairs.extract( (k,v) -> v > 5).show();
        //*/

    }
    
    public static int sumUp(IntIntPairs pairs)
    {
        return pairs.accumulate( (k,v) -> { if (k==0) { return v; } else { return 0; } } );
    }
    
     public static void addNToValue( IntIntPairs pairs, int n )
     {
        pairs.manipulate( (k,v) -> k, (k,v) -> v+n);
     }

     public static boolean uniqueKey( IntIntPairs pairs, int n )
     {
         return pairs.accumulate( (k,v) -> k == n ? 1 : 0) == 1;
     }

     public static void doubleGreaterN( IntIntPairs pairs, int n )
     {
         IntIntPairs result = pairs.extract( (k,v) -> k > n);
         result.manipulate( (k,v) -> k, (k,v) -> v*2);
         pairs.combine(result);
     }

     public static IntIntPairs concat(IntIntPairs first, IntIntPairs second)
     {
         int size = first.accumulate( (k,v) -> 1) + second.accumulate( (k,v) -> 1);
         IntIntPairs result = new IntIntPairs(size);
         result.combine(first);
         result.combine(second);
         return result;
     }
}
