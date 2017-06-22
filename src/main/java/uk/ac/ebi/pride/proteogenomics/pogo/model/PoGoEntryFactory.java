package uk.ac.ebi.pride.proteogenomics.pogo.model;


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

    /**
     * This method allows external strategies/algorithms for creating PoGo entries to be encapsulated and shared among
     * multiple libraries
     *
     * @param poGoEntryVisitor the visitor that implements the creation strategy for a PoGo bean
     * @return the created PoGoEntry
     */
    public static PoGoEntry createPoGoEntryWithStrategy(PoGoEntryVisitor poGoEntryVisitor) {
        return (poGoEntryVisitor.visit(new PoGoEntry()));
    }
}
