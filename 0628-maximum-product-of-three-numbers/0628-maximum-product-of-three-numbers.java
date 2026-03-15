class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int l=nums.length;
        int p=1;
        for(int i=1;i<4;i++){
            p=p*nums[l-i];
        }
        int p1=nums[0]*nums[1]*nums[nums.length-1];
        return p1>p?p1:p;
    }
}