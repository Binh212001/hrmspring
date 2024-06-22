<#import "../common/standerPage.ftl" as standerPage>
<@standerPage.Layout>
    <h2>New Employee</h2>
    <form action="/employees/save" method="post" class="row">
        <div class="form-group col-6">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" required>
        </div>
        <div class="form-group col-6">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <div class="form-group col-6">
            <label for="firstName">First Name</label>
            <input type="text" class="form-control" id="firstName" name="firstName" required>
        </div>
        <div class="form-group col-6">
            <label for="lastName">Last Name</label>
            <input type="text" class="form-control" id="lastName" name="lastName" required>
        </div>
        <div class="form-group col-6">
            <label for="dateOfBirth">Date of Birth</label>
            <input type="date" class="form-control" id="dateOfBirth" name="dateOfBirth" required>
        </div>
        <div class="form-group col-6">
            <label for="gender">Gender</label>
            <select class="form-control" id="gender" name="gender">
                <option value="Male">Male</option>
                <option value="Female">Female</option>
            </select>
        </div>
        <div class="form-group col-6">
            <label for="phone">Phone</label>
            <input type="text" class="form-control" id="phone" name="phone" required>
        </div>
        <div class="form-group col-6">
            <label for="address">Address</label>
            <input type="text" class="form-control" id="address" name="address" required>
        </div>
        <div class="form-group col-6">
            <label for="hireDate">Hire Date</label>
            <input type="date" class="form-control" id="hireDate" name="hireDate" required>
        </div>
        <div class="form-group col-6">
            <label for="departmentId">Department</label>
            <input type="number" class="form-control" id="departmentId" name="departmentId" required>
        </div>
        <div class="form-group col-6">
            <label for="positionId">Position</label>
            <input type="number" class="form-control" id="positionId" name="positionId" required>
        </div>
        <div class="form-group col-6">
            <label for="contractId">Contract</label>
            <input type="number" class="form-control" id="contractId" name="contractId" required>
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
                <input  class="form-control" id="university" name="university" required>
            </div>
            <div class="form-group col-6">
                <label for="graduation">Year of Graduation</label>
                <input  class="form-control" id="graduation" name="graduation" required>
            </div>
             <div class="form-group col-6">
                <label for="gpa">GPA</label>
                <input  class="form-control" id="gpa" name="gpa" required>
            </div>
        </div>
        <div id="other-tab-info" class="col-12 hidden">
            <div class="form-group col-6">
                <label for="vehicleName">Vehicles Name</label>
                <input  class="form-control" id="vehicleName" name="vehicleName" required>
            </div>
            <div class="form-group col-6">
                <label for="vehicleNo">Vehicle No</label>
                <input  class="form-control" id="vehicleNo" name="vehicleNo" required>
            </div>
        </div>
        <div class="col-12">
            <button type="submit" class="btn btn-primary">Save</button>
        </div>
    </form>
</@standerPage.Layout>

