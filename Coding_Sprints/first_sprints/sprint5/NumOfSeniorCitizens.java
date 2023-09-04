package coding_interviews1.first_sprints.sprint5;

// https://leetcode.com/contest/biweekly-contest-104/problems/number-of-senior-citizens
public class NumOfSeniorCitizens {

	public static void main(String[] args) {
		String[] dStrings = { "7868190130M7522", "5303914400F9211", "9273338290F4010" };
		System.out.println(countSeniors(dStrings));
	}

	public static int countSeniors(String[] details) {

		int c = 0;
		for (int i = 0; i < details.length; i++) {
			String pasDetails = details[i];
			int age = (pasDetails.charAt(11) - '0') * 10 + (pasDetails.charAt(12) - '0');
			if (age > 60)
				c++;
		}
		return c;
	}
}
