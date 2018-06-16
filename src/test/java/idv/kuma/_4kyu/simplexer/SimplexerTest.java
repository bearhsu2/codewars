package idv.kuma._4kyu.simplexer;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.*;

public class SimplexerTest {

    private Simplexer lexer;

    @Test
    public void HasNext_Empty() {
        createLexer("");

        checkHasNext(false);
    }


    @Test
    public void Single_Identifier_x() {
        createLexer("x");

        checkHasNext(true);

        getNextTokenAndCheck("x", "identifier");

        checkHasNext(false);
    }


    @Test
    public void Single_Identifier_y() {
        createLexer("y");

        checkHasNext(true);
        getNextTokenAndCheck("y", "identifier");
        checkHasNext(false);
    }

    @Test
    public void Single_Identifier_xy() {
        createLexer("xy");

        checkHasNext(true);
        getNextTokenAndCheck("xy", "identifier");
        checkHasNext(false);
    }

    @Test
    public void Single_Boolean_True() {
        createLexer("true");

        checkHasNext(true);
        getNextTokenAndCheck("true", "boolean");
        checkHasNext(false);
    }

    @Test
    public void Single_Boolean_False() {
        createLexer("false");

        checkHasNext(true);
        getNextTokenAndCheck("false", "boolean");
        checkHasNext(false);
    }

    @Test
    public void Single_Integer() {
        createLexer("12345");

        checkHasNext(true);
        getNextTokenAndCheck("12345", "integer");
        checkHasNext(false);
    }

    @Test
    public void Single_String() {
        createLexer("\"Hello\"");

        checkHasNext(true);
        getNextTokenAndCheck("\"Hello\"", "string");
        checkHasNext(false);
    }

    @Test
    public void Single_Operator_plus() {
        createLexer("+");

        checkHasNext(true);
        getNextTokenAndCheck("+", "operator");
        checkHasNext(false);
    }

    @Test
    public void Single_Operator_Minus() {
        createLexer("-");

        checkHasNext(true);
        getNextTokenAndCheck("-", "operator");
        checkHasNext(false);
    }

    @Test
    public void Single_Operator_Star() {
        createLexer("*");

        checkHasNext(true);
        getNextTokenAndCheck("*", "operator");
        checkHasNext(false);
    }



    @Test
    public void Single_Keyword_if() {
        createLexer("if");

        checkHasNext(true);
        getNextTokenAndCheck("if", "keyword");
        checkHasNext(false);
    }


//    @Test
//    public void Single_Whitespace_One_Space() {
//        createLexer(" ");
//
//        checkHasNext(true);
//        getNextTokenAndCheck(" ", "whitespace");
//        checkHasNext(false);
//    }




    private void getNextTokenAndCheck(String expectedText, String expectedType) {
        Token actualToken = lexer.next();
        assertEquals(new Token(expectedText, expectedType), actualToken);
    }


    private void checkHasNext(boolean hasNext) {
        assertEquals(hasNext, lexer.hasNext());
    }


    private void createLexer(String buffer) {
        lexer = new Simplexer(buffer);
    }




////////////////////////////////
////////////////////////////////
////////////////////////////////
////////////////////////////////


    @Ignore
    @Test
    public void testSingle() {
        // Identifier
        Simplexer lexer = new Simplexer("x");
        assertEquals(true, lexer.hasNext());
        assertEquals(new Token("x", "identifier"), lexer.next());

        // Boolean
        lexer = new Simplexer("true");
        assertEquals(true, lexer.hasNext());
        assertEquals(new Token("true", "boolean"), lexer.next());

        // Integer
        lexer = new Simplexer("12345");
        assertEquals(true, lexer.hasNext());
        assertEquals(new Token("12345", "integer"), lexer.next());

        // String
        lexer = new Simplexer("\"Hello\"");
        assertEquals(true, lexer.hasNext());
        assertEquals(new Token("\"Hello\"", "string"), lexer.next());

        // Keyword
        lexer = new Simplexer("break");
        assertEquals(true, lexer.hasNext());
        assertEquals(new Token("break", "keyword"), lexer.next());
    }




    @Ignore
    @Test
    public void testExperession() {
        // Simple expression
        Simplexer lexer = new Simplexer("(1 + 2) - 5");
        assertEquals(Arrays.asList(new Token[]{
                new Token("(", "operator"),
                new Token("1", "integer"),
                new Token(" ", "whitespace"),
                new Token("+", "operator"),
                new Token(" ", "whitespace"),
                new Token("2", "integer"),
                new Token(")", "operator"),
                new Token(" ", "whitespace"),
                new Token("-", "operator"),
                new Token(" ", "whitespace"),
                new Token("5", "integer")
        }), toList(lexer));
    }

    @Ignore
    @Test
    public void testStatement() {
        // Simple statement.
        Simplexer lexer = new Simplexer("return x + 1");
        assertEquals(Arrays.asList(new Token[]{
                new Token("return", "keyword"),
                new Token(" ", "whitespace"),
                new Token("x", "identifier"),
                new Token(" ", "whitespace"),
                new Token("+", "operator"),
                new Token(" ", "whitespace"),
                new Token("1", "integer")
        }), toList(lexer));
    }

    private List<Token> toList(Simplexer lexer) {
        List<Token> tokens = new ArrayList<>();
        lexer.forEachRemaining(tokens::add);
        return tokens;
    }

}
