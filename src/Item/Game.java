package Item;

public class Game extends Item{
    private String title;
    private String genre;
    private String publisher;
    private String condition;

    public Game() {
    }

    public Game(int itemID, String name, String description, double rentalChargePerDay, boolean availbility) {
        super(itemID, name, description, rentalChargePerDay, availbility);
    }

    public Game(String title, String genre, String publisher, String condition) {
        this.title = title;
        this.genre = genre;
        this.publisher = publisher;
        this.condition = condition;
    }

    public Game(int itemID, String name, String description, double rentalChargePerDay, boolean availbility, String title, String genre, String publisher, String condition) {
        super(itemID, name, description, rentalChargePerDay, availbility);
        this.title = title;
        this.genre = genre;
        this.publisher = publisher;
        this.condition = condition;
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
