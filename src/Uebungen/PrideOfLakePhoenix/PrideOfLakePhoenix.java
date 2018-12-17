package Uebungen.PrideOfLakePhoenix;

public class PrideOfLakePhoenix {

    public static boolean existsTotalBalance(int[] containers, int limit, int divergence, int unitsLoaded){
        if (Math.abs(divergence) > limit){
            return false;
        }
        else if (unitsLoaded == containers.length){
            return divergence == 0;
        }
        return existsTotalBalance(containers, limit, divergence+containers[unitsLoaded], unitsLoaded+1)
                || existsTotalBalance(containers, limit, divergence-containers[unitsLoaded], unitsLoaded+1);

    }

    public static boolean existsBalanceWith3Holds(int[] containers, int limit, int divergence, int uLoaded){
        if (Math.abs(divergence) > limit)
            return false;
        else if (uLoaded == containers.length)
            return divergence == 0;
        else if (existsTotalBalance(containers, limit, divergence, uLoaded))
            return true;
        return existsBalanceWith3Holds(containers, limit, divergence, uLoaded+1);
    }

    public static boolean existsBalanceWith3LimitedHolds(int[] containers, int[] conLimits, int limit, int divergence, int uLoaded){
        if (Math.abs(divergence) > limit)
            return false;
        else if (uLoaded == containers.length)
            return divergence == 0;
        else if (conLimits[0]>0) {
            conLimits[0] -= 1;
            return existsBalanceWith3LimitedHolds(containers, conLimits, limit, divergence-containers[uLoaded], uLoaded+1);
        }
        else if (conLimits[1]>0){
            conLimits[1] -= 1;
            return existsBalanceWith3LimitedHolds(containers, conLimits, limit, divergence, uLoaded+1);
        }
        else if (conLimits[2]>0){
            conLimits[2] -= 1;
            return existsBalanceWith3LimitedHolds(containers, conLimits, limit, divergence+containers[uLoaded], uLoaded+1);
        }
        else return false;
    }
}



