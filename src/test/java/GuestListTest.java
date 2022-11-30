import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GuestListTest {
     @Test
     void shouldBeEmptyInitially() throws IOException {
          //Given
          GuestList newGuestList = new GuestList();
          //When
          newGuestList.setGuests(new ArrayList<String>());
          ArrayList<String> actual = newGuestList.getGuests();
          //Then
          Assertions.assertEquals(new ArrayList<String>(), actual);
     }

     @Test
     void shouldReadSameGuestsAsWrittenBefore() throws IOException {
          //Given
          GuestList newGuestList = new GuestList();
          //When
          ArrayList<String> guestList = new ArrayList<>();
          guestList.add("Karl");
          guestList.add("Ute");
          newGuestList.setGuests(guestList);
          ArrayList<String> actual = newGuestList.getGuests();
          //Then
          Assertions.assertEquals(guestList, actual);
     }

     @Test
     void shouldWriteToFileSystem() throws IOException {
          //Given
          GuestList newGuestList = new GuestList();
          //When
          ArrayList<String> guestList = new ArrayList<>();
          guestList.add("Theodor");
          guestList.add("Anette");
          newGuestList.setGuests(guestList);
          ArrayList<String> actual = (ArrayList<String>) Files.readAllLines(Path.of("src/main/java/guests.txt"));
          //Then
          Assertions.assertEquals(guestList, actual);
     }

     @Test
     void shouldReadFromFileSystem() throws IOException {
          //Given
          ArrayList<String> guestList = new ArrayList<>();
          guestList.add("Stephan");
          guestList.add("Max");
          Path filePath = Paths.get("src/main/java/guests.txt");
          Files.write(filePath, guestList);
          //When
          GuestList newGuestList = new GuestList();
          ArrayList<String> actual = newGuestList.getGuests();
          //Then
          Assertions.assertEquals(guestList, actual);

     }

     @Test
     void addedGuest_RewritesFile() throws IOException {
          //Given
          GuestList newGuestList = new GuestList();
          ArrayList<String> guestList = new ArrayList<>();
          guestList.add("Theodor");
          guestList.add("Anette");
          newGuestList.setGuests(guestList);

          ArrayList<String> testList = new ArrayList<>();
          testList.add("Theodor");
          testList.add("Anette");
          testList.add("Carlito");
          //When
          newGuestList.addGuest("Carlito");
          ArrayList<String> actual = newGuestList.getGuests();
          //Then
          Assertions.assertEquals(testList, actual);

     }






}