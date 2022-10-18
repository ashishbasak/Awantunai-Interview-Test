package com.awantunai.test.demo.dto.mapper;

public class ModelMapper {
    private final org.modelmapper.ModelMapper modelMapper;

    public ModelMapper() {
        this.modelMapper = new org.modelmapper.ModelMapper();
    }

    private void mapperType(){

    }

    public org.modelmapper.ModelMapper map(){
        return this.modelMapper;
    }
}
