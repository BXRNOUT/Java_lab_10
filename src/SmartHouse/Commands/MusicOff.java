package SmartHouse.Commands;


import SmartHouse.Room;

public class MusicOff extends ClassCommand
{
    public MusicOff(Room room) {super(room);}
    @Override
    public void execute() {super.room.musicOff();}
}
