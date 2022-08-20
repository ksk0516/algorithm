package a0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1992_김선규 {

	static int[][] box;
	static int N, n;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		box = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				box[i][j] = s.charAt(j) - '0';
			}
		}

		int cnt = N * N;

		quad(0, 0, N, cnt);

		System.out.println(sb);
	}

	public static void quad(int x, int y, int n, int cnt) { // 투입할 때마다 괄호 넣어주고, 맨 큰 사각형부터 시작
		if (n == 0)
			return;

		int num = check(x, y, n, cnt); // 쪼개야하는지 확인하는 함수.

		if (num != 2) { // 배열엔 1 또는 0 뿐이므로 2가 나오면 변을 나눠주러 내려감
			sb.append(num);
			return;
		}

		if (cnt == 0)
			return;

		else {
			cnt /= 4; // 배열의 총 개수는 1/4로 줍니다.
			if (cnt == 0)
				cnt = 1;
			n /= 2; // 배열 한 변의 크기는 1/2로 줍니다.
			sb.append('(');
			quad(x, y, n, cnt);
			quad(x, y + n, n, cnt);
			quad(x + n, y, n, cnt);
			quad(x + n, y + n, n, cnt);
			sb.append(')');

		}
	}

	public static int check(int x, int y, int n, int cnt) { // 1뿐이면 1출력, 0뿐이면 0출력, 섞여있다면 2가 출력됩니다.
		int oneCnt = 0;
		int zeroCnt = 0;
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (box[i][j] == 1)
					oneCnt++;
				else
					zeroCnt++;
			}
		}

		if (oneCnt == cnt)
			return 1;
		else if (zeroCnt == cnt)
			return 0;
		else
			return 2;
	}

}
