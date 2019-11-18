import java.util.Scanner;
  
public class Main_2577_회전초밥 {
  
    public static void main(String[] args) {
  
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 접시의 수
        int d = sc.nextInt(); // 초밥의 가짓수
        int k = sc.nextInt(); // 연속해서 먹는 접시의 수
        int c = sc.nextInt(); // 쿠폰 번호
        int max = 0;
        int[] arr = new int[n+k];
        int[] check = new int[d + 1];
        for (int i = 0; i < n; i++) { // 초밥갯수만큼입력
            arr[i] = sc.nextInt();
        }
        for (int i = n; i < n+k; i++) { // 회전되는거 계산
            arr[i] = arr[i - n];
        }
  
        //System.out.println(Arrays.toString(arr));
        check[c] = 987654321; // 쿠폰
        for (int i = 0; i < k; i++) { // 처음에 연속되는거
            check[arr[i]]++;
        }
        for (int i = 1; i <= d; i++) {
            if (check[i] > 0) {
                max++;
            }
        }
        //System.out.println(max);
        int temp=0;
        for (int i = k; i <n+k   ; i++) {
            if(arr[i]==arr[i-k])continue;
            check[arr[i-k]]--;
            check[arr[i]]++;
            temp=0;
            for (int j = 1; j <= d; j++) {
                if (check[j] > 0) {
                    temp++;
                }
            }
            if(max<temp)max=temp;
        }
        System.out.println(max);
    }
  
}
