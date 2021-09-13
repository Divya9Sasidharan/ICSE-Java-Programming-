public abstract class Vehicle {


    private boolean wiper_active;
    private boolean[] doors;
    private boolean trunk_open;

    public void toggle_wiper() {
        if (wiper_active) {
            wiper_active = false;
        } else {
            wiper_active = true;
        }
    }

    public boolean getWiperState() {
        return wiper_active;
    }
    public int getNumberOfDoors() {
        return doors.length;
    }

    public void setDoorState(int door,boolean state)
    {
        doors=new boolean[door];
        for (int i = 0; i < door ; i++) {
            doors[i]=state;

        }
    }


    public boolean getDoorState(int door)
    {
        return doors[door];
    }
    public boolean getTrunkState() {
        return trunk_open;

    }
    public void setTrunkState(boolean trunkState) {
        trunk_open=trunkState;

    }

    public abstract void unlockAllDoors();
    public abstract void lockAllDoors();
    public Vehicle(boolean wiperState, boolean trunkState) {
        this.wiper_active=wiperState;
        this.trunk_open=trunkState;

    }
}