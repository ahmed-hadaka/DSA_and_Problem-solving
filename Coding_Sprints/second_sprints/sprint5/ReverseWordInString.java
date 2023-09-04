package coding_interviews1.second_sprints.sprint5;

// https://leetcode.com/problems/reverse-words-in-a-string/description/
public class ReverseWordInString {
	public static void main(String[] args) {
		ReverseWordInString reverseWordInString = new ReverseWordInString();
		System.out.println(reverseWordInString.reverseWords("   a 1goo7d  9Exampe2   5"));
	}

	public String reverseWords(String s) {
		String[] strArr = s.split(" ");
		StringBuilder reversedString = new StringBuilder("");
		for (int i = strArr.length - 1; i >= 0; i--) {
			if (strArr[i].length() > 0 && strArr[i].charAt(0) != ' ') {
				reversedString.append(strArr[i]).append(" ");
			}
		}
		return reversedString.toString().substring(0, reversedString.length() - 1);
	}
}
