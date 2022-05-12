/**
 * Stores a String representing a station ID passed in the constructor
 * 
 * @author Mohammad Mukhtaruzzaman
 * @version 2020-09-18
 */
public class MesoStation {
	private String stID;

	public MesoStation(String stId) {
		this.stID = stId;
	}

	public String getStID() {
		return stID;
	}
}