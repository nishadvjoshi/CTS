<%-- 
    Document   : ctsDashboard
    Created on : 8 Sep, 2017, 5:17:15 PM
    Author     : Admin
--%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" />

<%@page contentType="text/html"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
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

        
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

        
                <style>
            .table-wrapper-scroll-x {
display: block;
max-width: 100%;
overflow-x: auto;
-ms-overflow-style: -ms-autohiding-scrollbar;
}
       


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
</style>
        
        
        
        
        
        
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
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Example Pages">
                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#HomeMenu" data-parent="#exampleAccordion">
                         <i class="fa fa-fw fa-home"></i>
                            <span class="nav-link-text">
                                Home</span>
                        </a>
                        <ul class="sidenav-second-level collapse" id="HomeMenu">
                            <li>
                                <a href="DashBoardController?action=listDairy">Dashboard</a>
                            </li>
                            <li>
                                <a href="ARCILBoardController?action=listDashboard">ARC Dashboard</a>
                            </li>                              
                        </ul>
                    </li>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Example Pages">
                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseExamplePages" data-parent="#exampleAccordion">
                            <!--<i class="fa fa-fw fa-file"></i>-->
                            <i class="fa  fa-cogs"></i>
                            <span class="nav-link-text">
                                Operations</span>
                        </a>
                        <ul class="sidenav-second-level collapse" id="collapseExamplePages">
                            <li>
                                <a href="AdvocateController?action=listAdvocate">Advocates</a>
                            </li>
                            <li>
                                <a href="UserController?action=listUser">Users</a>
                            </li>
                            <li>
                                <a href="ClientController?action=listClient">Clients</a>

                            </li>
                            <li>
                                <a href="CourtController?action=listCourt">Courts</a>
                            </li>
                            <li>
                                <a href="CaseStageController?action=listCaseStage">Case Stage</a>
                            </li>
                            <li>
                                 <a href="CategoryController?action=listCategory">Case Category</a>
                            </li>                                
                        </ul>
                    </li>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Example Pages">
                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#CaseMenu" data-parent="#exampleAccordion">
                           <!-- <i class="fa fa-fw fa-file"></i>-->
                           <i class="fa fa-briefcase"></i>
                            <span class="nav-link-text">
                                Case</span>
                        </a>
                        <ul class="sidenav-second-level collapse" id="CaseMenu">
                            <li>
                                <a href="CaseMasterController?action=listCaseMaster">Case Master</a>
                            </li>
                            <li>
                                <a href="CaseDetailController?action=listCaseDetail">Case Diary</a>
                            </li>
                            <li>
                                <a href="CaseDocumentController?action=listDocument">Case Documents</a>
                            </li>
                          <!-- <li>
                                <a href="CaseStageController?action=listCaseStage">Case Stage</a>
                            </li>-->
                            <li>
                                <a href="CaseTaskController?action=listTaskDetails">Allocate Work</a>
                            </li>
                            <li>
                                <a href="CasePaymentsController?action=listPayments">Case Payments</a>
                            </li> 
                            <li>
                                <a href="CaseExpensesController?action=listExpenses">Case Expenses</a>
                            </li> 
                        </ul>
                    </li>

                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Link">
                        <a class="nav-link" href="#">
                            <i class="fa fa-fw fa-link"></i>
                            <span class="nav-link-text">
                                Link</span>
                        </a>
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
                        <a href="#">Dashboard</a>
                    </li>
                    <li class="breadcrumb-item active">My Dashboard</li>
                </ol>

                <!-- Icon Cards -->
                <div class="row">
                    <div class="col-xl-3 col-sm-6 mb-3">
                        <div class="card text-white bg-primary o-hidden h-100">
                            <div class="card-body">
                                <div class="card-body-icon">
                                    <i class="fa fa-fw fa-comments"></i>
                                </div>
                                <div class="mr-5">
                                    <c:out value="${casemonthlycount.ccd_MonthlyCaseCount}" /> Monthly Board
                                </div>
                            </div>
                            <a href="DashBoardController?action=listMonthlyBoard" class="card-footer text-white clearfix small z-1">
                                <span class="float-left">View Details</span>
                                <span class="float-right">
                                    <i class="fa fa-angle-right"></i>
                                </span>
                            </a>
                        </div>
                    </div>
                    <div class="col-xl-3 col-sm-6 mb-3">
                        <div class="card text-white bg-warning o-hidden h-100">
                            <div class="card-body">
                                <div class="card-body-icon">
                                    <i class="fa fa-fw fa-list"></i>
                                </div>
                                <div class="mr-5">
                                    <c:out value="${weeklytaskcount.ctm_WeeklyTaskCount}"  /> New Tasks!
                                </div>
                            </div>
                            <a href="TaskUpdateController?action=listTaskDetails" class="card-footer text-white clearfix small z-1">
                                <span class="float-left">View Details</span>
                                <span class="float-right">
                                    <i class="fa fa-angle-right"></i>
                                </span>
                            </a>
                        </div>
                    </div>
                    <div class="col-xl-3 col-sm-6 mb-3">
                        <div class="card text-white bg-success o-hidden h-100">
                            <div class="card-body">
                                <div class="card-body-icon">
                                    <i class="fa fa-fw fa-shopping-cart"></i>
                                </div>
                                <div class="mr-5">
                                    <c:out value="${casemastercount.cad_CaseMasterCount}" /> Cases
                                </div>
                            </div>
                            <a href="CaseMasterController?action=listCaseMaster" class="card-footer text-white clearfix small z-1">
                                <span class="float-left">View Details</span>
                                <span class="float-right">
                                    <i class="fa fa-angle-right"></i>
                                </span>
                            </a>
                        </div>
                    </div>
                    <div class="col-xl-3 col-sm-6 mb-3">
                        <div class="card text-white bg-danger o-hidden h-100">
                            <div class="card-body">
                                <div class="card-body-icon">
                                    <i class="fa fa-fw fa-support"></i>
                                </div>
                                <div class="mr-5">
                                    <c:out value="${caseundatedcount.ccd_UnDatedCaseCount}" /> UnDated Cases
                                </div>
                            </div>
                            <a href="DashBoardController?action=listUnDatedBoard" class="card-footer text-white clearfix small z-1">
                                <span class="float-left">View Details</span>
                                <span class="float-right">
                                    <i class="fa fa-angle-right"></i>
                                </span>
                            </a>
                        </div>
                    </div>
                </div>



                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fa fa-table"></i>
                        Daily Board
                         <b class="pull-right">
    
                        <fmt:formatDate var="year" value="${now}" pattern="dd/MM/yyyy" /> ${year}

