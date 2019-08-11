import java.util.Scanner;

public class BOJ_13458_시험감독 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int room = sc.nextInt();
        int[] arr = new int[room];
        long result =0;
        for(int i=0;i<room;i++) {
            arr[i]=sc.nextInt();
        }
        int main = sc.nextInt();
        int sub = sc.nextInt();
        for(int i=0;i<room;i++) {
            arr[i]=arr[i]-main;
            result++;
        }
        for(int i=0;i<room;i++) {    
            if(arr[i]>0) {
                result+=arr[i]/sub;
                arr[i]=arr[i]%sub;
                if(arr[i]>0) {
                    arr[i]=0;
                    result++;
                }
            }
        }
        System.out.println(result);
        
    }

}
