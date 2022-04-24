

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


@WebServlet("/InitHibernate")
public class InitHibernate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public InitHibernate() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
				if(session !=null) {
			out.print("Hibernate is initialized and configured Successfully");
			
			session.close();
			out.print("Hibernate Session is closed");
		
		}	
		
			out.print("</body> </html>");
			
	}
			
		
	}



