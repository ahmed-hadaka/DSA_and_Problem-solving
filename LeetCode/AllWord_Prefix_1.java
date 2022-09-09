package problems_Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AllWord_Prefix_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		System.out.println("enter number of full names");
		int fullNum = sc.nextInt();
		for (int j = 0; j < fullNum; j++) {
			System.out.println("enter the name");
			String name = sc.next();
			char[] arr = name.toCharArray();
			List<String> names = new ArrayList<>();
			String fullName = "";
			for (char c : arr) {
				fullName += c;
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
			System.out.println("enter the quiry");
			String quiry = sc.next();
			if (map.containsKey(quiry))
				System.out.println(map.get(quiry));
			else {
				System.out.println("didn't found!");
			}
		}
		sc.close();
	}

}
