import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {

    static int[][] arr;
    static int white = 0; // 흰색 종이 개수
    static int blue = 0;  // 파란색 종이 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 한 변의 길이
        arr = new int[n][n];

        // 입력 받기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 분할 정복 시작 (0,0)에서 n x n 영역
        divide(0, 0, n);

        // 결과 출력
        System.out.println(white);
        System.out.println(blue);
    }

    /**
     * (x, y)부터 size x size 영역을 검사
     */
    static void divide(int x, int y, int size) {

        // 1. 현재 영역이 모두 같은 색인지 확인
        if (isSameColor(x, y, size)) {
            if (arr[x][y] == 0) {
                white++;
            } else {
                blue++;
            }
            return; // 더 이상 나눌 필요 없음
        }

        // 2. 다르면 4등분
        int half = size / 2;

        divide(x, y, half);                 // 좌상
        divide(x, y + half, half);          // 우상
        divide(x + half, y, half);          // 좌하
        divide(x + half, y + half, half);   // 우하
    }

    /**
     * 해당 영역이 전부 같은 색인지 확인
     */
    static boolean isSameColor(int x, int y, int size) {
        int color = arr[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != color) {
                    return false; // 하나라도 다르면 false
                }
            }
        }
        return true;
    }
}
