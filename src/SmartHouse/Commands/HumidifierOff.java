package SmartHouse.Commands;

import SmartHouse.Room;

public class HumidifierOff extends ClassCommand
{
    public HumidifierOff(Room room) {super(room);}
    @Override
    public void execute() {super.room.humidifierOff();}
}
