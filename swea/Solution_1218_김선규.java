import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1218_김선규 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			String s = br.readLine();
			// input

			Stack<Character> st = new Stack<Character>();

			for (int i = 0; i < s.length(); i++) {
				char a = s.charAt(i);

				switch (a) {
				case '(':
					st.add(a);
					break;
				case '[':
					st.add(a);
					break;
				case '{':
					st.add(a);
					break;
				case '<':
					st.add(a);
					break;
				case ')':
					if (!st.isEmpty() && st.peek().equals('('))
						st.pop();
					else
						st.add(')');
					break;
				case ']':
					if (!st.isEmpty() && st.peek().equals('['))
						st.pop();
					else
						st.add(']');
					break;
				case '}':
					if (!st.isEmpty() && st.peek().equals('{'))
						st.pop();
					else
						st.add('}');
					break;
				case '>':
					if (!st.isEmpty() && st.peek().equals('<'))
						st.pop();
					else
						st.add('>');
					break;
				}


			}
			if (st.isEmpty())
				System.out.println("#" + tc + " " + 1);
			else
				System.out.println("#" + tc + " " + 0);
		}
	}
}
