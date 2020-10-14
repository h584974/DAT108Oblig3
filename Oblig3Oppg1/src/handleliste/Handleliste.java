package handleliste;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.Vare;
import database.VareDAO;
import innlogging.InnloggingUtil;

@WebServlet("/Handleliste")
public class Handleliste extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private VareDAO vareDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(InnloggingUtil.isInnlogget(request)) {
			// Henter vareliste fra database
			List<Vare> vareliste = vareDAO.getVareliste();
			
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>Handleliste</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Handleliste</h1>");
			out.println("<form method=\"post\" action=\"HandlelistePost\">");
			out.println("<input type=\"submit\" value=\"Legg til\">");
			out.println("<input type=\"text\" name=\"vareNavn\">");
			out.println("<input type=\"hidden\" name=\"slett\" value=\"false\">");
			out.println("</form>");
			
			// Skriver ut et for melement med hver vare, som sender til HandlelisteSlett ved bruk av Slett knapp.
			vareliste.forEach(vare -> {
				out.println("<form method=\"post\" action=\"HandlelistePost\">");
				out.println("<p><input type=\"submit\" value=\"Slett\">&ensp;" + EscapeHTML.escape(vare.getVareNavn()) +"</p>");
				out.println("<input type=\"hidden\" value=\"" + vare + "\" name=\"vareNavn\">");
				out.println("<input type=\"hidden\" name=\"slett\" value=\"true\">");
				out.println("</form>");
			});
			
			out.println("</body>");
			out.println("</html>");
		}
		// Redirecter til LoggInn om innlogginstiden er utl�pt
		else {
			response.sendRedirect("LoggInn");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}