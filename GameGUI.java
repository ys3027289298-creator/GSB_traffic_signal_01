import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class GameGUI {
    private Core state = new Core();
    private JLabel status = new JLabel(" ");

    public GameGUI() {
        JFrame frame = new JFrame("红绿灯调度");
        JPanel panel = new JPanel();
        JButton addBtn = new JButton("添加");
        JButton receiveBtn = new JButton("接收");
        JButton cancelBtn = new JButton("取消");
        JButton eventBtn = new JButton("事件");
        addBtn.addActionListener(e -> { state.add(state.items.size() + 1, 10); refresh(); });
        receiveBtn.addActionListener(e -> { state.receive(state.items.size() + 1); refresh(); });
        cancelBtn.addActionListener(e -> { state.cancel(1); refresh(); });
        eventBtn.addActionListener(e -> { state.event(); refresh(); });
        panel.add(addBtn);
        panel.add(receiveBtn);
        panel.add(cancelBtn);
        panel.add(eventBtn);
        frame.add(panel, BorderLayout.NORTH);
        frame.add(status, BorderLayout.SOUTH);
        frame.setSize(420, 180);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        refresh();
    }

    private void refresh() {
        status.setText("stock=" + state.stock + " metric=" + state.metric + " items=" + state.items.size());
    }

    public static void main(String[] args) {
        new GameGUI();
    }
}
