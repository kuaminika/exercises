package validPath;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import template.LogTool;

import java.util.Arrays;

public class SolutionWithLog {
 
    LogTool  l = new LogTool();
   
    public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {

        if( A == 0 || B==0) return "NO"; 

        boolean [][] cannotTravelTo = new boolean[A+1][B+1];
        boolean [][] visited = new boolean[A+1][B+1];
        int n = C;
        int radius = D;

     

      for(int i= 0; i<n;i++)
        {
            int circleX = E.get(i);
            int circleY = F.get(i);

            int minX = Math.max(0, circleX - radius);
        int maxX = Math.min(A, circleX + radius);
        int minY = Math.max(0, circleY - radius);
        int maxY = Math.min(B, circleY + radius);

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                if (isWithinCircle(circleX, circleY, x, y, radius)) {
                    cannotTravelTo[x][y] = true;
                }
            }
        }

        }

       


        Queue<Point> q = new LinkedList<Point>();

        if(cannotTravelTo[0][0] ) return "NO";

        Point start = new Point(0,0);
        visited[start.x][start.y] = true;

        q.add(start);

        while(!q.isEmpty())
        {

            Point p = q.poll();


           ArrayList<Point> destinations =   p.destinationsIn(cannotTravelTo);

           for(Point destination : destinations)
           {
               if(visited[destination.x][destination.y]) continue;
               
               
               visited[destination.x][destination.y] = true;


              if( destination.x == A && destination.y == B) return "YES";


              q.add(destination);               
           }
        } 

        return "NO";
    }



    public boolean isWithinCircle(int cx, int cy, int x, int y, int R) {
        // Check if squared distance is less than or equal to the squared radius
        return (x - cx) * (x - cx) + (y - cy) * (y - cy) <= R * R;
    }


    class Point{
        int x;
        int y;
       
        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }


        boolean destinationIsValid(int x, int y, int n, int m)
        {
         

            return (x<n && x>=0  && y>=0 && y<m);

        }


        public ArrayList<Point> destinationsIn(  boolean[][] cannotTravelTo)
        {
                int n = cannotTravelTo.length;
                int m = cannotTravelTo[0].length;
                int[] dx = {+1,-1, 0, 0};
                int[] dy = {0,  0, +1,-1};


             ArrayList<Point>  result = new  ArrayList<Point> ();
                for(int i = 0;i< 4;i++)
                {
                    int newX = x+dx[i];
                    int newY = y+dy[i];

                  if(!destinationIsValid(newX,newY, n,m)) continue;

                  if(cannotTravelTo[newX][newY]) continue;

                    result.add(new Point(newX,newY));
                }


                return result;
        }

    }



     
    
}