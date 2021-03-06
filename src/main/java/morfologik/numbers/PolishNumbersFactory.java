package morfologik.numbers;

import java.util.Map;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.TokenFilterFactory;


public class PolishNumbersFactory extends TokenFilterFactory {
    public PolishNumbersFactory(Map<String, String> args) {
        super(args);
    }

    @Override
    public TokenStream create(TokenStream input) {
        return new PolishNumbers(input);
    }
}
