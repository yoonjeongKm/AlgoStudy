import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        int num = 666;

        while (true) {
            if(String.valueOf(num).contains("666")) {
                count++; // 666이 포함된 수면 카운트 1 증가
            if(count == N) { //찾고자하는 N번째로 작은 종말의 수일 경우 출력하고 종료
                System.out.println(num);
                break;
            }
            }
            num++; // 계속 +1 하여 탐색
        }
    }
}
