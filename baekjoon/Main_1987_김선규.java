package a0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_1987_김선규 {

	static int[][] board;
	static int[][] delta = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }};
	static int max = 1;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		board = new int[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = s.charAt(j) - 'A';
			}
		}
		// input end

		check = new boolean[26];

		findRoute(0, 0, R, C, 1); // 첫 방문지도 카운팅되므로 ans는 1부터 시작

		System.out.println(max);
	}

	public static void findRoute(int x, int y, int R, int C, int ans) {
		
		if (check[board[x][y]]) {// 방문한 적이 있다면 리턴
			max = Math.max(max, ans); // 리턴 시 최고 깊이이므로 max값 저장
			return;
		}
		
		check[board[x][y]] = true; // 방문 체크
		
		for (int i = 0; i < 4; i++) { // 4방탐색

			if (x + delta[i][0] >= 0 && y + delta[i][1] >= 0 && x + delta[i][0] < R && y + delta[i][1] < C) {
			// 이동 후 위치가 범위 안이어야 함

				int nx = x + delta[i][0];
				int ny = y + delta[i][1];
				
				if(check[board[nx][ny]]) { // 이동할 곳이 true라면 다시 빼줌 -> 현재위치
					nx -= delta[i][0];
					ny -= delta[i][1];
				}
				else { // 이동할 곳이 false라면 이동
					max = Math.max(max, ans+1);
					findRoute(nx, ny, R, C, ans+1);
				}
			}
		}
		// 4방탐색 후 갈곳이 없다면 현재 위치를 false하고 리턴
		check[board[x][y]] = false;
		return;
	}

}
