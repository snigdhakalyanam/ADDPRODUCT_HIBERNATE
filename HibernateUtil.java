import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;
	static {
		try {
		
			StandardServiceRegistry standardRegistry=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			sessionFactory = metadata.buildSessionFactory();
	
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}
		
		public static SessionFactory getSessionFactory() {
			return sessionFactory;
		}
	
	
	}
	
	

