package Challenge_3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Bhavya Singh
 * */
public class CustomerProfile {
    private String id;
    private static final String ID_NUMBER_FORMAT = "^\\d{6}$";
    private static final int MAX_FAVOURITES = 5;
    private String name;
    private List<Food> favourites = new ArrayList<Food>();

    /**
     * Checks are made on ID and number of favourites,
     * id should follow ID_NUMBER_FORMAT = "^\\d{6}$"
     * and number of favourites should not be greater than MAX_FAVOURITES = 5
     *
     * @param id
     * @param name
     * @param favourites
     * */
    public CustomerProfile(String id, String name, List<Food> favourites) throws IllegalArgumentException {
        super();
        Pattern pattern = Pattern.compile(ID_NUMBER_FORMAT);

        if (!pattern.matcher(id).matches()) {
            throw new IllegalArgumentException("Badly formatted ID");
        }
        this.id = id;
        this.name = name;
        this.setFavourites(favourites);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isIn(Food food) {
        return this.favourites.contains(food);
    }

    public void setFavourites(List<Food> favourites) throws IllegalArgumentException {
        if ((favourites.size() + this.favourites.size()) > MAX_FAVOURITES) {
            throw new IllegalArgumentException("Too many favourites");
        }
        this.favourites.addAll(favourites);
    }

    @Override
    public String toString() {
        return String.format("CustomerProfile [name = %s, id = %s]", this.name, this.id);
    }
}
