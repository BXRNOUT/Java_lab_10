package SmartHouse;

import SmartHouse.Commands.Command;
import SmartHouse.Commands.LightOn;
import SmartHouse.InterfacesRooms.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Path2D;

public class Main
{
    public static void main(String[] args)
    {
        JFrame house = new JFrame("Управление умным домом");
        house.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        house.setSize(800, 825);
        house.setLocationRelativeTo(null);
        house.setVisible(true);

        Street street = new Room();
        Bathroom bathroom = new Room();
        Kitchen kitchen = new Room();
        Bedroom bedroomOne = new Room();
        Bedroom bedroomTwo = new Room();
        WaitingRoom waitingRoom = new Room();
        Hall hall = new Room();

        JPanel jPanel = new JPanel();
        house.add(jPanel);

        Color[] arrayButtonColors = {Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY, Color.WHITE, Color.BLACK};
        Path2D[] arrayButtonShapes = {createFirstRoomButton(), createSecondRoomButton(), createThirdRoomButton(), createFourthRoomButton(), createFifthRoomButton(), createSixthRoomButton(), createStreetButton(), createWalls()};
        house.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (arrayButtonShapes[0].contains(e.getPoint()))
                {
                    arrayButtonColors[0] = Color.PINK;
                    Info jDialogInfo = new Info(null, "Bathroom", true, (Room) bathroom);
                }
                if(arrayButtonColors[0] == Color.PINK)
                    arrayButtonColors[0] = Color.GRAY;
                if (arrayButtonShapes[1].contains(e.getPoint()))
                {
                    arrayButtonColors[1] = Color.PINK;
                    Info jDialogInfo = new Info(null, "Kitchen", true, (Room) kitchen);
                }
                if(arrayButtonColors[1] == Color.PINK)
                    arrayButtonColors[1] = Color.GRAY;
                if (arrayButtonShapes[2].contains(e.getPoint()))
                {
                    arrayButtonColors[2] = Color.PINK;
                    Info jDialogInfo = new Info(null, "Bedroom one", true, (Room) bedroomOne);
                }
                if(arrayButtonColors[2] == Color.PINK)
                    arrayButtonColors[2] = Color.GRAY;
                if (arrayButtonShapes[3].contains(e.getPoint()))
                {
                    arrayButtonColors[3] = Color.PINK;
                    Info jDialogInfo = new Info(null, "Bedroom two", true, (Room) bedroomTwo);
                }
                if(arrayButtonColors[3] == Color.PINK)
                    arrayButtonColors[3] = Color.GRAY;
                if (arrayButtonShapes[4].contains(e.getPoint()))
                {
                    arrayButtonColors[4] = Color.PINK;
                    Info jDialogInfo = new Info(null, "Waiting room", true, (Room) waitingRoom);
                }
                if(arrayButtonColors[4] == Color.PINK)
                    arrayButtonColors[4] = Color.GRAY;
                if (arrayButtonShapes[5].contains(e.getPoint()))
                {
                    arrayButtonColors[5] = Color.PINK;
                    Info jDialogInfo = new Info(null, "Hall", true, (Room) hall);
                }
                if(arrayButtonColors[5] == Color.PINK)
                    arrayButtonColors[5] = Color.GRAY;
                if (arrayButtonShapes[6].contains(e.getPoint()))
                {
                    arrayButtonColors[6] = Color.PINK;
                    Info jDialogInfo = new Info(null, "Street", true, (Room) street);
                }
                if(arrayButtonColors[6] == Color.PINK)
                    arrayButtonColors[6] = Color.WHITE;
            }
        });

        Timer timer = new Timer(1, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Graphics2D g2d = (Graphics2D) jPanel.getRootPane().getGraphics();
                jPanel.update(g2d);

                for (int i = 0; i < arrayButtonShapes.length; i++)
                {
                    g2d.setColor(arrayButtonColors[i]);
                    g2d.fill(arrayButtonShapes[i]);
                }
            }
        });
        timer.start();
    }

    private static Path2D createStreetButton()
    {
        Path2D path2D = new Path2D.Double();
        path2D.moveTo(0,0);
        path2D.lineTo(800,0);
        path2D.lineTo(800,800);
        path2D.lineTo(300,800);
        path2D.lineTo(300,750);
        path2D.lineTo(750,750);
        path2D.lineTo(750,50);
        path2D.lineTo(50,50);
        path2D.lineTo(50,375);
        path2D.lineTo(125,375);
        path2D.lineTo(125,450);
        path2D.lineTo(250,575);
        path2D.lineTo(300,575);
        path2D.lineTo(300,800);
        path2D.lineTo(0,800);
        path2D.closePath();
        return path2D;
    }
    private static Path2D createSixthRoomButton()
    {
        Path2D path2D = new Path2D.Double();
        path2D.moveTo(337,262);
        path2D.lineTo(700,262);
        path2D.lineTo(700,475);
        path2D.lineTo(325,475);
        path2D.lineTo(300,450);
        path2D.lineTo(275,475);
        path2D.lineTo(300,500);
        path2D.lineTo(300,525);
        path2D.lineTo(250,525);
        path2D.lineTo(175,450);
        path2D.lineTo(175,400);
        path2D.lineTo(200,400);
        path2D.lineTo(225,425);
        path2D.lineTo(250,400);
        path2D.lineTo(225,375);
        path2D.closePath();
        return path2D;
    }
    private static Path2D createFifthRoomButton()
    {
        Path2D path2D = new Path2D.Double();
        path2D.moveTo(100,100);
        path2D.lineTo(300,100);
        path2D.lineTo(300,250);
        path2D.lineTo(225,325);
        path2D.lineTo(100,325);
        path2D.closePath();
        return path2D;
    }
    private static Path2D createFourthRoomButton()
    {
        Path2D path2D = new Path2D.Double();
        path2D.moveTo(350,500);
        path2D.lineTo(525,500);
        path2D.lineTo(525,700);
        path2D.lineTo(350,700);
        path2D.closePath();
        return path2D;
    }
    private static Path2D createThirdRoomButton()
    {
        Path2D path2D = new Path2D.Double();
        path2D.moveTo(550, 500);
        path2D.lineTo(700,500);
        path2D.lineTo(700,700);
        path2D.lineTo(550,700);
        path2D.closePath();
        return path2D;
    }
    private static Path2D createSecondRoomButton()
    {
        Path2D path2D = new Path2D.Double();
        path2D.moveTo(487,100);
        path2D.lineTo(700,100);
        path2D.lineTo(700,200);
        path2D.lineTo(600,200);
        path2D.lineTo(600,237);
        path2D.lineTo(487,237);
        path2D.closePath();
        return path2D;
    }
    private static Path2D createFirstRoomButton()
    {
        Path2D path2D = new Path2D.Double();
        path2D.moveTo(350, 100);
        path2D.lineTo(462,100);
        path2D.lineTo(462,237);
        path2D.lineTo(350,237);
        path2D.closePath();
        return path2D;
    }
    private static Path2D createWalls()
    {
        Path2D path2D = new Path2D.Double();
        path2D.moveTo(50, 375);
        path2D.lineTo(50, 50);
        path2D.lineTo(750, 50);
        path2D.lineTo(750, 100);
        path2D.lineTo(700, 100);
        path2D.lineTo(100, 100);
        path2D.lineTo(100, 325);
        path2D.lineTo(225, 325);
        path2D.lineTo(300, 250);
        path2D.lineTo(300, 100);
        path2D.lineTo(350, 100);
        path2D.lineTo(350, 237);
        path2D.lineTo(462, 237);
        path2D.lineTo(462, 100);
        path2D.lineTo(487, 100);
        path2D.lineTo(487, 237);
        path2D.lineTo(600, 237);
        path2D.lineTo(600, 200);
        path2D.lineTo(700, 200);
        path2D.lineTo(700, 100);
        path2D.lineTo(750, 100);
        path2D.lineTo(750, 750);
        path2D.lineTo(700, 750);
        path2D.lineTo(700, 262);
        path2D.lineTo(337, 262);
        path2D.lineTo(225, 375);
        path2D.lineTo(250, 400);
        path2D.lineTo(225, 425);
        path2D.lineTo(200, 400);
        path2D.lineTo(175, 400);
        path2D.lineTo(175, 450);
        path2D.lineTo(250, 525);
        path2D.lineTo(300, 525);
        path2D.lineTo(300, 500);
        path2D.lineTo(275, 475);
        path2D.lineTo(300, 450);
        path2D.lineTo(325, 475);
        path2D.lineTo(700, 475);
        path2D.lineTo(700, 500);
        path2D.lineTo(350, 500);
        path2D.lineTo(350, 700);
        path2D.lineTo(525, 700);
        path2D.lineTo(525, 500);
        path2D.lineTo(550, 500);
        path2D.lineTo(550, 700);
        path2D.lineTo(700, 700);
        path2D.lineTo(700, 750);
        path2D.lineTo(300, 750);
        path2D.lineTo(300, 575);
        path2D.lineTo(250, 575);
        path2D.lineTo(125, 450);
        path2D.lineTo(125, 375);
        path2D.closePath();
        return path2D;
    }
}
