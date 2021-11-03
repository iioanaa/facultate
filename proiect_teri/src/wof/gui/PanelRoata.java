package wof.gui;

import wof.game.RoataNorocului;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PanelRoata extends JPanel {
    private static final String IMAGES_DIR = "/images/";

    private static final String[] IMAGE_NAMES;

    private static final Map<String, Color> WHEEL_COLORS;

    private static final int DEGREES_EACH = 20;

    private final Map<String, Image> IMAGES;

    private RoataNorocului game;

    private Timer wheelTimer;

    private ButtonListener buttonListener;

    private List<String> imageNames;

    private String spaceLanded;

    private JPanel lettersPanel;

    private JButton spinWheel;

    private JTextArea statusArea;

    static {

        IMAGE_NAMES =
                new String[] {"300.png", "750.png", "500.png", "loseATurn.png",
                        "1000.png", "600.png", "350.png", "950.png", "800.png",
                        "550.png", "450.png", "700.png", "bankrupt.png", "650.png",
                        "250.png", "900.png", "400.png", "850.png"};

        WHEEL_COLORS = new HashMap<String, Color>();
        WHEEL_COLORS.put("300", Color.BLUE);
        WHEEL_COLORS.put("750", Color.RED);
        WHEEL_COLORS.put("500", Color.ORANGE);
        WHEEL_COLORS.put("loseATurn", Color.WHITE);
        WHEEL_COLORS.put("1000", Color.MAGENTA);
        WHEEL_COLORS.put("600", new Color(255, 107, 36));
        WHEEL_COLORS.put("350", new Color(192, 192, 192));
        WHEEL_COLORS.put("950", new Color(128, 64, 0));
        WHEEL_COLORS.put("800", new Color(128, 0, 255));
        WHEEL_COLORS.put("550", new Color(0, 128, 128));
        WHEEL_COLORS.put("450", new Color(255, 0, 128));
        WHEEL_COLORS.put("700", new Color(0, 128, 0));
        WHEEL_COLORS.put("bankrupt", Color.BLACK);
        WHEEL_COLORS.put("650", Color.YELLOW);
        WHEEL_COLORS.put("250", Color.GREEN);
        WHEEL_COLORS.put("900", Color.PINK);
        WHEEL_COLORS.put("400", Color.GRAY);
        WHEEL_COLORS.put("850", Color.CYAN);
    }

    public PanelRoata(RoataNorocului game){
                   //   PanelScor scorPanel){

        super();

        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();

        IMAGES = new HashMap<String, Image>();
        //text image
        for (String imageName : IMAGE_NAMES) {
            IMAGES.put(
                    imageName,
                    defaultToolkit.getImage(getClass().getResource(
                            IMAGES_DIR + imageName)));
        }
         //sageata
        IMAGES.put(
                "arrow.png",
                defaultToolkit.getImage(getClass().getResource(
                        IMAGES_DIR + "arrow.png")));

        //rotire
        wheelTimer = new Timer(25, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = imageNames.get(0);
                imageNames.remove(0);
                imageNames.add(value);

                repaint();
            }
        });


        buttonListener = new ButtonListener();

        lettersPanel = new JPanel();
        lettersPanel.setPreferredSize(new Dimension(100, 200));
        lettersPanel.setLayout(new GridLayout(6, 5, 2, 2));

        spinWheel = new JButton("Spin Wheel");
        spinWheel.addActionListener(buttonListener);



        statusArea = new JTextArea();
        statusArea.setFont(new Font("Tahoma", Font.PLAIN, 11));
        statusArea.setEditable(false);
        statusArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        statusArea.setLineWrap(true);
        statusArea.setWrapStyleWord(true);

        Box optionButtonsBox = Box.createVerticalBox();
        optionButtonsBox.add(spinWheel);
        optionButtonsBox.add(Box.createVerticalStrut(10));

        optionButtonsBox.add(Box.createVerticalStrut(18));

        optionButtonsBox.add(Box.createVerticalStrut(20));

        Box letterButtonsBox = Box.createVerticalBox();
        letterButtonsBox.add(lettersPanel);
        letterButtonsBox.add(Box.createVerticalStrut(10));
        letterButtonsBox.add(statusArea);
        letterButtonsBox.add(Box.createVerticalStrut(235));

       Box outsideBox = Box.createHorizontalBox();
        outsideBox.add(Box.createHorizontalStrut(20));
        outsideBox.add(optionButtonsBox);
        outsideBox.add(Box.createHorizontalStrut(550));
        outsideBox.add(letterButtonsBox);
        outsideBox.add(Box.createHorizontalStrut(20));
        outsideBox.setPreferredSize(new Dimension(900, 500));

        add(outsideBox);
        setPreferredSize(new Dimension(900, 300));

        newGame();
    }



    public void newGame() {
        statusArea.setText("Bun venit la Roata Norocului\n"
                + "Tu poti incepe sa rotesti ");

        imageNames = new ArrayList<String>();

        for (String name : IMAGE_NAMES) {
            imageNames.add(name);
        }

        spinWheel.setEnabled(true);

        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D)g.create();


        for (int i = 0, degrees = 0; i < imageNames.size() / 2; ++i) {
            g2D.setColor(WHEEL_COLORS.get(imageNames.get(i).substring(0,
                    imageNames.get(i).indexOf('.'))));
            g2D.fillArc(150, 45, 480, 480, degrees, DEGREES_EACH);
            degrees += DEGREES_EACH;
        }


        g2D.translate(390, 285);
        g2D.rotate(Math.toRadians(-100));


        for (int i = 0; i < imageNames.size() / 2; ++i) {
            g2D.drawImage(IMAGES.get(imageNames.get(i)), -42, 0, this);
            g2D.rotate(Math.toRadians(-DEGREES_EACH));
        }

        g2D.translate(-390, -285);

        g.drawImage(IMAGES.get("arrow.png"), 370, 10, this);
    }



    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton)e.getSource();

            if (source == spinWheel) {
                String cmd = e.getActionCommand();

                if (cmd.equals("Spin Wheel")) {

                    wheelTimer.start();
                    statusArea.setText("Roata se invarte");
                    spinWheel.setText("Stop ");
                } else if (cmd.equals("Stop ")) {

                    wheelTimer.stop();

                    spaceLanded = imageNames.get(4);
                }
            }

            }

        }
    }

