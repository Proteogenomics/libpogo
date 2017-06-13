package uk.ac.ebi.pride.proteogenomics.pogo.model;

import java.util.List;

/**
 * Project: libpogo
 * Package: uk.ac.ebi.pride.proteogenomics.pogo.model
 * Timestamp: 2017-06-13 09:37
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */

public interface PoGoImporter {
    List<PoGoEntry> readPoGoFile(String fileName);
}
