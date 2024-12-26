package SmartHouse.Commands;


import SmartHouse.Room;

public class TVOn extends ClassCommand
{
    public TVOn(Room room) {super(room);}
    @Override
    public void execute() {super.room.tvOn();}
}
