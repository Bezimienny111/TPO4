

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.badlogic.gdx.utils.Json;

/**
 * Servlet implementation class Table
 */
@WebServlet("/Table")
public class Table extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Table() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String s = (String) request.getAttribute("cars");
		StringBuilder html = new StringBuilder();
		if(!s.equals("Brak")) {
		Json jsonNew = new Json();
		String outTable;
		List<Car> cars = new ArrayList<Car>();
		cars = jsonNew.fromJson(ArrayList.class, s);
		html.append("<head>\r\n"
				+ "<style>\r\n"
				+ "table, th, td {\r\n"
				+ "  border: 1px solid black;\r\n"
				+ "}\r\n"
				+ "</style>\r\n"
				+ "</head>\r\n"
				+ "<body>");
		html.append("<table style=\"width:100%\">");
		html.append("<tr>");
		html.append("<th>" + "Marka" +"</th>");
		html.append("<th>" + "Rok Produkcji" + "</th>");
		html.append("<th>" + "Silnik" + "</th>");
		html.append("<th>" + "Maksymalna Prędkość" + "</th>");
		html.append("</tr>");
		for(Car c:cars) {
			html.append("<tr>");
			html.append("<th>" + c.getMarka() +"</th>");
			html.append("<th>" + c.getRok() + "</th>");
			html.append("<th>" + c.getSilnik() + "</th>");
			html.append("<th>" + c.getMaxPrędkośc() + "</th>");
			html.append("</tr>");
		}
		html.append("</table>");
		html.append("<form action=\"Msg\" method=\"get\">"+
			    "<input type=\"submit\" value=\"Wróć\" />"+
			 "</form>");
		}else {
			html.append("Brak danych");
			html.append("<form action=\"Msg\" method=\"get\">"+
				    "<input type=\"submit\" value=\"Wróć\" />"+
				 "</form>");
		}
			
	//	System.out.println("Jestem tutaj");
		response.setContentType("text/html; charset=ISO-8859-2");
		PrintWriter writer = response.getWriter();
		writer.println("<html> <h1> " + html + "</h1> </html>");
		
		writer.close();
		
		
		
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
