import java.util.Scanner;

public class boj_14888_연산자끼워넣기 {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        arr = new int[t];

        for (int i = 0; i < t; i++) {
            arr[i] = sc.nextInt();
        }
        int plus = sc.nextInt();
        int minus = sc.nextInt();
        int mul = sc.nextInt();
        int div = sc.nextInt();

        solve(1, plus, minus, mul, div, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void solve(int index, int plus, int minus, int mul, int div, int temp) {

        if (index == arr.length) {
            max = Math.max(max, temp);
            min = Math.min(min, temp);

            return;
        }
        if (plus > 0)
            solve(index + 1, plus - 1, minus, mul, div, temp + arr[index]);
        if (minus > 0)
            solve(index + 1, plus, minus - 1, mul, div, temp - arr[index]);
        if (mul > 0)
            solve(index + 1, plus, minus, mul - 1, div, temp * arr[index]);
        if (div > 0)
            solve(index + 1, plus, minus, mul, div - 1, temp / arr[index]);

    }

}
