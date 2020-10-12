package handleliste;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HandlelisteSlett")
public class HandlelisteSlett extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HandlelisteSlett() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vareNavn = request.getParameter("vareNavn");
		String varerStr = request.getParameter("varer");
		
		if(vareNavn != null && varerStr != null) {
			String[] varer = varerStr.split(",");
			varerStr = "";
			
			for(int i = 0; i < varer.length; i++) {
				if(!varer[i].equalsIgnoreCase(vareNavn)) {
					if(i >= varer.length - 1) {
						varerStr += varer[i];
					}
					else {
						varerStr += varer[i] + ",";
					}
				}
			}
		}
		
		request.getSession().setAttribute("varer", varerStr);
		response.sendRedirect("Handleliste");
	}

}