package labs.lab4;

/**
 * Represents a downloadable item like a movie, song, etc
 */
public class DigitalItem extends MerchandiseItem {

	private Format format;

	/*
	 * Note: This may be the first time you see an enum, but it is the perfect
	 * construct for a situation like this, where you want a set of predefined
	 * constants. The textbook explains enums in Special Topic 5.4 on pages 155-156.
	 * You can also google "Java enum" and read about them online.
	 */
	public static enum Format {
		VIDEO, AUDIO, EBOOK
	};

	/**
	 * Constructor
	 * 
	 * @param name   name of the item
	 * @param price  price of the item
	 * @param format format of the item
	 */
	public DigitalItem(String name, double price, Format format) {
		super(name, price);
		// FILL IN
		this.format = format;
	}


	/**
	 * Returns the format of the item
	 * 
	 * @return format of the item
	 */
	public Format getFormat() {
		return format; // FIX ME
	}


	/**
	 * Sets the format of the item
	 * 
	 * @param f new format
	 */
	public void setFormat(Format f) {
		// FILL IN
		format = f;
	}


	@Override
	public String purchase(String purchaseDate) {
		return purchaseDate; // FIX ME
	}


	@Override
	public boolean equals(Object otherObject) {
		if (!super.equals(otherObject)) { return false; }
		if (otherObject instanceof DigitalItem) {
			DigitalItem other = (DigitalItem) otherObject;
			return this.getName().equals(other.getName()) && this.getPrice() == other.getPrice() && format == other.getFormat(); // FIX ME
		}
		return false;
	}
		


	@Override
	public String toString() {
		return super.toString() + ", format: " + getFormat(); // FIX ME
	}

}