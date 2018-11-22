import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class ObjectCsvParser {

	private static final String SAMPLE_CSV_FILE_PATH = "c:/Users/schudst/Documents/users-with-header2.csv";

//	try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
//			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);) {
//		for (CSVRecord csvRecord : csvParser) {
//			// Accessing Values by Column Index
//			String name = csvRecord.get(0);
//			String email = csvRecord.get(1);
//			String phone = csvRecord.get(2);
//			String country = csvRecord.get(3);
//	
	public static void main(String[] args) throws FileNotFoundException, IOException {

//		//Create the CSVFormat object
//		CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
//		
//		//initialize the CSVParser object
//		CSVParser parser = new CSVParser(new FileReader("employees.csv"), format);

		Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

		List<User> users = new ArrayList<User>();
		for (CSVRecord record : csvParser) {
			User user = new User();
			user.setName(record.get("Name"));
			user.setEmail(record.get("Email"));
			user.setPhone(Long.parseLong(record.get("Phone")));
			user.setCountry(record.get("Country"));
			users.add(user);
		}
		// close the parser
		csvParser.close();

		System.out.println(users);

//		//CSV Write Example using CSVPrinter
//		CSVPrinter printer = new CSVPrinter(System.out, format.withDelimiter('#'));
//		System.out.println("********");
//		printer.printRecord("ID","Name","Role","Salary");
//		for(User emp : emps){
//			List<String> empData = new ArrayList<String>();
//			empData.add(emp.getId());
//			empData.add(emp.getName());
//			empData.add(emp.getRole());
//			empData.add(emp.getSalary());
//			printer.printRecord(empData);
//		}
//		//close the printer
//		printer.close();
//	}
	}
}
