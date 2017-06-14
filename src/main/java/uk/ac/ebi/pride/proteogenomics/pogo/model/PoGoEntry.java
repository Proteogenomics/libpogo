package uk.ac.ebi.pride.proteogenomics.pogo.model;

import uk.ac.ebi.pride.proteogenomics.pogo.model.translator.PoGoEntryTranslator;

/**
 * Project: libpogo
 * Package: uk.ac.ebi.pride.proteogenomics.pogo.model
 * Timestamp: 2017-06-12 14:40
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 *
 * This class models a PoGo input entry for PoGo software (https://github.com/cschlaffner/PoGo)
 */

public class PoGoEntry {
    private String experiment = "";
    private String peptide = "";
    private Integer psm = 0;
    private Double quant = 0d;

    protected PoGoEntry() {
    }

    protected PoGoEntry(String experiment, String peptide, Integer psm, Double quant) {
        this.experiment = experiment;
        this.peptide = peptide;
        this.psm = psm;
        this.quant = quant;
    }

    public String getExperiment() {
        return experiment;
    }

    public String getPeptide() {
        return peptide;
    }

    public Integer getPsm() {
        return psm;
    }

    public Double getQuant() {
        return quant;
    }

    public void setExperiment(String experiment) {
        this.experiment = experiment;
    }

    public void setPeptide(String peptide) {
        this.peptide = peptide;
    }

    public void setPsm(Integer psm) {
        this.psm = psm;
    }

    public void setQuant(Double quant) {
        this.quant = quant;
    }

    // Visitor
    public void accept(PoGoEntryTranslator poGoEntryTranslator) {
        poGoEntryTranslator.visit(this);
    }
}
