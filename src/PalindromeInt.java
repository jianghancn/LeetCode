
public class PalindromeInt {

    public boolean isPalindrome(int x) {
        if(x<0) return false;
        if(x==0) return true;
        int a = x;
        long scale=1;
        while(a/scale>0) {
            scale*=10;
        }
        scale /=10;
        int b = x;
        while(b>0) {

            if(x/scale%10 == b%10) {
                scale/=10;
                b/=10;
            } else {
                return false;
            }
        }

        return true;
    }
}
