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
            System.out.println("Candle flickers.");
            return null;
        }else if(super.state == 1){
            System.out.println("Candle is getting shorter.");
            return null;
        }else if(super.state == 2){
            System.out.println("Candle is about to burn out.");
            return null;
        }else{
            System.out.println("Candle has burned out.");
            return null;
        }
    }

}
