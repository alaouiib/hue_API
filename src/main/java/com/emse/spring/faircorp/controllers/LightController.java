package com.emse.spring.faircorp.controllers;

import com.emse.spring.faircorp.dao.LightDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dto.LightDto;
import com.emse.spring.faircorp.model.Light;
import com.emse.spring.faircorp.model.Status;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.cbor.CBORFactory;
import javassist.bytecode.ByteArray;
import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
//import com.fasterxml.jackson.dataformat.cbor.*;
import com.fasterxml.jackson.dataformat.cbor.CBORParser;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController  // 1.
@RequestMapping(value = "/api/lights", consumes = "application/json;") // 2. ,
@Transactional // 3.
public class LightController {

    @Autowired
    private LightDao lightDao; // 4.
    @Autowired
    private RoomDao roomDao;


    @GetMapping // 5.
    public List<LightDto> findAll() {
        return lightDao.findAll()
                .stream()
                .map(LightDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public LightDto findById(@PathVariable Long id) {
        return lightDao.findById(id).map(light -> new LightDto(light)).orElse(null);
    }

    @PutMapping(path = "/{id}/switch")
    public LightDto switchStatus(@PathVariable Long id, @RequestBody String payload) throws IOException {
        Light light = lightDao.findById(id).orElseThrow(IllegalArgumentException::new);

//        // binary data received
//        String string = new String(payload.getBytes());
//        System.out.println(string);
         System.out.println(payload); // not gonna work because of the wrong parsing of the binary data received ! ( we have to take the bytes from this var )
//
//        // encode in binary and send !
        CBORFactory f = new CBORFactory();
        ObjectMapper mapper = new ObjectMapper(f);
//        byte[] cborData = mapper.writeValueAsBytes(payload);
//        System.out.println(cborData);
        String value = mapper.readValue(payload.getBytes(), String.class);
        System.out.println( "other Value " + value + " <-");
//        System.out.println(dataStream);
        try {
            JSONObject Body = new JSONObject(value);

//            System.out.println(Body.get("status"));

            String status = (String) Body.get("status");
            if (status.equals("ON")) {
                System.out.println(status);
                light.setStatus(Status.ON);
            } else if (status.equals("OFF")) {
                light.setStatus(Status.OFF);
            }
        } catch (JSONException err) {
//            Log.d("Error", err.toString());
            System.out.println("error" + err.toString());
        }
//        light.setStatus(light.getStatus() == Status.ON ? Status.OFF: Status.ON);
        return new LightDto(light);
    }

    @PostMapping
    public LightDto create(@RequestBody LightDto dto) {
        Light light = null;
        if (dto.getId() != null) {
            light = lightDao.findById(dto.getId()).orElse(null);
        }

        if (light == null) {
            light = lightDao.save(new Light(dto.getId(), roomDao.getOne(dto.getRoomId()), dto.getLevel(), dto.getStatus()));
        } else {
            light.setLevel(dto.getLevel());
            light.setStatus(dto.getStatus());
            lightDao.save(light);
        }

        return new LightDto(light);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        lightDao.deleteById(id);
    }



}