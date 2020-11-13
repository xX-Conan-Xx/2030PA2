import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //Room foyer = new Room("foyer").add(new Candle()).add(new Troll());
        //foyer = foyer.add(new Sword());
        //Stream.iterate(foyer, x -> x.tick()).limit(3).forEach(System.out::println);
        //System.out.println(foyer);
        Function<Room,Room> takeSword = x->{
            if(x.isSword()&&!x.isSwordtaken()){
                System.out.println("--> You have taken sword.");
                return new Room(x.getName(),x.getGameOArrayList(),true,x.isTrolldead(),x.getPreviousRoom());
            }else if(x.isSword()&&x.isSwordtaken()){
                System.out.println("--> You already have sword.");
                return new Room(x.getName(),x.getGameOArrayList(), x.isSwordtaken(), x.isTrolldead(),x.getPreviousRoom());
            }else{
                System.out.println("--> There is no sword.");
                return new Room(x.getName(),x.getGameOArrayList(),x.isSwordtaken(),x.isTrolldead(),x.getPreviousRoom());
            }
        };
        Function<Room,Room> killTroll = x->{
            if(x.isTroll()&&!x.isTrolldead()&&x.isSword()&&x.isSwordtaken()){
                System.out.println("--> Troll is killed.");
                return new Room(x.getName(),x.getGameOArrayList(),x.isSwordtaken(),true,x.getPreviousRoom()).deleteTroll();
            }else if(x.isTroll()&&!x.isTrolldead()&&!x.isSwordtaken()){
                System.out.println("--> You have no sword.");
                return new Room(x.getName(),x.getGameOArrayList(),x.isSwordtaken(),x.isTrolldead(),x.getPreviousRoom());
            }else if(!x.isTroll()){
                System.out.println("--> There is no troll");
                return new Room(x.getName(),x.getGameOArrayList(),x.isSwordtaken(),x.isTrolldead(),x.getPreviousRoom());
            }else{
                System.out.println("--> You have no sword.");
                return new Room(x.getName(),x.getGameOArrayList(),x.isSwordtaken(),x.isTrolldead(),x.getPreviousRoom());
            }
        };
        Function<Room,Room> dropSword = x->{
            System.out.println("--> You have dropped sword.");
            return new Room(x.getName(),x.getGameOArrayList(),false,x.isTrolldead(),x.getPreviousRoom());
        };
        //Room r1 = new Room("foyer").add(new Candle());
        //Room r2 = r1.go(x -> new Room("library").add(new Sword()));
        //Room r3 = r2.go(x -> new Room("dining").add(new Troll()));
        //Room r1 = new Room("foyer").add(new Candle());
        //Room r2 = r1.go(x -> new Room("dining").add(new Troll()));
        //Room r3 = r2.go(x -> new Room("library").add(new Sword()));
        Room f = new Room("foyer");
        f.back().add(new Candle());
        System.out.println(
                f
                //r1.go(x -> new Room("dining").add(new Troll())).tick().go(x -> new Room("library").add(new Sword())).tick().tick(takeSword).back().tick().tick(killTroll)
                //r3.tick(takeSword).back().tick(killTroll).tick(dropSword).back()
                //r3.tick(takeSword).back().tick(killTroll).tick(dropSword)
                //r3.tick(takeSword).back().tick(killTroll).back()
                //r1.go(x -> new Room("library").add(new Sword()).tick(takeSword).go(y -> new Room("dining").add(new Candle()).add(new Troll()))).tick(killTroll)
                //r2.tick(takeSword).go(x -> new Room("dining").add(new Candle()).add(new Troll())).tick(killTroll)
                //r2.tick(takeSword).go(x -> new Room("dining").add(new Candle()).add(new Troll()))
                //r3.tick(killTroll)
                //new Room("dining").add(new Candle()).tick().add(new Sword()).go(x -> new Room("mystery", x))
                //new Room("foyer").add(new Sword()).tick(takeSword).go(x -> new Room("dining").add(new Candle()))
                //new Room("dining").add(new Candle()).add(new Sword()).go(x -> new Room("mystery", x))
                //new Room("foyer").add(new Candle()).add(new Troll()).add(new Sword()).tick().tick(takeSword).tick(killTroll)
        );
    }

}
