package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;

import java.util.ArrayList;
import java.util.List;

public class ChainParserBuilder {
    private List<AbstractTextParser> parsers = new ArrayList<>();

    public ChainParserBuilder() {
    }

    public ChainParserBuilder setParser(AbstractTextParser abstractTextParser) {
        parsers.add(abstractTextParser);
        // Write your code here!
        return this;
    }

    public AbstractTextParser build() {
        // Write your code here!
        AbstractTextParser prev = parsers.get(0);

        for (int i = 1; i < parsers.size(); i++) {
            prev.setNextParser(parsers.get(i));
            prev = parsers.get(i);
        }

        return parsers.get(0);

    }
}
