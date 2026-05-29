/*
 * Huffman Coding GUI Application
 * Enhanced user interface for text compression
 * 
 * @author Noman Shakir
 */

package huffmancoding;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class HuffmanCodingGUI extends JFrame {

    private JTextArea inputTextArea;
    private JTextArea originalBinaryArea;
    private JTextArea compressedBinaryArea;
    private JLabel originalSizeLabel;
    private JLabel compressedSizeLabel;
    private JLabel sizeDifferenceLabel;
    private HuffmanCoding.HuffmanResult result;

    public HuffmanCodingGUI() {
        // Frame setup
        setTitle("Huffman Coding Compression - By Noman Shakir");
        setSize(1400, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Set modern look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Modern color scheme
        Color primaryColor = new Color(41, 128, 185);
        Color secondaryColor = new Color(52, 152, 219);
        Color accentColor = new Color(46, 204, 113);
        Color darkBg = new Color(44, 62, 80);
        Color lightBg = new Color(236, 240, 241);

        // Create and add panels
        JPanel topPanel = new JPanel();
        topPanel.setBackground(darkBg);
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create modern buttons
        JButton uploadButton = createStyledButton("Upload File", accentColor);
        JButton compressButton = createStyledButton("Compress Text", primaryColor);
        JButton clearButton = createStyledButton("Clear", new Color(231, 76, 60));

        topPanel.add(uploadButton);
        topPanel.add(compressButton);
        topPanel.add(clearButton);

        // Add author label
        JLabel authorLabel = new JLabel("Developed by: Noman Shakir");
        authorLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        authorLabel.setForeground(new Color(149, 165, 166));
        topPanel.add(Box.createHorizontalStrut(50));
        topPanel.add(authorLabel);

        add(topPanel, BorderLayout.NORTH);

        // Center panel with text areas and labels
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 14));
        tabbedPane.setBackground(lightBg);

        // Input text panel
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBackground(lightBg);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputTextArea = createTextArea("Enter Text to Compress:");
        inputPanel.add(createScrollPane(inputTextArea), BorderLayout.CENTER);

        // Binary data panel
        JPanel originalPanel = new JPanel(new BorderLayout());
        originalPanel.setBackground(lightBg);
        originalPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        originalBinaryArea = createTextArea("Original Binary Data:");
        originalSizeLabel = createLabel("Original Size: ");
        JPanel origLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        origLabelPanel.setBackground(lightBg);
        origLabelPanel.add(originalSizeLabel);
        originalPanel.add(createScrollPane(originalBinaryArea), BorderLayout.CENTER);
        originalPanel.add(origLabelPanel, BorderLayout.SOUTH);

        JPanel compressedPanel = new JPanel(new BorderLayout());
        compressedPanel.setBackground(lightBg);
        compressedPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        compressedBinaryArea = createTextArea("Compressed Binary Data:");
        compressedSizeLabel = createLabel("Compressed Size: ");
        sizeDifferenceLabel = createLabel("Size Difference: ");
        JPanel compLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        compLabelPanel.setBackground(lightBg);
        compLabelPanel.add(compressedSizeLabel);
        compLabelPanel.add(Box.createHorizontalStrut(20));
        compLabelPanel.add(sizeDifferenceLabel);
        compressedPanel.add(createScrollPane(compressedBinaryArea), BorderLayout.CENTER);
        compressedPanel.add(compLabelPanel, BorderLayout.SOUTH);

        tabbedPane.addTab("Input Text", inputPanel);
        tabbedPane.addTab("Original Data", originalPanel);
        tabbedPane.addTab("Compressed Data", compressedPanel);

        add(tabbedPane, BorderLayout.CENTER);

        // Add footer panel
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(darkBg);
        footerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel footerLabel = new JLabel("(C) 2026 Noman Shakir - Huffman Coding Implementation");
        footerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        footerLabel.setForeground(new Color(149, 165, 166));
        footerPanel.add(footerLabel);
        add(footerPanel, BorderLayout.SOUTH);

        // Action listeners for buttons
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
                int result = fileChooser.showOpenDialog(HuffmanCodingGUI.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    processFile(selectedFile);
                }
            }
        });

        compressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = inputTextArea.getText();
                if (text.isEmpty()) {
                    JOptionPane.showMessageDialog(HuffmanCodingGUI.this, "Please enter text to compress.",
                            "Input Required", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                result = HuffmanCoding.compress(text);
                displayResults();
                try {
                    HuffmanCoding.writeBinaryFile("OriginalFile.bin", result.originalBinary);
                    HuffmanCoding.writeBinaryFile("output.bin", result.compressedBinary);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(HuffmanCodingGUI.this,
                            "Error writing binary file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputTextArea.setText("");
                originalBinaryArea.setText("");
                compressedBinaryArea.setText("");
                originalSizeLabel.setText("Original Size: ");
                compressedSizeLabel.setText("Compressed Size: ");
                sizeDifferenceLabel.setText("Size Difference: ");
            }
        });
    }

    private JButton createStyledButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(12, 25, 12, 25));

        // Add hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(color.brighter());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(color);
            }
        });

        return button;
    }

    private JTextArea createTextArea(String title) {
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Consolas", Font.PLAIN, 13));
        textArea.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(new Color(52, 152, 219), 2),
                        title,
                        javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                        javax.swing.border.TitledBorder.DEFAULT_POSITION,
                        new Font("Segoe UI", Font.BOLD, 12),
                        new Color(44, 62, 80)),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        textArea.setBackground(Color.WHITE);
        textArea.setCaretColor(new Color(52, 152, 219));
        return textArea;
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, 15));
        label.setForeground(new Color(44, 62, 80));
        return label;
    }

    private JScrollPane createScrollPane(JTextArea textArea) {
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        return scrollPane;
    }

    private void processFile(File file) {
        try {
            String text = HuffmanCoding.readFile(file.getAbsolutePath());
            inputTextArea.setText(text);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayResults() {
        originalBinaryArea.setText(formatBinaryData(result.originalBinary));
        originalSizeLabel.setText("Original Size: " + result.originalSize + " bits");
        compressedBinaryArea.setText(formatBinaryData(result.compressedBinary));
        compressedSizeLabel.setText("Compressed Size: " + result.compressedSize + " bits");
        int saved = result.originalSize - result.compressedSize;
        double percentage = (saved * 100.0) / result.originalSize;
        sizeDifferenceLabel.setText(String.format("Space Saved: %d bits (%.2f%%)", saved, percentage));
    }

    private String formatBinaryData(String binaryData) {
        StringBuilder formatted = new StringBuilder();
        for (int i = 0; i < binaryData.length(); i += 8) {
            if (i > 0) {
                formatted.append(" ");
            }
            formatted.append(binaryData, i, Math.min(i + 8, binaryData.length()));
        }
        return formatted.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HuffmanCodingGUI gui = new HuffmanCodingGUI();
            gui.setVisible(true);
        });
    }
}
