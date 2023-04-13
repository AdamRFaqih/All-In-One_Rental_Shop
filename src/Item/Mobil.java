package Item;

public class Mobil extends Item implements Asuransi{
    private String pabrikan;
    private String model;
    private int tahunKeluaran;
    private String bahanBakar;

    public Mobil(
            String name,
            String description,
            double rentalChargePerDay,
            String pabrikan,
            String model,
            int tahunKeluaran,
            String bahanBakar
    ) {
        super(name, description, rentalChargePerDay);
        this.pabrikan = pabrikan;
        this.model = model;
        this.tahunKeluaran = tahunKeluaran;
        this.bahanBakar = bahanBakar;
    }

    @Override
    public double totalAsuransi() {
        return 0;
    }

    @Override
    public double getRentalCharge() {
        return 0;
    }

    @Override
    public void showItemDetail() {

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
