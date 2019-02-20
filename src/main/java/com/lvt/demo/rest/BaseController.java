package com.lvt.demo.rest;

import com.lvt.demo.bean.ResponseBasicObj;
import com.lvt.demo.dto.SampleObjectResponseDTO;
import com.lvt.demo.exception.ErrorCode;
import com.lvt.demo.model.Employee;
import com.lvt.demo.service.EmployeeService;
import com.lvt.demo.vm.UserVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/")
@RestController
public class BaseController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String defaultPage() throws Exception{
        return "{\n" +
                "  \"active_date\": \"string\",\n" +
                "  \"currency\": \"string\",\n" +
                "  \"description\": \"string\",\n" +
                "  \"in_charge_type\": \"string\",\n" +
                "  \"limit_config_wallet_level_id\": \"string\",\n" +
                "  \"max_amount\": \"string\",\n" +
                "  \"max_amount_day\": \"string\",\n" +
                "  \"max_amount_lifetime\": \"string\",\n" +
                "  \"max_amount_month\": \"string\",\n" +
                "  \"max_amount_weekly\": \"string\",\n" +
                "  \"max_amount_year\": \"string\",\n" +
                "  \"max_total_trans_day\": \"string\",\n" +
                "  \"max_total_trans_lifetime\": \"string\",\n" +
                "  \"max_total_trans_month\": \"string\",\n" +
                "  \"max_total_trans_weekly\": \"string\",\n" +
                "  \"max_total_trans_year\": \"string\",\n" +
                "  \"min_amount\": \"string\",\n" +
                "  \"operator_id_super\": \"string\",\n" +
                "  \"risk_level\": \"string\",\n" +
                "  \"status\": \"string\",\n" +
                "  \"transaction_type_id\": \"string\",\n" +
                "  \"wallet_level_id\": \"string\"\n" +
                "}";
    }

    @PostMapping
    public List<SampleObjectResponseDTO> userPage(@RequestBody  UserVM userVM) {
        List<SampleObjectResponseDTO> sampleDto = new ArrayList<>();
        sampleDto.add(new SampleObjectResponseDTO("1", "ok", "Cuong"));
        sampleDto.add(new SampleObjectResponseDTO("2", "ooooo", "Thang"));
        return sampleDto;
    }
}
