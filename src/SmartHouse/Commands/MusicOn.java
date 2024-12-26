package SmartHouse.Commands;

import SmartHouse.Room;

public class MusicOn extends ClassCommand
{
    public MusicOn(Room room) {super(room);}
    @Override
    public void execute() {super.room.musicOn();}
}
