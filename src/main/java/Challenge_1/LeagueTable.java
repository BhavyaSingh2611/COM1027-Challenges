package Challenge_1;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Bhavya Singh
 */
public class LeagueTable {
    private final String name;
    private ArrayList<University> universityList = new ArrayList<>();

    public LeagueTable() {
        this.name = "Guardian League Table";
    }

    public LeagueTable(String name) {
        this.name = name;
    }

    /**
     * Adds a university to the university list.
     * @param university
     */
    public void addUniversity(University university) throws NullPointerException {
        if (university == null) {
            throw new NullPointerException("University object is null");
        }
        universityList.add(university);
    }
    /**
     * Removes the specified university from the university list.
     * @param university
     */
    public void removeUniversity(University university) throws NullPointerException {
        if (university == null) {
            throw new NullPointerException("University object is null");
        }
        universityList.remove(university);
    }

    /**
     * Prints university list without any ordering.
     */
    public void printUniversityList() {
        System.out.println(this.name);
        System.out.println("---------------------");
        for (University university : universityList) {
            System.out.println(university.toString());
        }
    }

    /**
     * Prints university list in descending order based on the score obtained.
     */
    public void printOrderedList() {
        universityList.sort(new ScoreComparator());
        for (University university : universityList) {
            System.out.println(university.toString());
        }
    }

    static class ScoreComparator implements Comparator<University> {
        public int compare(University s1, University s2)
        {
            return Double.compare(s1.getScore(), s2.getScore());
        }
    }
}
