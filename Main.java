import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

/**
 * CS 410 Final Project
 * Java Implementation: Simple Calculator
 * Demonstrating Static Typing and Imperative Control Flow
 */
public class Main extends JFrame {

    private JTextField num1Field, num2Field, resultField;
    private JComboBox<String> operatorBox;

    static final Color BG = new Color(248, 247, 255);
    static final Color CARD = Color.WHITE;
    static final Color PRIMARY = new Color(108, 99, 255);
    static final Color PRIMARY_DARK = new Color(80, 72, 200);
    static final Color TEXT = new Color(40, 40, 60);
    static final Color SUBTLE = new Color(150, 145, 180);
    static final Color SUCCESS = new Color(34, 197, 94);
    static final Color ERROR = new Color(239, 68, 68);

    public Main() {
        setTitle("CS 410 · Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 560);
        setLocationRelativeTo(null);
        setResizable(false);
        setBackground(BG);

        JPanel root = new JPanel(new BorderLayout(0, 0));
        root.setBackground(BG);
        root.setBorder(new EmptyBorder(30, 36, 24, 36));

        // ── Header ──
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        header.setBackground(BG);
        header.setBorder(new EmptyBorder(0, 0, 20, 0));

        JLabel icon = new JLabel("🧮", SwingConstants.CENTER);
        icon.setFont(new Font("Dialog", Font.PLAIN, 36));
        icon.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel title = new JLabel("Simple Calculator");
        title.setFont(new Font("Dialog", Font.BOLD, 22));
        title.setForeground(TEXT);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("CS 410 Final Project");
        subtitle.setFont(new Font("Dialog", Font.PLAIN, 13));
        subtitle.setForeground(SUBTLE);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        header.add(icon);
        header.add(Box.createVerticalStrut(6));
        header.add(title);
        header.add(Box.createVerticalStrut(2));
        header.add(subtitle);

        // ── Card ──
        JPanel card = new RoundedPanel(20, CARD);
        card.setLayout(new GridBagLayout());
        card.setBorder(new EmptyBorder(24, 24, 24, 24));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 4, 8, 4);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        num1Field = styledField();
        num2Field = styledField();
        resultField = styledField();
        resultField.setEditable(false);
        resultField.setBackground(new Color(245, 244, 255));
        resultField.setForeground(PRIMARY);
        resultField.setFont(new Font("Dialog", Font.BOLD, 15));

        operatorBox = new JComboBox<>(new String[]{"+", "-", "×", "÷"});
        operatorBox.setFont(new Font("Dialog", Font.PLAIN, 15));
        operatorBox.setBackground(Color.WHITE);
        operatorBox.setPreferredSize(new Dimension(0, 46));
        operatorBox.setBorder(new LineBorder(new Color(220, 218, 240), 1, true));

        // Row 0 — First Number
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.35;
        card.add(styledLabel("First Number"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.65;
        card.add(num1Field, gbc);

        // Row 1 — Operator
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.35;
        card.add(styledLabel("Operator"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.65;
        card.add(operatorBox, gbc);

        // Row 2 — Second Number
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0.35;
        card.add(styledLabel("Second Number"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.65;
        card.add(num2Field, gbc);

        // Row 3 — Result
        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0.35;
        card.add(styledLabel("Result"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.65;
        card.add(resultField, gbc);

        // ── Button ──
        JButton btn = new JButton("Calculate") {
            @Override protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getModel().isPressed() ? PRIMARY_DARK : PRIMARY);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 14, 14);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Dialog", Font.BOLD, 15));
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setPreferredSize(new Dimension(0, 50));
        btn.addActionListener(e -> performCalculation());

        // ── Footer ──
        JLabel names = new JLabel(
            "จัดทำโดย: กัญญาณัฐ, จตุพร, อาภรณ์ภัทร์, กษิรา",
            SwingConstants.CENTER);
        names.setFont(new Font("Dialog", Font.PLAIN, 11));
        names.setForeground(SUBTLE);
        names.setBorder(new EmptyBorder(14, 0, 0, 0));

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBackground(BG);
        bottom.setBorder(new EmptyBorder(16, 0, 0, 0));
        bottom.add(btn, BorderLayout.CENTER);
        bottom.add(names, BorderLayout.SOUTH);

        root.add(header, BorderLayout.NORTH);
        root.add(card, BorderLayout.CENTER);
        root.add(bottom, BorderLayout.SOUTH);

        add(root);
        setVisible(true);
    }

    private JTextField styledField() {
        JTextField f = new JTextField();
        f.setFont(new Font("Dialog", Font.PLAIN, 15));
        f.setForeground(TEXT);
        f.setPreferredSize(new Dimension(0, 46));
        f.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(220, 218, 240), 1, true),
            new EmptyBorder(10, 12, 10, 12)));
        return f;
    }

    private JLabel styledLabel(String text) {
        JLabel l = new JLabel(text);
        l.setFont(new Font("Dialog", Font.PLAIN, 13));
        l.setForeground(SUBTLE);
        return l;
    }

    private void performCalculation() {
        try {
            double num1 = Double.parseDouble(num1Field.getText().trim());
            double num2 = Double.parseDouble(num2Field.getText().trim());
            String opStr = operatorBox.getSelectedItem().toString();
            char op = opStr.equals("×") ? '*' : opStr.equals("÷") ? '/' : opStr.charAt(0);
            double result = calculate(num1, num2, op);
            if (Double.isNaN(result)) {
                resultField.setText("Cannot divide by zero");
                resultField.setForeground(ERROR);
            } else {
                resultField.setText(num1 + " " + opStr + " " + num2 + " = " + result);
                resultField.setForeground(SUCCESS);
            }
        } catch (NumberFormatException e) {
            resultField.setText("Invalid input");
            resultField.setForeground(ERROR);
        }
    }

    /**
     * การใช้ Switch Case และ Explicit Typing ตามคุณสมบัติของ Java
     */
    public static double calculate(double a, double b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return b == 0 ? Double.NaN : a / b;
            default: return 0;
        }
    }

    static class RoundedPanel extends JPanel {
        private final int radius;
        private final Color bg;
        RoundedPanel(int radius, Color bg) {
            this.radius = radius; this.bg = bg;
            setOpaque(false);
        }
        @Override protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(bg);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            g2.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}
