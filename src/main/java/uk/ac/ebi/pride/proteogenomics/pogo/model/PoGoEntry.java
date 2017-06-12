package uk.ac.ebi.pride.proteogenomics.pogo.model;

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

    public PoGoEntry(String experiment, String peptide, Integer psm, Double quant) {
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
}
