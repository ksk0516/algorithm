import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1861_김선규 {
	
	static int[][] box;
	static boolean[][] check;
	static int N, ToTal = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<= T ; tc++) {
			N = Integer.parseInt(br.readLine());
			box = new int[N+2][N+2];
			check = new boolean[N+2][N+2];
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=N; j++) {
					box[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//  input end
			
			
			int max = 0;
			int here = 0;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					ToTal = 0;
					int tmp = find(i, j, 1);
					
					if(max < tmp) {
						max = tmp;
						here = box[i][j];
					}
					
					if(max == tmp) 
						here = (box[i][j] > here) ? here : box[i][j];
				}
			}
			
			System.out.println("#"+tc+" "+here+" "+max);
		}
	}
	
	
	private static int find(int x, int y, int count) {
		
		check[x][y] = true;
		
		if(!check[x+1][y] && box[x][y] + 1 == box[x+1][y]) {
			count++;
			find(x+1, y, count);
			check[x+1][y] = false;
		}
		else if(!check[x-1][y] && box[x][y] + 1 == box[x-1][y]) {
			count++;
			find(x-1, y, count);
			check[x-1][y] = false;
		}
		else if(!check[x][y+1] && box[x][y] + 1 == box[x][y+1]) {
			count++;
			find(x, y+1, count);
			check[x][y+1] = false;
		}
		else if(!check[x][y-1] && box[x][y] + 1 == box[x][y-1]) {
			count++;
			find(x, y-1, count);
			check[x][y-1] = false;
		}
		
		ToTal = (ToTal > count) ? ToTal : count;
		
		check[x][y] = false;
		
		return ToTal;
	}

}
