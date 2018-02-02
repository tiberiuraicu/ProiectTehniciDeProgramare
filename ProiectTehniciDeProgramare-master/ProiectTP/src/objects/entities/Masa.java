package objects.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AsezareMese")
public class Masa {
    @Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "xCoord")
	private int xCoord;
	
	@Column(name = "yCoord")
	private int yCoord;
	
	@Column(name = "color")
	private String stare;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}

	public String getStare() {
		return stare;
	}

	public void setStare(String stare) {
		this.stare = stare;
	}
}
