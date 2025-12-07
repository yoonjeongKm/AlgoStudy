import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2231 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine()); // 자연수 n
        int numberCopy = number; // 자연수 n 을 -1씩 줄이며 탐색할 복사본
        int result = 0; // 가장 작은 생성자 출력값

        // 자연수 n이 0이 될때까지 탐색
        while (numberCopy > 0) {

        --numberCopy;

        String[] numArr = String.valueOf(numberCopy).split(""); // 한 자리씩 확인

        int resultSum = 0; // 한자리끼리의 합

        for (String numArrPoint : numArr) {
            resultSum += Integer.parseInt(numArrPoint);
        }

        // 분해합일 경우 생성자에 갱신
        if(number == resultSum + numberCopy) {
            result = numberCopy;
        }
        }
        System.out.println(result);
    }
}
