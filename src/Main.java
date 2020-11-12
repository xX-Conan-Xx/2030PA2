import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Room foyer = new Room("foyer").add(new Candle()).add(new Troll());
        foyer = foyer.add(new Sword());
        //Stream.iterate(foyer, x -> x.tick()).limit(3).forEach(System.out::println);
        System.out.println(foyer);
    }
}
