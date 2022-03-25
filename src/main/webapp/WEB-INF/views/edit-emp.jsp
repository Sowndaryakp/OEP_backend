<html>
<head>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<link href="css/add-emp.css" rel="stylesheet">
</head>
<body>
  
	<div class="container">
			<div class="main">
				<div class="main-center">
				<h4 align="center">Employee Edit Form</h4>
					<form class="" method="post" action="post-edit">
						<div class="form-group">
							<label for="empno">Employee Number</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="empno" id="empno"  value="${employee.empno}" readonly="readonly" />
							</div>
						</div>
						<div class="form-group">
							<label for="ename">Edit Employee Name</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="ename" id="ename" value="${employee.ename}" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="job">Edit Job</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="job" id="job" value="${employee.job}" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="mgr">Edit Manager Number</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="number" class="form-control" name="mgr" id="mgr" value="${employee.mgr}" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="hiredate">Edit Hiredate</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="date" class="form-control" name="hiredate" id="hiredate" value="${employee.hiredate}" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="sal">Edit Salary</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="number" class="form-control" name="sal" id="sal" value="${employee.sal}" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="comm">Enter Commission</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="number" class="form-control" name="comm" id="comm" value="${employee.comm}" />
							</div>
						</div>
						
						
						<div class="form-group">
							<label for="deptno">Edit Deptno</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="number" class="form-control" name="deptno" id="deptno" value="${employee.deptno}" />
							</div>
						</div>

						
						<div class="form-group" align="center">
							<button type="submit" class="btn btn-primary">Update</button>
						</div>
					</form>
				</div><!--main-center"-->
			</div><!--main-->
		</div><!--container-->
	</body>	
</html>