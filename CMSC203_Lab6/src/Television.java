// The purpose of this class is to model a television
// Tyler Do 2/18/23
public class Television {
	// The manufacturer attribute will hold the brand name. 
	// This cannot change once the television is created, so will be a named constant.
	private final String MANUFACTURER;
	
	// The screenSize attribute will hold the size of the television screen.
	// This cannot change once the television has been created so will be a named constant.
	private final int SCREEN_SIZE;
	
	// The powerOn attribute will hold the value true if the
	// power is on and false if the power is off.
	private boolean powerOn;
	
	// The channel attribute will hold the value of the station 
	// that the television is showing.
	private int channel;
	
	// The volume attribute will hold a number value representing 
	// the loudness (0 being no sound).
	private int volume;
	
	// Creates a two argument constructor. Initializes fields of Television class.
	public Television(String manufacturer, int screenSize) {
		MANUFACTURER = manufacturer;
		SCREEN_SIZE = screenSize;
		powerOn = false;
		volume = 20;
		channel = 2;
	}
	
	/** Returns the value of volume
	 * @return volume The volume of the television
	 * */
	public int getVolume() {
		return volume;
	}
	
	/** Returns the value of channel
	 * @return channel The value of channel or the channel number
	 * */
	public int getChannel() {
		return channel;
	}
	
	/** Returns the value of manufacturer
	 *  @return MANUFACTURER The value or brand of the manufacturer
	 * */
	public String getManufacturer() {
		return MANUFACTURER;
	}
	
	/** Returns the value of screen size
	 * @return SCREEN_SIZE The value of the screen size
	 * */
	public int getScreenSize() {
		return SCREEN_SIZE;
	}
	
	/** Assigns the value of channel to the argument
	 * Requires an int parameter
	 * @param channel2 argument that is given
	 * */
	public void setChannel(int channel2) {
		channel = channel2;
	}
	
	/** Reverses the boolean value of powerOn
	 * */
	public void power() {
		powerOn = !powerOn;
	}
	
	/** Increments the volume by 1
	 * */
	public void increaseVolume() {
		volume++;
	}
	
	/** Decrements the volume by 1
	 * */
	public void decreaseVolume() {
		volume--;
	}
	
}
