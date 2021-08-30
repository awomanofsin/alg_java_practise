public class Leetcode11 {
    public int maxArea(int[] height) {
        int begin = 0;
        int end = height.length - 1;
        int maxArea = 0;

        while(begin<end){
            int area = (end-begin)*Math.min(height[begin],height[end]);
            maxArea = Math.max(area,maxArea);
            if(height[end] > height[begin]){
                begin ++;
            }else{
                end --;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] x = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        Leetcode11 leetcode11 = new Leetcode11();
        int res = leetcode11.maxArea(x);
        System.out.println(res);
    }
}
