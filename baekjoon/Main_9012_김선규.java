import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012_김선규 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			String s = br.readLine();
			Stack<Character> stack = new Stack<Character>();

			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				
				if(stack.isEmpty()) {
					stack.push(c);
				}
				
				else {
					if(stack.peek()=='(') {
						if(c==')')
							stack.pop();
						else
							stack.push(c);
					}
					else
						stack.push(c);
				}
			}
			if(stack.isEmpty())
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
