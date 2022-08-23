import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location {
	int x;
	int y;
	int cnt;
	
	Location(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

public class Main_7576_김선규 {
	
	static int N, M, zeroCnt, oneCnt;
	static int[][] delta = {{0, 1},{0, -1},{1, 0},{-1, 0}};
	static int[][] tomato;
	static boolean[][] visited; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		tomato = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if(tomato[i][j]==0)
					zeroCnt++;
				else if(tomato[i][j]==1)
					oneCnt++;
			}
		}
		
		spread();
		
		int ans = 0;
		int day = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visited[i][j])
					ans++;
			}
		}
		
		ans -= oneCnt;
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				day = Math.max(tomato[i][j], day);
			}
		}
		
		if(zeroCnt==0)
			System.out.println(0);
		else if(ans==zeroCnt)
			System.out.println(day);
		else
			System.out.println(-1);
		
	}
	
	public static void spread() {
		
		Location[] loc = new Location[oneCnt];
		
		Queue<Location> q = new LinkedList<>();
		
		int start = 0;
		
		for(int i=0; i<N; i++) { // 1인 위치를 찾아서 loc객체 배열에 저장
			for(int j=0; j<M; j++) {
				if(tomato[i][j]==1) {
					q.add(loc[start++] = new Location(i, j, 1));
					visited[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			
			Location l = q.poll();
			
			for(int i=0; i<4; i++) {
				
				int nx = l.x + delta[i][0];
				int ny = l.y + delta[i][1];
				
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if(tomato[nx][ny]==-1)
						continue;
					
					if(tomato[nx][ny] == 0)
						tomato[nx][ny] = l.cnt;
					
					if(visited[nx][ny]) continue;
					
					visited[nx][ny] = true;
					q.add(new Location(nx, ny, l.cnt+1));
				}
			}
		}
	}
}
