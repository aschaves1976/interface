package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProgramInterfaceComparable1 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		List<String> list = new ArrayList<>();
		String path = "C:\\ASChaves\\JAVA\\temp\\InterComp.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String name = br.readLine();
			while (name != null) {
				list.add(name);
				name = br.readLine();
				System.out.println();
			}
			java.util.Collections.sort(list);
			for (String s : list) {
				System.out.println(s);
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
