import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.utils.Json;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		List<String> dostepne = new ArrayList<String>();
		List<Car> osobowy = new ArrayList<Car>();
		List<Car> f1 = new ArrayList<Car>();
		List<Car> ciezarowy = new ArrayList<Car>();
		List<Car> dostawczy = new ArrayList<Car>();
		
		dostepne.add("osobowy");
		dostepne.add("f1");
		dostepne.add("ciezarowy");
		dostepne.add("dostawczy");
		osobowy.add(new Car("Fiat","1993","1,6","180"));
		osobowy.add(new Car("Renault","1999","1,8","190"));
		f1.add(new Car("Ferrari","2021","2,0","310"));
		f1.add(new Car("Ferrari","2010","2,0","300"));
		ciezarowy.add(new Car("Volvo","1993","1,7","150"));
		ciezarowy.add(new Car("Citroen","2008","1,9","140"));
	//	dostawczy.add(new Car("DAF","2005","2,0","150"));
	//	dostawczy.add(new Car("Volvo","2000","2,0","130"));
		
		//saveList(f1);

		
		List<Car> f2 = loadCar("f1");
		System.out.println(f2.get(0).Print());
		
	}
	public static void saveList(List<Car> osobowy){
			Json json = new Json();
			
			String pathT = "src/main/webapp/Json/f1.json";
			FileOutputStream outputStream;
			try {
				outputStream = new FileOutputStream(pathT);
			
		    byte[] strToBytes = json.prettyPrint(osobowy).getBytes();
		    outputStream.write(strToBytes);
		    outputStream.flush();
		    outputStream.close();
			
			//file.writeString(wordList[0].toString(), false);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	
	
	public static List<Car> loadCar(String s)  {
		List<Car> out = new ArrayList<Car>();
		BufferedReader br;
		try {
			

			br = new BufferedReader(new FileReader("src/main/webapp/Json/"+s+".json"));
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		//System.out.println(everything);
		    br.close();
			Json json = new Json();
			//json.setIgnoreUnknownFields(true);
			
			out = json.fromJson(ArrayList.class, everything);
			//System.out.println(wordList[0]);
		//	json.prettyPrint(list);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return out;
		
	}
	
	public static List<String> loadList()  {
		List<String> out = new ArrayList<String>();
		BufferedReader br;
		try {
			

			br = new BufferedReader(new FileReader("src/main/webapp/Json/list.json"));
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		//System.out.println(everything);
		    br.close();
			Json json = new Json();
			//json.setIgnoreUnknownFields(true);
			
			out = json.fromJson(ArrayList.class, everything);
			//System.out.println(wordList[0]);
		//	json.prettyPrint(list);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return out;
		
	}
	
}
