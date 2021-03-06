<%-- 
    Document   : ctsClientCaseDiary
    Created on : 11 May, 2018, 5:43:01 PM
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


    </head>

    <body class="fixed-nav sticky-footer bg-dark" id="page-top">

                      <!-- Navigation -->
            <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
            <a class="navbar-brand" href="#">CTS</a>
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
                    <li class="nav-item active" data-toggle="tooltip" data-placement="right" title="Dashboard">
                        <a class="nav-link" href="ClientDashBoardController?action=listDairy">
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
                            <li>
                                <a href="ClientCaseDetailsController?action=listCaseDetail">Case Diary</a>
                            </li>
                      

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
                        <a href="#">Dashboard</a>
                    </li>
                    <li class="breadcrumb-item active">My Dashboard</li>
                </ol>

                <h1>Maintain Case Dairy</h1>
                <body class="bg-dark">


                    <form method="POST" class="register" action='ClientCaseDetailsController' name="frmAddCaseDetail">

                        <p> <select data-placeholder="Select Case..." name ="cad_FileName1" class="chosen-select" style="width:90%"  >
                                <option selected disabled>Select Case</option>
                                <c:forEach items="${casemasters}" var="casemaster">                                                         
                                    <option value="${casemaster.cad_ID}" ${casemaster.cad_ID == casedetail.cad_ID ? 'selected' : ''}>${casemaster.cad_CaseNo} || ${casemaster.cad_FileName}</option>
                                </c:forEach>
                            </select>


                        </p>

                        <p>
                            <button type="submit" name="GetDetails" value="GetDetails" style="width:30%" class="btn btn-primary">Get Details</button> 


                        </p>

                        <P><label>Case ID : </label> <label><c:out value="${casemaster.cad_ID}" /> </label> </p>                        
                        <P><label>Case Number : </label> <label><c:out value="${casemaster.cad_CaseNo}" /> </label> </p>
                        <P><label>File Name : </label> <label><c:out value="${casemaster.cad_FileName}" /> </label></p>


                        <div class="card mb-3">
                            <div class="card-header">
                                <i class="fa fa-table"></i>
                                Case History
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" width="100%" id="dataTable" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>Update</th>
                                                <th>Delete</th>                                                                                                                                                                                                     
                                                <th>Previous Date(s)</th>
                                                <th>Attending Adv.</th>
                                                <th>Stage</th>
                                                <th>Location</th>                    
                                                <th>Judge</th>                    
                                                <th>Rojnama</th>                                                                              
                                                <th>Court</th> 
                                                <th>Create UserName</th>
                                                <th>Modify UserName</th>                                         
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th>Update</th>
                                                <th>Delete</th>                                                                                                                                                                                                     
                                                <th>Previous Date(s)</th>
                                                <th>Attending Adv.</th>
                                                <th>Stage</th>
                                                <th>Location</th>                    
                                                <th>Judge</th>                    
                                                <th>Rojnama</th>                                                                              
                                                <th>Court</th> 
                                                <th>Create UserName</th>
                                                <th>Modify UserName</th>                                         
                                            </tr>
                                        </tfoot>
                                        <tbody>
                                            <c:forEach items="${casedetails}" var="casedetail">
                                                <tr>

                                                    <td><a  href="CaseDetailController?action=edit&CaseDetailID=<c:out value="${casedetail.ccd_ID}"/>">Edit</a></td>
                                                    <td><a href="CaseDetailController?action=delete&CaseDetailID=<c:out value="${casedetail.ccd_ID}"/>">Delete</a></td>

                                                    <td><fmt:formatDate value="${casedetail.ccd_CurrentDate}" pattern="dd/MM/yyyy" /></td>
                                                    <td><c:out value="${casedetail.ccd_AAdvocate}" /></td>
                                                    <td><c:out value="${casedetail.ccd_Stage}" /></td>
                                                    <td><c:out value="${casedetail.ccd_CaseLocation}" /></td>
                                                    <td><c:out value="${casedetail.ccd_Judge}" /></td>
                                                    <td><c:out value="${casedetail.ccd_Rojnama}" /></td>                                                                
                                                    <td><c:out value="${casedetail.ccd_Court}" /></td>                                                                
                                                    <td><c:out value="${casedetail.ccd_CreateUserName}" /></td>
                                                    <td><c:out value="${casedetail.ccd_ModifyUserName}" /></td>

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





                        <!-- Bootstrap core JavaScript -->
                        <script src="vendor/jquery/jquery.min.js"></script>
                        <script src="vendor/popper/popper.min.js"></script>
                        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

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


        <!-- Bootstrap core JavaScript 
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/popper/popper.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>-->

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



    </body>

</html>