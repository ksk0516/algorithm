import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225_김선규 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();

			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < 8; i++)
				q.add(Integer.parseInt(st.nextToken()));
			//********input********
			
			int m = 1;   //cycle 1~5를 빼주는 변수. 1부터 빼주니까 1이라고 초기화해줌
			int tmp = 2; //q의 맨 앞값. 0보다 작아지면 while문 종료시키기 위한 변수.
			
			while (tmp > 0) {
				if(m==6) 
					m=1;
				tmp = q.peek() - m;
				if(tmp <= 0) 
					tmp = 0;
				q.poll();
				q.add(tmp);
				m++;
			}
			
			//*********output**********
			sb.append("#").append(tc).append(" ");
			for(int i=0; i<8; i++)
				sb.append(q.poll()+" ");
			System.out.println(sb);
		}
	}

}
