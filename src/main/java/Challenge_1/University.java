package Challenge_1;

import java.util.regex.Pattern;

/**
 * @author Bhavya Singh
 */
public class University {
    private final String name;
    private final double score;
    private final String websiteUrl;

    /**
     * University class, the score should be in the range 0-100 (inclusive) and websiteUrl
     * should be a valid .ac.uk website link to the university website
     * @param name
     * @param score
     * @param websiteUrl
     */
    public University(String name, double score, String websiteUrl) throws IllegalArgumentException {
        this.name = name.toUpperCase();
        
        if (score > 100 || score < 0) {
            throw new IllegalArgumentException("Incorrect value for score");
        } else {
            this.score = score;
        }

        Pattern pattern = Pattern.compile("(^www\\.)?[a-z]*(\\.ac\\.uk$)", Pattern.CASE_INSENSITIVE);

        if (!pattern.matcher(websiteUrl).matches()) {
            throw new IllegalArgumentException("Badly formatted URL");
        }

        this.websiteUrl = websiteUrl;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public String getUrl() {
        return websiteUrl;
    }

    @Override
    public String toString() {
        return name + " (" + websiteUrl + ") - " + String.format("%.1f", score) + "%";
    }
}