<#import "../common/standerPage.ftl" as standerPage>
<@standerPage.Layout>
    <h3><#if mode == "0">New Leave <#elseif mode=="1">Update Leave<#else>
            Request leave of ${leave.employee.fullName} on ${leave.date}
        </#if></h3>
    <div>
        <#if mode == "2">
            <a class="btn btn-success" id="btnShowEditLeave">Edit</a>
        <#else >
            <button id="btnSaveOvertime" class="btn  btn-primary ">
                Save
            </button>
        </#if>
    </div>
    <input id="mode" value="${mode}" hidden />
    <form id="leaveForm" class="row">
        <input id="leaveId" name="leaveId" class="hidden" value="<#if mode == "1"|| mode=="2">${leave.leaveId}</#if>"  />
        <div class="form-group col-6">
            <label for="employeeId">Employee</label>
            <select class="form-control" id="employeeId" name="employeeId">
                <#if mode == "1" || mode == "2" && leave?? && leave.employee??>
                    <#assign selectedEmployeeId = leave.employee.employeeId />
                </#if>
                <#list employee as e>
                    <option value="${e.employeeId}"
                            <#if selectedEmployeeId?? && e.employeeId == selectedEmployeeId>selected</#if>>${e.fullName}</option>
                </#list>
            </select>
        </div>
        <div class="form-group col-6">
            <label for="id">Date</label>
            <input type="date" class="form-control" id="date" name="date"
                   <#if mode == "1"|| mode=="2">value="${leave.date}"</#if>/>
        </div>
        <div class="form-group col-6">
            <label for="reason">Reason</label>
            <input type="text" class="form-control" id="reason" name="reason"
                   <#if mode == "1"|| mode=="2">value="${leave.reason}"</#if>/>
        </div>
    </form>

</@standerPage.Layout>
