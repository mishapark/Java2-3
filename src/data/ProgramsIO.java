package data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProgramsIO {
private static File myFile = new File("ProgramList.txt");
	
	public static Object[] readPrograms() throws IOException {
		Scanner scanner = new Scanner(myFile);
		ArrayList<String> names = new ArrayList<String>();
		while(scanner.hasNext()) {
			String name = scanner.nextLine();
			names.add(name);
		}
		scanner.close();
		return names.toArray();
	}
}
