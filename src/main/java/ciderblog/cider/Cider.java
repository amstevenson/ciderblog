package ciderblog.cider;

import lombok.Value;

@Value // All fields are private and final. Getters (but not setters) are generated (https://projectlombok.org/features/Value.html)
public class Cider {
    String name;
    String producedAt;
    String rating;
    String price;
    String locationPurchased;
    String review;
    String sniffRating;

    public String getCover() {
        return "/img/" + this.name.replace(" ", "_").toLowerCase() + ".jpg";
    }
}
