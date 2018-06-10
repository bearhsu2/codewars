package idv.kuma._4kyu.simplexer;

public class Token {
    String text;
    String type;

    public Token(String text, String type) {
        this.text = text;
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object another){
        if (!(another instanceof Token)){
            return false;
        }

        Token anotherToken = (Token) another;

        return (text.equals(anotherToken.getText()) && text.equals(anotherToken.getText()));

    }
}
