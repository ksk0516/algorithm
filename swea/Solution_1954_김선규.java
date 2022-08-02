import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1954_김선규 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] go = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] dal = new int[N + 2][N + 2];
			//input
			
			int x = 1, y = 1;
			int num = 1;
			int tmp = 0; //방향 전환을 위한 변수

			if(N==1) {
				System.out.println("#"+tc+" ");
				System.out.println(1);
				continue;
			}
				
			while (num <= N*N) {
				int j = tmp % 4;
				for (int i = 0; i < N; i++) {
					dal[x][y] = num;
					num++;

					//다음 이동자리
					x += go[j][0];
					y += go[j][1];
					
					//다음 이동자리가 5거나 0이면 멈춤 -> 방향 전환
					if ((x + go[j][0]) == N + 1 || (x + go[j][0]) == 0 || (y + go[j][1]) == N + 1 || (y + go[j][1]) == 0)
						break;
					
					//다음 이동자리가 숫자가 차있으면 멈춤 -> 방향 전환
					if (dal[x + go[j][0]][y + go[j][1]] != 0)
						break;
				}
				tmp++;
			}

			
			//output
			System.out.println("#"+tc+" ");
			for (x = 1; x < N + 1; x++) {
				for (y = 1; y < N + 1; y++) {
					System.out.print(dal[x][y] + " ");
				}
				System.out.println();
			}
		}
	}
}