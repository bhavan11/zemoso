
public class RainWaterTrapping {

	public static void main(String[] args) {
		//int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		//int[] height = {3,0,0,2,0,4};
		int[] height = {4,2,0,3,2,5};
		System.out.println(trap(height));
	}
	
	public static int trap(int[] height) {
        int[] fGL = new int[height.length];
        fGL[0]=height[0];
        for(int i=1; i<height.length; i++)
        {
        	fGL[i] = Math.max(fGL[i-1], height[i]);
        }
        
        int ans=0;
        int temp=0;
        for(int i=height.length-1; i>=0; i--)
        {
        	if(i==height.length-1)
        		temp = height[i];
        	else
        		temp = Math.max(temp, height[i]);
        	ans += Math.min(temp, fGL[i])-height[i];
        }
        
        return ans;
    }

}
