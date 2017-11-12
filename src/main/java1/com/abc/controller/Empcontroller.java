package com.abc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abc.service.RegisterService;
import com.fasterxml.jackson.core.JsonProcessingException;


@Controller
@RequestMapping(value ="Employee")
public class Empcontroller {
	@Autowired
	RegisterService registerService;
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public @ResponseBody String getAll(@RequestParam("type") String type) throws JsonProcessingException {
		return registerService.getDataList(type);
	}
	@RequestMapping(value = "/getOneByUuidAndVersion", method = RequestMethod.GET)
	public @ResponseBody String getOneByUuidAndVersion(@RequestParam("uuid") String uuid,
			@RequestParam("version") String version, @RequestParam("type") String type) throws JsonProcessingException {
		return registerService.getOneByUuidAndVersion(uuid, version, type);
	}
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public ResponseEntity<String> save(@RequestBody Map<String, Object> document, @RequestParam("type") String type) {
		String Id = registerService.save(document, type);
		return new ResponseEntity<String>(Id, HttpStatus.OK);
	}
	@RequestMapping(value = "/getlinechart", method = RequestMethod.GET)
	public @ResponseBody String getlinechart(@RequestParam("type") String type) throws JsonProcessingException {
		return registerService.getlinechart(type);
	}
}
