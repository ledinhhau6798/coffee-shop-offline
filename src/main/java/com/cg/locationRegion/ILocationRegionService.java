package com.cg.locationRegion;

import com.cg.model.LocationRegion;
import com.cg.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface ILocationRegionService{
    List<LocationRegion> findAll();

    Optional<LocationRegion> findById(Long id);

    LocationRegion save(LocationRegion t);

    void delete(LocationRegion t);

}
