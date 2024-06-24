<#import "../common/standerPage.ftl" as standerPage>
<@standerPage.Layout>
    <h2>
        <#if mode == "0">
            New Employee
        <#elseif mode == "1">
            Update Employee
        <#else>
            Pham Ngoc Binh Information
        </#if>
    </h2>

    <form id="employeeForm" class="row">
        <div class="col-12">
            <#if mode == "0">
                <button type="button" id="saveEmployee" class="btn btn-primary">Save</button>
            <#else>
                <button type="button" id="editEmployee" class="btn btn-primary">Edit</button>
            </#if>
        </div>
        <#if mode == "2">
        <div class="form-group col-12 ">
            <img src="${employee.university}"/>
            <input type="file" class="form-control" id="id" name="id"/>
        </div>
        </#if>
        <div class="form-group col-6 <#if mode != "1">hidden</#if> ">
            <label for="id">EmployeeID</label>
            <input type="number" class="form-control" id="id" name="id" disabled
                    <#if mode  == "1" || mode=="2">  value="${employee.employeeId}"</#if>
            >
        </div>
        <div class="form-group col-6">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" required
                    <#if mode  == "1" || mode=="2">  value="${employee.email}"</#if>
                   <#if mode != "0" && mode != "1"  >disabled</#if>>
        </div>
        <div class="form-group col-6  <#if mode  != "0"  >hidden</#if>">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" required
                   value="<#if mode  == "1"  >${employee.password}</#if>"
                   <#if mode != "0" && mode != "1"  >disabled</#if>>
        </div>
        <div class="form-group col-6">
            <label for="firstName">First Name</label>
            <input type="text" class="form-control" id="firstName" name="firstName" required
                    <#if mode  == "1" || mode=="2">  value="${employee.firstName}"</#if>
                   <#if mode != "0" && mode != "1"  >disabled</#if>>
        </div>
        <div class="form-group col-6">
            <label for="lastName">Last Name</label>
            <input type="text" class="form-control" id="lastName" name="lastName" required
                    <#if mode  == "1" || mode=="2">  value="${employee.lastName}"</#if>
                   <#if mode != "0" && mode != "1"  >disabled</#if>>
        </div>
        <div class="form-group col-6">
            <label for="dateOfBirth">Date of Birth</label>
            <input type="date" class="form-control" id="dateOfBirth" name="dateOfBirth" required
                   <#if mode == "1" || mode=="2">value="${employee.dateOfBirth?string('yyyy-MM-dd')}"</#if>
                   <#if mode != "0" && mode != "1"  >disabled</#if>>
        </div>
        <div class="form-group col-6">
            <label for="gender">Gender</label>
            <select class="form-control" id="gender" name="gender"
                    <#if mode != "0" && mode != "1"  >disabled</#if>
            >
                <option value="0">Male</option>
                <option value="1">Female</option>
            </select>
        </div>
        <div class="form-group col-6">
            <label for="phone">Phone</label>
            <input type="text" class="form-control" id="phone" name="phone" required
                    <#if mode  == "1" || mode=="2">  value="${employee.phone}"</#if>
                   <#if mode != "0" && mode != "1"  >disabled</#if>>
        </div>
        <div class="form-group col-6">
            <label for="address">Address</label>
            <input type="text" class="form-control" id="address" name="address" required
                    <#if mode  == "1" || mode=="2">  value="${employee.address}"</#if>
                   <#if mode != "0" && mode != "1"  >disabled</#if>>
        </div>
        <div class="form-group col-6">
            <label for="hireDate">Hire Date</label>
            <input type="date" class="form-control" id="hireDate" name="hireDate" required
                   <#if mode == "1"|| mode=="2">value="${employee.hireDate?string('yyyy-MM-dd')}"</#if>
                   <#if mode != "0" && mode != "1"  >disabled</#if>>
        </div>
        <div class="form-group col-6">
            <label for="departmentId">Department</label>
            <select class="form-control" id="departmentId" name="departmentId"
                    <#if mode != "0" && mode != "1"  >disabled</#if>>
                <option value="1">IT</option>
                <option value="2">HR</option>
            </select>
        </div>
        <div class="form-group col-6">
            <label for="positionId">Position</label>
            <select class="form-control" id="positionId" name="positionId"
                    <#if mode != "0" && mode != "1"  >disabled</#if>>
                <option value="1">IT</option>
                <option value="2">HR</option>
            </select>
        </div>
        <ul class="nav nav-tabs col-12" id="tabList">
            <li class="nav-item" id="edu-tab">
                <a class="nav-link active">Education information</a>
            </li>
            <li class="nav-item" id="other-tab">
                <a class="nav-link">Orther Infomation</a>
            </li>
        </ul>

        <div id="edu-tab-info" class="col-12">
            <div class="form-group col-6">
                <label for="university">University</label>
                <input class="form-control" id="university" name="university" required
                        <#if mode  == "1" || mode=="2">  value="${employee.university}"</#if>
                       <#if mode != "0" && mode != "1"  >disabled</#if>>
            </div>
            <div class="form-group col-6">
                <label for="graduation">Year of Graduation</label>
                <input class="form-control" id="graduation" name="graduation" required
                        <#if mode  == "1" || mode=="2">  value="${employee.graduation}"</#if>
                        <#if mode != "0" && mode != "1"  >disabled</#if>>
            </div>
            <div class="form-group col-6">
                <label for="gpa">GPA</label>
                <input class="form-control" id="gpa" name="gpa" type="number" required
                        <#if mode  == "1" || mode=="2">  value="${employee.gpa}"</#if>
                        <#if mode != "0" && mode != "1"  >disabled</#if>>
            </div>
        </div>
        <div id="other-tab-info" class="col-12 hidden">
            <div class="form-group col-6">
                <label for="vehicleName">Vehicles Name</label>
                <input class="form-control" id="vehicleName" name="vehicleName" required
                        <#if mode  == "1" || mode=="2">  value="${employee.vehicleName}"</#if>
                        <#if mode != "0" && mode != "1"  >disabled</#if>>
            </div>
            <div class="form-group col-6">
                <label for="vehicleNo">Vehicle No</label>
                <input class="form-control" id="vehicleNo" name="vehicleNo" required
                        <#if mode  == "1" || mode=="2">  value="${employee.vehicleNo}"</#if>
                        <#if mode != "0" && mode != "1"  >disabled</#if>>
            </div>
        </div>

    </form>
</@standerPage.Layout>

