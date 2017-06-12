package uk.ac.ebi.pride.proteogenomics.pogo.model.export;

/**
 * Project: libpogo
 * Package: uk.ac.ebi.pride.proteogenomics.pogo.model.export
 * Timestamp: 2017-06-12 15:32
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */

public class PoGoEntrySerializerTabDelimiter extends PoGoEntrySerializer {
    @Override
    public String getDelimiter() {
        return "\t";
    }
}
