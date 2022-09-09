package problems_Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FindFullNames {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		System.out.println("enter number of full names");
		int fullNum = sc.nextInt();
		for (int i = 0; i < fullNum; i++) {
			System.out.println("enter the full name pacies number");
			int fullName_pacies = sc.nextInt();
			String fullName = "";
			List<String> names = new ArrayList<>();
			for (int j = 0; j < fullName_pacies; j++) {
				String part = sc.next();
				if (j != 0)
					fullName += " ";
				fullName += part;
				names.add(fullName);
			}
			for (String string : names) {
				if (map.get(string) == null) {
					ArrayList<String> temp = new ArrayList<>();
					map.put(string, temp);// create a key-value pair
					temp.add(fullName); // update the value
				} else
					map.get(string).add(fullName);
			}
		}
		System.out.println("enter your quiry number");
		int qNum = sc.nextInt();
		for (int i = 0; i < qNum; i++) {
			System.out.println("enter the quiry pacies number");
			int qPacies = sc.nextInt();
			String fullQuiry = "";
			for (int j = 0; j < qPacies; j++) {
				String peice = sc.next();
				if (j != 0)
					fullQuiry += " ";
				fullQuiry += peice;
			}

			if (map.containsKey(fullQuiry))
				System.out.println(map.get(fullQuiry));
			else {
				System.out.println("didn't found!");
			}

		}
		sc.close();
	}

}
