package innlogging;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoggInnPost")
public class LoggInnPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String passord = request.getParameter("passord");
		String korrektPassord = getServletContext().getInitParameter("passord");
		String tidStr = getServletContext().getInitParameter("innloggingstid");
		int tid = 0;
		
		try {
			tid = Integer.parseInt(tidStr);
		}
		catch (NumberFormatException e){}
		
		if(InnloggingUtil.isGyldigPassord(passord, korrektPassord)) {
			InnloggingUtil.loggInnMedTimeout(request, tid);
			response.sendRedirect("Handleliste");
		}
		else {
			request.getSession().setAttribute("feilmelding", "Feil passord oppgitt, pr&oslash;v igjen:");
			response.sendRedirect("LoggInn");
		}
	}

}