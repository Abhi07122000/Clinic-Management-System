<nav class="navbar navbar-expand-lg navbar-dark bg-info">
<div class="container-fluid">
	<a class="navbar-brand" href="Aindex.jsp"><i
		class="fa-solid fa-house-medical"></i> Welcome Admin</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav me-auto">
			<li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Doctor
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="ADoctor.jsp">Add Doctor</a></li>
            <li><a class="dropdown-item" href="viewDoctor.jsp">View Doctor's</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="viewDoctor.jsp">Modify/Delete</a></li>
          </ul>
        </li>
        
			<li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
           Appointment
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="suggestDoctor.jsp">Suggest Doctor</a></li>
            
          </ul>
        </li>
		
		</ul>
		<div class="dropdown">
		<button class="btn btn-primary dropdown-toggle" type="button"
			id="dropdownMenuButton1" data-bs-toggle="dropdown"
			aria-expanded="false">Admin</button>
		<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
			<li><a class="dropdown-item" href="../adminLogout">Logout</a></li>
		</ul>
	</div>
	</div>
	</div>
</nav>