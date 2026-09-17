import java.util.*;

class ABC{
    int nA;int nB;int nC;
    public ABC(int nA,int nB, int nC){
        this.nA = nA;
        this.nB = nB;
        this.nC = nC;
    }
}
class SmallestSubstringRemoved {
    public static String removeSmallestSubstring(String str) {
        int a = 0;
        int b = 0;
        int c = 0;
        Map<Integer, ABC> map = new HashMap<>();
        // for(char ch : str.toCharArray()){
        //     if(ch == 'a') a++;
        //     else if(ch == 'b') b++;
        //     else c++;
        // }
        for(int i=0; i< str.length(); i++){
            if(str.charAt(i) == 'a') a++;
            else if(str.charAt(i) == 'b') b++;
            else c++;
            map.put(i, new ABC(a, b, c)); // prefix sum
        }
        int diff_ab = a - b;//. if diff_ab pos , remove a , if negative remove b
        int diff_ac = a - c;
        

    }

    public static void main(String[] args) {
        String input = "abcde";
        String result = removeSmallestSubstring(input);
        System.out.println("Original String: " + input);
        System.out.println("String after removing smallest substring: " + result);
    }
}

// abbbbcccc -> bbbccc
// bcbcabcbc -> 
// aaaabc
// ba bcc c

// abccabc 
// 0123456
// (1,0,0)(1,1,0)(1,1,1)
// pref2 - pref1 = (0,0,1)