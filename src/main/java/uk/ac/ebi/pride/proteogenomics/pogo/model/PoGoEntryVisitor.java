package uk.ac.ebi.pride.proteogenomics.pogo.model;

import uk.ac.ebi.pride.proteogenomics.pogo.model.PoGoEntry;

/**
 * Project: libpogo
 * Package: uk.ac.ebi.pride.proteogenomics.pogo.model.translator
 * Timestamp: 2017-06-13 14:55
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 *
 * Interface for factoring visitors that implement the strategy to fill in and / or modifying a PoGoEntry
 */

public interface PoGoEntryVisitor {
    PoGoEntry visit(PoGoEntry poGoEntry);
}
