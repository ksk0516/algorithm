import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1107_김선규 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[] check = new boolean[10];
		int[] button = new int[M];
		if (M != 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				button[i] = Integer.parseInt(st.nextToken());
				check[button[i]] = true;
			}
		}
		// input end

		int start = 100;
		int rsl = 0, ans = 0;
		int min = Integer.MAX_VALUE;

		// 모든 경우의수 곱하기 자릿수 = 대략 600만. 완전탐색으로 해결
		if (N == start) {
			min = 0;
		}
		else {
			rsl = Math.abs(N - 100); // 아무데도 갈 수 없다면 rsl가 정답이 되겠지   // N-100이 자릿수보다 작으면 정답은 그냥 N-100이 되겠네
			for (int i = 0; i <= 999999; i++) {
				// N = 5457 / rsl = 5357
				String s = Integer.toString(i); 
				int num = 0;
				//0부터 999999까지 N에 도달하려면 얼마나 걸리는지 체크
				for (int j = 0; j < s.length(); j++) { // 0~999999  채널로 바로 갈 수 있는지 체크 !
					if (!check[s.charAt(j) - '0']) { // 각 자리가 false인지 체크
						num++; // 그 자리가 false라서 ~ 갈수 있다면 자릿수만큼 num++
					}
				}
				if (num == s.length()) { // 원하는 채널로 바로 이동이 가능하다면? : 이동한 채널의 자릿수 + N까지 남은 거리
					ans = num + Math.abs(N - i);
					if(num > rsl)
						ans = rsl;
//					System.out.println("ans : " + num + " + " + Math.abs(N - i) + " = " + ans);
//					System.out.println("-----");
				} else { // 원하는 채널로 바로 이동이 불가능하다면? 100번 채널에서 N까지 일일히 + - 눌러야함
//					ans = Math.min(Math.abs(N - 100), min);
					ans = rsl;
				}
				min = Math.min(min, ans);
				// 0부터 끝까지 모든 수를 확인후 min을 확정지음
			}
			
		}
		System.out.println(min);
	}

}
