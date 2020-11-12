import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

class Room{
    private final String name;
    private final List<GameO> gameOArrayList;
    private final boolean isSwordtaken;
    private final boolean isTrolldead;
    Room (String name){
        this.name = name;
        this.gameOArrayList = new ArrayList<GameO>();
        this.isSwordtaken = false;
        this.isTrolldead = false;
    }
    Room (String name, List<GameO> gameOArrayList, GameO gameO){
        this.name = name;
        gameOArrayList.add(gameO);
        this.gameOArrayList = gameOArrayList;
        this.isSwordtaken = false;
        this.isTrolldead = false;
    }

    Room (String name, List<GameO> gameOArrayList, boolean isSwordtaken, boolean isTrollDead){
        this.name = name;
        this.gameOArrayList = gameOArrayList;
        this.isSwordtaken = isSwordtaken;
        this.isTrolldead = isTrollDead;
    }

    public boolean isSwordtaken() {
        return isSwordtaken;
    }

    public boolean isTrolldead() {
        return isTrolldead;
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

    public boolean isTroll(){
        boolean isTroll = false;
        for(GameO gameO:this.gameOArrayList){
            if(gameO instanceof Troll){
                isTroll = true;
            }
        }
        return isTroll;
    }

    public Room add(GameO gameO){
        return new Room(this.name, this.gameOArrayList,gameO);
    }

    public Room deleteTroll(){
        List<GameO> listAfterDeleteTroll = new ArrayList<>();
        for (GameO gameO:this.gameOArrayList){
            if(gameO instanceof Troll){
            }else{
                listAfterDeleteTroll.add(gameO);
            }
        }
        return new Room(this.name,listAfterDeleteTroll,this.isSwordtaken,true);
    }

    public Room tick(){
        return new Room(this.name, gameOArrayList.stream().map(x->x.tickk()).collect(Collectors.toList()),this.isSwordtaken,this.isTrolldead);
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
