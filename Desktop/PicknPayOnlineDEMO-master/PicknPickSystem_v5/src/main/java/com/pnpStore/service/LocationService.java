package com.pnpStore.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.pnpStore.model.Location;
import com.pnpStore.repository.LocationRepository;

import org.springframework.stereotype.Service;

@Service
public class LocationService {
    
    @Autowired
    public LocationRepository locationRepository;
    
    
    public void SaveLocation(Location location)
    {
        locationRepository.save(location);
    }
    
}
