import java.util.Scanner;

public class SWEA_D3_1234_비밀번호 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        for (int t = 1; t < 11; t++) {

            int n = sc.nextInt();

            str = sc.next();
            boolean flag = true;
            while (flag) {
                flag = false;
                for (int i = 0; i < str.length() - 1; i++) {
                    if (str.charAt(i) == str.charAt(i + 1)) {
                        
                        String temp = str.charAt(i) +""+ str.charAt(i) ;
                        str =str.replace(temp, "");
                        i--;
                        flag = true;

                    }

                }

            }

            System.out.println("#" + t + " " + str);
        }

    }

}