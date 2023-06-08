package Item;

public class Mobil extends Item{
    private String pabrikan;
    private String model;
    private int tahunKeluaran;
    private String bahanBakar;

    public Mobil() {
    }

    public Mobil(int itemID, String name, String description, double rentalChargePerDay, boolean availbility) {
        super(itemID, name, description, rentalChargePerDay, availbility);
    }

    public Mobil(String pabrikan, String model, int tahunKeluaran, String bahanBakar) {
        this.pabrikan = pabrikan;
        this.model = model;
        this.tahunKeluaran = tahunKeluaran;
        this.bahanBakar = bahanBakar;
    }

    public Mobil(int itemID, String name, String description, double rentalChargePerDay, boolean availbility, String pabrikan, String model, int tahunKeluaran, String bahanBakar) {
        super(itemID, name, description, rentalChargePerDay, availbility);
        this.pabrikan = pabrikan;
        this.model = model;
        this.tahunKeluaran = tahunKeluaran;
        this.bahanBakar = bahanBakar;
    }

    public String getPabrikan() {
        return pabrikan;
    }

    public void setPabrikan(String pabrikan) {
        this.pabrikan = pabrikan;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getTahunKeluaran() {
        return tahunKeluaran;
    }

    public void setTahunKeluaran(int tahunKeluaran) {
        this.tahunKeluaran = tahunKeluaran;
    }

    public String getBahanBakar() {
        return bahanBakar;
    }

    public void setBahanBakar(String bahanBakar) {
        this.bahanBakar = bahanBakar;
    }
}
