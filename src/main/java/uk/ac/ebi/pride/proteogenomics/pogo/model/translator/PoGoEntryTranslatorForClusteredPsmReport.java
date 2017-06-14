package uk.ac.ebi.pride.proteogenomics.pogo.model.translator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Project: libpogo
 * Package: uk.ac.ebi.pride.proteogenomics.pogo.model.translator
 * Timestamp: 2017-06-14 10:30
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */

public class PoGoEntryTranslatorForClusteredPsmReport implements PoGoEntryTranslator {
    private static final Logger logger = LoggerFactory.getLogger(PoGoEntryTranslatorForClusteredPsmReport.class);

    @Override
    public String getExperiment(String experiment) {
        return null;
    }

    @Override
    public String getPeptide(String peptide) {
        return null;
    }

    @Override
    public Integer getPsm(Integer psm) {
        return null;
    }

    @Override
    public Double getQuant(Double quant) {
        return null;
    }
}
