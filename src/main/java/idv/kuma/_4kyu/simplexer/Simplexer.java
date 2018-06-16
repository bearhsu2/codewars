package idv.kuma._4kyu.simplexer;


import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
integer : Any sequence of one or more digits.

boolean : true or false.

string : Any sequence of characters surrounded by "double quotes".

operator : The characters +, -, *, /, %, (, ), and =.

keyword : The following are keywords: if, else, for, while, return, func, and break.

whitespace : Matches standard whitespace characters (space, newline, tab, etc.)
Consecutive whitespace characters should be matched together.

identifier : Any sequence of alphanumber characters, as well as underscore and dollar sign,
and which doesn't start with a digit. Make sure that keywords aren't matched as identifiers!

* */
public class Simplexer implements Iterator<Token> {

    public static final String REGEX_BOOLEAN = "^(true|false)";
    public static final String REGEX_INTEGER = "^\\d+";
    public static final String REGEX_STRING = "^\".*\"";
    public static final String REGEX_OPERATOR = "^[\\+-/%\\(\\)=\\*]";
    public static final String REGEX_KEYWORD = "^(if|else|for|while|return|func|break)";
    public static final String REGEX_WHITESPACE = "^([\\s]+)";


    String buffer;
    int nextIndex;

    public Simplexer(String buffer) {
        this.buffer = buffer;
        this.nextIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return nextIndex < buffer.length();
    }

    @Override
    public Token next() {

        System.out.println("=======================");



        Token token = null;

        if (token == null) {
            token = tryMatchPattern(REGEX_BOOLEAN, "boolean");
        }

        if (token == null){
            token = tryMatchPattern(REGEX_INTEGER, "integer");
        }

        if (token == null){
            token = tryMatchPattern(REGEX_STRING, "string");
        }

        if (token == null){
            token = tryMatchPattern(REGEX_OPERATOR, "operator");
        }

        if (token == null){
            token = tryMatchPattern(REGEX_KEYWORD, "keyword");
        }

        if (token == null){
            token = tryMatchPattern(REGEX_WHITESPACE, "whitespace");
        }


        if (token == null){
            token = new Token(buffer, "identifier");
            nextIndex += buffer.length();
            System.out.println("token: " + token);
        }

        return token;
    }

    private Token tryMatchPattern(String regex, String tokenType) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(buffer);
        Token token = null;

        if (m.find()) {
            System.out.println("start(): " + m.start());
            System.out.println("end(): " + m.end());


            String tokenText = buffer.substring(m.start(), m.end());
            token = new Token(tokenText, tokenType);
            nextIndex += tokenText.length();
        }

        System.out.println("token: " + token);

        return token;
    }

}