// DO NOT ALTER
/**
 * Creates MesoStation object from String stationID
 * 
 * @version 3.15
 */
public class MesoStation {
	/**
	 * Station ID of given four letter String
	 */
	private String stID;

	/**
	 * Constructs MesoStation object
	 * 
	 * @param stId is a String stID
	 */
	public MesoStation(String stId) {
		this.stID = stId;
	}

	/**
	 * Getter that returns station ID passed from constructor
	 * 
	 * @return Returns station ID passed from constructor
	 */
	public String getStID() {
		return stID;
	}
}