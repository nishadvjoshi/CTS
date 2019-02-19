<%-- 
    Document   : ctsAddCaseMaster
    Created on : 16 Jun, 2018, 1:54:02 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

        <link rel="stylesheet" href="css/prism.css">
        <link rel="stylesheet" href="css/chosen.css">


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
               
               
               
               
        <div class="content-wrapper">

            <div class="container-fluid">

                <!-- Breadcrumbs -->
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="#">Dashboard</a>
                    </li>
                    <li class="breadcrumb-item active">My Dashboard</li>
                </ol>

                <h1>Manage Cases</h1>
                <!-- Example Tables Card -->

                <form role="form" method="POST" class="register" action='CaseMasterController' name="frmAddCaseMaster">


                    <p>
                        <input type="hidden" readonly="readonly"  class="form-control" placeholder="Case ID will be allocated by the system..." name="CaseMasterID" id="CaseMasterID" value="<c:out value="${casemaster.cad_ID}" />" /> 
                    </p>    
                    <p>     
                        <input type="readonly" readonly="readonly" style="width:480px;" class="form-control" placeholder="Registration No" name="cad_RegNo" value="<c:out value="${casemaster.cad_RegNo}" />" required />
                    <lable>&nbsp;&nbsp;&nbsp;&nbsp;</lable> </td>
                    <input type="text" style="width:80%;" class="form-control" placeholder="Case Type (CL,CR,DRT...)" name="cad_CaseType" data-toggle="tooltip" title="Please Mention Case Type (Civil, Criminal, etc.) " value="<c:out value="${casemaster.cad_CaseType}" />" required /> 

                    </p>


                    <p>
                        <input type="text" style="width:80%;" class="form-control" placeholder="Asset Code (For ARCIL case)" name="cad_AssetCode" data-toggle="tooltip" title="Please Enter AssetCode for ARCIL cases" value="<c:out value="${casemaster.cad_AssetCode}" />" />                                             
                    </p>
                    <p> 
                        <label style="width:10%;">Select Client</label>
                        <select data-placeholder="Select Client..." name ="cad_ClientName" class="chosen-select" style="width:70%;" >
                            <c:forEach items="${clients}" var="client">                                                
                                <option value="${client.cmc_ID}">${client.cmc_FirstName}</option>
                            </c:forEach>
                        </select>  

                    </p>
                    <p>     

                        <input type="text"  style="width:80%;" class="form-control" placeholder="Case Number" name="cad_CaseNo" data-toggle="tooltip" title="Please Enter Case Number" value="<c:out value="${casemaster.cad_CaseNo}" />" /> 
                    <lable>&nbsp;&nbsp;&nbsp;&nbsp;</lable> 
                    <input type="text" style="width:80%;" class="form-control" placeholder="File Number" name="cad_FileNo" data-toggle="tooltip" title="Please Enter File Number" value="<c:out value="${casemaster.cad_FileNo}" />"  /> 

                    </p>

                    <p>                                        
                        <input type="text" style="width:80%;" class="form-control" placeholder="File Name (ClientName vs Opponent)" name="cad_FileName" data-toggle="tooltip" title="Please Enter File Name" value="<c:out value="${casemaster.cad_FileName}" />" required /> 
                    </p>

                    <p>     
                        <input type="text" style="width:80%;"  class="form-control" placeholder="Case Location" name="cad_Location" data-toggle="tooltip" title="Please Enter Case Location" value="<c:out value="${casemaster.cad_Location}" />" /> 
                    <lable>&nbsp;&nbsp;&nbsp;&nbsp;</lable> </td>
                    <input type="text"  style="width:80%;" class="form-control" placeholder="Court Name" name="cad_Court" data-toggle="tooltip" title="Please Enter Court Name" value="<c:out value="${casemaster.cad_Court}" />" />
                    <lable>&nbsp;&nbsp;&nbsp;&nbsp;</lable> </td>
                    <input type="text"  style="width:80%;" class="form-control" placeholder="Appearing for..." name="cad_AppearingFor" data-toggle="tooltip" title="Please Enter Client Name" value="<c:out value="${casemaster.cad_AppearingFor}" />" />  

                    </p>
                    <p>
                        <label style="width:20.5%;">Select Attending Advocate</label> 
                  

                    <select data-placeholder="Select Attending Advocate..." name ="cad_Advocate" class="chosen-select" style="width:30%;" >
                        <c:forEach items="${advocates}" var="advocate">                                                
                            <option value="${advocate.cam_ID}">${advocate.cam_FirstName}</option>
                        </c:forEach>
                    </select>  

                    </p>
                    <p>     
                        <label style="width:20.5%;">Vakilpatra Filed By Advocate</label> 
                   

                    <select data-placeholder="Select Advocate..." name ="cad_VakilPatraFiledBy" class="chosen-select" style="width:30%;" >
                        <c:forEach items="${advocates}" var="advocate">                                                
                            <option value="${advocate.cam_ID}">${advocate.cam_FirstName}</option>
                        </c:forEach>
                    </select>  

                    </p>
                    <p>
                        <label style="width:40%;" > <input type="checkbox" value="" id="cboxToggle" name="cboxToggle" onClick="Toggle();" checked>Set Default Date for Vakil Patra Filed On </label> 
                        <input type="text" style="width:40%;"  class="form-control" placeholder="Vakil patra on date in dd/mm/yyyy format" name="cad_VakilPatraFiledOn" value="<c:out value="${casemaster.cad_VakilPatraFiledOn}" />" required /> 


                    </p>


                    <p>
                        <input type="text" style="width:40%;" class="form-control" placeholder="ACT" name="cad_ACT" data-toggle="tooltip" title="Under which ACT case was filed" value="<c:out value="${casemaster.cad_ACT}" />" required />  
                    <lable>&nbsp;&nbsp;&nbsp;&nbsp;</lable> 
                    <input type="text" style="width:40%;" class="form-control" placeholder="Case Stage" name="cad_Stage" data-toggle="tooltip" title="Please Enter Case Stage" value="<c:out value="${casemaster.cad_Stage}" />" required /> 




                    </p>

                    <p>
                        <input type="text" style="width:40%;" class="form-control" placeholder="Opponent Name " name="cad_OpponentName" data-toggle="tooltip" title="Please Enter Opponent's Name" value="<c:out value="${casemaster.cad_OpponentName}" />" />  
                    <lable>&nbsp;&nbsp;&nbsp;&nbsp;</lable> </td>
                    <input type="text" style="width:40%;" class="form-control" placeholder="Opponent Advocate Name" name="cad_OpponentAdvocate" data-toggle="tooltip" title="Please Enter Opponent Advocate's Name" value="<c:out value="${casemaster.cad_OpponentAdvocate}" />" /> 



                    </p>
                    <p>
                        <input type="text" style="width:40%;" class="form-control" placeholder="Remarks" name="cad_Remarks" data-toggle="tooltip" title="Please Enter Remarks" value="<c:out value="${casemaster.cad_Remarks}" />" />  
                    <lable>&nbsp;&nbsp;&nbsp;&nbsp;</lable> 
                    <input type="text" style="width:40%;" class="form-control" placeholder="Other Information" name="cad_OtherInfo" value="<c:out value="${casemaster.cad_OtherInfo}" />" />



                    </p>



                    <input type="hidden"  class="form-control" placeholder="Case Category" name="cad_CaseCategory" value="<c:out value="${casemaster.cad_CaseCategory}" />" /> 
                    <input type="hidden"  class="form-control" name="cad_DeleteFlag" value="<c:out value="false" />" /> 
                    <input type="hidden"  class="form-control" name="cad_ActiveFlag" value="<c:out value="true" />" /> 
                    <input type="hidden"  class="form-control" name="cad_CreateDate" value="<fmt:formatDate pattern="MM/dd/yyyy" value="<%= new java.util.Date()%>" />" />                
                    <input type="hidden"  class="form-control" name="cad_CreateUser" value="<c:out value="1" />" />                 
                    <input type="hidden"  class="form-control" name="cad_ModifyDate" value="<fmt:formatDate pattern="MM/dd/yyyy" value="<%= new java.util.Date()%>" />" />                
                    <input type="hidden"  class="form-control" name="cad_ModifyUser" value="<c:out value="1" />" /> 
                    <p>
                        <button type="submit" name="SaveDetails" id="SaveDetails" class="btn btn-primary">Submit</button>                            
                        <button type="reset" class="btn btn-default">Reset Button</button>
                    </p>
            </div>

            <script>
                Toggle();
                function Toggle() {
                    if (document.frmAddCaseMaster.cboxToggle.checked) {
                        document.frmAddCaseMaster.cad_VakilPatraFiledOn.value = '01/01/2016';
                    }
                    else {
                        document.frmAddCaseMaster.cad_VakilPatraFiledOn.value = '';
                    }
                }
            </script>
        </form>  






    </div>
    <!-- /.container-fluid -->

    <!-- /.container-fluid -->


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

<!-- Custom scripts for Option Box -->
<script src="js/chosen.jquery.min.js" type="text/javascript"></script>
<script src="js/prism.js" type="text/javascript" charset="utf-8"></script>
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

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>


<script>$('#casestageModal').on('show.bs.modal', function (e) {

            //get data-id attribute of the clicked element
            var CaseStageName = $(e.relatedTarget).data('ccs_StageName');

            //populate the textbox
            $(e.currentTarget).find('input[name="ccs_StageName"]').val(CaseStageName);
        });</script>

</body>

</html>


