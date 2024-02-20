import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Main2{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TreeGUI();
        });
    }
}

class TreeGUI extends JFrame {
    private JTree tree;
    private DefaultMutableTreeNode rootNode;
    private DefaultTreeModel treeModel;
    private DefaultMutableTreeNode selectedNode;

    public TreeGUI() {
        setTitle("City Building Room GUI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rootNode = new DefaultMutableTreeNode("Cities");
        treeModel = new DefaultTreeModel(rootNode);
        tree = new JTree(treeModel);

        JButton addCityButton = new JButton("Add City");
        addCityButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cityName = JOptionPane.showInputDialog("Enter city name:");
                if (cityName != null && !cityName.isEmpty()) {
                    City city = new City(cityName);
                    DefaultMutableTreeNode cityNode = new DefaultMutableTreeNode(city);
                    rootNode.add(cityNode);
                    treeModel.reload(rootNode);
                }
            }
        });

        JButton addBuildingButton = new JButton("Add Building");
        addBuildingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String buildingName = JOptionPane.showInputDialog("Enter building name:");
                if (buildingName != null && !buildingName.isEmpty()) {
                    Building building = new Building(buildingName);
                    DefaultMutableTreeNode buildingNode = new DefaultMutableTreeNode(building);
                    if (selectedNode != null && selectedNode.getUserObject() instanceof City) {
                        selectedNode.add(buildingNode);
                        treeModel.reload(selectedNode);
                        tree.expandPath(new TreePath(selectedNode.getPath()));
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select a city to add a building.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        JButton addRoomButton = new JButton("Add Room");
        addRoomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String roomName = JOptionPane.showInputDialog("Enter room name:");
                if (roomName != null && !roomName.isEmpty()) {
                    Room room = new Room(roomName);
                    DefaultMutableTreeNode roomNode = new DefaultMutableTreeNode(room);
                    if (selectedNode != null && selectedNode.getUserObject() instanceof Building) {
                        selectedNode.add(roomNode);
                        treeModel.reload(selectedNode);
                        tree.expandPath(new TreePath(selectedNode.getPath()));
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select a building to add a room.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            }
        });

        JPanel addCityPanel = new JPanel();
        addCityPanel.add(addCityButton);

        JPanel addBuildingPanel = new JPanel();
        addBuildingPanel.add(addBuildingButton);

        JPanel addRoomPanel = new JPanel();
        addRoomPanel.add(addRoomButton);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.add(addCityPanel);
        buttonPanel.add(addBuildingPanel);
        buttonPanel.add(addRoomPanel);

        JScrollPane scrollPane = new JScrollPane(tree);

        getContentPane().add(buttonPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}

class City {
    private String name;
    private List<Building> buildings = new ArrayList<>();

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public void removeBuilding(Building building) {
        buildings.remove(building);
    }

    @Override
    public String toString() {
        return name;
    }
}

class Building {
    private String name;
    private List<Room> rooms = new ArrayList<>();

    public Building(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    @Override
    public String toString() {
        return name;
    }
}

class Room {
    private String name;

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
