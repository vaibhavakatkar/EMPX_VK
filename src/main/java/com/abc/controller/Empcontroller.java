package com.abc.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abc.service.RegisterService;
import com.fasterxml.jackson.core.JsonProcessingException;

@CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 4800, allowCredentials = "true")
@Controller
@RequestMapping(value ="Employee")
public class Empcontroller {
	@Autowired
	RegisterService registerService;
	@CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 6000)
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public @ResponseBody String getAll(@RequestParam("type") String type) throws JsonProcessingException {
		return registerService.getDataList(type);
	}
	
	@RequestMapping(value = "/getAllLogin", method = RequestMethod.POST)
	public @ResponseBody String getAllLogin(@RequestParam("type") String type,@RequestParam("name") String name) throws JsonProcessingException {
		return registerService.getLoginList(type,name);
	}
	@RequestMapping(value = "/getOneByUuidAndVersion", method = RequestMethod.GET)
	public @ResponseBody String getOneByUuidAndVersion(@RequestParam("uuid") String uuid,
			@RequestParam("version") String version, @RequestParam("type") String type) throws JsonProcessingException {
		return registerService.getOneByUuidAndVersion(uuid, version, type);
	}
	
	
	@RequestMapping(value = "/getGempByName", method = RequestMethod.GET)
	public @ResponseBody String getGempByName(@RequestParam("name") String name,
		   @RequestParam("type") String type) throws JsonProcessingException {
		return registerService.getGempByName(name, type);
	}

	
	
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<String> save(@RequestBody Map<String, Object> document, @RequestParam("type") String type,HttpServletRequest request)
			throws Exception {
		String Id = registerService.save(document, type);
		return new ResponseEntity<String>(Id, HttpStatus.OK);
	}
	
	
	
	
	
	@RequestMapping(value = "/getlinechart", method = RequestMethod.GET)
	
	public @ResponseBody String getlinechart(@RequestParam("type") String type) throws JsonProcessingException {
		return registerService.getlinechart(type);
	}
}
