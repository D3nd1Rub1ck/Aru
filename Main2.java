import javax.swing.*;

public class Main2{ // точка входа 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TreeGUI(); // запускаем GUI
        });
    }
}