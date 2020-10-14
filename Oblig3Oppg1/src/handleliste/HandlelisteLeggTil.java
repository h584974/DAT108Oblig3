package handleliste;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.Vare;
import database.VareDAO;
import org.apache.commons.text.StringEscapeUtils;

@WebServlet("/HandlelisteLeggTil")
public class HandlelisteLeggTil extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private VareDAO vareDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vareNavn = request.getParameter("vareNavn");
		
		if(vareNavn != null && !vareNavn.isBlank()) {
			Vare nyVare = new Vare(vareNavn);
			vareDAO.leggTilVare(nyVare);
		}
		
		response.sendRedirect("Handleliste");
	}

}