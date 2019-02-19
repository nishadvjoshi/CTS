<%-- 
    Document   : ctsUserById
    Created on : Jan 29, 2019, 3:24:58 PM
    Author     : nishad
--%>



<!DOCTYPE html>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="now" class="java.util.Date" />
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <meta name="description" content="">
        <meta name="author" content="">
        <title>Sushil Nimbkar & Associate</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- Plugin CSS -->
        <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/sb-admin.css" rel="stylesheet">

<style>
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 0px;
}

tr:nth-child(even){background-color: #d9d9d9}
.form-group
{
    width:40%;
}
</style>

<script type="text/javascript">

  function checkForm(form)
  {
      if(form.cmu_psw.value !="" && form.OldPass.value !="" )
      {
          if(form.cmu_psw.value== form.OldPass.value  )
          {
                         
               if(form.NewPass1.value != "" && form.NewPass1.value == form.NewPass2.value) {
      if(form.NewPass1.value.length <= 6) {
        alert("Error: Password must contain at least six characters!");
        form.NewPass1.focus();
        return false;
      }
      
       if(form.NewPass1.value== form.OldPass.value || form.NewPass2.value== form.OldPass.value && form.cmu_psw.value == form.NewPass1.value) {
        alert("Error: Password similar AS a old Password!");
        form.NewPass1.focus();
        return false;
      }
      
   
      re = /[0-9]/;
      if(!re.test(form.NewPass1.value)) {
        alert("Error: password must contain at least one number (0-9)!");
        form.NewPass1.focus();
        return false;
      }
      re = /[a-z]/;
      if(!re.test(form.NewPass1.value)) {
        alert("Error: password must contain at least one lowercase letter (a-z)!");
        form.NewPass1.focus();
        return false;
      }
      
      re = /[A-Z]/;
      if(!re.test(form.NewPass1.value)) {
        alert("Error: password must contain at least one uppercase letter (A-Z)!");
        form.NewPass1.focus();
        return false;
      }
    } else {
      alert("Error: Both passwords is different !");
      form.NewPass1.focus();
      return false;
    }

    alert("You entered a valid password: " + form.NewPass1.value);
    return true;
  }
     
            else
            {
                alert("Old Password in incorrect!");
                
                form.OldPass.focus();
                return false;
            }
              
              
          }
           else
            {
                alert("Enter Old Password!");
                return false;
            }
              
              
          }
      
  

   

</script>










    </head>

    <body class="fixed-nav sticky-footer bg-dark" id="page-top">

                       <!-- Navigation -->
       <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
            <a class="navbar-brand" href="#">CTS</a>
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
                    <li class="nav-item active" data-toggle="tooltip" data-placement="right" title="Dashboard">
                        <a class="nav-link" href="DashBoardController?action=listDairy">
                            <i class="fa fa-fw fa-dashboard"></i>
                            <span class="nav-link-text">
                                Dashboard</span>
                        </a>
                    </li>


                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Menu Levels">
                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti" data-parent="#exampleAccordion">
                            <i class="fa fa-fw fa-sitemap"></i>
                            <span class="nav-link-text">
                                Case</span>
                        </a>
                        <ul class="sidenav-second-level collapse" id="collapseMulti">
                        <!--    <li>
                                <a href="ClientCaseDetailsController?action=listCaseDetail">Case Diary</a>
                            </li>
                      -->

                        </ul>
                    </li>

                </ul>
                <ul class="navbar-nav sidenav-toggler">
                    <li class="nav-item">
                        <a class="nav-link text-center" id="sidenavToggler">
                            <i class="fa fa-fw fa-angle-left"></i>
                        </a>
                    </li>
                </ul>
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle mr-lg-2" href="#" id="messagesDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fa fa-fw fa-envelope"></i>
                            <span class="d-lg-none">Messages
                                <span class="badge badge-pill badge-primary">12 New</span>
                            </span>
                            <span class="new-indicator text-primary d-none d-lg-block">
                                <i class="fa fa-fw fa-circle"></i>
                                <span class="number">12</span>
                            </span>
                        </a>
                        <div class="dropdown-menu" aria-labelledby="messagesDropdown">
                            <h6 class="dropdown-header">New Messages:</h6>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">
                                <strong>David Miller</strong>
                                <span class="small float-right text-muted">11:21 AM</span>
                                <div class="dropdown-message small">Hey there! This new version of SB Admin is pretty awesome! These messages clip off when they reach the end of the box so they don't overflow over to the sides!</div>
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">
                                <strong>Jane Smith</strong>
                                <span class="small float-right text-muted">11:21 AM</span>
                                <div class="dropdown-message small">I was wondering if you could meet for an appointment at 3:00 instead of 4:00. Thanks!</div>
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">
                                <strong>John Doe</strong>
                                <span class="small float-right text-muted">11:21 AM</span>
                                <div class="dropdown-message small">I've sent the final files over to you for review. When you're able to sign off of them let me know and we can discuss distribution.</div>
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item small" href="#">
                                View all messages
                            </a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle mr-lg-2" href="#" id="alertsDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fa fa-fw fa-bell"></i>
                            <span class="d-lg-none">Alerts
                                <span class="badge badge-pill badge-warning">6 New</span>
                            </span>
                            <span class="new-indicator text-warning d-none d-lg-block">
                                <i class="fa fa-fw fa-circle"></i>
                                <span class="number">6</span>
                            </span>
                        </a>
                        <div class="dropdown-menu" aria-labelledby="alertsDropdown">
                            <h6 class="dropdown-header">New Alerts:</h6>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">
                                <span class="text-success">
                                    <strong>
                                        <i class="fa fa-long-arrow-up"></i>
                                        Status Update</strong>
                                </span>
                                <span class="small float-right text-muted">11:21 AM</span>
                                <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">
                                <span class="text-danger">
                                    <strong>
                                        <i class="fa fa-long-arrow-down"></i>
                                        Status Update</strong>
                                </span>
                                <span class="small float-right text-muted">11:21 AM</span>
                                <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">
                                <span class="text-success">
                                    <strong>
                                        <i class="fa fa-long-arrow-up"></i>
                                        Status Update</strong>
                                </span>
                                <span class="small float-right text-muted">11:21 AM</span>
                                <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item small" href="#">
                                View all alerts
                            </a>
                        </div>
                    </li>
                     <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle mr-lg-5" href="#" id="alertsDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fa fa-fw fa-user-circle"></i>
                            <span class="d-lg-none"></span>                          
                        </a>
                                           
                        <div class="dropdown-menu" aria-labelledby="alertsDropdown">
                            <h6 class="dropdown-header"> <% out.println(session.getAttribute("FirstName"));%> </a></h6>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="UserProfileController?action=listUserDetail">
                                <span class="text-success">
                                    <strong>Profile</strong>
                                </span>
                              
                                </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#exampleModal">
                                <span class="text-danger">
                                    <strong> Sign Out</strong>
                                </span>
                            </a>
                        </div>
                 </li>
                    
                    
                                      
                    <li class="nav-item">
                        <form class="form-inline my-2 my-lg-0 mr-lg-2">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Search for...">
                                <span class="input-group-btn">
                                    <button class="btn btn-primary" type="button">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                            </div>
                        </form>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="content-wrapper">

            <div class="container-fluid">

                <!-- Breadcrumbs -->
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="DashBoardController?action=listDairy">Dashboard</a>
                    </li>
                    <li class="breadcrumb-item active">My Dashboard</li>
                </ol>

             
           
                 

                <div class="card mb-3">
                    <div class="card-header">
                       <i class="fa fa-fw fa-user-circle"></i>
                       Manage User Details
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <form method="POST" action="UserProfileController?action=update"  onsubmit="return checkForm(this);">
                                     
                            <div class="container-fluid">
                                
                                <div class="row"  hidden="">
                                   
                                      <div class=" col sm-6 form-group">
                                                  <label>User PRN  </label>                                                  
                                                  <input type="text" class="form-control" name="cmu_id" value="<c:out value="${user.cmu_ID}" />" hidden="" required="" >
                                              </div>
                                                 <div class=" col sm-6 form-group" >
                                                  <label>Password </label>                                                  
                                                  <input readonly="" type="password" class="form-control" name="cmu_psw" value="<c:out value="${user.cmu_Password}" />" required=""  >
                                              </div>
                                              
                                            
                                              </div>
                                              <div class="row">
                                               
                                <div class=" col sm-6 form-group" >
                                                  <label>User Name </label>                                                  
                                                  <input type="email" class="form-control" name="cmu_UserName" value="<c:out value="${user.cmu_UserName}" />" readonly="" required="" >
                                              </div>
                                              </div>
                                              <div class="row">
                                              
                                                <div class=" col sm-6 form-group" >
                                                  <label>First Name </label>                                                  
                                                  <input  type="text" class="form-control" name="cmu_FirstName" value="<c:out value="${user.cmu_FirstName}" />" required="" >
                                              </div>
                                            
                                                <div class=" col sm-6 form-group" >
                                                  <label>Last Name </label>                                                  
                                                  <input  type="text" class="form-control" name="cmu_LastName" value="<c:out value="${user.cmu_LastName}" />"  >
                                              </div>
                                             
                                              </div>
                                              
                                              
                                                  <div class="row">
                                                      
                                                          <div class=" col sm-4 form-group" >
                                                  <label>Enter Old Password </label>                                                  
                                                  <input  type="Password" class="form-control" name="OldPass" required="" data-toggle="tooltip" title="Old Password"   >
                                              </div>
                                                      
                                                       <div class=" col sm-4 form-group" >
                                                  <label>Enter New Password </label>                                                  
                                                  <input  type="Password" class="form-control" name="NewPass1" required=""    data-toggle="tooltip" title="password must contain at least one number (0-9),one lowercase letter (a-z), one uppercase letter (A-Z) and length >6 "  >
                                              </div>
                                                      
                                              <div class=" col sm-4 form-group" >
                                                  <label>Re-Enter New Password </label>                                                  
                                                  <input  type="Password" class="form-control" name="NewPass2" required="" Placeholder="" >
                                              </div>
                                              
                                                      <div class=" col sm-4 form-group"hidden="" >
                                                  <label>Re-Enter New Password </label>                                                  
                                                  <input  type="Password" class="form-control" name="update" required="" value="update" >
                                              </div>
                                             
                                              
                                                    </div>
                                              <button type="Submit" name="update" class="btn btn-primary" >Submit</button>
                            </div>   
                                             
                                    </form>
                                              
                                              
                              
                                            
                                                 
                                              
                                           <!--
                                                     <c:out value="${user.cmu_Password}" />
                                                    <c:out value="${user.cmu_FirstName}" />
                                                    <c:out value="${user.cmu_LastName}" />
                                                    <c:out value="${user.cmu_Role}" />                                              
                                                    <fmt:formatDate value="${user.cmu_CreateDate}" pattern="dd/MM/yyyy" />
                                                    <c:out value="${user.cmu_CreateUser}" />
                                                    <fmt:formatDate value="${user.cmu_ModifyDate}" pattern="dd/MM/yyyy" />                                               
                                                    <c:out value="${user.cmu_ModifyUser}" />
                                                    <c:out value="${user.cmu_DeleteFlag}" />
                                                   <c:out value="${user.cmu_ActiveFlag}" />

                                             -->
                                          
                                        
                          
                        </div>
                    </div>
                    <div class="card-footer small text-muted">
                        Updated yesterday at 11:59 PM
                    </div>
                </div>



            </div>
            <!-- /.container-fluid -->

            <!-- /.container-fluid -->


        </div>
        <!-- /.container-fluid -->

    </div>
    <!-- /.content-wrapper -->

   <footer class="sticky-footer">
            <div class="container">
                <div class="text-center">
                    <small>Copyright &copy; Sushil Nimbkar  & Associate
                    
                        <fmt:formatDate var="year" value="${now}" pattern="yyyy" /> (2010- ${year})

</small>
                </div>
            </div>
        </footer>


    <!-- Scroll to Top Button -->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fa fa-angle-up"></i>
    </a>

        <!-- Logout Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Select "Logout" below if you are ready to end your current session.
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="LogOutController?action=logout">Logout</a>
                </div>
            </div>
        </div>
    </div>


    <!-- CaseStage Modal -->
    <div class="modal fade" id="casestageModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Add Case Stage</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <input class="form-control" type="text" placeholder="Enter case stage name" id="ccs_StageName" name="ccs_StageName" value="<c:out value="${casestage.ccs_StageName}" />" required/>
                    <input class="form-control" type="text" placeholder="Enter case stage description" id="ccs_Description" name="ccs_Description" value="<c:out value="${casestage.ccs_Description}" />" required/>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
                <div class="modal-footer">

                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper/popper.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="vendor/datatables/jquery.dataTables.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/sb-admin.min.js"></script>

    <script>$('#casestageModal').on('show.bs.modal', function (e) {

            //get data-id attribute of the clicked element
            var CaseStageName = $(e.relatedTarget).data('ccs_StageName');

            //populate the textbox
            $(e.currentTarget).find('input[name="ccs_StageName"]').val(CaseStageName);
        });</script>

</body>

</html>
