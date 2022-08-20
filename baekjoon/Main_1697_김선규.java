package a0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_김선규 {

	static int[] distance = new int[100001];
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		// input end

		find(N, K);

		System.out.println(ans);
	}

	public static void find(int N, int K) {
		Queue<Integer> q = new LinkedList<>();

		if (N == K) { // 시작과 끝이 같을 경우 0초를 리턴
			ans = 0;
			return;
		}

		q.add(N);
		int now = 0;

		while (!q.isEmpty()) { // -1, +1, X2 한 값을 큐에 넣고 하나씩 빼며 -1, +1, X2 한 값을 다시 큐에 넣는 과정 반복
			now = q.poll();
			if (now >= 0 && now <= 100000) {
				if (now > 0 && distance[now - 1] == 0) {
					distance[now - 1] = distance[now] + 1;
					q.add(now - 1);
				}
				if (now < 100000 && distance[now + 1] == 0) {
					distance[now + 1] = distance[now] + 1;
					q.add(now + 1);
				}
				if (now > 0 && now <= 50000 && distance[now * 2] == 0) {
					distance[now * 2] = distance[now] + 1;
					q.add(now * 2);
				}

				// 반복하다가 K값이 나오면 정답 
				if (now - 1 == K) {
					ans = distance[now - 1];
					break;
				}
				if (now + 1 == K) {
					ans = distance[now + 1];
					break;
				}
				if (now * 2 == K) {
					ans = distance[now * 2];
					break;
				}

			}
		}
		return;
	}
}
