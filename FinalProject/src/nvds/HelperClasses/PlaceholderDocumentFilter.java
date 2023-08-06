package nvds.HelperClasses;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class PlaceholderDocumentFilter extends DocumentFilter {
    private final String placeholder;

    public PlaceholderDocumentFilter(String placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        if (fb.getDocument().getLength() == placeholder.length()) {
            return; // Prevent deletion of placeholder
        }
        super.remove(fb, offset, length);
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (fb.getDocument().getLength() == placeholder.length()) {
            return; // Prevent insertion over placeholder
        }
        super.insertString(fb, offset, string, attr);
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (fb.getDocument().getLength() == placeholder.length()) {
            fb.remove(0, placeholder.length()); // Remove placeholder before replacement
        }
        super.replace(fb, offset, length, text, attrs);
    }
}