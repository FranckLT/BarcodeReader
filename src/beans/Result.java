package beans;

public class Result {
	
	private int room;
	
	private String code;

	public Result(int room, String code) {
		super();
		this.room = room;
		this.code = code;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	

}
