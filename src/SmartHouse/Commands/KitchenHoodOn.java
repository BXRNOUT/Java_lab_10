package SmartHouse.Commands;


import SmartHouse.Room;

public class KitchenHoodOn extends ClassCommand
{
    public KitchenHoodOn(Room room) {super(room);}
    @Override
    public void execute() {super.room.kitchenHoodOn();}
}
