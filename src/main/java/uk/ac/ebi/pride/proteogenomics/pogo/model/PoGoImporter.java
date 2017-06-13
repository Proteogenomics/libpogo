package uk.ac.ebi.pride.proteogenomics.pogo.model;

import java.util.List;

/**
 * Project: libpogo
 * Package: uk.ac.ebi.pride.proteogenomics.pogo.model
 * Timestamp: 2017-06-13 09:37
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 *
 * This has not been written as a Reader, as it doesn't really support a "reader" interface, it will just read the full
 * PoGo input file and produce a list of PoGo entries
 */

public interface PoGoImporter {
    List<PoGoEntry> readPoGoFile(String fileName);
}
