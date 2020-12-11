package com.mihey.hibernateconsole.controller;

import java.util.List;
import com.mihey.hibernateconsole.model.Region;
import com.mihey.hibernateconsole.repository.RegionRepository;
import com.mihey.hibernateconsole.repository.hibernate.RegionRepositoryImpl;

public class RegionController {

    private RegionRepository regionRepository = new RegionRepositoryImpl();

    public Region saveRegion(Region region) {
        return regionRepository.save(region);
    }

    public Region getRegionById(int id) {
        return regionRepository.getById(id);
    }

    public Region editRegion(Region region) {
        return regionRepository.update(region);
    }

    public void deleteRegionById(int id) {
        regionRepository.deleteById(id);
    }

    public List<Region> getAllRegions() {
        return regionRepository.getAll();
    }
}
