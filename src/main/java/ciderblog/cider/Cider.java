package ciderblog.cider;

import org.apache.commons.io.FilenameUtils;
import lombok.Value;
import org.apache.commons.lang.ObjectUtils;

import java.io.File;

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

        String workDirectory = System.getProperty("user.dir");
        File folder = new File(workDirectory + "/src/main/resources/public/img");
        File[] listOfFiles = folder.listFiles();
        String ciderName = this.name.toLowerCase().replace(" ", "_");

        if (listOfFiles == null)
            throw new NullPointerException("No files were found in getCover method for the given directory.");

        for(File file : listOfFiles){

            String fileNameWithOutExt = FilenameUtils.removeExtension(file.getName());

            if (file.isFile() && (fileNameWithOutExt.equals(ciderName)))
                return "/img/" + file.getName();
        }

        // If we get here, it means that the for loop above did not return an image.
        return "image not found";
    }
}
