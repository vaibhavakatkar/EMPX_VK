var morrisCharts = function() {
	var da;
var settings = {
		  "async": true,
		  "crossDomain": true,
		  "url": "http://localhost:8080/Employee/getAll?type=employee",
		  "method": "GET",
		  "headers": {
		    "content-type": "application/json",
		    "cache-control": "no-cache",
		    "postman-token": "5808c21c-9964-6bfa-65fe-4e034b8ce673"
		  }
		}

		$.ajax(settings).done(function (response) {	
		  
		  var arr=new Array();
		  var parsedData = JSON.parse(response)
		  arr=parsedData;
		  var javacount = 150;
		  var dotnet=76;
		  var date ;
		  var finaldata= new Array();
		 
		 /* alert(finaldata.substr(3));
		 */
		  
		//  debugger;
		  for(var i = 0; i < arr.length; i++) {
			var a=arr[0].joindate;
			/*	  document.write("<br><br>array index: " + i);
				  var obj = arr[i];
				  for (var key in obj){
				    var value = obj[key];*/
		
				    if(arr[i].joindate==arr[i].joindate)
				    	{
				         date=arr[i].joindate;
				   	    }
				    if(arr[i].skill=="JAVA")
				    	{
				    	javacount++;
				    	}
				    if(arr[i].skill=="SPARK")
			    	{
				    	dotnet++;
			    	}
				    finaldata[i]='{'+"\"y\":"+"\""+date+"\""+",\"a\":"+javacount+", \"b\":"+dotnet+'}';
				 //   finaldata[i]=assas;
				 
		  }
		  //	debugger;
		  //var abc="["+finaldata.slice(11, -1)+"]";
		 // res =finaldata.replace("""", "");
		 // var result = res.substring(1, res.length-1);
		//  da=JSON.stringify(result);
		//  alert(da)
		 // alert(res)
		 /* var string = finaldata;
		    string.replace (/"/g,''); //"[apple,orange,pear]"
		    alert(string)*/
		 
		  response=finaldata;
		//  alert(finaldata);
		response=response.toString();
		// var ar= (res);
			
		  
		 // var array=ar.replace(/^'/, "");
		  //array=ar.replace(/'$/, "");	
		 // array=array.slice(0,array.length) ;
		 var hi=response;
		var hiii;
		for(i = 0; i < hi.length; i++)
		 {
		     hi[i] = hi[i].replace('\"','');
		    // hiii[i]= hi[i].replace(/"/g,'');
		        //alert(str1);
		     }
		    // hi="["+hi+"]";
	     var qwe=new Array();
		     qwe="["+hi+"]";
		     debugger;
		     alert(qwe)
		//     var aaaa=finaldata.replace(/"/g,'');
		    
		      console.log(qwe);
		    qwe=JSON.parse(qwe);
		    
	    	  abc(qwe);
		     
		    
		  //abc(array);
		  //return response;
		  });

function abc(qwe) {
	
	
	  Morris.Line({
	    	 
	      element: 'morris-line-example',
	      data:qwe,
	      xkey: "y",
	      ykeys: ["a", "b","c"],
	      labels: ['JAVA', 'SAPARK','asdasd'],
	      resize: true,
	      lineColors: ['#33414E', '#95B75D', '#95hf5D']
	    });
	  Morris.Area({
	        element: 'morris-area-example',
	        data:qwe,
	        xkey: 'y',
	        ykeys: ['a', 'b'],
	        labels: ['JAVA', 'SPARK'],
	        resize: true,
	        lineColors: ['#1caf9a', '#FEA223']
	    });
	    Morris.Bar({
	        element: 'morris-bar-example',
	        data: qwe,
	        xkey: 'y',
	        ykeys: ['a', 'b'],
	        labels: ['JAVA ', 'SPARK'],
	        barColors: ['#B64645', '#0000FF']
	    });
}
 
    Morris.Donut({
        element: 'morris-donut-example',
        data: [
            {label: "Download Sales", value: 12},
            {label: "In-Store Sales", value: 30},
            {label: "Mail-Order Sales", value: 20}
        ],
        colors: ['#95B75D', '#1caf9a', '#FEA223']
    });

}();