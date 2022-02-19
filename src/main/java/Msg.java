

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Msg
 */
//@WebServlet("/msg")
public class Msg extends HttpServlet {
	  // Początek HTML i właściwości <body> - tło, kolor tekstu i linków
	 private String prolog =
			 "<h1>Wpisz czego szukasz:</h1>"+
			 "<form action=\"searcher\" method=\"post\">"+
			     "Wprowadz typ pojazdu: <input type=\"text\" name=\"car\" size=\"20\">"+
			    "<input type=\"submit\" value=\"Szukaj\" />"+
			 "</form>";
           
	 
	 
	 
	 
// Tagi zamykające
private String epilog = "</body></html>";

	  // Metoda obsługi zlecenia GET

	  public void doGet(HttpServletRequest request,
	                       HttpServletResponse response)
	                 throws ServletException, IOException
	  {
		  response.setContentType("text/html; charset=ISO-8859-2");

		     // Strumień wyjściowy, tu generowana treść strony HTML
		     // PrintWriter umożliwia użycie metod print i println

		     PrintWriter out = response.getWriter();


		     out.println(prolog);  // piszemy początek html i tag <body ... >

		     // Piszemy treść
		  //  out.println("<h1>Dokument HTML<br>hdjjjjjjjjjjjjjjjjjj przez serwlet</h1>");
	//	     out.println("<br><br><a href=\\"Bye.html\\">Pożegnanie</a>");

		     // Znaczniki zamykające
		     out.println(epilog);
		     out.close();
	  }

}
