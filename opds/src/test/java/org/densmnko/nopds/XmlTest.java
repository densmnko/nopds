package org.densmnko.nopds;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.densmnko.nopds.model.atom.Feed;
import org.densmnko.nopds.model.atom.ImmutableAuthor;
import org.densmnko.nopds.model.atom.ImmutableFeed;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class XmlTest {

    @Test
    public void feed() throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        mapper.findAndRegisterModules();



        Feed feed = ImmutableFeed.builder()
                .author(ImmutableAuthor.builder().name("me").uri("none").build())
                .title("test feed")
                .id(UUID.randomUUID())
                .updated(LocalDateTime.now())
                .build();

        String xml = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(feed);
        System.out.println(xml);
        assertNotNull(xml);
    }
}
