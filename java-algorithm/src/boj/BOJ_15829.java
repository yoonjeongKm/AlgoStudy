import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15829 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine()); // 문자열 길이
        char[] chars = br.readLine().toCharArray(); // 문자열 배열 저장
        int resultSum = 0; // 해시 값

        // 알파벳 소문자 수열 * 31*(i)
        for (int i = 0; i < length; i++) {
            resultSum += (int) ((chars[i] - 'a' + 1) * Math.pow(31, i));
        }

        System.out.println(resultSum);
    }
}
