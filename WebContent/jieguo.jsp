<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<%
     int CK = (int)request.getAttribute("wow");

     String cx ="";
     int Count =0;
     int SSR =0;
     int SR =0;
     int R=0;
     int Rr=0;
     int Rsr=0;
     int Rssr=0;		 
     
     
     if(CK==1){
    	  cx="SSR";
     }
     else if(CK==2){
    	 cx="SR";
     }
     else if(CK==3){
    	 cx="R";
     }
     else if(CK==4){
    	 cx="clear!";
     }
         
    
   if(session.getAttribute("CNT")!=null){
	   Count=(Integer)session.getAttribute("CNT");
   } 
   
   if(session.getAttribute("SSR")!=null){
	   SSR=(Integer)session.getAttribute("SSR");
   }
   if(session.getAttribute("SR")!=null){
	   SR=(Integer)session.getAttribute("SR");
   }
   
   if(session.getAttribute("R")!=null){
	   R=(Integer)session.getAttribute("R");
   }
   
   if(session.getAttribute("CNT")!=null&&session.getAttribute("R")!=null){
		R=(Integer)session.getAttribute("R");		
		Rr=((100*R)/Count);		
	   }
   if(session.getAttribute("CNT")!=null&&session.getAttribute("SR")!=null){
		R=(Integer)session.getAttribute("SR");		
		Rsr=((100*R)/Count);		
	   }
   if(session.getAttribute("CNT")!=null&&session.getAttribute("SSR")!=null){
		R=(Integer)session.getAttribute("SSR");		
		Rssr=((100*R)/Count);		
	   }
   
   if(session.getAttribute("CLR")!=null){
	   cx="CLEAR!!";
   }
   
     
     
     
     
     
%>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center"style="color:green"><%=cx %></h1>
<p align="center" style="color:red">累计次数：<%=Count%></p>
<P align="center"style="color:orange">SSR次数：<%=SSR%></P>
<P align="center"style="color:purple">SR次数：<%=SR%></P>
<P align="center"style="color:black">R次数：<%=R%></P>
<p align="center"style="color:pink">R概率：<%=Rr %>%</p>
<p align="center"style="color:pink">SR概率：<%=Rsr %>%</p>
<p align="center"style="color:pink">SSR概率：<%=Rssr %>%</p>
<h2 align="center"><a href="gailv.jsp">Back</a></h2>

</body>
</html>