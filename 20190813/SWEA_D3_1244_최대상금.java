import java.util.Scanner;
 
public class SWEA_D3_1244_최대상금 {
    static String str;
    static char[] arr;
    static int answer;
    static int N;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for (int t = 1; t <= testcase; t++) {
            answer = 0;
            str = sc.next();
            arr = str.toCharArray();
            N = sc.nextInt();
            find(0, 0);
            System.out.println("#" + t + " " + answer);
        }
    }
 
    private static void find(int n, int index) {
        if (n == N) {
            answer = Math.max(answer, Integer.parseInt(str));
            return;
        }
        for (int i = index; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if(str.charAt(i)<=str.charAt(j)) {
                swap(i, j);
                find(n + 1, i);
                swap(j, i);
                }
            }
        }
    }
 
    private static void swap(int i, int j) {
        StringBuilder changeNum = new StringBuilder(str);
        char charA = str.charAt(i);
        char charB = str.charAt(j);
        changeNum.setCharAt(i, charB);
        changeNum.setCharAt(j, charA);
        str = changeNum.toString();
    }
 
}
