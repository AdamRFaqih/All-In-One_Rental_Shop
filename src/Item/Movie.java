package Item;

public class Movie extends Item{
    private String title;
    private String genre;
    private int releaseYear;
    private String director;
    private String condition;

    public Movie(
            String name,
            String description,
            double rentalChargePerDay,
            String title,
            String genre,
            int releaseYear,
            String director,
            String condition
    ) {
        super(name, description, rentalChargePerDay);
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

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
