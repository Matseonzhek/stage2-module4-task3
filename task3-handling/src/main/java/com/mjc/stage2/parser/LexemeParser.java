package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;

public class LexemeParser extends AbstractTextParser {
    private static final String LEXEME_REGEX = "\\s+";
    private static final String WORD_REGEX = "\\w[\\w!=?():]+";

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        AbstractTextComponent textComponent = null;
        if (abstractTextComponent.getComponentType().equals(TextComponentType.SYMBOL)) {
            String[] parts = string.split(LEXEME_REGEX);
            for (String part : parts) {
                textComponent = new SymbolLeaf(part.charAt(0));
                abstractTextComponent.add(textComponent);
            }
        } else {
            String[] parts = string.split(WORD_REGEX);
            for (String part : parts) {
                textComponent = new TextComponent(TextComponentType.WORD);
                nextParser.parse(textComponent,part);
            }

        }
        abstractTextComponent.add(textComponent);

    }

    // Write your code here!

}
