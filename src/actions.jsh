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
        }
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
        }
Function<Room,Room> dropSword = x->{
            System.out.println("--> You have dropped sword.");
            return new Room(x.getName(),x.getGameOArrayList(),false,x.isTrolldead(),x.getPreviousRoom());
        }