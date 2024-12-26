package SmartHouse.Commands;


import SmartHouse.Room;

public class TVOff extends ClassCommand
{
    public TVOff(Room room) {super(room);}
    @Override
    public void execute() {super.room.tvOff();}
}
