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
    public String getExperiment(String experiment);
    public String getPeptide(String peptide);
    public Integer getPsm(Integer psm);
    public Double getQuant(Double quant);
}
