package com.cg.locationRegion;

import com.cg.model.LocationRegion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
@RequiredArgsConstructor
public class LocationRegionServiceImpl implements ILocationRegionService{


    private final LocationRegionRepository locationRegionRepository;


    @Override
    public List<LocationRegion> findAll() {
        return locationRegionRepository.findAll();
    }

    @Override
    public Optional<LocationRegion> findById(Long id) {
        return locationRegionRepository.findById(id);
    }

    @Override
    public LocationRegion save(LocationRegion locationRegion) {
        return locationRegionRepository.save(locationRegion);
    }

    @Override
    public void delete(LocationRegion locationRegion) {

    }


}
