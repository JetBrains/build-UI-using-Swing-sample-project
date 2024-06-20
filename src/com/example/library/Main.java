package com.example.library;

import com.example.library.forms.BookEditorExample;
import com.example.library.forms.SaveButtonListener;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Launch the book editor form
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BookEditorExample bookEditorExample = new BookEditorExample();
                bookEditorExample.setVisible(true);

                bookEditorExample.setSaveButtonListener(new SaveButtonListener() {
                    @Override
                    public void onSaveClicked(Book book) {
                        System.out.println("Entered Book Details:");
                        System.out.println("Book Title: " + book.getName());
                        System.out.println("Author: " + book.getAuthor().getName());
                        System.out.println("Genre: " + book.getGenre());
                        System.out.println("Is Unavailable: " + book.isTaken());
                    }
                });
            }
        });
    }
}
