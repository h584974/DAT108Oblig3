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
		// Henter passord parameter og korrekt passord og innloggingstid fra web.xml
		String passord = request.getParameter("passord");
		String korrektPassord = getServletContext().getInitParameter("passord");
		String tidStr = getServletContext().getInitParameter("innloggingstid");
		int tid = 0;
		
		// Om tidStr gir uriktig resultat settes tid default til 0 sekunder
		try {
			tid = Integer.parseInt(tidStr);
		}
		catch (NumberFormatException e){}
		
		// Hvis passord er riktig sendes redirect til Handleliste med login timeout.
		// Ellers settes feilmelding og redirecter tilbake til LoggInn.
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