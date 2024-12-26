package SmartHouse;

import SmartHouse.Commands.*;
import SmartHouse.InterfacesRooms.Bedroom;
import SmartHouse.InterfacesRooms.Street;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Info
{
    public Info(Dialog parent, String title, boolean isModal, Room room)
    {
        JDialog frame = setSettings(parent,title,isModal);
        RoomController roomController = new RoomController();
        JPanel base = new JPanel(new FlowLayout());

        //строка для ввода температуры в спальнях
        JTextField jTextField = new JTextField();
        jTextField.setSize(100, 30);

        Command lightOn = new LightOn(room);
        Command lightOff = new LightOff(room);

        JPanel jPanelLight = new JPanel();
        JLabel jLabelLight = new JLabel("Свет");
        JButton jButtonLight = new JButton(room.getLightStatus() ? "On" : "Off");
        jButtonLight.setForeground(room.getLightStatus() ? Color.GREEN : Color.RED );
        jButtonLight.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(jButtonLight.getText().equals("On"))
                {
                    roomController.addCommand(lightOff);
                    jButtonLight.setText("Off");
                    jButtonLight.setForeground(Color.RED);
                }
                else
                {
                    roomController.addCommand(lightOn);
                    jButtonLight.setText("On");
                    jButtonLight.setForeground(Color.GREEN);
                }
            }
        });
        jPanelLight.add(jLabelLight);
        jPanelLight.add(jButtonLight);
        JPanel levelOne = new JPanel(new BorderLayout());
        levelOne.add(jPanelLight, BorderLayout.NORTH);



        if(title.equals("Bathroom") || title.equals("Kitchen") || title.equals("Bedroom one") || title.equals("Bedroom two") || title.equals("Waiting room") || title.equals("Hall"))
        {
            Command openDoor = new OpenDoor(room);
            Command closeDoor = new CloseDoor(room);

            JPanel jPanelDoor = new JPanel();
            JLabel jLabelDoor = new JLabel("Замок двери");
            JButton jButtonDoor = new JButton(room.getDoorStatus() ? "Open" : "Close");
            jButtonDoor.setForeground(room.getDoorStatus() ? Color.GREEN : Color.RED );
            jButtonDoor.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if(jButtonDoor.getText().equals("Open"))
                    {
                        roomController.addCommand(closeDoor);
                        jButtonDoor.setText("Close");
                        jButtonDoor.setForeground(Color.RED);
                    }
                    else
                    {
                        roomController.addCommand(openDoor);
                        jButtonDoor.setText("Open");
                        jButtonDoor.setForeground(Color.GREEN);
                    }
                }
            });
            jPanelDoor.add(jLabelDoor);
            jPanelDoor.add(jButtonDoor);
            JPanel levelTwo = new JPanel(new BorderLayout());
            levelTwo.add(jPanelDoor, BorderLayout.NORTH);
            levelOne.add(levelTwo, BorderLayout.CENTER);



            if(title.equals("Kitchen"))
            {
                Command kitchenHoodOn = new KitchenHoodOn(room);
                Command kitchenHoodOff = new KitchenHoodOff(room);

                JPanel jPanelHood = new JPanel();
                JLabel jLabelHood = new JLabel("Вытяжка");
                JButton jButtonHood = new JButton(room.getKitchenHoodStatus() ? "On" : "Off");
                jButtonHood.setForeground(room.getKitchenHoodStatus() ? Color.GREEN : Color.RED );
                jButtonHood.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        if(jButtonHood.getText().equals("On"))
                        {
                            roomController.addCommand(kitchenHoodOff);
                            jButtonHood.setText("Off");
                            jButtonHood.setForeground(Color.RED);
                        }
                        else
                        {
                            roomController.addCommand(kitchenHoodOn);
                            jButtonHood.setText("On");
                            jButtonHood.setForeground(Color.GREEN);
                        }
                    }
                });
                jPanelHood.add(jLabelHood);
                jPanelHood.add(jButtonHood);
                levelTwo.add(jPanelHood, BorderLayout.CENTER);
            }



            if(title.equals("Bedroom one") || title.equals("Bedroom two"))
            {
                JPanel jPanelBedroom = new JPanel(new BorderLayout());
                JLabel jLabelBedroom = new JLabel("Температура комнаты: " + room.getTemperature());
                jLabelBedroom.setForeground(room.getTemperature() < 20 ? Color.BLUE : Color.ORANGE );

                jPanelBedroom.add(jLabelBedroom, BorderLayout.NORTH);
                jPanelBedroom.add(jTextField, BorderLayout.CENTER);
                levelTwo.add(jPanelBedroom, BorderLayout.CENTER);
            }



            if(title.equals("Waiting room"))
            {
                Command tvOn = new TVOn(room);
                Command tvOff = new TVOff(room);

                JPanel jPanelTV = new JPanel();
                JLabel jLabelTV = new JLabel("Телевизор");
                JButton jButtonTV = new JButton(room.getTVStatus() ? "On" : "Off");
                jButtonTV.setForeground(room.getTVStatus() ? Color.GREEN : Color.RED );
                jButtonTV.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        if(jButtonTV.getText().equals("On"))
                        {
                            roomController.addCommand(tvOff);
                            jButtonTV.setText("Off");
                            jButtonTV.setForeground(Color.RED);
                        }
                        else
                        {
                            roomController.addCommand(tvOn);
                            jButtonTV.setText("On");
                            jButtonTV.setForeground(Color.GREEN);
                        }
                    }
                });
                jPanelTV.add(jLabelTV);
                jPanelTV.add(jButtonTV);
                levelTwo.add(jPanelTV, BorderLayout.CENTER);
            }



            if(title.equals("Hall"))
            {
                Command musicOn = new MusicOn(room);
                Command musicOff = new MusicOff(room);
                Command humidifierOn = new HumidifierOn(room);
                Command humidifierOff = new HumidifierOff(room);

                JPanel jPanelMusic = new JPanel();
                JPanel jPanelHumidifier = new JPanel();
                JLabel jLabelMusic = new JLabel("Музыка");
                JLabel jLabelHumidifier = new JLabel("Увлажнитель");
                JButton jButtonMusic = new JButton(room.getMusicStatus() ? "On" : "Off");
                JButton jButtonHumidifier = new JButton(room.getHumidifierStatus() ? "On" : "Off");
                jButtonMusic.setForeground(room.getMusicStatus() ? Color.GREEN : Color.RED );
                jButtonHumidifier.setForeground(room.getHumidifierStatus() ? Color.GREEN : Color.RED );
                jButtonMusic.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        if(jButtonMusic.getText().equals("On"))
                        {
                            roomController.addCommand(musicOff);
                            jButtonMusic.setText("Off");
                            jButtonMusic.setForeground(Color.RED);
                        }
                        else
                        {
                            roomController.addCommand(musicOn);
                            jButtonMusic.setText("On");
                            jButtonMusic.setForeground(Color.GREEN);
                        }
                    }
                });
                jButtonHumidifier.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        if(jButtonHumidifier.getText().equals("On"))
                        {
                            roomController.addCommand(humidifierOff);
                            jButtonHumidifier.setText("Off");
                            jButtonHumidifier.setForeground(Color.RED);
                        }
                        else
                        {
                            roomController.addCommand(humidifierOn);
                            jButtonHumidifier.setText("On");
                            jButtonHumidifier.setForeground(Color.GREEN);
                        }
                    }
                });
                jPanelMusic.add(jLabelMusic);
                jPanelMusic.add(jButtonMusic);
                jPanelHumidifier.add(jLabelHumidifier);
                jPanelHumidifier.add(jButtonHumidifier);
                JPanel levelThree = new JPanel(new BorderLayout());
                levelThree.add(jPanelMusic, BorderLayout.NORTH);
                levelThree.add(jPanelHumidifier, BorderLayout.CENTER);
                levelTwo.add(levelThree, BorderLayout.CENTER);
            }
        }


        //Кнопка Сохранить изменения и добавление всех элементов на окно
        JButton ok = new JButton("Сохранить изменения");
        ok.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(title.equals("Bedroom two") || title.equals("Bedroom one"))
                {
                    try
                    {
                        String temperature = jTextField.getText();
                        if (temperature.matches("\\d+"))
                        {
                            Command setTemperature = new SetTemperature(room, Integer.parseInt(temperature));
                            roomController.addCommand(setTemperature);
                        }
                    }
                    catch (NumberFormatException ignored) {}
                }
                roomController.pressButton();
                frame.dispose();
            }
        });
        base.add(levelOne);
        frame.add(base, BorderLayout.NORTH);
        frame.add(ok, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private JDialog setSettings(Dialog parent, String title, boolean isModal)
    {
        JDialog jDialog = new JDialog(parent,title,isModal);
        jDialog.setLayout(new BorderLayout());
        jDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jDialog.setSize(200,220);
        jDialog.setLocationRelativeTo(null);
        return jDialog;
    }
}
