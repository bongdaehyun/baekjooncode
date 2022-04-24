import java.util.*;

public class leetcode_11_mostWater {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxv = 0;

        while(start < end){

            maxv = Math.max(maxv , (end-start)*Math.min(height[start],height[end]));
            if(height[start] < height[end]){
                start ++;
            }else{
                end--;
            }
        }

        return maxv;
    }
}
