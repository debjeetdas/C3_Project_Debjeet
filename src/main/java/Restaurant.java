import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
//        System.out.println("getCurrentTime ----> "+this.getCurrentTime());
//        System.out.println("opening ----> "+this.openingTime);
//        System.out.println("closing ----> "+this.closingTime);
//        System.out.println("value ----> "+ (this.getCurrentTime().compareTo(this.openingTime) >= 0 && this.getCurrentTime().compareTo(this.closingTime) <= 0));
        return this.getCurrentTime().compareTo(this.openingTime) >= 0 && this.getCurrentTime().compareTo(this.closingTime) <= 0;
    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
        return menu;
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }

    public Double calculateOrderValue(List<Item> items) {
        double totalOrderValue = 0;
        for(int i = 0; i < items.size(); i++)
        {
            totalOrderValue = totalOrderValue + items.get(i).getPrice();
        }
        System.out.println("totalOrderValue ----> "+totalOrderValue);
        return totalOrderValue;
    }
}
