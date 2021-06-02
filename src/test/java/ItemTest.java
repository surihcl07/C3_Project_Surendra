import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;
class ItemTest{
	RestaurantService service = new RestaurantService();
	Restaurant restaurant;
	@Test
	public void total_order_value_should_return_expected_value(){		
				
	LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurant = service.addRestaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);
        
        assertEquals(388, restaurant.getOrderValue());
        
	}
	
}
