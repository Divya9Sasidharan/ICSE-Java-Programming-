public class Car extends Vehicle implements Trunk{
    int  door=4;

    public Car(boolean wiperState, boolean trunkState) {
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
        Car std = new Car(true,true);
        System.out.println("NumberOfDoors : "+std.getNumberOfDoors());
        System.out.println("call car with wiperState as : "+std.getWiperState()+" and trunkState  : "+std.getTrunkState());
        std.toggle_wiper();
        System.out.println("After calling toggle_wiper : "+std.getWiperState());
        std.lockAllDoors();
        System.out.println("After calling lockAllDoors() door state : ");
        System.out.println(std.getDoorState(std.getNumberOfDoors()-1));
        std.unlockAllDoors();
        System.out.println("After calling unlockAllDoors() door state : ");
        System.out.println(std.getDoorState(std.getNumberOfDoors()-1));
        std.openTrunk();
        System.out.println("After calling openTrunk() getTrunkState : ");
        System.out.println(std.getTrunkState());
        std.closeTrunk();
        System.out.println("After calling closeTrunk() getTrunkState : ");
        System.out.println(std.getTrunkState());

    }
}