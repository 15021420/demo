package com.lvt.demo.service;

import com.lvt.demo.dto.SampleObjectResponseDTO;
import com.lvt.demo.exception.CustomApplicationException;
import com.lvt.demo.exception.ErrorCode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SampleService {
    public List<SampleObjectResponseDTO> getListSampleDataSuccess() {
        List<SampleObjectResponseDTO> sampleDto = new ArrayList<>();
        sampleDto.add(new SampleObjectResponseDTO("1", "ok", "Cuong"));
        sampleDto.add(new SampleObjectResponseDTO("2", "ooooo", "Thang"));
        sampleDto.add(new SampleObjectResponseDTO("3", "ooođaoo", "Thanaddg"));
        return sampleDto;
    }

    public List<SampleObjectResponseDTO> getListSampleDataFail() throws CustomApplicationException {
        throw new CustomApplicationException(ErrorCode.CAN_NOT_GET_DATA_SAMPLE);
    }
}
