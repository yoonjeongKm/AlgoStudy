import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 1,2 를 조합하는 경우의 수

        int[] arr = new int[n+1];

        arr[0] = 1; // 아무것도 안만드는것을 1개라고 하기
        arr[1] = 1; // 2X1 만드는 방법 1개

        for(int i = 2; i <= n; i++){
            arr[i] = (arr[i-1] + arr[i-2]) % 10007;
        }

        System.out.println(arr[n]);
    }
}
