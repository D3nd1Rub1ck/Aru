import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

// стандартный GUI классс TreeGUI в java 
class TreeGUI extends JFrame {
    private JTree tree;
    private DefaultMutableTreeNode rootNode; // хранилище все городов корень дерева
    private DefaultTreeModel treeModel; 
    private DefaultMutableTreeNode selectedNode; // ветка которая выбранна сейчас для дальнейшего приязывания к ней 

    public TreeGUI() { // его конструктор он же его тело 
    
        setTitle("My city GUI"); // название окна 
        setSize(500, 500); // размер экрана 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // операция выхода 

        rootNode = new DefaultMutableTreeNode("Cities"); // создание корня 
        treeModel = new DefaultTreeModel(rootNode); // от него уже сттроим  дерево
        tree = new JTree(treeModel); // дерево

        JButton addCityButton = new JButton("Add City"); // кнопка города 
        addCityButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cityName = JOptionPane.showInputDialog("Enter city name:"); //  запрос у пользователя названия города.
                if (cityName != null && !cityName.isEmpty()) { // валидация  если оно не пустое создаём город 
                    City city = new City(cityName); // создаем объект города 
                    DefaultMutableTreeNode cityNode = new DefaultMutableTreeNode(city); // Создаем ветку дерева 
                    rootNode.add(cityNode); // привязываем ветку к дереку а точнее к самому корню потому что это город 
                    treeModel.reload(rootNode); // обновляем экран 
                }
            }
        });

        JButton addBuildingButton = new JButton("Add Building"); // кнопка Здания 
        addBuildingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String buildingName = JOptionPane.showInputDialog("Enter building name:");
                if (buildingName != null && !buildingName.isEmpty()) {
                    Building building = new Building(buildingName);
                    building.printBuilding();
                    DefaultMutableTreeNode buildingNode = new DefaultMutableTreeNode(building);
                    if (selectedNode != null && selectedNode.getUserObject() instanceof City) { 
                        // если выбранная ветка подходит для записание к ней созданного объекта типа здание 
                        selectedNode.add(buildingNode);
                        treeModel.reload(selectedNode);
                        tree.expandPath(new TreePath(selectedNode.getPath()));
                    } else {
                        // иначе говорим пользователю что он ничего не выбрал 
                        JOptionPane.showMessageDialog(null, "Please select a city to add a building.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }); 

        // Один в один тоже самое для комнат 

        JButton addRoomButton = new JButton("Add Room");
        addRoomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String roomName = JOptionPane.showInputDialog("Enter room name:");
                //int roomArea = JOptionPane.showInputDialog("Enter room name:");
                if (roomName != null && !roomName.isEmpty()) {
                    Room room = new Room(roomName, 10);
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

        tree.addTreeSelectionListener(new TreeSelectionListener() { // меняет выбраную ветку 
            public void valueChanged(TreeSelectionEvent e) {
                selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent(); 
            }
        });

        JPanel addCityPanel = new JPanel();
        addCityPanel.add(addCityButton);// доабвляет кнопку в панель

        JPanel addBuildingPanel = new JPanel();
        addBuildingPanel.add(addBuildingButton);// доабвляет кнопку в панель

        JPanel addRoomPanel = new JPanel();
        addRoomPanel.add(addRoomButton);// доабвляет кнопку в панель

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));// располагает их сеткой 
        buttonPanel.add(addCityPanel);
        buttonPanel.add(addBuildingPanel);
        buttonPanel.add(addRoomPanel);// доабвляет сетку на экран 

        JScrollPane scrollPane = new JScrollPane(tree);

        getContentPane().add(buttonPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setVisible(true); // показывает все созданное 
    }
}