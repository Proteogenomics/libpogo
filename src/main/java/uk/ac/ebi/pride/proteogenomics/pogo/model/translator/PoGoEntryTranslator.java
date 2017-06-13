package uk.ac.ebi.pride.proteogenomics.pogo.model.translator;

/**
 * Project: libpogo
 * Package: uk.ac.ebi.pride.proteogenomics.pogo.model.translator
 * Timestamp: 2017-06-13 14:55
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */

public interface PoGoEntryTranslator {
    String getExperiment(String experiment);
    String getPeptide(String peptide);
    Integer getPsm(Integer psm);
    Double getQuant(Double quant);
}
