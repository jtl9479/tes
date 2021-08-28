package com.example.pro.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pro.Mapper.Mmapper;

@Service
public class MServiceImpl implements MService{

	@Autowired
	Mmapper mmapper;
}
