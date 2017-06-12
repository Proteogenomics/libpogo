package uk.ac.ebi.pride.proteogenomics.pogo.model.export.file;

import java.util.List;

/**
 * Project: libpogo
 * Package: uk.ac.ebi.pride.proteogenomics.pogo.model.export.file
 * Timestamp: 2017-06-12 15:58
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */

public abstract class PoGoHeaderSerializer {
    protected abstract String getDelimiter();

    public String serializeHeader(List<String> headers) {
        return String.join(getDelimiter(), headers);
    }
}
