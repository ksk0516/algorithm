import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6808_김선규 {

	static boolean[] isSelected = new boolean[10];
	static int[] gyu;
	static int[] in;
	static int[] ans = new int[10];
	static int win = 0, lose = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			gyu = new int[10];
			in = new int[10];
			boolean[] chk = new boolean[19];
			chk[0] = true;
			for(int i=1; i<gyu.length; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				chk[gyu[i]] = true; // 예 1,2,3,4,5,6,7,8,9는 true
			}
			// input end
			
			for(int i=1, j=1; i<=18; i++) {
				if(!chk[i]) {
					in[j] = i;
					j++;
				}
			}// 인영이의 카드 완성	
			
			perm(1);
			
			System.out.println("#"+tc+" "+win+" "+lose);
			win -= win;
			lose -= lose;
		}
	}
	
	private static void perm(int cnt) {
		if(cnt == 10) {
			int g=0;
			int n=0;
			for(int i=1; i<=9; i++) {
				if(gyu[i] > ans[i])
					g += gyu[i] + ans[i];
				else
					n += gyu[i] + ans[i];
			}
			if(g>n)
				win++;
			else
				lose++;
		}
		
		for (int i = 1; i <= 9; i++) {
			if (isSelected[i]) continue;
			ans[cnt] = in[i];
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;			
		}	}
	
}
