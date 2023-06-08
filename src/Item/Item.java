package Item;

public abstract class Item {
    static private int itemCount;
    
    private int itemID;
    private String name;
    private String description;
    private double rentalChargePerDay;
    private boolean availbility;

    public Item() {
    }

    public Item(int itemID, String name, String description, double rentalChargePerDay, boolean availbility) {
        this.itemID = itemID;
        this.name = name;
        this.description = description;
        this.rentalChargePerDay = rentalChargePerDay;
        this.availbility = availbility;
    }

    public static int getItemCount() {
        return itemCount;
    }

    public static void setItemCount(int itemCount) {
        Item.itemCount = itemCount;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRentalChargePerDay() {
        return rentalChargePerDay;
    }

    public void setRentalChargePerDay(double rentalChargePerDay) {
        this.rentalChargePerDay = rentalChargePerDay;
    }

    public boolean isAvailbility() {
        return availbility;
    }

    public void setAvailbility(boolean availbility) {
        this.availbility = availbility;
    }
}
