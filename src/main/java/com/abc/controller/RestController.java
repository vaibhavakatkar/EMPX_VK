package com.abc.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
 
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.abc.model.UploadedFile;
import com.google.gson.Gson;




@Controller
@RequestMapping("/cont")
public class RestController {
 
  UploadedFile ufile;
  public RestController(){
    System.out.println("init RestController");
    ufile = new UploadedFile();
  }
 
  @RequestMapping(value = "/listofFiles", method = RequestMethod.GET)
  public @ResponseBody String listofFile(HttpServletResponse response){
     
	   File file = new File("/home/vaibhav/git/EMPX_VK/src/main/webapp/jsp/FILE_UPLOAD/");
       String[] fileList = file.list();
       Map<String, List<String>> map = new HashMap<String, List<String>>();
       List<String> newList = Arrays.asList(fileList);
       List<String> files = new ArrayList<String>();
       files.addAll(newList);
       
       
       map.put("FILE_NAME", files);
       
        	  /*  HashMap<String , String> hm=new HashMap<>();
               for(String name:fileList){
            	   hm.put( "FILE_NAME",name);
                         
               }*/
               Gson gson = new Gson(); 
               String json = gson.toJson(map); 
               System.out.println(json);
       return json;
  }

  
  
  @RequestMapping(value = "/get/{value}", method = RequestMethod.GET)
  public void get(HttpServletResponse response,@PathVariable String value){
        try {
 
            response.setContentType(ufile.type);
            response.setContentLength(ufile.length);
            FileCopyUtils.copy(ufile.bytes, response.getOutputStream());
            System.out.println("get call");
 
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  }
  
  
  
  
  
  
 
   @RequestMapping(value = "/upload", method = RequestMethod.POST)
   public @ResponseBody void upload(MultipartHttpServletRequest request, HttpServletResponse response) {                 
 
     //0. notice, we have used MultipartHttpServletRequest
 
     //1. get the files from the request object
     Iterator<String> itr =  request.getFileNames();
 
     MultipartFile file = request.getFile(itr.next());
     String name=file.getOriginalFilename();
     System.out.println(file.getOriginalFilename() +" uploaded!");
     if (!name.isEmpty()) {
			try {
		        ufile.length = file.getBytes().length;
		        ufile.bytes= file.getBytes();
		        ufile.type = file.getContentType();
		        ufile.name = file.getOriginalFilename();
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = "/home/vaibhav/git/EMPX_VK/src/main/webapp/jsp/";
				System.out.println(rootPath);
				File dir = new File(rootPath + File.separator + "FILE_UPLOAD");
		
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(ufile.bytes);
				stream.close();

				System.out.println("Server File Location="
						+ serverFile.getAbsolutePath());
				response.sendRedirect("http://localhost:8080/jsp/download.html");
				return;
				 
			
			} catch (Exception e) {
				//return "You failed to upload " + name + " => " + e.getMessage();
				System.out.println("You failed to upload " + name + " => " + e.getMessage());
			}
		} else {
			System.out.println("You failed to upload " + file.getOriginalFilename()
					+ " because the file was empty.");
		}


     
     
     
     
  
 
    
  }
   
   @RequestMapping(value = "/file/{name}", method = RequestMethod.GET)
   public ResponseEntity<byte[]> downloadFile(@PathVariable("name") String name) throws IOException {
       String filename = "/home/vaibhav/git/EMPX_VK/src/main/webapp/jsp/FILE_UPLOAD/" + name+".png";
       InputStream inputImage = new FileInputStream(filename);
       ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
       byte[] buffer = new byte[512];
       int l = inputImage.read(buffer);
       while(l >= 0) {
           outputStream.write(buffer, 0, l);
           l = inputImage.read(buffer);
       }
       HttpHeaders headers = new HttpHeaders();
       headers.set("Content-Type", "image/jpeg");
       headers.set("Content-Disposition", "attachment; filename=\"" + name + ".jpg\"");
       return new ResponseEntity<byte[]>(outputStream.toByteArray(), headers, HttpStatus.OK);
   }
   
   
   
   
   
   
   
   
   
   
 
}