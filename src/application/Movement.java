package application;

public class Movement {

    public static int left(int x,int speed)
    {
        return x-speed;
    }
    public static int right(int x,int speed)
    {
        return x+speed;
    }
    public static int back(int y, int speed)
    {
        return y-speed;
    }
    public static int forward(int y, int speed)
    {
        return y+speed;
    }



}
