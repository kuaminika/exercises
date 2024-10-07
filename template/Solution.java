package template;

import java.util.ArrayList;
import java.util.HashMap;
 

public class Solution {
    LogTool l = new LogTool();
    public int solve(ArrayList<Integer> A, int B) {       


      return 1;
    }
}


class LogTool {
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