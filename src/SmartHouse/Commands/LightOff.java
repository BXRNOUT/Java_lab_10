package SmartHouse.Commands;

import SmartHouse.Room;

public class LightOff extends ClassCommand
{
    public LightOff(Room room) {super(room);}
    @Override
    public void execute() {super.room.lightOff();}
}
