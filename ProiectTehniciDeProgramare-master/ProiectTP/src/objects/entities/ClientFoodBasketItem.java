package objects.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ClientFoodBasket")
public class ClientFoodBasketItem {
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column(name="Food_Id")
	private int food_Id;
	
	@Column(name="Client_Id")
	private int client_Id;

	public int getFood_Id() {
		return food_Id;
	}

	public void setFood_Id(int food_Id) {
		this.food_Id = food_Id;
	}

	public int getClient_Id() {
		return client_Id;
	}

	public void setClient_Id(int client_Id) {
		this.client_Id = client_Id;
	}

}
