import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

class Room{
    private final String name;
    private final List<GameO> gameOArrayList;
    private final boolean isSwordtaken;
    Room (String name){
        this.name = name;
        this.gameOArrayList = new ArrayList<GameO>();
        this.isSwordtaken = false;
    }
    Room (String name, List<GameO> gameOArrayList, GameO gameO){
        this.name = name;
        gameOArrayList.add(gameO);
        this.gameOArrayList = gameOArrayList;
        this.isSwordtaken = false;
    }
    Room (String name, List<GameO> gameOArrayList){
        this.name = name;
        this.gameOArrayList = gameOArrayList;
        this.isSwordtaken = false;
    }
    Room (String name, List<GameO> gameOArrayList, boolean isSwordtaken){
        this.name = name;
        this.gameOArrayList = gameOArrayList;
        this.isSwordtaken = isSwordtaken;
    }

    public boolean isSwordtaken() {
        return isSwordtaken;
    }

    public String getName() {
        return name;
    }

    public List<GameO> getGameOArrayList() {
        return gameOArrayList;
    }
    public boolean isSword(){
        boolean isSword = false;
        for(GameO gameO:this.gameOArrayList){
            if(gameO instanceof Sword){
                isSword = true;
            }
        }
        return isSword;
    }
    public Room add(GameO gameO){
        return new Room(this.name, this.gameOArrayList,gameO);
    }
    public Room tick(){
        return new Room(this.name, gameOArrayList.stream().map(x->x.tickk()).collect(Collectors.toList()),this.isSwordtaken);
    }
    public Room tick(Function<Room, Room> f){
        Room roomAfterTick = this.tick();
        return f.apply(roomAfterTick);
    }
    public String toString(){
        String name = "@"+this.name;
        String printObject = "";
        for (GameO gameO:gameOArrayList){
            printObject = printObject + "\n"+ gameO.toString();
        }
        return name + printObject;
    }
}
