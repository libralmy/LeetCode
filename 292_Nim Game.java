/**
f[1] = true
f[2] = true
f[3] = true
f[4] = false
f[n] = !f[n-1] || !f[n-2] || !f[n-3]
***/

class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
