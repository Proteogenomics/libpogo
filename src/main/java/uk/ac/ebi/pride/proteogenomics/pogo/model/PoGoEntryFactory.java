package uk.ac.ebi.pride.proteogenomics.pogo.model;

import uk.ac.ebi.pride.proteogenomics.pogo.model.export.PoGoExporter;

/**
 * Project: libpogo
 * Package: uk.ac.ebi.pride.proteogenomics.pogo.model
 * Timestamp: 2017-06-13 14:46
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */

public class PoGoEntryFactory {
    public static PoGoEntry createPoGoEntry(String experiment, String peptide, Integer psm, Double quant) {
        return new PoGoEntry(experiment, peptide, psm, quant);
    }
}
