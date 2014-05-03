package morfologik.numbers;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;

public final class PolishNumbers extends TokenFilter {
    private CharTermAttribute charTermAttr;

    public PolishNumbers(TokenStream input) {
        super(input);
        this.charTermAttr = addAttribute(CharTermAttribute.class);
    }

    @Override
    public boolean incrementToken() throws IOException {
        if (!input.incrementToken()) {
            return false;
        }

        try {
            long liczba = Long.parseLong(new String(charTermAttr.buffer()));
            String slownie = LiczbaSlownie.liczba_slownie(liczba);
            charTermAttr.setEmpty();
            charTermAttr.copyBuffer(slownie.toCharArray(), 0, slownie.length());

        } catch (NumberFormatException e){

        }

        return true;
    }
}
