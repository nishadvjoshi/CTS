<%-- 
    Document   : ctsAddAdvocate
    Created on : 3 Oct, 2017, 2:46:03 PM
    Author     : Admin
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        <script>
            $(document).ready(function () {
                $("#cam_DOB").keyup(function () {
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
                    document.frmAddAdvocate.cam_DOB.focus();
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
                    document.frmAddAdvocate.cam_DOB.focus();
                    return false;
                }
            }
        </script>

        <script>
            $.validator.setDefaults({
            submitHandler: function () {
                alert("submitted!");
            }
            });
            });</script>

        <style>
            div.dataTables_wrapper {
                width: 1100px;
                margin: 0 auto;
            }
        </style>
        <script>
                    function FillBilling(f) {


                        if (f.billingtoo.checked) {

                            f.cam_PAddr1.value = f.cam_Addr1.value;
                            f.cam_PAddr2.value = f.cam_Addr2.value;
                            f.cam_PNearLocation.value = f.cam_NearLocation.value;
                            f.cam_PDistrict.value = f.cam_District.value;
                            f.cam_PCity.value = f.cam_City.value;
                            f.cam_PState.value = f.cam_State.value;
                            f.cam_PState.value = f.cam_State.value;
                            f.cam_PZipCode.value = f.cam_ZipCode.value;

                        } else {
                            f.cam_PAddr1.value = '';
                            f.cam_PAddr2.value = '';
                            f.cam_PNearLocation.value = '';
                            f.cam_PDistrict.value = '';
                            f.cam_PCity.value = '';
                            f.cam_PState.value = '';
                            f.cam_PState.value = '';
                            f.cam_PZipCode.value = '';

                        }
                    }


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

                <h1>Manage Advocates</h1>
                <!-- Example Tables Card -->

                <form role="form" method="POST" class="register" id="commentForm" action='AdvocateController' name="frmAddAdvocate">
                    <div class="form-group">

                        <p>
                            <input type="text"  class="form-control"   placeholder="AdvocateID will be allocated by the system..." readonly="readonly" name="AdvocateID" value="<c:out value="${advocate.cam_ID}" />" />
                        </p>
                        <p>
                            <input type="text"  class="form-control"  placeholder="Enter FirstName MiddleName LastName" name="cam_FirstName" data-toggle="tooltip" title="Please Enter Advocate's Full Name"  value="<c:out value="${advocate.cam_FirstName}" />" required />                        </p>
                        <p>
                            <input type="text"  class="form-control"  placeholder="Associate / Opponent" name="cam_AdvocateType" data-toggle="tooltip" title="Is Advocate Your Associate Or Opponent" value="<c:out value="${advocate.cam_AdvocateType}" />" required />
                        </p>
                        <p>
                            <input type="text"  class="form-control"  placeholder="Enter Sanad Number" name="cam_AdvocateCode" data-toggle="tooltip" title="Please Enter Sanad Number" value="<c:out value="${advocate.cam_AdvocateCode}" />" required/>
                        </p>
                        <p>

                            <input type="text"  class="form-control"  placeholder="Enter License Number" name="cam_LicenseNo" data-toggle="tooltip" title="Please Enter Advocate's License Number" value="<c:out value="${advocate.cam_LicenseNo}" />" required/>
                        </p>

                        <p> <input type="text"  class="form-control"  placeholder="Enter Passport Number" name="cam_PassportNo" data-toggle="tooltip" title="Please Enter Passport Number" value="<c:out value="${advocate.cam_PassportNo}" />" required/> </p>

                        <p> <input type="text"  class="form-control"  placeholder="Enter Date of Birth dd/MM/yyyy format" id="cam_DOB" name="cam_DOB" data-toggle="tooltip" title="Please Enter Birth Date in dd/mm/yyyy format" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${advocate.cam_DOB}" />" required/>  </p>

                        <p> <input type="text"  class="form-control"   placeholder="Enter Primary EmailID" name="cam_EmailID1" data-toggle="tooltip" title="Please Enter Primary EmailID" value="<c:out value="${advocate.cam_EmailID1}" />" required/> </p>                                           

                        <p> <input type="text"  class="form-control"  placeholder="Enter Alternate EmailID" name="cam_EmailID2" data-toggle="tooltip" title="Please Enter Secondary EmailID" value="<c:out value="${advocate.cam_EmailID2}" />" /> </p>

                        <p> <input type="text"  class="form-control"  placeholder="Enter Primary Mobile Number" name="cam_CellNo1" data-toggle="tooltip" title="Please Enter Primary Cell Number" value="<c:out value="${advocate.cam_CellNo1}" />" onkeypress="return isNumber(event)" required/> </p>

                        <p> <input type="text"  class="form-control"  placeholder="Enter Alternate Mobile Number" name="cam_CellNo2" data-toggle="tooltip" title="Please Enter Secondary Cell Number" value="<c:out value="${advocate.cam_CellNo2}" />" onkeypress="return isNumber(event)" /> </p>

                        <p> <input type="text"  class="form-control"  placeholder="Enter Landline Number" name="cam_LandlineNo" data-toggle="tooltip" title="Please Enter Landline Number" value="<c:out value="${advocate.cam_LandlineNo}" />" onkeypress="return isNumber(event)" /> </p>

                        <p> <input type="text"  class="form-control"  placeholder="Enter flat, building number, etc..." name="cam_Addr1" data-toggle="tooltip" title="Please Enter Flat/Building name" value="<c:out value="${advocate.cam_Addr1}" />" required/> </p>

                        <p> <input type="text"  class="form-control"  placeholder="Enter Street, area, etc." name="cam_Addr2" data-toggle="tooltip" title="Please Enter Street Name / Area" value="<c:out value="${advocate.cam_Addr2}" />" /> </p>

                        <p> <input type="text"  class="form-control"  placeholder="Enter nearby location" name="cam_NearLocation" data-toggle="tooltip" title="Please Enter Nearby Location" value="<c:out value="${advocate.cam_NearLocation}" />" /> </p>

                        <p><input type="text"  class="form-control"  placeholder="Enter District" name="cam_District" data-toggle="tooltip" title="Please Enter District Name" value="<c:out value="${advocate.cam_District}" />" required/> </p>

                        <p> <input type="text"  class="form-control"  placeholder="Enter City" name="cam_City" data-toggle="tooltip" title="Please Enter City Name" value="<c:out value="${advocate.cam_City}" />" required/>  </p>

                        <p> <input type="text"  class="form-control"  placeholder="Enter Zipcode" name="cam_ZipCode" data-toggle="tooltip" title="Please Enter Zip Code" value="<c:out value="${advocate.cam_ZipCode}" />" onkeypress="return isNumber(event)" required/>  </p>    

                        <p> <input type="text"  class="form-control"  placeholder="Enter State" name="cam_State" data-toggle="tooltip" title="Please Enter State Name" value="<c:out value="${advocate.cam_State}" />" required/> </p>

                        <p><input type="text"  class="form-control"  placeholder="Enter Country" name="cam_Country" data-toggle="tooltip" title="Please Enter Country Name" value="<c:out value="${advocate.cam_Country}" />" required/> </p>

                        <p>
                            <input type="checkbox" onclick="FillBilling(this.form)" name="billingtoo">
                            <label> Permanent Address is same as Present Address </label>
                        </p>

                        <p> <input type="text"  class="form-control"  placeholder="Enter flat, building number, etc..." name="cam_PAddr1" data-toggle="tooltip" title="Please Enter Flat/Building name" value="<c:out value="${advocate.cam_PAddr1}" />" /> </p>

                        <p> <input type="text"  class="form-control"  placeholder="Enter Street, area, etc." name="cam_PAddr2" data-toggle="tooltip" title="Please Enter Street Name / Area"  value="<c:out value="${advocate.cam_PAddr2}" />" />  </p>

                        <p> <input type="text"  class="form-control"  placeholder="Enter nearby location" name="cam_PNearLocation" data-toggle="tooltip" title="Please Enter Nearby Location"  value="<c:out value="${advocate.cam_PNearLocation}" />" /> </p>    

                        <p> <input type="text"  class="form-control"  placeholder="Enter District" name="cam_PDistrict" data-toggle="tooltip" title="Please Enter District Name" value="<c:out value="${advocate.cam_PDistrict}" />" /> </p>

                        <p> <input type="text"  class="form-control"  placeholder="Enter City" name="cam_PCity" data-toggle="tooltip" title="Please Enter City Name" value="<c:out value="${advocate.cam_PCity}" />" />  </p>

                        <p> <input type="text"  class="form-control"  placeholder="Enter Zipcode" name="cam_PZipCode" data-toggle="tooltip" title="Please Enter Zip Code" value="<c:out value="${advocate.cam_PZipCode}" />" onkeypress="return isNumber(event)" />  </p>    

                        <p> <input type="text"  class="form-control"  placeholder="Enter State" name="cam_PState" data-toggle="tooltip" title="Please Enter State Name" value="<c:out value="${advocate.cam_PState}" />" /> </p>

                        <p> <input type="text"  class="form-control"  placeholder="Enter Country" name="cam_PCountry" data-toggle="tooltip" title="Please Enter Country Name" value="<c:out value="${advocate.cam_PCountry}" />" /> </p>


                        <input type="hidden"  class="form-control" name="cam_DeleteFlag" value="<c:out value="false" />" /> 
                        <input type="hidden"  class="form-control" name="cam_ActiveFlag" value="<c:out value="true" />" /> 
                        <input type="hidden"  class="form-control" name="cam_CreateDate" value="<fmt:formatDate pattern="MM/dd/yyyy" value="<%= new java.util.Date()%>" />" />                
                        <input type="hidden"  class="form-control" name="cam_CreateUser" value="<c:out value="1" />" />                 
                        <input type="hidden"  class="form-control" name="cam_ModifyDate" value="<fmt:formatDate pattern="MM/dd/yyyy" value="<%= new java.util.Date()%>" />" />                
                        <input type="hidden"  class="form-control" name="cam_ModifyUser" value="<c:out value="1" />" /> 
                        <p>
                            <button type="submit" class="btn btn-primary" onclick="return  validatedate(document.frmAddAdvocate.cam_DOB)">Submit</button>                            
                            <button type="reset" class="btn btn-default">Reset Button</button>
                        </p>
                    </div>

                </form>


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

        <script>$('#casestageModal').on('show.bs.modal', function (e) {

                                    //get data-id attribute of the clicked element
                                    var CaseStageName = $(e.relatedTarget).data('ccs_StageName');

                                    //populate the textbox
                                    $(e.currentTarget).find('input[name="ccs_StageName"]').val(CaseStageName);
                                });</script>

    </body>

</html>

