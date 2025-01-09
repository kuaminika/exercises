package russianDollEnvelope;


public class Envelope {
    public int height;
    public int width;
 
     public Envelope(int h,int w)
     {
        height = h;
        width = w;
     }
    public String toString()
    {
       return String.format("{w:%dx h:%d}", width,height);
    }
}
