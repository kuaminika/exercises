import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import javax.swing.text.html.HTMLDocument.Iterator;

class Sale {
    public int deadline;
    public int savings;

    public Sale(int deadline, int savings) {
        this.deadline = deadline;
        this.savings = savings;
    }

    public String toString()
    {
        return "{"+this.deadline+","+this.savings+"}";
    }
}

public class Solution {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        List<Sale> sales = new ArrayList<>();
        int m = (int)Math.pow(10, 9)+7;


        for (int i = 0; i < A.size(); i++) {
            sales.add(new Sale(A.get(i), B.get(i)));
        }

        sales.sort((Comparator<? super Sale>) new EarliestTimeComparator());
        int n = sales.size();
        PriorityQueue<Integer> maxSavingsHeap = new PriorityQueue<>();
        int totalSavings = 0;
        int time = 0;
        for (int i = 0; i < sales.size(); i++) {

            Sale sale = sales.get(i); 
            if (time <sale.deadline) 
            {
                maxSavingsHeap.add(sale.savings);  
                totalSavings = (( totalSavings%m)+ (sale.savings%m))%m;
                time++; 
                continue;
            }
 
            if (!maxSavingsHeap.isEmpty() && maxSavingsHeap.peek() < sale.savings) {  // Check if current sale has higher savings
                int smallest = maxSavingsHeap.poll();
        
                totalSavings = ( totalSavings%m)-(smallest%m);
              
                totalSavings =( ( totalSavings%m)+ (sale.savings%m))%m;
                maxSavingsHeap.add(sale.savings);
            } 
        }

        return totalSavings;
    }


    public void print_queue(PriorityQueue<Integer> actual_queue){      
        PriorityQueue<Integer>copy = new PriorityQueue<Integer>();
        copy.addAll(actual_queue) ;        
        while (!copy.isEmpty()) {
            log(copy.poll()+" ");
        }
        logLn("") ;
                
        actual_queue.addAll(copy) ;
        
    }
    public   void logLn(String s)
    {
       
       System.out.println(s);
   }
   private   void log(String s)
   {
       
       System.out.print(s);
   }

}

class EarliestTimeComparator implements Comparator<Sale> {
    @Override
    public int compare(Sale a, Sale b) {
        return a.deadline - b.deadline;
    }
}
