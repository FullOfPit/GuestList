import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GuestListTest {
     @Test
     void shouldBeEmptyInitially() {
          //Given
          GuestList newGuestList = new GuestList();
          //When
          newGuestList.setGuests(new ArrayList<String>());
          ArrayList<String> actual = newGuestList.getGuests();
          //Then
          Assertions.assertEquals(new ArrayList<String>(), actual);
     }

     @Test
     void shouldReadSameGuestsAsWrittenBefore() {
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




}