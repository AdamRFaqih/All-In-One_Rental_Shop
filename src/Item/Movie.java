package Item;

public class Movie extends Item{
    private String title;
    private String genre;
    private int releaseYear;
    private String director;
    private String condition;

    public Movie(
            int itemID,
            String name,
            String description,
            double rentalChargePerDay,
            String title,
            String genre,
            int releaseYear,
            String director,
            String condition
    ) {
        super(itemID, name, description, rentalChargePerDay);
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.director = director;
        this.condition = condition;
    }

    @Override
    public double getRentalCharge() {
        return 0;
    }

    @Override
    public void showItemDetail() {

    }
}
