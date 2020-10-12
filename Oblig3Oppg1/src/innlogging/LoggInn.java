package innlogging;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoggInn")
public class LoggInn extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoggInn() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String feilmelding = (String)request.getSession().getAttribute("feilmelding");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>LoggInn</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form method=\"post\" action=\"LoggInnPost\">");
		out.println("<fieldset>");
		out.println("<legend>Innlogging</legend>");
		
		if(feilmelding != null)
			out.println("<p>" + feilmelding + "</p>");
		
		out.println("<p>Oppgi passord:</p>");
		out.println("<input type=\"password\" name=\"passord\">");
		out.println("<br>");
		out.println("<br>");
		out.println("<input type=\"submit\" value=\"Logg inn\">");
		out.println("</fieldset>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}