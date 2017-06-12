package uk.ac.ebi.pride.proteogenomics.pogo.model.export.file;

/**
 * Project: libpogo
 * Package: uk.ac.ebi.pride.proteogenomics.pogo.model.export.file
 * Timestamp: 2017-06-12 16:02
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */

public class PoGoHeaderSerializerTabDelimiter extends PoGoHeaderSerializer {
    @Override
    public String getDelimiter() {
        return "\t";
    }
}
