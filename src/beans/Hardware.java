package beans;

public class Hardware {
	
	private String code;
	
	private Room room;
	
	private Category category;
	
	

	public Hardware( String code, Room room, Category category) {
		super();
		this.code = code;
		this.room = room;
		this.category = category;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
}
