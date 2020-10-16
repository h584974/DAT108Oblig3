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

@WebServlet("/HandlelistePost")
public class HandlelistePost extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private VareDAO vareDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Henter parametre fra request.
		boolean slett = Boolean.parseBoolean(request.getParameter("slett"));
		String vareNavn = request.getParameter("vareNavn");
		int karakterGrense = 0;
		
		// Hvis karaktergrensen skulle bli lest feil settes den default til 0, 
		// som fører til at en vare vil hverken bli lagt til eller slettet.
		try {
			karakterGrense = Integer.parseInt(getServletContext().getInitParameter("karaktergrense"));
		}
		catch(NumberFormatException e) {};
		
		if(vareNavn != null && !vareNavn.isBlank() && vareNavn.length() <= karakterGrense) {
			// Sjekker om vi skal slette eller legge til vare
			if(slett) {
				vareDAO.slettVare(vareDAO.getVare(vareNavn));
			}
			else {
				vareDAO.leggTilVare(new Vare(vareNavn));
			}
		}
		
		response.sendRedirect("Handleliste");
	}

}