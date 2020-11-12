import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //Room foyer = new Room("foyer").add(new Candle()).add(new Troll());
        //foyer = foyer.add(new Sword());
        //Stream.iterate(foyer, x -> x.tick()).limit(3).forEach(System.out::println);
        //System.out.println(foyer);
        System.out.println(new Room("foyer").add(new Sword()).tick(takeSword()));
    }
    static Function<Room,Room> takeSword(){
        Function<Room,Room> result = x->{
            if(x.isSword()){
                System.out.println("--> You have taken sword.");
                return new Room(x.getName(),x.getGameOArrayList());
            }else{
                System.out.println("--> There is no sword.");
                return new Room(x.getName(),x.getGameOArrayList());
            }
        };
        return result;
    }
}
