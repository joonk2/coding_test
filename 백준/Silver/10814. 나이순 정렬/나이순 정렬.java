import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;



public class Main {
	
	static class Person {
		int age;
		String name;
		int input_order;
		
		Person(int age, String name, int input_order) {
			this.age = age;
			this.name = name;
			this.input_order = input_order;
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Person> lst = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String[] arr = br.readLine().split(" ");
			int age = Integer.parseInt(arr[0]);
			String name = arr[1];
			int idx = i;
			lst.add(new Person(age, name, idx));
		}
		
		List<Person> res = myCompare(lst);
		
		StringBuilder sb = new StringBuilder();
		for (Person P : res) {
			sb.append(P.age + " " + P.name + "\n");
		}
		System.out.print(sb.toString());
		
	}
	
	
	public static List<Person> myCompare(List<Person> lst) {
		Collections.sort(lst, new Comparator<Person>() {
			public int compare(Person a, Person b) {
				if (a.age != b.age) {
					return a.age - b.age;
				}
				else {
					return a.input_order - b.input_order;
				}
			}
		});
		return lst;
	}
	
}