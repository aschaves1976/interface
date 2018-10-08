package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.entities.Employee;

public class ProgramInterfaceComprable2 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		List<Employee> list = new ArrayList<>();
		String path = "C:\\ASChaves\\JAVA\\temp\\InterComp.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String employeeCsv = br.readLine();
			while (employeeCsv != null) {
				String[] fields = employeeCsv.split(",");
				list.add(new Employee(fields[0], Double.parseDouble(fields[1])));
				employeeCsv = br.readLine();
			}
			/*
			 * funcionarios ordenados por nome: na classe Employee, no método compareTo(),
			 * utilizar o atributo name; Funcionarios ordenados pelo salário: na classe
			 * Employee, no método compareTo(), utilizar o atributo salary;Se precisar
			 * ordenar em ordem decrescente, utilizar o sinal de "-" no compareTo()
			 */
			Collections.sort(list);
			for (Employee e : list) {
				System.out.println(e.toString());
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
