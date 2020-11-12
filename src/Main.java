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
                return new Room(x.getName(),x.getGameOArrayList(),true,x.isTrolldead());
            }else if(x.isSword()&&x.isSwordtaken()){
                System.out.println("--> You already have sword.");
                return new Room(x.getName(),x.getGameOArrayList(), x.isSwordtaken(), x.isTrolldead());
            }else{
                System.out.println("--> There is no sword.");
                return new Room(x.getName(),x.getGameOArrayList(),x.isSwordtaken(),x.isTrolldead());
            }
        };
        Function<Room,Room> killTroll = x->{
            if(x.isTroll()&&!x.isTrolldead()&&x.isSword()&&x.isSwordtaken()){
                System.out.println("--> Troll is killed.");
                return new Room(x.getName(),x.getGameOArrayList(),x.isSwordtaken(),true).deleteTroll();
            }else if(x.isTroll()&&!x.isTrolldead()&&!x.isSwordtaken()){
                System.out.println("--> You have no sword.");
                return new Room(x.getName(),x.getGameOArrayList(),x.isSwordtaken(),x.isTrolldead());
            }else if(!x.isTroll()){
                System.out.println("--> There is no troll");
                return new Room(x.getName(),x.getGameOArrayList(),x.isSwordtaken(),x.isTrolldead());
            }else{
                System.out.println("--> You have no sword.");
                return new Room(x.getName(),x.getGameOArrayList(),x.isSwordtaken(),x.isTrolldead());
            }
        };
        System.out.println(
                new Room("foyer").add(new Candle()).add(new Troll()).add(new Sword()).tick().tick(takeSword).tick(killTroll)
        );
    }

}
