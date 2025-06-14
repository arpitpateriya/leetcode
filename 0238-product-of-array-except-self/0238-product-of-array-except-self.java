class Solution {
    public  int[] productExceptSelf(int[] nums) {
        int rl[]=new int [nums.length];
        int lr[]=new int [nums.length];
       int res[]= new int [nums.length];
        rl[0]=1;
        for (int i=1;i<nums.length;i++){
            rl[i]=rl[i-1]*nums[i-1];
        }
        lr[nums.length-1]=1;
        for(int i =nums.length-2;i>=0;i--){
            lr[i]=lr[i+1]*nums[i+1];
        }
        for(int i=0;i<nums.length;i++)
        {
            res[i]=lr[i]*rl[i];
        }
        return res;
    }}