package mybatis;

import booking.model.Luggage;
import booking.mybatis.services.LuggageService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LuggageTest {

    private Luggage luggage1;
    private LuggageService luggageService;

    @Before
    public void setUp() {
        luggageService = new LuggageService();
        luggage1 = new Luggage(1, "check-in");
        luggageService.create(luggage1);
    }

    @Test
    public void testCreateLuggage() {
        Luggage db_luggage = luggageService.findById(luggage1.getId());
        assert luggage1.equals(db_luggage);
    }

    @Test
    public void updateLuggage() {
        Luggage luggageUpdate = new Luggage(luggage1.getId(), luggage1.getPassengerId(), "Checked Bag");
        luggageService.update(luggageUpdate);
        Luggage db_luggage = luggageService.findById(luggage1.getId());
        assert luggageUpdate.equals(db_luggage);
    }

    @Test
    public void deleteLuggage() {
        luggageService.delete(luggage1.getId());
        Luggage db_luggage = luggageService.findById(luggage1.getId());
        assert db_luggage == null;
    }

    @After
    public void tearDown() {
        luggageService.delete(luggage1.getId());
    }
}
