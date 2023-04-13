package Item;

public class Motor extends Item implements Asuransi{
    private String pabrikan;
    private String model;
    private int tahunKeluar;

    public Motor(
            String name,
            String description,
            double rentalChargePerDay,
            String pabrikan,
            String model,
            int tahunKeluar
    ) {
        super(name, description, rentalChargePerDay);
        this.pabrikan = pabrikan;
        this.model = model;
        this.tahunKeluar = tahunKeluar;
    }

    @Override
    public double getRentalCharge() {
        return 0;
    }

    @Override
    public void showItemDetail() {

    }

    @Override
    public double totalAsuransi() {
        return 0;
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

    public int getTahunKeluar() {
        return tahunKeluar;
    }

    public void setTahunKeluar(int tahunKeluar) {
        this.tahunKeluar = tahunKeluar;
    }
}
