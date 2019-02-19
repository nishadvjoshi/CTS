<%-- 
    Document   : ctsRojnama
    Created on : 23 Nov, 2017, 3:27:00 PM
    Author     : Admin
--%>

<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

    <head>



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


    </head>

    <body class="fixed-nav sticky-footer bg-dark" id="page-top">

  



            <div class="container-fluid">

               

                <h1>Maintain Case Dairy</h1>
             

                    <form method="POST" class="register" action='CaseDetailController' name="frmAddCaseDetail">


                        
                        
                        <p> <label>Enter Next Date : </label> <input type="text" style="width:80%" class="form-control"  id="ccd_NextCurrentDate" name="ccd_NextCurrentDate" data-toggle="tooltip" title="Please Enter Next Case Date in dd/mm/yyyy format" value="<fmt:formatDate value="${casemdetail.ccd_CurrentDate}" pattern="dd/MM/yyyy" />" /></p>
                        <p> <label >Select Attending Advocate  : </label> 

                            <select data-placeholder="Select Advocate..." name ="ccd_AAdvocate" data-toggle="tooltip" title="Select Advocate Attending Case"  class="chosen-selectq" style="width:auto;height:auto;"  >
                                <c:forEach items="${advocates}" var="advocate">                                                
                                    <option value="${advocate.cam_FirstName}" ${advocate.cam_FirstName == casemdetail.ccd_AAdvocate ? 'selected' : ''}>${advocate.cam_FirstName}</option>
                                </c:forEach>
                            </select>                                          

                            <button type="submit" name="AddAdvocate" value="AddAdvocate" class="btn btn-primary">+</button>


                        </p>
                        <p> <label>Select Case State  :</label> 

                            <select data-placeholder="Select Case State..." name ="ccd_Stage" data-toggle="tooltip" title="Select Correct Case Stage" class="chosen-selectq" style="width:auto;height:auto;" >
                                <c:forEach items="${casestages}" var="casestage">                                                
                                    <option value="${casestage.ccs_StageName}" ${casestage.ccs_StageName == casemdetail.ccd_Stage ? 'selected' : ''}>${casestage.ccs_StageName}</option>
                                </c:forEach>
                            </select>                                          
                    
                            <button type="submit" name="AddCaseStage" value="AddCaseStage" class="btn btn-primary" >+</button>

                        <p> <label>Select Court  :</label> 

                            <select data-placeholder="Select Court..." name ="ccd_Court" class="chosen-selectq" data-toggle="tooltip" title="Select Court" style="width:auto;height:auto;" >
                                <c:forEach items="${courts}" var="court">                                                
                                    <option value="${court.ccm_CourtName}" ${court.ccm_CourtName == casemdetail.ccd_Court ? 'selected' : ''}>${court.ccm_CourtName}</option>
                                </c:forEach>
                            </select>                                          

                            <button type="submit" name="AddCourt" value="AddCourt" class="btn btn-primary" >+</button>

                        </p>

                        <p><input type="text"  style="width:80%;"  class="form-control" placeholder="ccd_CaseLocation" name="ccd_CaseLocation" id="ccd_CaseLocation" data-toggle="tooltip" title="Please Enter Case Location" value="<c:out value="${casemdetail.ccd_CaseLocation}" />" /> </p>
                        <p> <input type="text" style="width:80%;" class="form-control" placeholder="Judge" name="ccd_Judge" data-toggle="tooltip" title="Please Enter Judge Name" value="<c:out value="${casemdetail.ccd_Judge}" />" /> </p>
                        <p> <input type="text" style="width:80%;" class="form-control" placeholder="Judgment" name="ccd_Judgment" data-toggle="tooltip" title="Please Enter Judgement Given By The Judge" value="<c:out value="${casemdetail.ccd_Judgment}" />" /> </p>
                        <p> <textarea  rows="50" cols="50" style="width:80%; height:80px;" class="form-control" placeholder="Rojnama" name="ccd_Rojnama" id="ccd_Rojnama" data-toggle="tooltip" title="Please Enter Case Rojnama" > <c:out value="${casemdetail.ccd_Rojnama}" />  </textarea> </p>
                        <p> <textarea  rows="50" cols="50" style="width:80%; height:80px;" class="form-control" placeholder="Remarks" name="ccd_Remarks" id="ccd_Remarks" data-toggle="tooltip" title="Please Enter Remarks"> <c:out value="${casedetail.ccd_Remarks}" />  </textarea> </p>

                        <p>
                            <%--<button type="submit" name="SaveDetails" value="SaveDetails" class="btn btn-primary" onClick="return ValidateEndDate();">Submit</button> --%>
                            <button type="submit" name="SaveDetails" id="SaveDetails" class="btn btn-primary"  disabled  onclick="return  validatedate(document.frmAddCaseDetail.ccd_NextCurrentDate)" >Submit</button>
                            <button type="reset" class="btn btn-default">Reset Button</button>
                        </p>
                        <input type="hidden" type="hidden" style="width:auto;" class="form-control" placeholder="Registration No" name="cad_RegNo" value="<c:out value="${casemaster.cad_RegNo}" />" />
                        <input type="text"  style="width:200px;"  class="form-control" placeholder="CaseMasterID" name="cad_id" value="<c:out value="${casemdetail.cad_ID}" />" /> 
                        <input type="hidden" style="width:200px;"  class="form-control" placeholder="CaseDetailID" name="LastDetail_ID" value="<c:out value="${casemdetail.ccd_ID}" />" /> 
                        <input type="hidden"  style="width:200px;"  class="form-control" placeholder="CaseDetailID" name="ccd_id" value="<c:out value="${casemdetail.ccd_ID}" />" /> 
                        <input type="hidden" style="width:200px;"  class="form-control" placeholder="ClientID" name="cmc_ID" value="<c:out value="${casemaster.cmc_ID}" />" /> 
                        <input type="hidden"  class="form-control" placeholder="Previous Date" id="ccd_PreviousDate" name="ccd_PreviousDate" value="<fmt:formatDate value="${casemdetail.ccd_CurrentDate}" pattern="dd/MM/yyyy" />" /> 
                        <input type="hidden"  class="form-control" name="ccd_EditFlag" value="<%=request.getAttribute("upd")%>" /> 
                        <input type="hidden"  class="form-control" name="ccd_DeleteFlag" value="<c:out value="${casedetail.ccd_DeleteFlag}" />" /> 
                        <input type="hidden"  class="form-control" name="ccd_ActiveFlag" value="<c:out value="true" />" /> 
                        <input type="hidden"  class="form-control" name="ccd_CreateDate" value="<fmt:formatDate pattern="dd/MM/yyyy" value="<%= new java.util.Date()%>" />" />                
                        <input type="hidden"  class="form-control" name="ccd_CreateUser" value="<c:out value="${sessionScope.cmu_ID}" />"/>                 
                        <input type="hidden"  class="form-control" name="ccd_ModifyDate" value="<fmt:formatDate pattern="dd/MM/yyyy" value="<%= new java.util.Date()%>" />" />                
                        <input type="hidden"  class="form-control" name="ccd_ModifyUser" value="<c:out value="${sessionScope.cmu_ID}" />" /> 
                        <input type="hidden"  class="form-control" name="ccd_CreateUserName" value="<%=session.getAttribute("FirstName")%>" /> 


                    </form>


               

            </div>
            <!-- /.container-fluid -->

     



      





    </body>

</html>