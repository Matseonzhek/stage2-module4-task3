package com.mjc.stage2.parser;


import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponentType;

public class WordParser extends AbstractTextParser {
    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        if (abstractTextComponent.getComponentType().equals(TextComponentType.WORD)) {
            for (char c : string.toCharArray()) {
                abstractTextComponent.add(
                        new SymbolLeaf(c)
                );
            }
        }
    }


}
