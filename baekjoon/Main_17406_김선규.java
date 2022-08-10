import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17406_김선규 {

	static int[][] arr;
	static int[][] tmp;
	static boolean[] visited;
	static int[] ans;
	static int[] r;
	static int[] c;
	static int[] s;
	static int N, M, R;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		tmp = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				tmp[i][j] = arr[i][j];
			}
		}
		visited = new boolean[R];
		ans = new int[R];

		r = new int[R];
		c = new int[R];
		s = new int[R];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			r[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
			s[i] = Integer.parseInt(st.nextToken());
		}
		// input end
		

		perm(0, R); // R가지 경우의 수 순열 찾기
		
		System.out.println(min); // 최종 결과(최솟값) 출력
	}

	private static void perm(int idx, int cnt) {
		if (idx == cnt) { // 정답 후보의 배열이 완성된다면
			for (int i = 0; i < cnt; i++) {
				spin(r[ans[i]], c[ans[i]], s[ans[i]]); // 완성된 순열로 배열을 돌려줍니다.
			}
			
			for (int i = 1; i <= N; i++) { // 완성된 순열의 각 행별 최솟값을 구해줍니다. 
				int sum = 0;
				for (int j = 1; j <= M; j++) {
					sum += tmp[i][j];
				}
				min = (sum > min) ? min : sum; // 최솟값 갱신
			}
			
			tmp = new int[N + 1][M + 1]; // 다음 순열로 새롭게 배열을 돌려야 하므로 배열을 초기화 해줍니다.
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					tmp[i][j] = arr[i][j];
				}
			}
		}

		for (int i = 0; i < cnt; i++) { // 순열 생성하는 로직입니다.
			if (visited[i])
				continue;
			ans[idx] = i;
			visited[i] = true;
			perm(idx + 1, cnt);
			visited[i] = false;
		}
	}

	private static void spin(int r, int c, int s) { // 배열을 오른쪽으로 한칸씩 돌리는 로직입니다.
		int sx = r - s; // 시작 : 맨왼쪽위 (sx, sy) 
		int sy = c - s;
		int ex = r + s;
		int ey = c + s; // 끝 : 맨오른쪽아래 (ex, ey)

		int times = ex - sx; 

		for (int cycle = 0; cycle < s; cycle++) {
			int first = tmp[sx][sy]; // 맨 첫칸은 덮어씌워지므로 first라는 변수에 저장

			for (; sx < ex; sx++) { // 왼쪽 줄 돌리기
				tmp[sx][sy] = tmp[sx + 1][sy];
			}
			sx = ex - times;
			for (; sy < ey; sy++) { // 아래쪽 줄 돌리기
				tmp[ex][sy] = tmp[ex][sy + 1];
			}
			sy = ey - times;
			for (; ex > sx; ex--) { // 오른쪽 줄 돌리기
				tmp[ex][ey] = tmp[ex - 1][ey];
			}
			ex = sx + times;
			for (; ey > sy; ey--) { // 위쪽 줄 돌리기
				tmp[sx][ey] = tmp[sx][ey - 1];
			}
			ey = sy + times;
			
			tmp[sx][sy + 1] = first; // 덮어씌워진 값 제대로 넣어주기
			
			sx++;
			sy++;
			ex--;
			ey--;
			times--;
			times--;
			// 안쪽의 한칸 작은 배열로 들어가기 위해 모든 변수를 일부 증가, 일부 감소 시켜줍니다.
		}
	}
}