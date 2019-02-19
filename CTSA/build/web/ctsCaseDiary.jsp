<%-- 
    Document   : ctsCaseDiary
    Created on : 8 Sep, 2017, 7:38:59 PM
    Author     : Admin
--%>

<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <meta name="description" content="">
        <meta name="author" content="">
        <title>Sushil Nimbkar & Associate</title>


        <link rel="stylesheet" href="css/select2.css" />
        <script type="text/javascript" src="js/select2.js"></script>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- Plugin CSS -->
        <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/sb-admin.css" rel="stylesheet">




        <link rel="stylesheet" href="css/prism.css">
        <link rel="stylesheet" href="css/chosen.css">
        <script>
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });
        </script>
        
            <script language="javascript">
function deleteRecord(id,Case){
    var doIt=confirm('Do you want to delete the record of\n Case ID  : '+id+ ' \n Advocate name :' +Case+ ' ');
   
  if(doIt){
   var f=document.form;
    //f.action="../ClientController?action=delete&ClientID="+id;
    window.location.href="CaseDetailController?action=delete&CaseDetailID="+id;
    f.submit();
    
    }
  else{

    }
}
</script>



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




 <script>
            function validatedate(inputText)
            {
                var dateformat = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;
                // Match the date format through regular expression
                if (inputText.value.match(dateformat))
                {
                    document.frmAddCaseDetail.ccd_NextCurrentDate.focus();
                    //Test which seperator is used '/' or '-'
                    var opera1 = inputText.value.split('/');
                    var opera2 = inputText.value.split('-');
                    lopera1 = opera1.length;
                    lopera2 = opera2.length;
                    // Extract the string into month, date and year
                    if (lopera1 > 1)
                    {
                        var pdate = inputText.value.split('/');
                    }
                    else if (lopera2 > 1)
                    {
                        var pdate = inputText.value.split('-');
                    }
                    var mm = parseInt(pdate[1]);
                    var dd = parseInt(pdate[0]);
                    var yy = parseInt(pdate[2]);
                    // Create list of days of a month [assume there is no leap year by default]
                    var ListofDays = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
                    if (mm == 1 || mm > 2)
                    {
                        if (dd > ListofDays[mm - 1])
                        {
                            alert('Invalid date format! Please use dd/mm/yyyy format.');
                            return false;
                        }
                    }
                    if (mm == 2)
                    {
                        var lyear = false;
                        3
                        if ((!(yy % 4) && yy % 100) || !(yy % 400))
                        {
                            lyear = true;
                        }
                        if ((lyear == false) && (dd >= 29))
                        {
                            alert('Invalid date format! Please use dd/mm/yyyy format.');
                            return false;
                        }
                        if ((lyear == true) && (dd > 29))
                        {
                            alert('Invalid date format! Please use dd/mm/yyyy format.');
                            return false;
                        }
                    }
                }
                else
                {
                    alert("Invalid date format! Please use dd/mm/yyyy format.");
                    document.frmAddCaseDetail.ccd_NextCurrentDate.focus();
                    return false;
                }
            }
        </script>
    
        
        
        <!-- Update -------->
                <script type="text/javascript">
            $(document).ready(function () {
                $('#SaveDetails').attr('disabled', 'disabled');
                $('#ccd_Rojnama').keyup(function () {
                    if ($(this).val() != '') {
                        $('#SaveDetails').removeAttr('disabled');
                    }
                    else {
                        $('#SaveDetails').attr('disabled', 'disabled');
                    }
                });
            });</script>
        <script>
            $(document).ready(function () {
                $("#ccd_NextCurrentDate").keyup(function () {
                    if ($(this).val().length == 2 || $(this).val().length == 5) {
                        $(this).val($(this).val() + "/");
                    }
                });
            });
        </script>
        <script>
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });
        </script>

        <script>
            function validatedate(inputText)
            {
                var dateformat = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;
                // Match the date format through regular expression
                if (inputText.value.match(dateformat))
                {
                    document.frmAddCaseDetail.ccd_NextCurrentDate.focus();
                    //Test which seperator is used '/' or '-'
                    var opera1 = inputText.value.split('/');
                    var opera2 = inputText.value.split('-');
                    lopera1 = opera1.length;
                    lopera2 = opera2.length;
                    // Extract the string into month, date and year
                    if (lopera1 > 1)
                    {
                        var pdate = inputText.value.split('/');
                    }
                    else if (lopera2 > 1)
                    {
                        var pdate = inputText.value.split('-');
                    }
                    var mm = parseInt(pdate[1]);
                    var dd = parseInt(pdate[0]);
                    var yy = parseInt(pdate[2]);
                    // Create list of days of a month [assume there is no leap year by default]
                    var ListofDays = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
                    if (mm == 1 || mm > 2)
                    {
                        if (dd > ListofDays[mm - 1])
                        {
                            alert('Invalid date format! Please use dd/mm/yyyy format.');
                            return false;
                        }
                    }
                    if (mm == 2)
                    {
                        var lyear = false;
                        3
                        if ((!(yy % 4) && yy % 100) || !(yy % 400))
                        {
                            lyear = true;
                        }
                        if ((lyear == false) && (dd >= 29))
                        {
                            alert('Invalid date format! Please use dd/mm/yyyy format.');
                            return false;
                        }
                        if ((lyear == true) && (dd > 29))
                        {
                            alert('Invalid date format! Please use dd/mm/yyyy format.');
                            return false;
                        }
                    }
                }
                else
                {
                    alert("Invalid date format! Please use dd/mm/yyyy format.");
                    document.frmAddCaseDetail.ccd_NextCurrentDate.focus();
                    return false;
                }
            }
        </script>

     
        <script>
            $(document).ready(function () {
                $("#ccd_NextCurrentDate").keyup(function () {
                    if ($(this).val().length == 2 || $(this).val().length == 5) {
                        $(this).val($(this).val() + "/");
                    }
                });
            });
        </script>
        <script>
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });
        </script>

        <script>
            function validatedate(inputText)
            {
                var dateformat = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;
                // Match the date format through regular expression
                if (inputText.value.match(dateformat))
                {
                    document.frmAddCaseDetail.ccd_NextCurrentDate.focus();
                    //Test which seperator is used '/' or '-'
                    var opera1 = inputText.value.split('/');
                    var opera2 = inputText.value.split('-');
                    lopera1 = opera1.length;
                    lopera2 = opera2.length;
                    // Extract the string into month, date and year
                    if (lopera1 > 1)
                    {
                        var pdate = inputText.value.split('/');
                    }
                    else if (lopera2 > 1)
                    {
                        var pdate = inputText.value.split('-');
                    }
                    var mm = parseInt(pdate[1]);
                    var dd = parseInt(pdate[0]);
                    var yy = parseInt(pdate[2]);
                    // Create list of days of a month [assume there is no leap year by default]
                    var ListofDays = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
                    if (mm == 1 || mm > 2)
                    {
                        if (dd > ListofDays[mm - 1])
                        {
                            alert('Invalid date format! Please use dd/mm/yyyy format.');
                            return false;
                        }
                    }
                    if (mm == 2)
                    {
                        var lyear = false;
                        3
                        if ((!(yy % 4) && yy % 100) || !(yy % 400))
                        {
                            lyear = true;
                        }
                        if ((lyear == false) && (dd >= 29))
                        {
                            alert('Invalid date format! Please use dd/mm/yyyy format.');
                            return false;
                        }
                        if ((lyear == true) && (dd > 29))
                        {
                            alert('Invalid date format! Please use dd/mm/yyyy format.');
                            return false;
                        }
                    }
                }
                else
                {
                    alert("Invalid date format! Please use dd/mm/yyyy format.");
                    document.frmAddCaseDetail.ccd_NextCurrentDate.focus();
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

                    
 <!--//Edit modal       -->
 <div class="modal fade" id=editUserPopUp tabindex="-1" 
    role="dialog" aria-labelledby="helpModalLabel" aria-hidden="true">
  <div class="modal-dialog ">
    <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title" id="myModalLabel">Update Password</h4>
        </div>
        <div class="modal-body">                                                                                    
        <form class="EditUserBody" method="POST" role="form"  >
          <div class="input-group col-md-8">
           <span class="input-group-addon">User Name</span>
             <input class="form-control" id="userName" type="text" class="input-medium" disabled />
          </div>  
            <br>
               <div class="input-group col-md-8">
           <span class="input-group-addon">User Name</span>
             <input class="form-control" id="xyz" type="text" class="input-medium" disabled />
          </div>           
        </form> 
       </div>   
    </div>
  </div>
</div>
        <div class="content-wrapper">

            <div class="container-fluid">

                <!-- Breadcrumbs -->
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="#">Dashboard</a>
                    </li>
                    <li class="breadcrumb-item active">My Dashboard</li>
                </ol>
 <% //out.println(" User Name :"+session.getAttribute("FirstName"));%>
                <h1>Maintain Case Dairy</h1>
                <body class="bg-dark">


                    <form method="POST" class="register" action='CaseDetailController' name="frmAddCaseDetail">

                        <p> <select data-placeholder="Select Case..." name ="cad_FileName" data-toggle="tooltip" title="Select Case For Rojnama" class="chosen-select" style="width:90%" required >
                                <option selected disabled value="">Select Case</option>
                           
                                
                                <c:forEach items="${casemasters}" var="casemaster">                                                         
                                    <option value="${casemaster.cad_ID}" ${casemaster.cad_ID == casedetail.cad_ID ? 'selected' : ''}>${casemaster.cad_CaseNo} || ${casemaster.cad_FileName}</option>
                                </c:forEach>
                                    
                                    
                                    
                            </select>


                        </p>

                        <p>
                            <button type="submit" name="GetDetails" value="GetDetails" style="width:30%" class="btn btn-primary">Get Details</button> 
                            <!--    <button type="submit" name="NewRojnama" value="NewRojnama" style="width:30%" class="btn btn-primary">New Rojnama</button>
                        
                               -->
                              <button  type="button" class="btn btn-primary"  data-toggle="modal"    
                                      
                                      data-caseid="<c:out value="${casemaster.cad_ID}"/>" data-casename="<c:out value="${casemaster.cad_CaseNo}" />"  data-filename="<c:out value="${casemaster.cad_FileName}" />"
                                      data-clientid="<c:out value="${casemdetail.cad_ID}" />" data_regno="<c:out value="${casemaster.cad_RegNo}" />"
                                       data-target="#rojnama" >New Rojnama</button>
                                         <!-- cad_id,cad_RegNo,cad_CaseNo,cad_FileName,-->
                        </p>
                                </form>
<!--
                        <P><label>Case ID : </label> <label><c:out value="${casemaster.cad_ID}" /> </label> </p>                        
                        <P><label>Case Number : </label> <label><c:out value="${casemaster.cad_CaseNo}" /> </label> </p>
                        <P><label>File Name : </label> <label><c:out value="${casemaster.cad_FileName}" /> </label></p>
                        <input type="text" readonly="readonly" style="width:auto;" class="form-control" placeholder="Registration No" name="cad_RegNo" value="<c:out value="${casemaster.cad_RegNo}" />" />
-->

                        <div class="card mb-3">
                            <div class="card-header">
                                <i class="fa fa-table"></i>
                                Case History
                            </div>
                            <div class="card-body table-wrapper-scroll-x">
                                <div class="table-responsive">
                                    <table class="table table-bordered" width="100%" id="dataTable" cellspacing="0">
                                        <thead>
                                            <tr>
                                             
                                                <th>Update</th>
                                                <th>Delete</th>  
                                                <th hidden="">ccd_Id</th>
                                                <th hidden="">cad_ID</th>
                                                <th>Previous Date(s)</th>
                                                <th>Attending Adv.</th>
                                                <th>Stage</th>
                                                <th>Location</th>                    
                                                <th>Judge</th>                    
                                                <th>Rojnama</th>                                                                              
                                                <th>Court</th> 
                                                <!--<th>Create UserName</th>
                                                <th>Modify UserName</th>                                         -->
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                
                                                <th>Update</th>
                                                <th>Delete</th>  
                                                <th hidden="">ccd_Id</th>
                                                <th hidden="">cad_ID</th>
                                                <th>Previous Date(s)</th>
                                                <th>Attending Adv.</th>
                                                <th>Stage</th>
                                                <th>Location</th>                    
                                                <th>Judge</th>                    
                                                <th>Rojnama</th>                                                                              
                                                <th>Court</th> 
                                            <!--    <th>Create UserName</th>
                                                <th>Modify UserName</th>                                         -->
                                            </tr>
                                        </tfoot>
                                        <tbody>
                                            <c:forEach items="${casedetails}" var="casedetail">
                                                <tr>

                                                    <td>
                                                        
                                                        <a data-toggle="modal" 
                                                           
                                                           
                                                           data-ccdid="<c:out value="${casedetail.ccd_ID}"/>" data-name="<c:out value="${casedetail.ccd_AAdvocate}" />" data-court="<c:out value="${casedetail.ccd_Court}" />"
                                                         data-msg="<c:out value="${casedetail.ccd_Rojnama}" />"  data-stage="<c:out value="${casedetail.ccd_Stage}" />" data-location="<c:out value="${casedetail.ccd_CaseLocation}" />"
                                                         data-judge="<c:out value="${casedetail.ccd_Judge}" />" data-date="<fmt:formatDate value="${casedetail.ccd_CurrentDate}" pattern="dd/MM/yyyy" />" data-cmcid="<c:out value="${casemaster.cmc_ID}" />"
                                                         data-cadid="<c:out value="${casemaster.cad_ID}" />" data-caseno="<c:out value="${casemaster.cad_CaseNo}" />" data-filename="<c:out value="${casemaster.cad_FileName}" />"
                                                         data-Judgment="<c:out value="${casedetail.ccd_Judgment}" />" data-remark="<c:out value="${casedetail.ccd_Remarks}" />"
                                                         data-target="#transferModal" href="#">Edit</a></td>
                                                         
                                                         
                                                         
                                                   <td><a href="#" onclick="deleteRecord(<c:out value="${casedetail.ccd_ID},'${casedetail.ccd_AAdvocate}'" /> );">Delete</a></td>
                                                 
                                                    <td hidden=""><c:out value="${casedetail.ccd_ID}" /></td>
                                                    <td hidden=""><c:out value="${casemaster.cad_ID}" /></td>
                                                    <td><fmt:formatDate value="${casedetail.ccd_CurrentDate}" pattern="dd/MM/yyyy" /></td>
                                                    <td><c:out value="${casedetail.ccd_AAdvocate}" /></td>
                                                    <td><c:out value="${casedetail.ccd_Stage}" /></td>
                                                    <td><c:out value="${casedetail.ccd_CaseLocation}" /></td>
                                                    <td><c:out value="${casedetail.ccd_Judge}" /></td>
                                                    <td><c:out value="${casedetail.ccd_Rojnama}" /></td>                                                                
                                                    <td><c:out value="${casedetail.ccd_Court}" /></td>                                                                
                                                  <!--  <td><c:out value="${casedetail.ccd_CreateUserName}" /></td>
                                                    <td><c:out value="${casedetail.ccd_ModifyUserName}" /></td>-->

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
                        <input type="hidden"  style="width:200px;"  class="form-control" placeholder="CaseMasterID" name="cad_id" value="<c:out value="${casemdetail.cad_ID}" />" /> 
                        <input type="hidden" style="width:200px;"  class="form-control" placeholder="CaseDetailID" name="LastDetail_ID" value="<c:out value="${casemdetail.ccd_ID}" />" /> 
                        <input type="hidden"  style="width:200px;"  class="form-control" placeholder="CaseDetailID" name="ccd_id" value="<c:out value="${casemdetail.ccd_ID}" />" /> 
                        <input type="hidden" style="width:200px;"  class="form-control" placeholder="ClientID" name="cmc_ID" value="<c:out value="${casemaster.cmc_ID}" />" /> 
                        <input type="hidden"  class="form-control" placeholder="Previous Date" id="ccd_PreviousDate" name="ccd_PreviousDate" value="<fmt:formatDate value="${casemdetail.ccd_CurrentDate}" pattern="dd/MM/yyyy" />" /> 
                        <input type="hidden"  class="form-control" name="ccd_EditFlag" value="<%=request.getAttribute("upd")%>" /> 
                        <input type="hidden"  class="form-control" name="ccd_DeleteFlag" value="<c:out value="${casedetail.ccd_DeleteFlag}" />" /> 
                        <input type="hidden"  class="form-control" name="ccd_ActiveFlag" value="<c:out value="true" />" /> 
                        <input type="hidden"  class="form-control" name="ccd_CreateDate" value="<fmt:formatDate pattern="dd/MM/yyyy" value="<%= new java.util.Date()%>" />" />                
                        <input type="hidden"  class="form-control" name="ccd_CreateUser" value="<%=session.getAttribute("cmu_ID")%>" />                 
                        <input type="hidden"  class="form-control" name="ccd_ModifyDate" value="<fmt:formatDate pattern="dd/MM/yyyy" value="<%= new java.util.Date()%>" />" />                
                        <input type="hidden"  class="form-control" name="ccd_ModifyUser" value="<%=session.getAttribute("cmu_ID")%>" /> 
                        <input type="hidden"  class="form-control" name="ccd_CreateUserName" value="<%=session.getAttribute("FirstName")%>" /> 

            


                </body>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /.content-wrapper -->



  <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" />
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

       
       
           
  <!-- -->
  
        <!-- Bootstrap core JavaScript  -->
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

        <!-- Custom scripts for Option Box -->
        <script src="js/chosen.jquery.min.js" type="text/javascript"></script>
        <script src="js/prism.js" type="text/javascript" charset="utf-8"></script>
   
  
       
      
       
          

       
<div class="modal fade" id="transferModal" tabindex="-1" role="dialog" aria-labelledby="transferModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
           <h4 class="modal-title" id="exampleModalLabel1" >Update Rojnama</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
       
      </div>
    <div class="modal-body">
        
        
       <form method="POST" class="register" action='CaseDetailController' name="frmAddCaseDetail">
           
           
      <div class="form-group">
        <label for="recipient-name"  class="control-label">ID:</label>
        <input type="text"  style="width:200px;"  class="form-control"  name="ccd_id" id="ID" readonly />  
      </div>
      
          
            
      
        
        
          <div class="form-group">
        <label for="recipient-name"   class="control-label">Next Date:</label>
        <input type="text" date-format="DD/MMMM/YYYY" data-toggle="tooltip" title="Please Enter Next Case Date in dd/mm/yyyy format" placeholder="dd/mm/yyyy" pattern="(0[1-9]|1[0-9]|2[0-9]|3[01]).(0[1-9]|1[012]).[0-9]{4}" required=""  name="ccd_NextCurrentDate" class="form-control" id="date" style="width:80%;">
      </div>
         
        <p>       <label >Select Attending Advocate  : </label> 

                            <select data-placeholder="Select Advocate..." name ="ccd_AAdvocate" data-toggle="tooltip" title="Select Advocate Attending Case" required="" class="chosen-select1" style="width:36%;"  >
                                <option selected="true" disabled value="">Select Advocate</option>      
                                <c:forEach items="${advocates}" var="advocate">                                                
                                    <option value="${advocate.cam_FirstName}" ${advocate.cam_FirstName == casemdetail.ccd_AAdvocate ? 'selected' : ''}>${advocate.cam_FirstName}</option>
                                </c:forEach>
                            </select>                                          
                             <a href="CaseDetailController?action=AddAdvocate" ><button class="btn btn-primary btn-sm">+</button></a>
                            
       </p>


   <p>      
      <label>Select Case State  :</label> 

      <select data-placeholder="Select Case State..." required="" name ="ccd_Stage" data-toggle="tooltip" title="Select Correct Case Stage" class="chosen-select1" style="width:44.5%;" >
                              <option selected="true" disabled value="">Select Stage</option>       
                                <c:forEach items="${casestages}" var="casestage">                                                
                                    <option value="${casestage.ccs_StageName}" ${casestage.ccs_StageName == casemdetail.ccd_Stage ? 'selected' : ''}>${casestage.ccs_StageName}</option>
                                </c:forEach>
                            </select>     
                            <a href="CaseDetailController?action=AddCaseStage" ><button class="btn btn-primary btn-sm">+</button></a>

       

   </p>    
                            
                            
            <p> <label>Select Court  :</label> 
                            <select data-placeholder="Select Court..." name ="ccd_Court" class="chosen-select1" required="" data-toggle="tooltip" title="Select Court" style="width:48.5%;" >
                                <option value="" selected="true" disabled="">Select court</option>               
                                        <c:forEach items="${courts}" var="court">                                                
                                    <option  value="${court.ccm_CourtName}" ${court.ccm_CourtName == casemdetail.ccd_Court ? 'selected' : ''}>${court.ccm_CourtName}</option>
                                </c:forEach>
                            </select>   
                             <a href="CaseDetailController?action=AddCourt" ><button class="btn btn-primary btn-sm">+</button></a>
               
            </p>
      
   
        
        <div class="form-group">
        <label for="recipient-name"  class="control-label">Location:</label>
        <input type="text" name="ccd_CaseLocation" class="form-control" id="location"   style="width:80%;" required="" value="">
      </div>
        
        
        <div class="form-group">
        <label for="recipient-name"  class="control-label">Judge:</label>
        <input type="text" name="ccd_Judge" class="form-control" id="judge" required="" value="<c:out value="${casemdetail.ccd_Judge}" />"  style="width:80%;" >
      </div>
        
        
      <div class="form-group">
        <label for="recipient-name"  class="control-label">Judgment:</label>
        <input type="text" style="width:80%;" class="form-control"  placeholder="Judgment" name="ccd_Judgment" data-toggle="tooltip" title="Please Enter Judgement Given By The Judge" value="<c:out value="${casemdetail.ccd_Judgment}" />" required=""/> 
      </div>                          
                            
                            
      <div class="form-group">
        <label for="message-text"  class="control-label">Rojnama:</label>
        <textarea class="form-control" name="ccd_Rojnama" id="Rojnama"   style="width:80%;" required="" value=""></textarea>
      </div>
       
                      


      
           <div hidden="">
                          <input type="text"  style="width:200px;"  class="form-control" placeholder="CaseDetailID" name="cad_ID" id="cadid"  /> 
                        <input type="text"  style="width:200px;"  class="form-control" placeholder="ClientID" name="cmc_ID" id="cmcid" /> 
                        <input type="text"  style="width:auto;" class="form-control" placeholder="Registration No" name="cad_CaseNo" id="caseno" />
                        <input type="text"  style="width:auto;" class="form-control" placeholder="Registration No" name="cad_RegNo" value="<c:out value="${casemaster.cad_RegNo}" />" />
                        <input type="text"  style="width:auto;" class="form-control" placeholder="FileName" name="cad_FileName" id="filename" />  
                        <input type="text"  class="form-control"  placeholder="Previous Date" id="ccd_PreviousDate" name="ccd_PreviousDate" value="<fmt:formatDate value="${casemdetail.ccd_CurrentDate}" pattern="dd/MM/yyyy" />" /> 
                        <input type="text"  class="form-control"  name="ccd_EditFlag" value="update" /> 
                        <input type="text"  class="form-control"  name="ccd_DeleteFlag" value="<c:out value="${casedetail.ccd_DeleteFlag}" />" /> 
                        <input type="text"  class="form-control"  name="ccd_ActiveFlag" value="<c:out value="true" />" /> 
                        <input type="text"  class="form-control"  name="ccd_CreateDate" value="<fmt:formatDate pattern="dd/MM/yyyy" value="<%= new java.util.Date()%>" />" />                
                        <input type="text"  class="form-control"  name="ccd_CreateUser" value="<c:out value="${sessionScope.cmu_ID}" />"/>                 
                        <input type="text"  class="form-control"  name="ccd_ModifyDate" value="<fmt:formatDate pattern="dd/MM/yyyy" value="<%= new java.util.Date()%>" />" />                
                        <input type="text"  class="form-control"  name="ccd_ModifyUser" value="<c:out value="${sessionScope.cmu_ID}" />" /> 
                        <input type="text"  class="form-control"  name="ccd_CreateUserName" value="<%=session.getAttribute("FirstName")%>" /> 

           </div>
             <div class="modal-footer pull-left">
                     <button type="submit" name="SaveDetails"  class="btn btn-primary"   >Submit</button>
    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
 
  </div>
           
    </form>
  </div>

</div>
  </div></div>

   <script>
$('#transferModal').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget) // Button that triggered the modal
  var recipient = button.data('ccdid') // Extract info from data-* attributes
    var recipient1 = button.data('name') // Extract info from data-* attributes
      var recipient2 = button.data('msg') // Extract info from data-* attributes
       var recipient3 = button.data('court') // Extract info from data-* attributes
         var recipient4 = button.data('date') // Extract info from data-* attributes
           var recipient5 = button.data('judge') // Extract info from data-* attributes
             var recipient6 = button.data('location') // Extract info from data-* attributes
               var recipient7 = button.data('stage') // Extract info from data-* attributes
                var recipient8 = button.data('cadid') // Extract info from data-* attributes
                 var recipient9 = button.data('caseno') // Extract info from data-* attributes
                  var recipient10 = button.data('filename') // Extract info from data-* attributes
                   var recipient11 = button.data('cmcid') // Extract info from data-* attributes
                    var recipient12 = button.data('Judgment') // Extract info from data-* attributes
                     var recipient13 = button.data('remark') // Extract info from data-* attributes
  var modal = $(this)
  //modal.find('.modal-title').text('Edit Rojnama of Id: ' + recipient)
  modal.find('.modal-body  #ID').val(recipient)
   modal.find('.modal-body #Advname').val(recipient1)
      modal.find('.modal-body #Rojnama').val(recipient2)
        modal.find('.modal-body #court').val(recipient3)
        modal.find('.modal-body #date').val(recipient4)
         modal.find('.modal-body #judge').val(recipient5)
          modal.find('.modal-body #location').val(recipient6)
          modal.find('.modal-body #stage').val(recipient7)
           modal.find('.modal-body #cadid').val(recipient8)
            modal.find('.modal-body #caseno').val(recipient9)
            modal.find('.modal-body #filename').val(recipient10)
             modal.find('.modal-body #cmcid').val(recipient11)
               modal.find('.modal-body #judgement').val(recipient12)
                  modal.find('.modal-body #remark').val(recipient13)
          
          
   //alert(recipient12)
});
      </script>      

   
      
      
     <!-- Rojnama Modal-->
     
     <div class="modal fade" id="rojnama" tabindex="-1" role="dialog" aria-labelledby="rojnama">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
           <h4 class="modal-title" id="exampleModalLabel" >New Rojnama</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
       
      </div>
    <div class="modal-body">
        
        
           
       <form method="POST" class="register" action='CaseDetailController' name="frmAddCaseDetail">
  
           <div class="container">
               <div class="row">
                   
                   <div class="col-sm-4">
                       <label>Case ID : </label>  <input type="text" readonly="" style="width:auto;" class="form-control" placeholder="CaseID" name="cad_ID" id="caseid" />                        
                   </div>
                   
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
        <input type="text" data-toggle="tooltip" title="Please Enter Next Case Date in dd/mm/yyyy format" placeholder="dd/mm/yyyy"  name="ccd_NextCurrentDate" required="" class="form-control" id="date1" style="width:80%;">
      </div>
        
      

        
            <p>      
            <label >Select Attending Advocate  : </label> 

            <select data-placeholder="Select Advocate..." name ="ccd_AAdvocate" data-toggle="tooltip" title="Select Advocate Attending Case" required="" class="chosen-select1"  style="width:36%;"   >
                                <option selected="true" disabled value="">Select Advocate</option>      
                                <c:forEach items="${advocates}" var="advocate">                                                
                                    <option value="${advocate.cam_FirstName}" ${advocate.cam_FirstName == casemdetail.ccd_AAdvocate ? 'selected' : ''}>${advocate.cam_FirstName}</option>
                                </c:forEach>
                            </select>                                          
                             <a href="CaseDetailController?action=AddAdvocate" ><button class="btn btn-primary btn-sm">+</button></a>
                          
            </p>

     
   <p>      
      <label>Select Case State  :</label> 

      <select data-placeholder="Select Case State..." required="" name ="ccd_Stage" data-toggle="tooltip" title="Select Correct Case Stage" class="chosen-select1" style="width:44.5%;" >
                              <option selected="true" disabled value="">Select Stage</option>       
                                <c:forEach items="${casestages}" var="casestage">                                                
                                    <option value="${casestage.ccs_StageName}" ${casestage.ccs_StageName == casemdetail.ccd_Stage ? 'selected' : ''}>${casestage.ccs_StageName}</option>
                                </c:forEach>
                            </select>         
                             <a href="CaseDetailController?action=AddCaseStage" ><button class="btn btn-primary btn-sm">+</button></a>


                      
            </p>    
                            
                            
                            <p> <label>Select Court  :</label> 
                            <select data-placeholder="Select Court..." name ="ccd_Court" class="chosen-select1" required="" data-toggle="tooltip" title="Select Court" style="width:49%;" >
                                <option value="" selected="true" disabled="">Select court</option>               
                <c:forEach items="${courts}" var="court">                                                
                                    <option  value="${court.ccm_CourtName}" ${court.ccm_CourtName == casemdetail.ccd_Court ? 'selected' : ''}>${court.ccm_CourtName}</option>
                                </c:forEach>
                            </select>   
                             <a href="CaseDetailController?action=AddCourt" ><button class="btn btn-primary btn-sm">+</button></a>
                                
                            </p>      
  
        
        <div class="form-group">
        <label for="recipient-name"  class="control-label">Location:</label>
        <input type="text" name="ccd_CaseLocation" class="form-control" required=""  id="location" style="width:80%;">
      </div>
        
        
        <div class="form-group">
        <label for="recipient-name"  class="control-label">Judge:</label>
        <input type="text" name="ccd_Judge" class="form-control" id="judge" required=""  style="width:80%;">
      </div>
          
         <div class="form-group">
        <label for="message-text"  class="control-label">Judgment</label>
        <textarea class="form-control" name="ccd_Judgment" id="judgement"  required="" style="width:80%;"></textarea>
      </div>
        
      <div class="form-group">
        <label for="message-text"  class="control-label">Rojnama:</label>
        <textarea class="form-control" name="ccd_Rojnama" id="Rojnama"  required="" style="width:80%;"></textarea>
      </div>
       
     
           
   
           <div hidden="">
                        <input type="text"  style="width:200px;"  class="form-control" placeholder="ClientID" name="cmc_ID" id="clientid" /> 
                        <input type="text"  style="width:auto;" class="form-control" placeholder="Registration No" name="cad_RegNo" value="<c:out value="${casemaster.cad_RegNo}" />" />
                        <input type="text"  style="width:200px;"  class="form-control" placeholder="CaseMasterID" name="ccd_id" id="ID" value="<c:out value="${casemaster.cad_ID}" />" /> 
                        <input type="text" style="width:200px;"  class="form-control" placeholder="CaseDetailID" name="LastDetail_ID" value="<c:out value="${casemdetail.ccd_ID}" />" />     
                        <input type="text"  style="width:200px;"  class="form-control" placeholder="CaseDetailID" name="ccd_id"  id="ID" value="<c:out value="${casemdetail.ccd_ID}" />" /> 
                        <input type="text"  class="form-control"  placeholder="Previous Date" id="ccd_PreviousDate" name="ccd_PreviousDate" value="<fmt:formatDate value="${casemdetail.ccd_CurrentDate}" pattern="dd/MM/yyyy" />" /> 
                        <input type="text"  class="form-control"  name="ccd_EditFlag" value="SaveDetails" /> 
                        <input type="text"  class="form-control"  name="ccd_DeleteFlag" value="<c:out value="${casedetail.ccd_DeleteFlag}" />" /> 
                        <input type="text"  class="form-control"  name="ccd_ActiveFlag" value="<c:out value="true" />" /> 
                        <input type="text"  class="form-control"  name="ccd_CreateDate" value="<fmt:formatDate pattern="dd/MM/yyyy" value="<%= new java.util.Date()%>" />" />                
                        <input type="text"  class="form-control"  name="ccd_CreateUser" value="<c:out value="${sessionScope.cmu_ID}" />"/>                 
                        <input type="text"  class="form-control"  name="ccd_ModifyDate" value="<fmt:formatDate pattern="dd/MM/yyyy" value="<%= new java.util.Date()%>" />" />                
                        <input type="text"  class="form-control"  name="ccd_ModifyUser" value="<c:out value="${sessionScope.cmu_ID}" />" /> 
                        <input type="text"  class="form-control"  name="ccd_CreateUserName" value="<%=session.getAttribute("FirstName")%>" /> 

           </div>
                        
               <input type="checkbox"  id="defaultUnchecked" name="Document" value="1" >
    <label class="custom-control-label" for="defaultUnchecked">Do you want to upload Case Documents</label>
    <br>
             <div class="modal-footer pull-left" >
               
                     
                       <button type="submit" name="SaveDetails" id="SaveDetails1" class="btn btn-primary pull-left"    >Submit</button>
                    
            
   
     <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
  </div>
           
    </form>
  </div>

</div>
  </div></div>

   <script>
$('#rojnama').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget) // Button that triggered the modal
  var caseid = button.data('caseid') // Extract info from data-* attributes
    var casename = button.data('casename') // Extract info from data-* attributes
      var filename = button.data('filename') // Extract info from data-* attributes
      var clientid=button.data('clientid')


    
  var modal = $(this)
 
  modal.find('.modal-body  #caseid').val(caseid)
 
      modal.find('.modal-body #casename').val(casename)
        modal.find('.modal-body #filename').val(filename)
         modal.find('.modal-body #clientid').val(clientid)
      
          
          
   
});
      </script>      

      
           <script type="text/javascript">
            var config = {
                '.chosen-select': {},
                '.chosen-select-deselect': {allow_single_deselect: true},
                '.chosen-select-no-single': {disable_search_threshold: 10},
                '.chosen-select-no-results': {no_results_text: 'Oops, nothing found!'},
                '.chosen-select-width': {width: "95%"}
            }
            for (var selector in config) {
                $(selector).chosen(config[selector]);
            }
        </script>
        <script type="text/javascript">
            $(".myselect").select2();
        </script> 

      
      
  
    </body>

</html>

