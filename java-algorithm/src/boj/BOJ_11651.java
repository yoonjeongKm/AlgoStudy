import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 점의 개수
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }

        /*
        * 리턴값	  의미
          음수	  a가 b보다 앞에 온다
          0	      순서 동일
          양수	  a가 b보다 뒤에 온다
        * */

        Arrays.sort(arr, (a, b) -> {
            //y 값이 같다면 x 기준으로 정렬하겠다
            if(a[1] == b[1]) {
                return a[0] - b[0];
            }
            // 그외의 경우에는 y값 기준으로 정렬
            return a[1] - b[1];
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }

        System.out.println(sb);
    }
}
