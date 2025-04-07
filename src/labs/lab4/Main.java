package labs.lab4;

public class Main {
    public static void main(String[] args) {
    	MerchandiseItem item1 = new StandardItem("Running socks", 34.99, "A pack of 12 white running socks, women's size 9-11");
    	MerchandiseItem item2 = new GroceryItem("Bananas", 2.00, "2021-12-28");
    	MerchandiseItem item3 = new DigitalItem("Big Java", 112.50, DigitalItem.Format.EBOOK);
    	MerchandiseItem item4 = new DigitalItem("Big Java", 112.50, DigitalItem.Format.EBOOK);
    	MerchandiseItem item5 = new DigitalItem("Clueless", 6.99, DigitalItem.Format.VIDEO);
    	MerchandiseItem item6 = new DigitalItem("Beethoven's 5th Symphony", 0.99, DigitalItem.Format.AUDIO);
    	MerchandiseItem item7 = new StandardItem("AirPod Pros", 189.98, "Apple AirPods Pro wireless ear buds");

    	MerchandiseItem[] items = {item1, item2, item3, item4, item5, item6, item7};

    	for (MerchandiseItem item : items) {
    	   System.out.println(item);
    	   System.out.println(item.purchase("2021-09-01"));
    	}
    }
}