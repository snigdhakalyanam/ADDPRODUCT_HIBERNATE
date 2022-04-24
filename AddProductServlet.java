
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@WebServlet ("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private Session session = null;
   
       
       public void init() throws ServletException{
    	
    	SessionFactory sessionFactory =HibernateUtil.getSessionFactory();
    	session = sessionFactory.openSession();
    	
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Retrieve the form values
		String productName = request.getParameter("eProductName");
		String productPrice = request.getParameter("eProductPrice");
		BigDecimal price = BigDecimal.ZERO;
		if(productPrice !=null) {
			Double priceDouble = Double.parseDouble(productPrice);
			price=BigDecimal.valueOf(priceDouble);
		}
		
			EProduct eProduct = new EProduct();
			eProduct.setName(productName);
			eProduct.setPrice(price);
			eProduct.setDateAdded(new Date());
			
			Transaction transaction = session.beginTransaction();
		try {
			
			session.save(eProduct);
			transaction.commit();
		
		} catch(Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		session.save(eProduct);
		
	PrintWriter out = response.getWriter();
	out.print("<html><body>");
	out.print("Product is saved successfully <br>");
	out.print("<a href = 'list'>List Products </a>");
	out.print("</body> </html>");
	
		
	}

	public void destroy() {
		if(session!= null)
		{
			session.close();
			
		}		
	}
	

}
