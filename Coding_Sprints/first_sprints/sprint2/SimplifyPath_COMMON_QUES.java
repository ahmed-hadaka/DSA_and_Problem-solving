package coding_interviews1.first_sprints.sprint2;

import java.util.Stack;

// https://leetcode.com/problems/simplify-path/description/
public class SimplifyPath_COMMON_QUES {
	// '.' ==> stay in your current dir/file
	// ".." ==> go back on level.
	public static void main(String[] args) {
		SimplifyPath_COMMON_QUES simplifyPath = new SimplifyPath_COMMON_QUES();
		String s = simplifyPath.simplifyPath("/..hidden");
		System.out.println(s);
	}

	// lengthy code :|
	public String simplifyPath(String path) {
		Stack<String> st = new Stack<>();
		for (int i = 0; i < path.length(); i++) {
			char c = path.charAt(i);
			if (c == '.') {
				//
				int count = 0;
				for (int s = i; s < path.length(); s++) {
					if (path.charAt(s) == '/')
						break;
					count++;
				}
				//
				if (count == 1) {
					if (!st.isEmpty())
						st.pop();
				} else if (count == 2) {
					if (path.charAt(i + 1) != '.') {
						st.push(path.substring(i, i + 2));
					} else {
						int t = 0;
						while (!st.isEmpty() && t < 3) {
							st.pop();
							t++;
						}
					}
					i++;
				} else {
					st.push(path.substring(i, i + count));
					i = i + count - 1;
				}
			} else if (c == '/') {
				if (st.isEmpty() || !st.peek().equals("/"))
					st.push("/");
			} else {
				int count = 0;
				for (int s = i; s < path.length(); s++) {
					if (path.charAt(s) == '/')
						break;
					count++;
				}
				st.push(path.substring(i, i + count));
				i = i + count - 1;
			}
		}
		StringBuilder canonicalPath = new StringBuilder("");
		for (String string : st) {
			canonicalPath.append(string);
		}
		String res = canonicalPath.toString();
		if (canonicalPath.length() != 0 && canonicalPath.charAt(canonicalPath.length() - 1) == '/')
			res = canonicalPath.substring(0, canonicalPath.length() - 1).toString();
		if (res.length() != 0 && res.charAt(0) != '/')
			return "/" + res;
		return res.length() == 0 ? "/" : res;
	}
}
