import java.math.BigDecimal;
import java.util.Date;

public class EProduct {

	private long ID;
	private String name;
	private BigDecimal price;
	
	private Date dateAdded;

	public EProduct(long ID, String name, BigDecimal price, Date dateAdded) {
		
		this.ID = ID;
		this.name = name;
		this.price = price;
		this.dateAdded = dateAdded;
	}
	
	public EProduct() {}
		
	

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	
	
	
	
}
