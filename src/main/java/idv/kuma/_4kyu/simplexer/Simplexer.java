package idv.kuma._4kyu.simplexer;


import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.Iterator;

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

    char[] charArray;
    int index;

    public Simplexer(String buffer) {
        this.charArray = buffer.toCharArray();
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < charArray.length;
    }

    @Override
    public Token next() {
        Token token = new Token("x", "identifier");
        index += 1;

        return token;
    }

}