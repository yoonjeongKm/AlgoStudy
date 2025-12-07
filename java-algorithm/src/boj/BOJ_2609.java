import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sArr = br.readLine().split(" ");
        int a = Integer.parseInt(sArr[0]); // 첫번째 자연수
        int b = Integer.parseInt(sArr[1]); // 두번째 자연수

        int originalA = a;
        int originalB = b;

        // 최대공약수 구하기 (유클리드 호제법)
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        int gcd = a;  // 반복문 종료 시 gcd 저장

        int lcm = (originalA * originalB) / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }
}
