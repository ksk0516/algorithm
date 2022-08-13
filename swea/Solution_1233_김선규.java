import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233_김선규 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int ok = 1;
			boolean holzzak = false;
			int div = N / 2;
			if (div % 2 == 0) {
				div--;
				holzzak = true; // 짝수면 true
			}

			if (holzzak) { // 짝수면
				for (int j = 0; j < div; j++) {
					st = new StringTokenizer(br.readLine());
					int node = Integer.parseInt(st.nextToken());
					char c = st.nextToken().charAt(0);
					if (c >= 48 && c <= 57) {
						ok = 0;
					}
					if (j == div - 1) {
						int left = Integer.parseInt(st.nextToken());
					} else {
						int left = Integer.parseInt(st.nextToken());
						int right = Integer.parseInt(st.nextToken());
					}
				}
				for (int j = div; j < N; j++) {
					st = new StringTokenizer(br.readLine());
				}
			} else { // 홀수면
				for (int j = 0; j < div; j++) {
					st = new StringTokenizer(br.readLine());
					int node = Integer.parseInt(st.nextToken());
					char c = st.nextToken().charAt(0);
					if (c >= 48 && c <= 57) {
						ok = 0;
					}
					if (j == div - 1) {
						int left = Integer.parseInt(st.nextToken());
					} else {
						int left = Integer.parseInt(st.nextToken());
						int right = Integer.parseInt(st.nextToken());
					}
				}
				for (int j = div; j < N; j++) {
					st = new StringTokenizer(br.readLine());
				}
			}
			System.out.println("#" + tc + " " + ok);
		}
	}
}
