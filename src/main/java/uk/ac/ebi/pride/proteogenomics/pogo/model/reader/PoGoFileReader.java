package uk.ac.ebi.pride.proteogenomics.pogo.model.reader;

import uk.ac.ebi.pride.proteogenomics.pogo.model.PoGoEntry;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: libpogo
 * Package: uk.ac.ebi.pride.proteogenomics.pogo.model.reader
 * Timestamp: 2017-06-13 09:37
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */

public abstract class PoGoFileReader {

    protected abstract String getDelimiter();

    public List<PoGoEntry> readAllPoGoEntries(String fileName) {
        List<PoGoEntry> poGoEntries = new ArrayList<>();
        // TODO
        return poGoEntries;
    }
}
