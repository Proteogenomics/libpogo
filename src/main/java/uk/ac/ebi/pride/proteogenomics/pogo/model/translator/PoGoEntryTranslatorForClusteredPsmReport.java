package uk.ac.ebi.pride.proteogenomics.pogo.model.translator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ebi.pride.proteogenomics.pogo.model.PoGoEntry;
import uk.ac.ebi.pride.spectracluster.repo.model.ClusteredPSMReport;

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

    private ClusteredPSMReport clusteredPSMReport = null;

    public PoGoEntryTranslatorForClusteredPsmReport(ClusteredPSMReport clusteredPSMReport) {
        this.clusteredPSMReport = clusteredPSMReport;
    }

    @Override
    public PoGoEntry visit(PoGoEntry poGoEntry) {
        // TODO
        poGoEntry.setExperiment(clusteredPSMReport.getClusterId().toString());
        // TODO - Translate peptide sequence with modifications embedded
        poGoEntry.setPsm(clusteredPSMReport.getClusterNumberPSMs());
        // TODO - This parameter will be let as zero right now, in the future we need to work out a way to leave as it is right now, or compute its value
        poGoEntry.setQuant(0d);
        return poGoEntry;
    }
}
