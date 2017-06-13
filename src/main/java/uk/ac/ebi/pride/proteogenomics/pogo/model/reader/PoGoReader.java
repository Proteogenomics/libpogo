package uk.ac.ebi.pride.proteogenomics.pogo.model.reader;

import uk.ac.ebi.pride.proteogenomics.pogo.model.PoGoEntry;

import java.io.Reader;
import java.util.List;

/**
 * Project: libpogo
 * Package: uk.ac.ebi.pride.proteogenomics.pogo.model.reader
 * Timestamp: 2017-06-13 09:37
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */

public interface PoGoReader {
    List<PoGoEntry> readPoGoFile(String fileName);
}
