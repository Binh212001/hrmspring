<#import "../common/standerPage.ftl" as standerPage>
<@standerPage.Layout>
    <h3><#if mode == "0">New Shift<#else>Update Shift</#if></h3>
    <div>
        <button id="btnSaveAttendance" class="btn  <#if mode == "0"> btn-primary  <#else>  btn-success </#if>">
            <#if mode == "0"> Save<#else>Edit</#if>
        </button>
    </div>
    <input id="mode" value="${mode}" hidden />
    <form id="shiftForm" class="row">
        <input id="attendanceId" name="attendanceId" class="hidden" value="<#if mode == "1">${attendance.attendanceId}</#if>"  />
        <div class="form-group col-6">
            <label for="employeeId">Employee</label>
            <select class="form-control" id="employeeId" name="employeeId" >
                <#list employees as employee>
                    <option value="${employee.employeeId}">${employee.fullName}</option>
                </#list>
            </select>
        </div>
        <div class="form-group col-6">
            <label for="id">Date</label>
            <input type="date" class="form-control" id="date" name="date"
                   <#if mode == "1">value="${attendance.createdAt?string('yyyy-MM-dd')}"</#if>/>
        </div>
        <input name="_csrf" type="hidden" value="${_csrf.token}">
    </form>

</@standerPage.Layout>
