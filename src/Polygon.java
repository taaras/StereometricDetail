import java.util.*;

/**
 * @author Taras Shvyryd
 */
public class Polygon {
    private ArrayList<Integer> xPoints = new ArrayList<>();
    private ArrayList<Integer> yPoints = new ArrayList<>();

    public int[] getXPoints(){
        int[] output = new int[xPoints.size()];
        for(int i = 0; i < xPoints.size(); i++)
            output[i] = xPoints.get(i);
        return output;
    }

    public int[] getYPoints(){
        int[] output = new int[yPoints.size()];
        for(int i = 0; i < yPoints.size(); i++)
            output[i] = yPoints.get(i);
        return output;
    }

    public void add(int x, int y){
        xPoints.add(x);
        yPoints.add(y);
    }
}