package a0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1541_김선규 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		ArrayList<String> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), "-"); // -가 나올때마다 나눠준다
		while (st.hasMoreElements()) {
			list.add(st.nextToken());
		}

		int sum = 0;

		if (list.size() == 1) { // 전부다 +만 있다면
			st = new StringTokenizer(list.get(0), "+");
			while (st.hasMoreElements()) {
				int a = Integer.parseInt(st.nextToken());
				sum += a;
			}
		} else {
			st = new StringTokenizer(list.get(0), "+");
			while (st.hasMoreElements()) {
				int a = Integer.parseInt(st.nextToken());
				sum += a;
			}

			for (int i = 1; i < list.size(); i++) {
				st = new StringTokenizer(list.get(i), "+");
				while (st.hasMoreElements()) {
					int b = Integer.parseInt(st.nextToken());
					sum -= b;
				}
			}

		}

		System.out.println(sum);

	}
}
