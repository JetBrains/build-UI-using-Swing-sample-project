package com.example.library.forms;

import com.example.library.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookEditorExample extends JFrame{
    private JPanel contentPane;
    private JTextField authorNameField;
    private JComboBox<Genre> genreComboBox;
    private JTextField bookNameField;
    private JCheckBox isTakenCheckBox;
    private JButton saveButton;
    private JButton cancelButton;

    private Library library;
    private SaveButtonListener saveButtonListener;

    public BookEditorExample() {
        library = new Library();

        setTitle("Book Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();

        // Populate the genre combo box
        populateGenreComboBox();

        // Set the frame location to the center of the screen
        setLocationRelativeTo(null);

        // Save button event listener
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveChanges();
            }
        });

        // Cancel button event listener
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelChanges();
            }
        });

        // Set the frame visible
        setVisible(true);
    }
    public void setSaveButtonListener(SaveButtonListener listener) {
        this.saveButtonListener = listener;
    }
    private void saveChanges() {
        String authorName = authorNameField.getText();
        String bookName = bookNameField.getText();
        Genre genre = (Genre) genreComboBox.getSelectedItem();
        boolean isTaken = isTakenCheckBox.isSelected();

        // Create Author object
        Author author = new Author(authorName, ""); // Set the author name

        // Create Book object
        Book book = new Book(author, genre, null, bookName);
        book.setTaken(isTaken);

        // Notify the listener with the book object
        if (saveButtonListener != null) {
            saveButtonListener.onSaveClicked(book);
        }

        // Reset fields
        authorNameField.setText("");
        bookNameField.setText("");
        genreComboBox.setSelectedIndex(0);
        isTakenCheckBox.setSelected(false);
    }


    private void cancelChanges() {
        // Reset fields
        bookNameField.setText("");
        genreComboBox.setSelectedIndex(0);
        isTakenCheckBox.setSelected(false);
    }

    private void populateGenreComboBox() {
        // Get the combo box model
        DefaultComboBoxModel<Genre> comboBoxModel = (DefaultComboBoxModel<Genre>) genreComboBox.getModel();

        // Add genre values to the combo box model
        for (Genre genre : Genre.values()) {
            comboBoxModel.addElement(genre);
        }
    }

}
