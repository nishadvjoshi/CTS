<%-- 
    Document   : ctsCaseDocuments
    Created on : 25 Jun, 2018, 1:48:46 PM
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

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>
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
                $("#ccp_PaymentDate").keyup(function () {
                    if ($(this).val().length == 2 || $(this).val().length == 5) {
                        $(this).val($(this).val() + "/");
                    }
                });
            });
        </script>
        <script>
            $(document).ready(function () {
                $("#ccp_PaymentChequeDate").keyup(function () {
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
            function isNumber(evt) {
                evt = (evt) ? evt : window.event;
                var charCode = (evt.which) ? evt.which : evt.keyCode;
                if (charCode > 31 && (charCode < 48 || charCode > 57)) {
                    return false;
                }
                return true;
            }
        </script>

        <script>
            function validatedate(inputText)
            {
                var dateformat = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;
                // Match the date format through regular expression
                if (inputText.value.match(dateformat))
                {
                    document.frmAddCasePayment.ccp_PaymentDate.focus();
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
                            alert('Invalid Payment Date format! Please use dd/mm/yyyy format.');
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
                            alert('Invalid Payment Date format! Please use dd/mm/yyyy format.');
                            return false;
                        }
                        if ((lyear == true) && (dd > 29))
                        {
                            alert('Invalid Payment Date format! Please use dd/mm/yyyy format.');
                            return false;
                        }
                    }
                }
                else
                {
                    alert("Invalid Payment Date format! Please use dd/mm/yyyy format.");
                    document.frmAddCasePayment.ccp_PaymentDate.focus();
                    return false;
                }
            }
        </script>
        <script>
            var $ccp_PaymentType = $('#ccp_PaymentType'),
                    $ccp_PaymentChequeNo = $('#ccp_PaymentChequeNo');
            $state.change(function () {
                if ($ccp_PaymentType.val() == 'CASH') {
                    $ccp_PaymentChequeNo.removeAttr('disabled');
                } else {
                    $ccp_PaymentChequeNo.attr('disabled', 'disabled').val('');
                }
            }).trigger('change'); // added trigger to calculate initial state
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

                <h1>Upload Case Documents</h1>
                <body class="bg-dark">

                    <form role="form" method="POST" class="register" action='CaseDocumentController' name="frmUploadDocuments" >
                        <div class="form-group">
                            <p>

                                <select data-placeholder="Select Case..." name ="cad_FileName1" required="" data-toggle="tooltip" title="Select Case" class="chosen-select" style="width:450px;" >
                                 <option selected disabled value="">Select Case</option>
                                    <c:forEach items="${casemasters}" var="casemaster">                                                
                                        <option value="${casemaster.cad_ID}" ${casedetail.cad_ID == casemaster.cad_ID ? 'selected' : ''}>${casemaster.cad_CaseNo} || ${casemaster.cad_FileName}</option>
                                    </c:forEach>
                                </select>

                                <button type="submit" name="GetDetails" value="GetDetails" class="btn btn-primary">Get Details</button> 



                            </p>
                            <div class="form-group">
                                <p>
                                    <input type="text" readonly="readonly" style="width:70%" class="form-control" placeholder="Case Number" name="cad_CaseNo" value="<c:out value="${casedetail.cad_CaseNo}" />" /> 
                                </p>

                                <p>     
                                    <input type="text" readonly="readonly" style="width:70%;" class="form-control" placeholder="File Name" name="cad_FileName" value="<c:out value="${casedetail.cad_FileName}" />" /> 
                                </p>
                                <p>
                                    <input type="text" readonly="readonly" style="width:70%;" class="form-control" placeholder="Client Name" name="cad_ClientName" value="<c:out value="${casedetail.cad_ClientName}" />" />

                                </p>

                                <input type="hidden" readonly="readonly" style="width:70%;"  class="form-control" placeholder="File Number" name="cad_FileNo" value="<c:out value="${casedetail.cad_FileNo}" />" />
                                <input type="hidden" readonly="readonly" style="width:70%;" class="form-control" placeholder="Registration No" name="cad_RegNo" value="<c:out value="${casedetail.cad_RegNo}" />" /> 
                                <input type="hidden" readonly="readonly" style="width:70%;"  class="form-control" placeholder="Case ID" name="cad_id" value="<c:out value="${casedetail.cad_ID}" />" />
                                <input type="hidden" readonly="readonly" style="width:200px;"  class="form-control" placeholder="CaseExpenseID" name="cce_ID" value="<c:out value="${caseexpense.cce_ID}" />" />
                                <input type="hidden" readonly="readonly" style="width:200px;"  class="form-control" placeholder="Case ID" name="pcad_ID" value="<c:out value="${caseexpense.cad_ID}" />" />
                                <input type="hidden"  class="form-control" name="cdd_DeleteFlag" value="<c:out value="0"/>" /> 
                                <input type="hidden"  class="form-control" name="cdd_ActiveFlag" value="<c:out value="true" />" /> 
                                <input type="hidden"  class="form-control" name="cdd_CreateDate" value="<fmt:formatDate pattern="dd/MM/yyyy" value="<%= new java.util.Date()%>" />" />                
                                <input type="hidden"  class="form-control" name="cdd_CreateUser" value="<c:out value="1" />" />                 
                                <input type="hidden"  class="form-control" name="cdd_ModifyDate" value="<fmt:formatDate pattern="dd/MM/yyyy" value="<%= new java.util.Date()%>" />" />                
                                <input type="hidden"  class="form-control" name="cdd_ModifyUser" value="<c:out value="1" />" /> 


                            </div>


                        </div>  

                        <div class="card mb-3">
                            <div class="card-header">
                                <i class="fa fa-table"></i>
                                Document Uploaded So far
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" width="100%" id="dataTable" cellspacing="0">                    <thead>
                                            <tr>

                                                <th>Download</th>
                                                <th>Document Name</th>
                                                <th>Document Type</th>
                                                <th>Upload Date</th>

                                            </tr>
                                        </thead>

                                        <tbody>
                                            <c:forEach items="${casedocuments}" var="casedocument">
                                                <tr>

                                                    <td><a href="CaseDocumentController?action=download&FileName=<c:out value="${casedocument.cdd_DocumentName}"/>">Download</a></td>
                                                    <td><c:out value="${casedocument.cdd_DocumentName}" /></td>
                                                    <td><c:out value="${casedocument.cdd_DocumentType}" /></td>
                                                    <td><c:out value="${casedocument.cdd_CreateDate}" /></td>
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
            </div>

        </form>

        <form role="form" method="POST" class="register" action="CaseDocumentController" enctype="multipart/form-data" >
            <div class="form-group">            

                Choose a file : <input type="file" name="file" multiple>
                <input type="submit" class="btn btn-primary" value="upload">

                <div id="result">
                    <h3>${requestScope["message"]}</h3>
                    <br>
                </div>
                     File name : ${requestScope["name"]}
                <br> File size : ${requestScope["size"]}
                <br> File type : ${requestScope["type"]}
            </div>
                </form>


              

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



        <!-- 
        Bootstrap core JavaScript   -->
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

   



</body>

</html>
