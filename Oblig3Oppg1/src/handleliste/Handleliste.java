package handleliste;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import innlogging.InnloggingUtil;

@WebServlet("/Handleliste")
public class Handleliste extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Handleliste() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(InnloggingUtil.isInnlogget(request)) {
			String varerStr = (String)request.getSession().getAttribute("varer");
			String[] varer = null;
			
			if(varerStr == null || varerStr.isBlank()) {
				varerStr = "";
			}
			else {
				varer = varerStr.split(",");
			}
			
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>Handleliste</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Handleliste</h1>");
			out.println("<form method=\"post\" action=\"HandlelisteLeggTil\">");
			out.println("<input type=\"submit\" value=\"Legg til\">");
			out.println("<input type=\"text\" name=\"vareNavn\">");
			out.println("<input type=\"hidden\" name=\"varer\" value=\"" + varerStr +"\">");
			out.println("</form>");

			if(varer != null && varer.length > 0) {
				for(int i = 0; i < varer.length; i++) {
					out.println("<form method=\"post\" action=\"HandlelisteSlett\">");
					out.println("<p><input type=\"submit\" value=\"Slett\">&ensp;" + varer[i] +"</p>");
					out.println("<input type=\"hidden\" value=\"" + varer[i] + "\" name=\"vareNavn\">");
					out.println("<input type=\"hidden\" value=\"" + varerStr + "\" name=\"varer\">");
					out.println("</form>");
				}
			}
			
			out.println("</body>");
			out.println("</html>");
		}
		else {
			response.sendRedirect("LoggInn");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}