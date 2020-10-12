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

@WebServlet("/HandlelisteLeggTil")
public class HandlelisteLeggTil extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private final VareDAO vareDAO = new VareDAO();
       
    public HandlelisteLeggTil() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vareNavn = request.getParameter("vareNavn");
		
		if(vareNavn != null && !vareNavn.isBlank()) {
			database.Handleliste handleliste = vareDAO.getHandleliste(1);
			Vare nyVare = new Vare(vareNavn, handleliste);
			vareDAO.leggTilVare(nyVare);
		}
		
		response.sendRedirect("Handleliste");
	}

}