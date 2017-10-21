package com.github.ppartisan.fishportal.model.detailcomposite;

import com.github.ppartisan.fishportal.model.detailcomposite.detail.web.SpeciesWebRepository;
import com.github.ppartisan.fishportal.model.detailcomposite.map.web.SearchDetailWebRepository;

import javax.inject.Inject;

public class DetailOperations {

    private final SearchDetailWebRepository map;
    private final SpeciesWebRepository detail;

    @Inject DetailOperations(
            SearchDetailWebRepository map,
            SpeciesWebRepository detail
    ) {
        this.map = map;
        this.detail = detail;
    }

    public void refresh(final long autoctr, final DetailListener listener) {
        map.refresh(autoctr, speciesCode -> detail.refresh(speciesCode, listener::onComplete));
    }
}
