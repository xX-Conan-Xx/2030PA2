import java.util.function.Function;

public class Troll extends GameO{
    Troll(){
        super();
    }
    Troll(int state){
        super(state);
    }
    @Override
    GameO tickk() {
        return new Troll(this.state+1);
    }
    GameO tickk(Function<GameO,GameO> f){
        return f.apply(this);
    }

    @Override
    public String toString() {
        if(state == 0){
            return "Troll lurks in the shadows.";
        }if(state == 1){
            return "Troll is getting hungry.";
        }if(state == 2){
            return "Troll is VERY hungry.";
        }if(state == 3){
            return "Troll is SUPER HUNGRY and is about to ATTACK!";
        }else{
            return "Troll attacks!";
        }
    }
}
