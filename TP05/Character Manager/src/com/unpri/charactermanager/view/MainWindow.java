
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.manager.CharacterManager;
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Locale;

public class MainWindow extends JFrame {

    private final CharacterManager manager;
    private final JPanel characterPanel;
    private final JLabel totalLabel;
    private final JLabel averageLabel;

    public MainWindow(CharacterManager manager) {
        this.manager = manager;

        setTitle("Character Manager - Sprint #3");
        setSize(750, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel(
                "Daftar Karakter",
                SwingConstants.CENTER
        );

        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setBorder(
                BorderFactory.createEmptyBorder(15, 10, 15, 10)
        );

        add(titleLabel, BorderLayout.NORTH);

        characterPanel = new JPanel();
        characterPanel.setLayout(
                new BoxLayout(characterPanel, BoxLayout.Y_AXIS)
        );
        characterPanel.setBackground(Color.WHITE);
        characterPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        );

        JScrollPane scrollPane = new JScrollPane(characterPanel);
        add(scrollPane, BorderLayout.CENTER);

        totalLabel = new JLabel("", SwingConstants.CENTER);
        totalLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        averageLabel = new JLabel("", SwingConstants.CENTER);
        averageLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JButton addButton = new JButton("Tambah Karakter");
        addButton.setFont(new Font("Arial", Font.BOLD, 14));
        addButton.addActionListener(e -> showAddCharacterDialog());

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(
                new BoxLayout(bottomPanel, BoxLayout.Y_AXIS)
        );
        bottomPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 15, 15, 15)
        );

        bottomPanel.add(totalLabel);
        bottomPanel.add(Box.createVerticalStrut(8));
        bottomPanel.add(averageLabel);
        bottomPanel.add(Box.createVerticalStrut(12));

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(addButton, BorderLayout.CENTER);
        bottomPanel.add(buttonPanel);

        add(bottomPanel, BorderLayout.SOUTH);

        refreshData();
    }

    public void refreshData() {
        characterPanel.removeAll();

        ArrayList<Character> characters = manager.getAllCharacters();

        for (Character character : characters) {
            JLabel characterLabel = new JLabel(character.toString());

            characterLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            characterLabel.setBorder(
                    BorderFactory.createEmptyBorder(10, 5, 10, 5)
            );
            characterLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            characterPanel.add(characterLabel);
        }

        totalLabel.setText(
                "Total Karakter: " + manager.getTotalCharacters()
        );

        averageLabel.setText(
                String.format(
                        Locale.US,
                        "Rata-rata Level: %.2f",
                        manager.getAverageLevel()
                )
        );

        characterPanel.revalidate();
        characterPanel.repaint();
    }

    private void showAddCharacterDialog() {
        JTextField nameField = new JTextField(15);
        JTextField levelField = new JTextField(15);

        JComboBox<CharacterType> typeBox =
                new JComboBox<>(CharacterType.values());

        JPanel form = new JPanel(new GridLayout(0, 2, 8, 8));
        form.add(new JLabel("Nama karakter:"));
        form.add(nameField);
        form.add(new JLabel("Level:"));
        form.add(levelField);
        form.add(new JLabel("Tipe:"));
        form.add(typeBox);

        int result = JOptionPane.showConfirmDialog(
                this,
                form,
                "Tambah Karakter",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result != JOptionPane.OK_OPTION) {
            return;
        }

        try {
            String name = nameField.getText().trim();
            int level = Integer.parseInt(levelField.getText().trim());
            CharacterType type = (CharacterType) typeBox.getSelectedItem();

            Character newCharacter = new Character(name, level, type);
            manager.addCharacter(newCharacter);

            refreshData();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Level harus berupa angka.",
                    "Input tidak valid",
                    JOptionPane.WARNING_MESSAGE
            );

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Input tidak valid",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }
}
