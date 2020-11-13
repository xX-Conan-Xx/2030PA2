import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

class Room{
    private final String name;
    private final List<GameO> gameOArrayList;
    private final boolean isSwordtaken;
    private final boolean isTrolldead;
    private final Room previousRoom;

    Room (String name){
        this.name = name;
        this.gameOArrayList = new ArrayList<GameO>();
        this.isSwordtaken = false;
        this.isTrolldead = false;
        this.previousRoom = null;
    }

    Room (String name,List<GameO> gameOList,Room previousRoom){
        this.name = name;
        this.gameOArrayList = gameOList;
        this.isSwordtaken = false;
        this.isTrolldead = false;
        this.previousRoom = previousRoom;
    }

    Room (String name, List<GameO> gameOArrayList, GameO gameO,Room previousRoom){
        this.name = name;
        List<GameO> gameOList = new ArrayList<>();
        gameOList.addAll(gameOArrayList);
        gameOList.add(gameO);
        this.gameOArrayList = gameOList;
        this.isSwordtaken = false;
        this.isTrolldead = false;
        this.previousRoom = previousRoom;
    }

    Room (String name, List<GameO> gameOArrayList, boolean isSwordtaken, boolean isTrollDead,Room previousRoom){
        this.name = name;
        this.gameOArrayList = gameOArrayList;
        this.isSwordtaken = isSwordtaken;
        this.isTrolldead = isTrollDead;
        this.previousRoom = previousRoom;
    }

    Room (String name, Room previousRoom){
        this.name = name;
        this.gameOArrayList = previousRoom.getGameOArrayList();
        this.isSwordtaken = previousRoom.isSwordtaken;
        this.isTrolldead = false;
        this.previousRoom = previousRoom;
    }

    public Room getPreviousRoom() {
        return previousRoom;
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
        return new Room(this.getName(), this.getGameOArrayList(), gameO, this.getPreviousRoom());
    }

    public Room add(List<GameO> gameOList){
        List<GameO> gl= this.getGameOArrayList();
        gl.addAll(gameOList);
        return new Room(this.name,gl, this.getPreviousRoom());
    }

    public Room deleteTroll(){
        List<GameO> listAfterDeleteTroll = new ArrayList<>();
        for (GameO gameO:this.gameOArrayList){
            if(gameO instanceof Troll){
            }else{
                listAfterDeleteTroll.add(gameO);
            }
        }
        return new Room(this.name,listAfterDeleteTroll,this.isSwordtaken,true,this.getPreviousRoom());
    }

    public Room tick(){
        return new Room(this.name, gameOArrayList.stream().map(x->x.tickk()).collect(Collectors.toList()),this.isSwordtaken,this.isTrolldead,this.getPreviousRoom());
    }

    public Room tick(Function<Room, Room> f){
        Room roomAfterTick = this.tick();
        return f.apply(roomAfterTick);
    }

    public Room go(Function<Room,Room> f){
        Room roomAfterApply = f.apply(this);
        Room roomCorrected = new Room(roomAfterApply.name,roomAfterApply.gameOArrayList,roomAfterApply.isSwordtaken,roomAfterApply.isTrolldead(),this);
        if(this.isSwordtaken()&&!roomCorrected.isSwordtaken){
            Room newRoom = new Room(roomAfterApply.getName()).add(new Sword()).add(roomAfterApply.getGameOArrayList());
            Room returnRoom = new Room(newRoom.getName(),newRoom.gameOArrayList, true, false,this);
            return returnRoom;
        }
        else{
            return roomCorrected;
        }
    }

    public Room back(){
        Room previousRoomBeforeEdited = this.previousRoom;
        Room previousRoomAfterEdited = new Room(previousRoomBeforeEdited.name,previousRoomBeforeEdited.gameOArrayList,this.isSwordtaken(),previousRoomBeforeEdited.isTrolldead,previousRoomBeforeEdited.getPreviousRoom());
        if(previousRoomAfterEdited.isSwordtaken == true){
            previousRoomAfterEdited.add(new Sword());
        }
        return previousRoomAfterEdited.tick();
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
