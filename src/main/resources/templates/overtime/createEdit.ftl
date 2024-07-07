<#import "../common/standerPage.ftl" as standerPage>
<@standerPage.Layout>
    <h3><#if mode == "0">New Overtime <#elseif mode=="1">Update overtime<#else>
            Request overtime of ${overtime.employee.fullName} on ${overtime.date}
        </#if></h3>
    <div>
        <#if mode == "2">
            <a class="btn btn-success" id="btnShowEditOt">Edit</a>
        <#else >
            <button id="btnSaveOvertime" class="btn  btn-primary ">
                Save
            </button>
        </#if>
    </div>
    <input id="mode" value="${mode}" hidden/>
    <form id="overtimeForm" class="row">
        <input id="overtimeId" name="overtimeId" class="hidden"
               value="<#if mode == "1"|| mode=="2">${overtime.overtimeId}</#if>"/>
        <div class="form-group col-6">
            <label for="employeeId">Employee</label>
            <select class="form-control" id="employeeId" name="employeeId">
                <#if mode == "1" || mode == "2" && overtime?? && overtime.employee??>
                    <#assign selectedEmployeeId = overtime.employee.employeeId />
                </#if>
                <#list employee as e>
                    <option value="${e.employeeId}"
                            name="employeeIdOption"
                            <#if selectedEmployeeId?? && e.employeeId == selectedEmployeeId>selected</#if>>${e.fullName}</option>
                </#list>
            </select>
        </div>
        <div class="form-group col-6">
            <label for="id">Date</label>
            <input type="date" class="form-control" id="date" name="date"
                   <#if mode == "1" || mode=="2">value="${overtime.date}"</#if>/>
        </div>
        <div class="form-group col-6">
            <label for="id">Start time</label>
            <input type="time" class="form-control" id="startTime" name="startTime"
                   <#if mode == "1" || mode=="2">value="${overtime.startTime}"</#if>/>
        </div>
        <div class="form-group col-6">
            <label for="id">End Time</label>
            <input type="time" class="form-control" id="endTime" name="endTime"
                   <#if mode == "1" || mode=="2">value="${overtime.endTime}"</#if>/>
        </div>
    </form>

</@standerPage.Layout>
