import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2164_김선규 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//=====input
		
		//데이터의 맨 앞, 맨 뒤에서 삽입, 삭제가 발생하므로 큐 자료구조를 사용하는 것이 맞다고 생각했습니다.
		Queue<Integer> q = new LinkedList<>();
		
		//카드 리스트를 큐에 삽입
		for(int i=1; i<=N; i++)	
			q.offer(i);
		
		//큐의 맨 앞 값 삭제 후 두번째 값을 다시 맨 뒤로 삽입하는 로직. 1개가 남을때까지 반복
		while(q.size()>1) {
			q.poll();
			int tmp = q.peek();
			q.poll();
			q.offer(tmp);
		}
		
		System.out.println(q.peek());
		
	}

}
