import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Room{
    private final String name;
    private final List<GameO> gameOArrayList;
    Room (String name){
        this.name = name;
        this.gameOArrayList = new ArrayList<GameO>();
    }
    Room (String name, List<GameO> gameOArrayList, GameO gameO){
        this.name = name;
        gameOArrayList.add(gameO);
        this.gameOArrayList = gameOArrayList;
    }
    Room (String name, List<GameO> gameOArrayList){
        this.name = name;
        this.gameOArrayList = gameOArrayList;
    }
    public Room add(GameO gameO){
        return new Room(this.name, this.gameOArrayList,gameO);
    }
    public Room tick(){
        return new Room(this.name, gameOArrayList.stream().map(x->x.tickk()).collect(Collectors.toList()));
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
