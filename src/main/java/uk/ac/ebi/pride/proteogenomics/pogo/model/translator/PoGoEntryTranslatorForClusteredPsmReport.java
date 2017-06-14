package uk.ac.ebi.pride.proteogenomics.pogo.model.translator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ebi.pride.archive.dataprovider.identification.ModificationProvider;
import uk.ac.ebi.pride.jmztab.model.Modification;
import uk.ac.ebi.pride.proteogenomics.pogo.model.PoGoEntry;
import uk.ac.ebi.pride.spectracluster.repo.model.ClusteredPSMReport;
import uk.ac.ebi.pride.utilities.pridemod.ModReader;
import uk.ac.ebi.pride.utilities.pridemod.controller.impl.PRIDEModDataAccessController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private String translateSequence() {
        StringBuilder translatedSequence = new StringBuilder("---NO_TRANSLATION---");
        Map<Integer, List<String>> modificationsMap = new HashMap<>();
        // Translate the modifications into their short names and sort them by position
        if (clusteredPSMReport.getModifications() != null) {
            for (ModificationProvider modification
                    : clusteredPSMReport.getModifications()
                 ) {
                String modificationShortName = ModReader.getInstance().getShortNamePRIDEModByChildAccession(modification.getAccession());
                if (modificationsMap.get(modification.getMainPosition()) == null) {
                    modificationsMap.put(modification.getMainPosition(), new ArrayList<>());
                }
                modificationsMap.get(modification.getMainPosition()).add(modificationShortName);
            }
        }
        // Embed modifications by position in the sequence
        if (clusteredPSMReport.getSequence().length() > 0) {
            translatedSequence = new StringBuilder();
        }
        if ((clusteredPSMReport.getSequence() != null) &&
                clusteredPSMReport.getSequence().length() > 0) {
            int position = 1;
            for (char character : clusteredPSMReport.getSequence().toCharArray()) {
                translatedSequence.append(character);
                if (modificationsMap.get(position) != null) {
                    translatedSequence.append(String.format("(%s)", String.join(",", modificationsMap.get(position))));
                }
                position++;
            }
        }
        return translatedSequence.toString();
    }

    public PoGoEntryTranslatorForClusteredPsmReport(ClusteredPSMReport clusteredPSMReport) {
        this.clusteredPSMReport = clusteredPSMReport;
    }

    @Override
    public PoGoEntry visit(PoGoEntry poGoEntry) {
        poGoEntry.setExperiment(clusteredPSMReport.getClusterId().toString());
        poGoEntry.setPeptide(translateSequence());
        poGoEntry.setPsm(clusteredPSMReport.getClusterNumberPSMs());
        // TODO - This parameter will be let as zero right now, in the future we need to work out a way to leave as it is right now, or compute its value
        poGoEntry.setQuant(0d);
        return poGoEntry;
    }
}
