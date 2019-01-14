package Testate.Testat41;

public class Strategies {

    public class CountXStrategy extends DoublyLinkedList.InspectionStrategy<Integer>{

        int x;
        int count;

        public CountXStrategy(int a){
            x = a;
            count = 0;
        }

        public void inspect (Integer a){
            count = a == x ? count + 1 : count;
        }

        public int getCount(){
            return count;
        }
    }

    public class CountInIntervalStrategy extends DoublyLinkedList.InspectionStrategy<Integer>{

        int[] values;
        int count;

        public CountInIntervalStrategy(DoublyLinkedList<Integer> list, int l, int u){
            values = new int[u-l];
            count = 0;
            Iterator<Integer> it = list.iterator();
            for (int i = 0; i < l; i++){
                it.next();
            }
            for (int i = 0; i < u-l; i++) {
                values[i] = it.next();
            }
        }

        public void inspect(Integer a){
            for (int i = 0; i < values.length; i++){
                count = a == i ? count + 1 : count;
            }
        }
    }

    public class AverageOfPositivesStrategy extends DoublyLinkedList.InspectionStrategy<Integer>{

        int count;
        int sum;
        int avg;

        public AverageOfPositivesStrategy(){
            count = 0;
            sum = 0;
        }

        public void inspect(Integer a){
            if (a > 0){
                count++;
                sum += a;
                avg = sum/count;
            }
        }
    }

    public class AllToAbsStrategy extends DoublyLinkedList.SubstitutionStrategy<Integer>{
        public Integer substitute (Integer a){
            if (a < 0){
                return -a;
            }
            return a;
        }
    }

    public class AddNToAllStrategy extends DoublyLinkedList.SubstitutionStrategy<Integer>{

        int n;

        public AddNToAllStrategy (int x){
            n = x;
        }

        public Integer substitute (Integer a){
            if (a > 0){
                return a+n;
            }
            return a;
        }
    }

    public class DoubleAllInIntervalStrategy extends DoublyLinkedList.SubstitutionStrategy<Integer>{

        int lb;
        int rb;

        public DoubleAllInIntervalStrategy (int bottom, int top){
            lb = bottom;
            rb = top;
        }

        public Integer substitute (Integer a){
            if (lb <= 0 && rb >= 0){
                lb--;
                rb--;
                return 2*a;
            }
            else{
                lb--;
                rb--;
                return a;
            }
        }
    }

    public class RemoveAllNegativesStratey extends DoublyLinkedList.DeletionStrategy<Integer>{

        public boolean select (Integer a){
            if (a < 0)
                return true;
            return false;
        }

    }

    public class RemoveAllInIntervalStrategy extends DoublyLinkedList.DeletionStrategy<Integer>{

        int lb;
        int rb;

        public RemoveAllInIntervalStrategy(int bottom, int top){
            lb = bottom;
            rb = top;
        }

        public boolean select (Integer a){
            if (lb <= 0 && rb >= 0){
                lb--;
                rb--;
                return true;
            }
            else{
                lb--;
                rb--;
                return false;
            }
        }
    }

    public class RemoveAndCountAllInIntervalStrategy extends DoublyLinkedList.DeletionStrategy<Integer>{

        int count;
        RemoveAllInIntervalStrategy strategy;

        public RemoveAndCountAllInIntervalStrategy (int bottom, int top){
            count = 0;
            strategy = new RemoveAllInIntervalStrategy(bottom, top);
        }

        public boolean select (Integer a){
            if (strategy.select(a)){
                count++;
                return true;
            }
            else return false;
        }
    }

    public class RemoveSmallerThanPredecessorStrategy extends DoublyLinkedList.DeletionStrategy<Integer>{
        Integer pred;

        public boolean select (Integer a){
            if (pred == null){
                pred = a;
                return false;
            }
            else if (a < pred){
                return true;
            }
            else{
                pred = a;
                return false;
            }
        }
    }

    public class OneFollowsZeroStrategy implements DoublyLinkedList.InsertionStrategy<Integer>{

        public boolean select(Integer ref) {
            if (ref.equals(0))
                return true;
            else return false;
        }

        public Integer insert(Integer ref){
            return new Integer(1);
        }
    }

    public class SubtotalStrategy implements DoublyLinkedList.InsertionStrategy<Integer>{

        int sum;

        public SubtotalStrategy(){
            sum = 0;
        }

        public boolean select (Integer ref){
            return true;
        }

        public Integer insert (Integer ref){
            return new Integer(sum);
        }
    }

    public class SubtotalOfThreeElementsStrategy implements DoublyLinkedList.InsertionStrategy<Integer>{

        int sum;
        int count;

        public SubtotalOfThreeElementsStrategy(){
            sum = 0;
            count = 0;
        }

        public boolean select (Integer ref){
            count++;
            sum += ref;
            if (count % 3 == 0) {
                sum = 0;
                return true;
            }
            else return false;
        }

        public Integer insert (Integer ref){
            return sum;
        }
    }

    public class InsertFromListStrategy implements DoublyLinkedList.InsertionStrategy<Integer>{

        DoublyLinkedList<Integer> list;
        int index;

        public InsertFromListStrategy (DoublyLinkedList<Integer> ints){
            list = ints;
            index = 0;
        }

        public boolean select (Integer ref){
            return true;
        }

        public Integer insert (Integer ref){
            if (index >= list.size())
                throw new IndexOutOfBoundsException();
            return list.get(index);
        }
    }
}
