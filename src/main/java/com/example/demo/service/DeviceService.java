package com.example.demo.service;

import com.example.demo.db.model.devm;

import java.util.Optional;

public interface DeviceService {

        Iterable<devm> listAll();

        void deleteById (Integer id);

        devm add(Integer id, Integer number, String name);

        Optional<devm> findById(Integer devm);

        void mody (Integer id, Integer number, String name);

}