package gymTrainer;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

public class SolutionWithLog {
    LogTool l  = new LogTool();
    public int solve(int A, ArrayList<ArrayList<Integer>> B, ArrayList<ArrayList<Integer>> C) {

        // 
        //  HashMap<Integer,ArrayList<Integer>> graphB = makeGraph(B);
        //   HashMap<Integer,ArrayList<Integer>> graphC = makeGraph(C);

        HashSet<Integer> nodesOfB = getNodesOf(B);
        HashSet<Integer> nodesOfC = getNodesOf(C);


        for(int node : nodesOfB)
        {
           if( nodesOfC.contains(node)) return 0;
        }


        int amountInB =   nodesOfB.size();
        int amountInC =  nodesOfC.size();
        int amontOfIsolateds = A- (amountInB+amountInC);

        int m = (int)Math.pow(10,9)+7;

        long amountOfDietsForB = fastPower(2, amountInB, m);
        long amountOfDietsForC =  fastPower(2, amountInC, m);
        long amountOfDietsForISolateds = fastPower(2,amontOfIsolateds,m);

        l.logLn(String.format("amountInB:%d,amountInC:%d,amontOfIsolateds:%d", amountInB,amountInC,amontOfIsolateds));
        l.logLn(String.format("amountOfDietsForB:%d,amountOfDietsForC:%d,amountOfDietsForISolateds:%d", amountOfDietsForB,amountOfDietsForC,amountOfDietsForISolateds));

        long bPlusc=  (amountOfDietsForB%m+amountOfDietsForC%m)%m;
        long result =  (amountOfDietsForISolateds%m + bPlusc%m)%m;
        return (int) result;

        // long result = (((amountOfDietsForB * amountOfDietsForC) % m) * amountOfDietsForISolateds) % m; 
        // return (int) result;
    }


 
    long fastPower(int a, int b, int m)
    {

        if(b == 0 ) return 1;

        boolean bIsEven = b%2 ==0;

        long half = fastPower(a, b/2,m);
        long evenBHalfPower =  (half %m * half%m)%m;

            if(bIsEven) return evenBHalfPower;

        return (evenBHalfPower%m * a%m)%m;
    }

    HashSet<Integer> getNodesOf(ArrayList<ArrayList<Integer>> edges)
    {
         HashSet<Integer> nodesOf = new  HashSet<Integer>();
        for(ArrayList<Integer> edge : edges)
        {
            int n1 = edge.get(0);
            int n2 = edge.get(1);

            nodesOf.add(n1);
            nodesOf.add(n2);
        }

        return nodesOf;
    }

    HashMap<Integer,ArrayList<Integer>> makeGraph(ArrayList<ArrayList<Integer>> edges)
    {

         HashMap<Integer,ArrayList<Integer>> result = new  HashMap<Integer,ArrayList<Integer>>();


        for(ArrayList<Integer> edge : edges)
        {
            int n1 = edge.get(0);
            int n2 = edge.get(1);
            result.putIfAbsent(n1, new ArrayList<Integer>());
            result.putIfAbsent(n2, new ArrayList<Integer>());
        }

        return result;


    }
}



// public class SolutionWithLog {
//     public int solve(int A, ArrayList<ArrayList<Integer>> B, ArrayList<ArrayList<Integer>> C) {
//         HashSet<Integer> nodesOfB = getNodesOf(B);
//         HashSet<Integer> nodesOfC = getNodesOf(C);

//         for(int node : nodesOfB) {
//             if(nodesOfC.contains(node)) return 0;
//         }

//         int amountInB = nodesOfB.size();
//         int amountInC = nodesOfC.size();
//         int amountOfIsolated = A - (amountInB + amountInC);

//         int m = 1000000007;

//         long result = fastPower(2, amountInB, m);
//         result = (result * fastPower(2, amountInC, m)) % m;
//         result = (result * fastPower(2, amountOfIsolated, m)) % m;

//         return (int) result;
//     }

//     long fastPower(long base, int exponent, int modulus) {
//         if (exponent == 0) return 1;
//         long result = 1;
//         base = base % modulus;
//         while (exponent > 0) {
//             if (exponent % 2 == 1)
//                 result = (result * base) % modulus;
//             exponent = exponent >> 1;
//             base = (base * base) % modulus;
//         }
//         return result;
//     }

//     HashSet<Integer> getNodesOf(ArrayList<ArrayList<Integer>> edges) {
//         HashSet<Integer> nodesOf = new HashSet<>();
//         for(ArrayList<Integer> edge : edges) {
//             nodesOf.add(edge.get(0));
//             nodesOf.add(edge.get(1));
//         }
//         return nodesOf;
//     }
// }