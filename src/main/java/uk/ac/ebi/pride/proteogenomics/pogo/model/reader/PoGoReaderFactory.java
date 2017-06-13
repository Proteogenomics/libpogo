package uk.ac.ebi.pride.proteogenomics.pogo.model.reader;

/**
 * Project: libpogo
 * Package: uk.ac.ebi.pride.proteogenomics.pogo.model.reader
 * Timestamp: 2017-06-13 10:13
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */

public class PoGoReaderFactory {
    public static PoGoFileReader getTabularPoGoFileReader(String fileName) {
        return new PoGoFileReaderTabDelimiterImpl(fileName);
    }
}
