package org.densmnko.nopds.model.atom;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableAuthor.class)
@JsonDeserialize(as = ImmutableAuthor.class)
public interface Author {

    @JacksonXmlProperty(namespace = "http://www.w3.org/2005/Atom")
    String name();

    @JacksonXmlProperty(namespace = "http://www.w3.org/2005/Atom")
    String uri();
}
