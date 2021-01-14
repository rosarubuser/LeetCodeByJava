class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int digit = x % 10;
        int remain = x / 10;
        int palinN = digit;
        while (remain != 0) {
            digit = remain % 10;
            palinN = palinN * 10 + digit;
            remain /= 10;
        }
            
        return palinN == x;
    }
}


// revert half to avoid INT_MAX overflow
class Solution {
    public boolean isPalindrome(int x) {
        int halfN = 0;
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        while (x > halfN) {
            halfN = halfN * 10 + x % 10;
            x /= 10;
        }
        return x == halfN || x == halfN / 10;
    }
}