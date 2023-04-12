package Item;

public abstract class Item {
    private int itemID;
    private String name;
    private String description;
    private double rentalChargePerDay;
    private boolean availbility;

    public Item(int itemID, String name, String description, double rentalChargePerDay) {
        this.itemID = itemID;
        this.name = name;
        this.description = description;
        this.rentalChargePerDay = rentalChargePerDay;
        availbility = true;
    }

    public int getItemID() {
        return itemID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setAvailbility() {
        if (availbility){
            availbility = false;
        }else {
            availbility = true;
        }
    }

    public abstract double getRentalCharge();
    public abstract void showItemDetail();
}