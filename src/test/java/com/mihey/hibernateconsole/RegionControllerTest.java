package com.mihey.hibernateconsole;

import com.mihey.hibernateconsole.controller.RegionController;
import com.mihey.hibernateconsole.model.Region;
import com.mihey.hibernateconsole.repository.RegionRepository;
import com.mihey.hibernateconsole.repository.hibernate.RegionRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class RegionControllerTest {

    @Mock
    RegionRepository regionRepository;

    @InjectMocks
    RegionController regionController = new RegionController();

    @Test
    public void regionControllerTest(){
        Region region = new Region();
        region.setId(1);
        region.setName("RUS");
        Mockito.when(regionRepository.getById(anyInt())).thenReturn(region);
        Assert.assertEquals("RUS",regionController.getRegionById(1).getName());
    }
}
