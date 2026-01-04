import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String info = br.readLine();
        int result = 0;
        boolean minus = false;
        StringBuilder sb = new StringBuilder();

        for (char c : info.toCharArray()) {
            if (c == '+' || c == '-') {
                int num = Integer.parseInt(sb.toString());
                sb.setLength(0);

                if (minus) result -= num;
                else result += num;

                if (c == '-') minus = true;
            } else {
                sb.append(c);
            }
        }

        // 마지막 숫자 처리
        int num = Integer.parseInt(sb.toString());
        if (minus) result -= num;
        else result += num;

        System.out.println(result);

    }
}
