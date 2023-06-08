package Item;

public class Motor extends Item{
    private String pabrikan;
    private String model;
    private int tahunKeluar;


    public Motor() {
    }

    public Motor(int itemID, String name, String description, double rentalChargePerDay, boolean availbility) {
        super(itemID, name, description, rentalChargePerDay, availbility);
    }

    public Motor(String pabrikan, String model, int tahunKeluar) {
        this.pabrikan = pabrikan;
        this.model = model;
        this.tahunKeluar = tahunKeluar;
    }

    public Motor(int itemID, String name, String description, double rentalChargePerDay, boolean availbility, String pabrikan, String model, int tahunKeluar) {
        super(itemID, name, description, rentalChargePerDay, availbility);
        this.pabrikan = pabrikan;
        this.model = model;
        this.tahunKeluar = tahunKeluar;
    }
}
