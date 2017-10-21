package com.github.ppartisan.fishportal.model.detailcomposite.detail;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.github.ppartisan.fishportal.model.detailcomposite.map.SearchDetailMapItem;
import com.google.gson.annotations.SerializedName;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "detail",
        foreignKeys = @ForeignKey(
                entity = SearchDetailMapItem.class,
                parentColumns = "map_speciesCode",
                childColumns = "speciesCode",
                onDelete = CASCADE
        ),
        indices = @Index(value = "speciesCode"))
public class DetailItem {

    @PrimaryKey @SerializedName("SpecCode") private final long speciesCode;
    @SerializedName("Genus") private final String genus;
    @SerializedName("Species") private final String species;
    @SerializedName("SpeciesRefNo") private final long speciesRefNumber;
    @SerializedName("FBName") private final String commonName;
    @SerializedName("FamCode") private final long familyCode;
    @SerializedName("SubFamily") private final String subFamily;
    @SerializedName("GenCode") private final long genCode;
    @SerializedName("BodyShapeI") private final String bodyShape;
    @SerializedName("Length") private final double length;
    @SerializedName("Dangerous") private final String dangerous;
    @SerializedName("Comments") private final String comments;

    public DetailItem(
            long speciesCode,
            String genus,
            String species,
            long speciesRefNumber,
            String commonName,
            long familyCode,
            String subFamily,
            long genCode,
            String bodyShape,
            double length,
            String dangerous,
            String comments
    ) {
        this.speciesCode = speciesCode;
        this.genus = genus;
        this.species = species;
        this.speciesRefNumber = speciesRefNumber;
        this.commonName = commonName;
        this.familyCode = familyCode;
        this.subFamily = subFamily;
        this.genCode = genCode;
        this.bodyShape = bodyShape;
        this.length = length;
        this.dangerous = dangerous;
        this.comments = comments;
    }

    public long getSpeciesCode() {
        return speciesCode;
    }

    public String getGenus() {
        return genus;
    }

    public String getSpecies() {
        return species;
    }

    public long getSpeciesRefNumber() {
        return speciesRefNumber;
    }

    public String getCommonName() {
        return commonName;
    }

    public long getFamilyCode() {
        return familyCode;
    }

    public String getSubFamily() {
        return subFamily;
    }

    public long getGenCode() {
        return genCode;
    }

    public String getBodyShape() {
        return bodyShape;
    }

    public double getLength() {
        return length;
    }

    public String getDangerous() {
        return dangerous;
    }

    public String getComments() {
        return comments;
    }

}
