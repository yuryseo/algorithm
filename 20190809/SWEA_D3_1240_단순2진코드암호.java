import java.util.Scanner;

public class SWEA_D3_1240_단순2진코드암호 {
    static int result = 0;

    public static void main(String[] args) {
        String[] num = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
                "0110111", "0001011" };
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for (int t = 1; t <= testcase; t++) {
            result = 0;
            int n = sc.nextInt();
            int m = sc.nextInt();
            String str;
            String tempcode = null;
            String num_code = null;
            int startIndex = 0;
            for (int i = 0; i < n; i++) {
                str = sc.next();
                if (str.contains("1")) {
                    tempcode = str;
                }

            }
            // start_index 찾기
            for (int i = tempcode.length() - 1; i >= 0; i--) {
                if (tempcode.charAt(i) == '1') {
                    startIndex = i - 55;
                    break;
                }
            }

            for (int i = startIndex; i < startIndex + 56; i = i + 7) {
                String temp = tempcode.substring(i, i + 7);
                for (int j = 0; j < 10; j++) {
                    if (num[j].equals(temp)) {
                        num_code += Integer.toString(j);

                    }

                }
            }
            num_code = num_code.replace("null", "");
            //System.out.println(num_code);

            CheckCode(num_code);

            System.out.println("#" + t + " " + result);
        }
    }

    private static void CheckCode(String num_code) {
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            char temp = (num_code.charAt(i));

            if (i % 2 == 0) {
                sum += 3 * (temp - '0');
            } else {
                sum += temp - '0';
            }
        }
        if (sum % 10 == 0) {
            sum = 0;

            for (int i = 0; i < 8; i++) {
                char temp = num_code.charAt(i);
                sum += temp - '0';
            }
            result=sum;
        } else {
            result = 0;
        }

    }
}
