class Candle extends GameO{
    Candle(){
       super(); 
    }
    Candle(int state){
        super(state);
    }
    public Candle tickk(){
        return new Candle(super.state+1);
    }
    public String toString(){
        if(super.state == 0){
            return "Candle flickers.";
        }else if(super.state == 1){
            return "Candle is getting shorter.";
        }else if(super.state == 2){
            return "Candle is about to burn out.";
        }else{
            return "Candle has burned out.";
        }
    }

}
