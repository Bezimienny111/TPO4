

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.badlogic.gdx.utils.Json;

/**
 * Servlet implementation class Searcher
 */
@WebServlet({ "/Searcher", "/searcher" })
public class Searcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private List<String> cars = new ArrayList<String>();
       private List<Car> done = new ArrayList<Car>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Searcher() {
        super();

    	
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String realPath = "/Json/list.json";
	    //	System.out.print(realPath);
		List<String> out = new ArrayList<String>();
		ServletContext context = getServletContext();
		 InputStream is = context.getResourceAsStream(realPath);
	        if (is != null) {
	        	
	    		BufferedReader br;
	    		try {
	    	        InputStreamReader isr = new InputStreamReader(is);
	    	        
	    			br = new BufferedReader(isr);
	    		
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
	        }
	        this.cars = out;

		
		String carType = request.getParameter("car");
		StringBuilder sb = new StringBuilder();
		List<Car> outCar = new ArrayList<Car>();
		if(this.cars.contains(carType)) {
			//System.out.println("aaaa");
			String carPath = "/Json/"+carType+".json";
		//	System.out.println(carPath);
			InputStream isT = context.getResourceAsStream(carPath);
			if (isT != null) {
			BufferedReader br;
			try { 
				InputStreamReader isr = new InputStreamReader(isT);
				br = new BufferedReader(isr);
			    StringBuilder sbT = new StringBuilder();
			    String line = br.readLine();

			    while (line != null) {
			 //   	System.out.println(line);
			    	sbT.append(line);
			    	sbT.append(System.lineSeparator());
			        line = br.readLine();
			    }
			    String everything = sbT.toString();
			//System.out.println(everything);
			    br.close();
				Json json = new Json();
				//json.setIgnoreUnknownFields(true);
				
				outCar = json.fromJson(ArrayList.class, everything);
				//System.out.println(wordList[0]);
			//	json.prettyPrint(list);
				System.out.println(outCar);
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
			
			done = outCar;
			//System.out.println(done);
			Json jsonPrint = new Json();
		
		
				sb.append(jsonPrint.prettyPrint(done));
			//	sb.append(System.lineSeparator());
			}
			else{
				sb.append("Brak");
			}
			//System.out.print(sb.toString());
//		StringBuilder html = new StringBuilder();
//		if(!sb.toString().equals("Brak")) {
//		Json jsonNew = new Json();
//		String outTable;
//		List<Car> cars = new ArrayList<Car>();
//		cars = jsonNew.fromJson(ArrayList.class, sb.toString());
//		
//		html.append("<table style=\"width:100%\">");
//		html.append("<tr>");
//		html.append("<th>" + "Marka" +"</th>");
//		html.append("<th>" + "Rok Produkcji" + "</th>");
//		html.append("<th>" + "Silnik" + "</th>");
//		html.append("<th>" + "Maksymalna Prędkość" + "</th>");
//		html.append("</tr>");
//		for(Car c:cars) {
//			html.append("<tr>");
//			html.append("<th>" + c.getMarka() +"</th>");
//			html.append("<th>" + c.getRok() + "</th>");
//			html.append("<th>" + c.getSilnik() + "</th>");
//			html.append("<th>" + c.getMaxPrędkośc() + "</th>");
//			html.append("</tr>");
//		}
//		html.append("</table>");
//		}else {
//			html.append("Brak danych");
//		}
			
			request.setAttribute("cars", sb.toString());
			
			 RequestDispatcher dispatcher =
				       getServletContext().getRequestDispatcher("/Table");
				    dispatcher.forward(request, response);
			
				    
		//response.setContentType("text/html; charset=ISO-8859-2");
	//	PrintWriter writer = response.getWriter();
		//writer.println("<h1>Hello " + html + "</h1>");
	//	writer.close();
	}
	
	
	public static List<String> loadList(String path)  {
		List<String> out = new ArrayList<String>();
		BufferedReader br;
		try {
			
	        InputStream ins = Searcher.class.getResourceAsStream(path);
	        InputStreamReader isr = new InputStreamReader(ins);
			br = new BufferedReader(isr);
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

}
