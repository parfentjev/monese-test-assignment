package org.monese.uitest.core;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ElementList {
    private final List<Element> elements;

    public ElementList(List<Element> elements) {
        this.elements = elements;
    }

    public Element singleElementBy(Predicate<Element> predicate) {
        List<Element> items = elements.stream().filter(predicate).collect(Collectors.toList());

        assertThat(items)
                .overridingErrorMessage("Expected 1 element, but found %d.", items.size())
                .hasSize(1);

        return items.get(0);
    }
}
