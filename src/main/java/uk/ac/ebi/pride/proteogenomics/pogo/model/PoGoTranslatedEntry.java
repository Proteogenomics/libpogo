package uk.ac.ebi.pride.proteogenomics.pogo.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ebi.pride.proteogenomics.pogo.model.translator.PoGoEntryTranslator;

/**
 * Project: libpogo
 * Package: uk.ac.ebi.pride.proteogenomics.pogo.model
 * Timestamp: 2017-06-13 14:58
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */

public class PoGoTranslatedEntry extends PoGoEntry {
    private static final Logger logger = LoggerFactory.getLogger(PoGoTranslatedEntry.class);

    private PoGoEntryTranslator poGoEntryTranslator = null;

    protected PoGoTranslatedEntry(PoGoEntryTranslator poGoEntryTranslator) {
        super();
        this.poGoEntryTranslator = poGoEntryTranslator;
    }

    @Override
    public void setExperiment(String experiment) {
        experiment = poGoEntryTranslator.getExperiment(experiment);
    }

    @Override
    public void setPeptide(String peptide) {
        // TODO
    }

    @Override
    public void setPsm(Integer psm) {
        // TODO
    }

    @Override
    public void setQuant(Double quant) {
        // TODO
    }
}
