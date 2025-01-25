package  cowsAndSnacks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;




public class LogTool {
    private boolean on;


    String indent = "";
    
    public LogTool()
    {
        on = true;
    }
    public void turnOn()
    {
        this.on = true;
    }

    public void turnOff()
    {
        this.on = false;
    }

    public void logLnArrr_int(int [] a)
    {
        String str = "";
        for(int i= 0; i<a.length;i++)
        {
            str+=a[i]+" ";
        }

        logLn(str);
    }
    public void log_matrixLn_int_int(ArrayList<ArrayList<Integer>> map)
    {
    
        System.out.print("[");
  
        for(int i= 0;i<map.size();i++ )
        {
            
        System.out.println(i+"->"+map.get(i));
        //    logArrListLn_int(map.get(i));
        }
        
        System.out.println("]");
    }

    public void log_matrixLn_int_int(HashMap<Integer,ArrayList<Integer>> map)
    {
    
        System.out.print("[");
  
        for(int i:map.keySet() )
        {
            
        System.out.println(i+"->"+map.get(i));
        //    logArrListLn_int(map.get(i));
        }
        
        System.out.println("]");
    }

    public void logDictionary_Int_int(HashMap<Integer,Integer> d)
    {
       
        System.out.print("{");
        for (Map<Integer,Integer>.Entry e: d.entrySet()) {
            System.out.print(String.format("%d:%d", e.getKey(),e.getValue()));
        }

        System.out.println("}");
    }

    public  void logArrListLn_int(ArrayList<Integer> rList)
    {
        System.out.print("[");
        for (Integer iterable_element : rList) {
            System.out.print(iterable_element+" ");
        }

        System.out.println("]");
    }
    
    public void logLnArrr_2D_boolean(boolean [][] a)
    {
        int m = a[0].length;
        String str = "";
        for(int i= 0; i<a.length;i++)
        {
            for(int j= 0; j<m;j++)
            {
                str+= (a[i][j]?1:0)+" ";
             //   str+="["+i+","+j+"]"+":"+a[i][j]+" ";
            }
            str+="\n";
        }

        logLn(str);
    }



    public void log(String str)
    {
        if(!on) return;
        System.out.print(indent+str);
    }


    public void logLn(String str)
    {
        if(!on) return;
        System.out.println(indent+str);
    }
}