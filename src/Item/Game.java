package Item;

public class Game extends Item{
    private String title;
    private String genre;
    private String publisher;
    private String condition;

    public Game(
            String name,
            String description,
            double rentalChargePerDay,
            String title,
            String genre,
            String publisher,
            String condition
    ) {
        super(name, description, rentalChargePerDay);
        this.title = title;
        this.genre = genre;
        this.publisher = publisher;
        this.condition = condition;
    }

    @Override
    public double getRentalCharge() {
        return 0;
    }

    @Override
    public void showItemDetail() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
