package com.abc.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
 
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




@Controller
@RequestMapping("/cont")
public class RestController {
 
  UploadedFile ufile;
  public RestController(){
    System.out.println("init RestController");
    ufile = new UploadedFile();
  }
 
  @RequestMapping(value = "/listofFiles", method = RequestMethod.GET)
  public @ResponseBody String[] listofFile(HttpServletResponse response){
     
        	   File file = new File("/home/vaibhav/git/EMPX_VK/null/FILE_UPLOAD/");
               String[] fileList = file.list();
               for(String name:fileList){
                   System.out.println(name);
               }
       return fileList;
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
   public @ResponseBody String upload(MultipartHttpServletRequest request, HttpServletResponse response) {                 
 
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
				String rootPath = System.getProperty("catalina.home");
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

				return name;
				 
			
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + file.getOriginalFilename()
					+ " because the file was empty.";
		}


     
     
     
     
     
     /*try {
                //just temporary save file info into ufile
        ufile.length = file.getBytes().length;
        ufile.bytes= file.getBytes();
        ufile.type = file.getContentType();
        ufile.name = file.getOriginalFilename();
 
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
 */
         
     
     
     //2. send it back to the client as <img> that calls get method
     //we are using getTimeInMillis to avoid server cached image 
 
    
  }
 
}