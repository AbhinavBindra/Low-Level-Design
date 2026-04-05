// Steps
// Step 1: Component Interface
interface TextView {
    void render();

}

// Step 2: Concrete Component
class PlainTextView implements TextView {
    private final String text;

    public PlainTextView(String text) {
        this.text = text;
    }

    @Override
    public void render() {
        System.out.println(text);
    }
}

// Step 3: Abstract Decorator
abstract class TextDecorator implements TextView {
    protected final TextView inner;

    public TextDecorator(TextView inner) {
        this.inner = inner;
    }
}

// Step 4: Concrete Decorators
// Bold Decorator
class BoldDecorator extends TextDecorator {
    public BoldDecorator(TextView inner) {
        super(inner);
    }

    @Override
    public void render() {
        System.out.print("<b>");
        inner.render();
        System.out.print("</b>");
    }
}

class ItalicDecorator extends TextDecorator {
    public ItalicDecorator(TextView inner) {
        super(inner);
    }

    @Override
    public void render() {
        System.out.print("<i>");
        inner.render();
        System.out.print("</i>");
    }
}

class UnderlineDecorator extends TextDecorator {
    public UnderlineDecorator(TextView inner) {
        super(inner);
    }

    @Override
    public void render() {
        System.out.print("<u>");
        inner.render();
        System.out.print("</u>");
    }
}

// Client Code
public class TextRendererApp {
    public static void main(String[] args) {
        TextView text = new PlainTextView("Hello, World!");

        // Plain text
        System.out.print("Plain:                   ");
        text.render();
        System.out.println();

        // Single decorator: Bold
        System.out.print("Bold:                    ");
        TextView boldText = new BoldDecorator(text);
        boldText.render();
        System.out.println();

        // Two decorators: Italic + Underline
        System.out.print("Italic + Underline:      ");
        TextView italicUnderline = new UnderlineDecorator(new ItalicDecorator(text));
        italicUnderline.render();
        System.out.println();

        // Three decorators: Bold + Italic + Underline
        System.out.print("Bold + Italic + Underline: ");
        TextView allStyles = new UnderlineDecorator(
                new ItalicDecorator(new BoldDecorator(text)));
        allStyles.render();
        System.out.println();
    }
}