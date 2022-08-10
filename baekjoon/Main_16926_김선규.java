import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926_김선규 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// input end

		int[][] newArr = new int[N][M];
		int[][] tmpArr = new int[N][M];
		tmpArr = arr;
		int rsx = 0, rsy = 0, rex = N - 1, rey = M - 1;
		int sx = 0, sy = 0, ex = N - 1, ey = M - 1;
		
		while (rsx <= rex && rsy <= rey) {

			for (int t = 0; t < R; t++) {
				int tmp = arr[sx][sy];

				for (int ny = sy + 1; ny <= ey; ny++) { 
					newArr[sx][sy] = arr[sx][ny]; 
					sy++;
				}
				sx = rsx;
				sy = rsy;
				for (int nx = sx + 1; nx <= ex; nx++) {
					newArr[sx][ey] = arr[nx][ey];
					sx++;
				}
				sx = rsx;
				sy = rsy;
				for (int ny = ey - 1; ny >= sy; ny--) { 
					newArr[ex][ey] = arr[ex][ny]; 
					ey--;
				}
				ex = rex;
				ey = rey;
				for (int nx = ex - 1; nx >= sx; nx--) { 
					newArr[ex][sy] = arr[nx][sy];
					ex--;
				}
				ex = rex;
				ey = rey;
				newArr[sx + 1][sy] = tmp;
				arr = newArr;
			}
			
			sx++;
			sy++;
			ex--;
			ey--;
			
			rsx++;
			rsy++;
			rex--;
			rey--;
			arr = tmpArr;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(newArr[i][j]+" ");
			}
			System.out.println();
		}

	}

}