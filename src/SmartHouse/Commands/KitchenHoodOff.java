package SmartHouse.Commands;


import SmartHouse.Room;

public class KitchenHoodOff extends ClassCommand
{
    public KitchenHoodOff (Room room) {super(room);}
    @Override
    public void execute() {super.room.kitchenHoodOff();}
}
