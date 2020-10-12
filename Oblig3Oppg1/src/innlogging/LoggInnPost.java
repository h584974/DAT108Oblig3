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
       
    public LoggInnPost() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String passord = request.getParameter("passord");
		if(InnloggingUtil.isGyldigPassord(passord, "admin")) {
			InnloggingUtil.loggInnMedTimeout(request, 30);
			response.sendRedirect("Handleliste");
		}
		else {
			request.getSession().setAttribute("feilmelding", "Feil passord oppgitt, pr&oslash;v igjen:");
			response.sendRedirect("LoggInn");
		}
	}

}