</b>
                    </div>
                    <div class="card-body table-wrapper-scroll-x">
                        <div class="table-responsive">
                            <table class="table table-bordered" width="100%" id="dataTable" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Update</th>  
                                        <th>Register No</th>  
                                        <th>Case Number</th>
                                        <th>File Name</th>
                                      <!--  <th>Current Date</th>                                                                       -->
                                        <th>Stage</th>
                                        <th>Judge</th>                                                                                           
                                        <th>Court</th>   
                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                        <th>Update</th>  
                                        <th>Register No</th>  
                                        <th>Case Number</th>
                                        <th>File Name</th>
                                      <!--  <th>Current Date</th>                                                                       -->
                                        <th>Stage</th>
                                        <th>Judge</th>                                                                                           
                                        <th>Court</th>   
                                    </tr>
                                </tfoot>
                                <tbody>
                                    <c:forEach items="${casedetails}" var="casedetail">
                                        <tr>
                                            <td><a data-toggle="modal"    
                                      
                                      data-caseid="<c:out value="${casedetail.cad_ID}"/>" data-casename="<c:out value="${casedetail.cad_CaseNo}" />"  data-filename="<c:out value="${casemaster.cad_FileName}" />"
                                      data-fname="<c:out value="${casedetail.cad_FileName}" />" data-regno="<c:out value="${casedetail.cad_RegNo}" />" data-ccdid="<c:out value="${casedetail.ccd_ID}" />"
                                      data-dates="<fmt:formatDate value="${casedetail.ccd_CurrentDate}" pattern="dd/MM/yy" />"
                                      data-target="#newrojnama" href="#">Update</a>
                                                
                                                <!--<a href="CaseDetailController?action=update&CaseMasterID=<c:out value="${casedetail.cad_ID}"/>">UPDATE</a>
                                                --></td>                                                        
                                            <td><c:out value="${casedetail.cad_RegNo}" /></td>                                                
                                            <td><c:out value="${casedetail.cad_CaseNo}" /></td>
                                            <td><c:out value="${casedetail.cad_FileName}" /></td>                                                        
                                           <!-- <td><fmt:formatDate value="${casedetail.ccd_CurrentDate}" pattern="dd/MM/yy" /></td>-->
                                            <td><c:out value="${casedetail.ccd_Stage}" /></td>  
                                            <td><c:out value="${casedetail.ccd_Judge}" /></td> 
                                            <td><c:out value="${casedetail.ccd_Court}" /></td>                                                                                                                                                                                            
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="card-footer small text-muted">
                        Updated yesterday at 11:59 PM
                    </div>
                </div> 












                <!-- Area Chart Example -->
              
               

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /.content-wrapper -->


        <footer class="sticky-footer">
            <div class="container">
                <div class="text-center">
                    <small>Copyright &copy; Sushil Nimbkar  & Associate
                    
                        <fmt:formatDate var="year" value="${now}" pattern="yyyy" /> (2017- ${year})

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
            
            
            
            
            
               
     <!-- Rojnama Modal-->
     
     <div class="modal fade" id="newrojnama" tabindex="-1" role="dialog" aria-labelledby="newrojnama">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
           <h4 class="modal-title" id="exampleModalLabel" >Rojnama</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
       
      </div>
    <div class="modal-body">
        
        
           
       <form method="POST" class="register" action='DashBoardController' name="frmAddCaseDetail" >
  
                        
   <div class="container-fluid">
       <div class="row">
           <div class="col-sm-4">
                            <label>Case ID : </label>  <input type="text" readonly="" style="width:auto;" class="form-control" placeholder="CaseID" name="cad_ID" id="caseid" />

           </div>
         
           <div hidden="">   <label >Registration no : </label> <input type="text" readonly="" style="width:auto;" class="form-control" placeholder="reg_no" name="cad_RegNo" id="regno" /> </div>

          
            <div class="col-sm-4">
            <label>Case Number : </label> <input type="text" readonly="" style="width:auto;" class="form-control" placeholder="CaseNumber" name="cad_CaseNo" id="casename" />

           </div>
            <div class="col-sm-4">
                      <label>File Name : </label> <input type="text" readonly="" style="width:auto;" class="form-control" placeholder="FileName" name="cad_FileName" id="filename" /> 

           </div>
       </div>
   </div>
                        
    
           <br>
        
        
          <div class="form-group">
        <label for="recipient-name"   class="control-label">Next Date:</label>
        <input type="text" data-toggle="tooltip" placeholder="dd/MM/yyyy" title="Please Enter Next Case Date in dd/mm/yyyy format"  name="ccd_NextCurrentDate" required="" class="form-control" id="date1" style="width:80%;">
      </div>
        
      

        
            <p>      
            <label >Select Attending Advocate  : </label> 

            <select data-placeholder="Select Advocate..." name ="ccd_AAdvocate" data-toggle="tooltip" title="Select Advocate Attending Case" class="chosen-select" required=""  style="width:36%;"   >
                                <option selected="true" disabled value="">Select Advocate</option>      
                                <c:forEach items="${advocates}" var="advocate">                                                
                                    <option value="${advocate.cam_FirstName}" ${advocate.cam_FirstName == casemdetails.ccd_AAdvocate ? 'selected' : ''}>${advocate.cam_FirstName}</option>
                                </c:forEach>
                            </select>                                          

              <a href="DashBoardController?action=AddAdvocate" ><button class="btn btn-primary btn-sm">+</button></a>
            </p>

     
   <p>      
      <label>Select Case State  :</label> 

      <select data-placeholder="Select Case State..." name ="ccd_Stage" data-toggle="tooltip" title="Select Correct Case Stage" required="" class="chosen-select" style="width:44.5%;" >
                              <option selected="true" disabled value="">Select Stage</option>       
                                <c:forEach items="${casestages}" var="casestage">                                                
                                    <option value="${casestage.ccs_StageName}" ${casestage.ccs_StageName == casemdetails.ccd_Stage ? 'selected' : ''}>${casestage.ccs_StageName}</option>
                                </c:forEach>
                            </select>         
                                         <a href="DashBoardController?action=AddCaseStage" ><button class="btn btn-primary btn-sm">+</button></a>
                           

                      
            </p>    
                            
                            
                            <p> <label>Select Court  :</label> 
                                <select data-placeholder="Select Court..." name ="ccd_Court" class="chosen-select" required=""  data-toggle="tooltip" title="Select Court" style="width:49%;" >
                                <option value="" selected="true" disabled="">Select court</option>               
                <c:forEach items="${courts}" var="court">                                                
                                    <option  value="${court.ccm_CourtName}" ${court.ccm_CourtName == casemdetails.ccd_Court ? 'selected' : ''}>${court.ccm_CourtName}</option>
                                </c:forEach>
                            </select>   
      
                             <a href="DashBoardController?action=AddCourt" ><button class="btn btn-primary btn-sm">+</button></a>
  
        
        <div class="form-group">
        <label for="recipient-name"  class="control-label">Location:</label>
        <input type="text" name="ccd_CaseLocation" class="form-control" id="location" style="width:80%;" required>
      </div>
        
        
        <div class="form-group">
        <label for="recipient-name"  class="control-label">Judge:</label>
        <input type="text" name="ccd_Judge" class="form-control" id="judge" style="width:80%;" required>
      </div>
          
         <div class="form-group">
        <label for="message-text"  class="control-label">Judgment</label>
        <textarea class="form-control" name="ccd_Judgment" id="judgement" style="width:80%;" required></textarea>
      </div>
        
      <div class="form-group">
        <label for="message-text"  class="control-label">Rojnama:</label>
        <textarea class="form-control" name="ccd_Rojnama" id="Rojnama" style="width:80%;" required></textarea>
      </div>
       
     
   
    <input type="checkbox"  id="defaultUnchecked" name="Document" value="1" >
    <label class="custom-control-label" for="defaultUnchecked">Do you want to upload Case Documents</label>

   
                            <div hidden="">
                       
                      
                        <!--<input type="text"  style="width:200px;"  class="form-control" placeholder="CaseMasterID" name="ccd_id" value="<c:out value="${casemaster.cad_ID}" />" />
                            <input type="text"  style="width:200px;"  class="form-control" placeholder="ClientID" name="cmc_ID" id="clientid" /> -->
                       Last <input type="text" style="width:200px;"  class="form-control" placeholder="CaseDetailID" name="LastDetail_ID" id="ccd_id" value="<c:out value="${casemdetail.ccd_ID}" />" />     
                        <input type="text"  style="width:200px;"  class="form-control" placeholder="CaseDetailID" name="ccd_id" id="ccd_id" value="<c:out value="${casemdetail.ccd_ID}" />" /> 
                        <input type="text"  class="form-control"  placeholder="Previous Date" id="ccd_PreviousDate" name="ccd_PreviousDate" /> 
                        <input type="text"  class="form-control"  name="ccd_EditFlag" value="update" /> 
                        <input type="text"  class="form-control"  name="ccd_DeleteFlag" value="<c:out value="${casedetail.ccd_DeleteFlag}" />" /> 
                        <input type="text"  class="form-control"  name="ccd_ActiveFlag" value="<c:out value="true" />" /> 
                        <input type="text"  class="form-control"  name="ccd_CreateDate" value="<fmt:formatDate pattern="dd/MM/yyyy" value="<%= new java.util.Date()%>" />" />                
                        <input type="text"  class="form-control"  name="ccd_CreateUser" value="<c:out value="${sessionScope.cmu_ID}" />"/>                 
                        <input type="text"  class="form-control"  name="ccd_ModifyDate" value="<fmt:formatDate pattern="dd/MM/yyyy" value="<%= new java.util.Date()%>" />" />                
                        <input type="text"  class="form-control"  name="ccd_ModifyUser" value="<c:out value="${sessionScope.cmu_ID}" />" /> 
                        <input type="text"  class="form-control"  name="ccd_CreateUserName" value="<%=session.getAttribute("FirstName")%>" /> 

           </div>
             <div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
     <button type="submit" name="SaveDetails" id="SaveDetails1" class="btn btn-primary"    >Submit</button>
  </div>
                      
                        
                        
    </form>
  </div>

</div>
  </div></div>

   <script>
$('#newrojnama').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget) // Button that triggered the modal
  var caseid = button.data('caseid') // Extract info from data-* attributes
    var casename = button.data('casename') // Extract info from data-* attributes
      var filename = button.data('fname') // Extract info from data-* attributes
      var reg_no=button.data('regno')
        var ccdid=button.data('ccdid')
         var dates=button.data('dates')


    
  var modal = $(this)
 
  modal.find('.modal-body  #caseid').val(caseid)
 
      modal.find('.modal-body #casename').val(casename)
        modal.find('.modal-body #filename').val(filename)
         modal.find('.modal-body #regno').val(reg_no)
          modal.find('.modal-body #ccd_id').val(ccdid)     
            modal.find('.modal-body #ccd_PreviousDate').val(dates)     
       
      //alert(dates)    
   
});
      </script>      

      
            
            
            
            
            
            
            
            

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

    </body>

</html>

