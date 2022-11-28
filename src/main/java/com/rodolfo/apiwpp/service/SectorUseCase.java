package com.rodolfo.apiwpp.service;

import com.rodolfo.apiwpp.http.SectorHttp;
import com.rodolfo.apiwpp.http.dto.response.SetorInfoResponseDTO;

import java.util.List;

public class SectorUseCase {

    private final SectorHttp sectorHttp;

    public SectorUseCase() {
        sectorHttp = new SectorHttp();
    }

    public List<SetorInfoResponseDTO> retrieveSectors() {
        return sectorHttp.getSectors();
    }
}
