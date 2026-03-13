class Solution {
    String[] digits = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
    public String toHex(int num) {
        return num < 0 ? toHexLong(-2L * Integer.MIN_VALUE + num) : toHexLong(num);
    }
    
    public String toHexLong(long num) {
        return num < 16 ? digits[(int)num] : toHexLong(num / 16) + digits[(int)(num % 16)];
    }
}