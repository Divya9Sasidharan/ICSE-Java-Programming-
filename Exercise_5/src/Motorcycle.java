public class Motorcycle extends Vehicle implements Trunk{
    int  door=0;

    public Motorcycle(boolean wiperState, boolean trunkState) {
        super(wiperState, trunkState);
        setDoorState(door,true);

    }

    @Override
    public void unlockAllDoors() {
        setDoorState(door,false);
    }

    @Override
    public void lockAllDoors() {
        setDoorState(door,true);


    }

    @Override
    public void openTrunk() {
        setTrunkState(true);

    }
    @Override
    public void closeTrunk() {
        setTrunkState(false);

    }
    public static void main(String[] args) {
        Motorcycle std = new Motorcycle(true,true);
        System.out.println("NumberOfDoors : "+std.getNumberOfDoors());
        System.out.println("call Motorcycle with wiperState as : "+std.getWiperState()+" and trunkState  : "+std.getTrunkState());
        std.toggle_wiper();
        System.out.println("After calling toggle_wiper : "+std.getWiperState());

        std.openTrunk();
        System.out.println("After calling openTrunk() getTrunkState : ");
        System.out.println(std.getTrunkState());
        std.closeTrunk();
        System.out.println("After calling closeTrunk() getTrunkState : ");
        System.out.println(std.getTrunkState());

    }
}