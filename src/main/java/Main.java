import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.naming.spi.Resolver;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Main {

	public static void main(String[] args) throws IOException {
		String documentsPath = System.getProperty("user.home")+"/Documents";
		Path documentsDirectory = Paths.get(documentsPath);
		String filename = "data1.csv";
		Path csvPath = documentsDirectory.resolve(filename);
//		System.out.println(csvPath);
		CSVParser csvParser = CSVParser.parse(csvPath,  Charset.defaultCharset(),CSVFormat.DEFAULT.withHeader("ID","Name","Age"));
		
//		csvParser.forEach(CSVRecord ->{System.out.println(CSVRecord.toMap());});
		
		Stream<CSVRecord> csvRecordStream = StreamSupport.stream(csvParser.spliterator(), false);
		
		List<Map<String, String>> rowList = csvRecordStream
		.skip(1)
		.map(csvRecord ->csvRecord.toMap())
		.collect(Collectors.toList());
		
		System.out.println(rowList);


	}

}
