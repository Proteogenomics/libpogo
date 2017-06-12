package uk.ac.ebi.pride.proteogenomics.pogo.model.export;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ebi.pride.proteogenomics.pogo.model.PoGoEntry;

/**
 * Project: libpogo
 * Package: uk.ac.ebi.pride.proteogenomics.pogo.model.export
 * Timestamp: 2017-06-12 15:26
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */

public abstract class PoGoEntrySerializer {
    private static final Logger logger = LoggerFactory.getLogger(PoGoEntrySerializer.class);

    public abstract String getDelimiter();

    public String serializeEntry(PoGoEntry poGoEntry) {
        return String.format("%s%s%s%s%d%s%f",
                poGoEntry.getExperiment(),
                getDelimiter(),
                poGoEntry.getPeptide(),
                getDelimiter(),
                poGoEntry.getPsm(),
                getDelimiter(),
                poGoEntry.getQuant());
    }
}
