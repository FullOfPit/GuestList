import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

@AllArgsConstructor
public class GuestList{

    public ArrayList<String> guests;

    public GuestList() {

    }

   public void setGuests(ArrayList<String> guestList) throws IOException {
        this.guests = guestList;
        Path filePath = Paths.get("src/main/java/guests.txt");
        Files.write(filePath, guestList);
   }
   public ArrayList<String> getGuests() throws IOException {
        if (this.guests != null) {
            return this.guests;
        }
        if (this.guests == null) {
            if (filePathExists(Paths.get("src/main/java/guests.txt"))) {
                return (ArrayList<String>) Files.readAllLines(Paths.get("src/main/java/guests.txt"));
            }
        }
        return null;
   }


   public boolean filePathExists(Path path) {
        return Files.exists(path);
   }

    @Override
    public String toString() {
        return "GuestList{" +
                "guests=" + guests +
                '}';
    }

}
