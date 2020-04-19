<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<!--     <h2>Jersey RESTful Web Application!</h2> -->
<!--     <p><a href="webapi/myresource">Jersey resource</a> -->
<!--     <p>Visit <a href="http://jersey.java.net">Project Jersey website</a> -->
<!--     for more information on Jersey! -->
<!--     <hr> -->
    
    <div class="container mt-5">
   			<div class="row">
   			<div class="col-md-4"></div>
   			<div class="col-md-4">
   			<h3 class="text-center text-black-50 mb-3">LOGIN</h3>
   			 <form action="webapi/login" method="post">
	   			 <div class="form-group">
		   			 <label>User Name</label>
		   			 <input class="form-control" type="text" name="userName">
	   			 </div>
	   			 <div class="form-group">
		   			 <label>Password</label>
		   			 <input class="form-control" type="password" name="password">
	   			 </div>
		    	<input class="btn btn-secondary btn-block" type="submit" name="submit" value="login">
		    </form>
   			</div>
   			<div class="col-md-4"></div>
   			</div>
    </div>
    
    
</body>
</html>
