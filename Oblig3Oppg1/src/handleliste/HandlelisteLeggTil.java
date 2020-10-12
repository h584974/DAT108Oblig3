package handleliste;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HandlelisteLeggTil")
public class HandlelisteLeggTil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HandlelisteLeggTil() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vareNavn = request.getParameter("vareNavn");
		
		if(vareNavn != null && !vareNavn.isBlank()) {
			vareNavn = vareNavn.replace(',', ' ');
			String varerStr = request.getParameter("varer");
			
			if(varerStr == null || varerStr.isBlank()) {
				varerStr = vareNavn;
			}
			else {
				varerStr = varerStr + "," + vareNavn;
			}
			request.getSession().setAttribute("varer", varerStr);
		}
		
		response.sendRedirect("Handleliste");
	}

}