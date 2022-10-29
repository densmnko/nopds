package org.densmnko.nopds.model.atom;

import org.immutables.value.Value;

@Value.Immutable
public interface Link {
    String rel();
    String href();
    String type();
}
