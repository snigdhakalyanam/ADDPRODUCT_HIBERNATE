

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


@WebServlet("/list")
public class ListProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ListProductsServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print(" <a href = 'AddProduct.html'>  Add Product </a>");
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
				if(session !=null) {
				List<EProduct> list =	session.createQuery("from EProduct").list();
				 for(EProduct eProduct : list) {
					 out.print("<br>"+eProduct.getID() + "\t"+ eProduct.getName()+"\t"+ eProduct.getPrice()+ "\t"+eProduct.getDateAdded()+"<br>");
					 
				 }
					//out.print("Hibernate is initialized and configured Successfully");
			
			session.close();
			out.print("Hibernate Session is closed");
		
		
				
				
				
				
				}	
		
			out.print("</body> </html>");
			
	}
			
		
	}



