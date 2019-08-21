import java.util.Scanner;

public class Jungol_1103_경비원 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();    //10
        int y = sc.nextInt();    //5
        int testcase = sc.nextInt();
        int[][] arr = new int[testcase + 1][2];
        for (int t = 0; t <= testcase; t++) {
            int dir = sc.nextInt(); // 방향
            int num = sc.nextInt();
            if (dir == 1) {
                arr[t][0] = 0;
                arr[t][1] = num;
            } else if (dir == 2) {
                arr[t][0] = y;
                arr[t][1] = num;
            } else if (dir == 3) {
                arr[t][0] = num;
                arr[t][1] = 0;
            } else if (dir == 4) {
                arr[t][0] = num;
                arr[t][1] = x;
            }
        }
         
        int store_x = arr[testcase][0];
        int store_y = arr[testcase][1];
        int sum = 0;
        for (int t = 0; t < testcase; t++) {
            int temp = 0;
            if (store_x == arr[t][0]) { // x좌표가 같을때
                if (store_y != arr[t][1]) { // y 좌표가 다르면
                    if (Math.abs(store_y - arr[t][1]) == x) { // y좌표의 차가 x이면 정반대 방향.

                        sum += x;
                        temp = (store_x +arr[t][0])  <= 2 * y - (store_x +arr[t][0])  ? (store_x +arr[t][0]) : 2 * y - (store_x +arr[t][0]) ;
                        sum += temp;
                    } // 두개 더한거 or 2y에서 두개 더한거 뺀거
                    else {
                        temp = Math.abs(store_y - arr[t][1]);
                        sum += temp;
                    }
                }
                // else : x가 같을때 y도 같은면 거리=0;

            } else { // x좌표가 다를 때
                //x의 차이가 y만큼날때
                if(Math.abs(store_x - arr[t][0])==y) {
                    
                        sum += y;
                        temp = (store_y +arr[t][1]) <= 2 * x - (store_y +arr[t][1]) ? (store_y +arr[t][1]) : 2 * x - (store_y +arr[t][1]);
                        sum += temp;
                        
                }else {//x가 달라
                    if (Math.abs(store_y - arr[t][1]) == 0) {    //y좌표의 차가 0
                    sum+=Math.abs(store_x - arr[t][0]);
                    }else {
                        temp = Math.abs(store_x - arr[t][0]) + Math.abs(store_y - arr[t][1]);
                        sum+=temp;
                    }
                    
                    
                }
            }//end of if
            //System.out.println(t+" "+sum);
        }//end of for
        System.out.println(sum);
    }

}