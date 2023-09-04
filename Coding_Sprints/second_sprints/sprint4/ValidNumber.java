package coding_interviews1.second_sprints.sprint4;

public class ValidNumber {
	public boolean isNumber(String s) {
		if (s.length() == 1) {
			if (s.charAt(0) == '-' || s.charAt(0) == '+' || s.charAt(0) == '.')
				return false;
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if ((c == 'e' || c == 'E') && i == 0)
				return false;
			if (c == '-' || c == '+') {
				if ((i > 0 && !(s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) || (i != 0))
					return false;
			}
			if (c == '.') {
				if ((i > 0
						&& !(Character.isDigit(s.charAt(i - 1)) || s.charAt(i - 1) == '-' || s.charAt(i - 1) == '+')))
					return false;
			}
			if (c == 'e' || c == 'E') {
				if (i == s.length() - 1 || !(Character.isDigit(s.charAt(i - 1)) || s.charAt(i - 1) == '.'))
					return false;
			}
		}
		return true;
	}
}
