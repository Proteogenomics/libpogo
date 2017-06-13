package uk.ac.ebi.pride.proteogenomics.pogo.model.reader;

/**
 * Project: libpogo
 * Package: uk.ac.ebi.pride.proteogenomics.pogo.model.reader
 * Timestamp: 2017-06-13 10:12
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */

public class PoGoFileReaderTabDelimiterImpl extends PoGoFileReader {
    public PoGoFileReaderTabDelimiterImpl(String fileName) {
        super(fileName);
    }

    @Override
    protected String getDelimiter() {
        return "\t";
    }
}
