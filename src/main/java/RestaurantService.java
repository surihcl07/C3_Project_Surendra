import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException{
       /*for (Restaurant restaurant: restaurants ) {
    	   if(restaurant.getName().equals(restaurantName));
    	   return restaurant;
       }
       throw new restaurantNotFoundException("No Restaurant found");
    */
    	Restaurant data = restaurants.stream().filter(r->r.getName().equals(restaurantName))
    			.findFirst()
    			.orElseThrow(()->new restaurantNotFoundException("No Restaurant found"));
    	return data;
    	
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
