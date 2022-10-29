package org.densmnko.nopds.model.atom;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.immutables.value.Value;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Value.Immutable
@JsonSerialize(as = ImmutableFeed.class)
@JsonDeserialize(as = ImmutableFeed.class)
// xmlns:dc="http://purl.org/dc/terms/"
// xmlns:opds="http://opds-spec.org/2010/catalog"
@JacksonXmlRootElement(localName = "feed",namespace = "http://www.w3.org/2005/Atom")
public interface Feed extends Serializable {

    @JacksonXmlProperty(namespace = "http://www.w3.org/2005/Atom")
    UUID id();

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(namespace = "http://www.w3.org/2005/Atom")
    List<Link> links();

    @JacksonXmlProperty(namespace = "http://www.w3.org/2005/Atom")
    String title();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    @JacksonXmlProperty(namespace = "http://www.w3.org/2005/Atom")
    LocalDateTime updated();

    @JacksonXmlProperty(namespace = "http://www.w3.org/2005/Atom")
    Author author();

    @JacksonXmlProperty(namespace = "http://www.w3.org/2005/Atom")
    @JacksonXmlElementWrapper(useWrapping = false)
    List<Entry> entries();
}
