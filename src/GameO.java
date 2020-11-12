abstract class GameO{
    protected final int state;
    GameO(){
        this.state = 0;
    }
    GameO(int state){
        this.state = state;
    }
    abstract GameO tickk();

}
