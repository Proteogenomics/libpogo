package uk.ac.ebi.pride.proteogenomics.pogo.model.export;

import uk.ac.ebi.pride.proteogenomics.pogo.model.PoGoEntry;

import java.util.List;

/**
 * Project: libpogo
 * Package: uk.ac.ebi.pride.proteogenomics.pogo.model.export
 * Timestamp: 2017-06-12 14:58
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */

public interface PoGoExporter {
    void export(List<PoGoEntry> poGoEntries);
}
