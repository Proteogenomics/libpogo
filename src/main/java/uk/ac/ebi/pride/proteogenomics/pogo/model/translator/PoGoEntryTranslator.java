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
    public void setExperiment(String experiment);
    public void setPeptide(String peptide);
    public void setPsm(Integer psm);
    public void setQuant(Double quant);
}
